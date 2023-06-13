package ui;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;

import negocio.Brasileirao;
import negocio.BrasileiraoServico;
import negocio.Jogo;
import negocio.Time;

public class UI {
	private Scanner sc;
	private Brasileirao brasileirao;
	private BrasileiraoServico brasileiraoServico;
	 
	public UI() {
		sc = new Scanner(System.in);
		brasileirao = new Brasileirao();
		brasileiraoServico = new BrasileiraoServico();
		brasileirao.setTimesJson();
	}   
	
	public Brasileirao getBrasileirao() {
		return brasileirao;
	}
	
	public BrasileiraoServico getBrasileiraoServico() {
		return brasileiraoServico;
	}

	public void menu() throws JsonProcessingException {
		int opcao; 
		do {
			exibirOpcoes();
			opcao = escolherOpcao();
			 
			switch(opcao) {
				case 1:
					inserirTimeUi();
					break;
				case 2:
					deletarTimeUi();
					break;
				case 3:
					registrarPartidaUi();
					break;
				case 4:
					mostrarTabelaClassificacaoUi();
					break;
				case 5:
					brasileiraoServico.salvarArquivoJson(brasileirao);
					break; 
				default:
					System.out.println("Opção inválida");
					brasileiraoServico.salvarArquivoJson(brasileirao);
					break;
			} 
			System.out.println();
			
		} while(opcao != 5);
		
		sc.close();
	}

	private void exibirOpcoes() {
		System.out.println("1 - Inserir time\n"
						 + "2 - Deletar time\n"
						 + "3 - Registrar partida\n"
						 + "4 - Mostrar tabela classificação\n"
						 + "5 - Sair");
	}
	
	private void inserirTimeUi() {
		Time timeAdicionar = new Time();
		System.out.println();
		System.out.println("Nome do time: ");
		sc.nextLine();
		timeAdicionar.setNome(sc.nextLine());
		brasileirao.inserirTime(timeAdicionar);
	}
	
	private void deletarTimeUi() {
		int idTimeDeletar;
		
		System.out.println(brasileirao);
		System.out.println("Digite o ID do time que deseja deletar: ");
		idTimeDeletar = sc.nextInt();
		
		if (brasileirao.deletarTimePorId(idTimeDeletar))
			System.out.println("Time deletado com sucesso");
		else 
			System.out.println("Não foi possível deletar o time com o ID especificado");
	}

	private void registrarPartidaUi() throws JsonProcessingException {
		Time time1, time2; 
		int id1, id2, placar1, placar2;
			
		if (brasileirao.getTimes().size() < 2) {
			System.out.println("Não existem times suficientes para uma partida!\n"
							 + "Adicione mais times para poder registrar uma partida!\n");
			return;
		} 
			
		System.out.println(brasileirao);
		System.out.println("Digite o ID do primeiro time: ");
		id1 = sc.nextInt();
		time1 = brasileirao.filtrarTimePorId(id1);
				
		if (time1 == null) {
			System.out.println("Time com o ID especificado não existe!\n"
						 	 + "Selecione novamente: ");
			return;
		}	
		 
		do {
			System.out.println("Digite o placar do " + time1.getNome() + ": ");
			placar1 = sc.nextInt();
		} while (placar1 < 0);
		
		System.out.println("Digite o ID do segundo time: ");
		id2 = sc.nextInt();
		time2 = brasileirao.filtrarTimePorId(id2);
			
		if (time2 == null) {
			System.out.println("Time com o ID especificado não existe!\n"
							 + "Selecione novamente os times!");
			return;
		}
			
		if (id1 == id2) {
			System.out.println("O time " + time1.getNome() + " não pode jogar contra ele mesmo!\n"
							 + "Insira outro time!\n");
			return;
		} 
			 
		do {
			System.out.println("Digite o placar do " + time2.getNome() + ": ");
			placar2 = sc.nextInt();
		} while (placar2 < 0);
			
		new Jogo(time1, time2, placar1, placar2);
		brasileirao.ordenarTimes();
	}
	
	private void mostrarTabelaClassificacaoUi() {
		DecimalFormat df = new DecimalFormat("#");

		System.out.printf("%22s%s%22s\n", "", "Brasileirão", "");
		System.out.printf("%-15s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %n", "Clube", "Pts", "PJ", "VIT", "E", "DER",
				"GM", "GC", "APR\n");

		for (Time time : brasileirao.getTimes())
			System.out.printf("%-15s %-4d %-4d %-4d %-4d %-4d %-4d %-4d %-3s%% %n", time.getNome(), time.getPontos(),
					time.getNumeroJogos(), time.getNumeroVitorias(), time.getNumeroEmpates(), time.getNumeroDerrotas(),
					time.getGolsPro(), time.getGolsSofridos(), df.format(time.getPercentualAproveitamento()));
	}
	
	private int escolherOpcao() {
		int opcao = 0;
		boolean inputValido = false;

		do {
			System.out.println("Digite a opção desejada: ");
			
			if (sc.hasNextInt()) {
				opcao = sc.nextInt();
				inputValido = true;
			} else { 
				System.out.println("Opção inválida");
	            exibirOpcoes();
	            System.out.println("Digite a opção desejada: ");
			}
		} while(!inputValido); 
		
		return opcao;
	}
}