package ui;

import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;

import negocio.Brasileirao;
import negocio.BrasileiraoServico;
import negocio.Jogo;
import negocio.Opcoes;
import negocio.Time;

public class UI {
	private Scanner sc;
	private Opcoes opcoes;
	private Brasileirao brasileirao;
	private BrasileiraoServico brasileiraoServico;
	
	public UI() {
		sc = new Scanner(System.in);
		opcoes = new Opcoes();
		brasileirao = new Brasileirao();
		brasileiraoServico = new BrasileiraoServico();
		brasileirao.setTimesJson();
	}
	
	public void menu() throws JsonProcessingException {
		int opcao; 
		do {
			opcoes.exibir();
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
			menu();
		}
		
		System.out.println(brasileirao);
		System.out.println("Digite o ID do primeiro time: ");
		id1 = sc.nextInt();
		time1 = brasileirao.filtrarTimePorId(id1);
		
		if (time1 == null) {
			System.out.println("Time com o ID especificado não existe!\n"
							 + "Selecione novamente!");
			registrarPartidaUi();
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
			registrarPartidaUi();
		}
		
		if(id1 == id2) {
			System.out.println("O time " + time1.getNome() + " não pode jogar contra ele mesmo!\n"
							 + "Insira outro time!\n");
			menu();
		} 
		
		do {
			System.out.println("Digite o placar do " + time2.getNome() + ": ");
			placar2 = sc.nextInt();
		} while (placar2 < 0);
		
		new Jogo(time1, time2, placar1, placar2);
		brasileirao.ordenarTimes();
	}
	
	private void mostrarTabelaClassificacaoUi() {
		System.out.println();
		brasileirao.mostrarTabelaClassificacao();
	}
	
	private int escolherOpcao() {
		System.out.println("Digite a opção desejada: ");
		return sc.nextInt();
	}
}