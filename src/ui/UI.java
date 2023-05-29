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
	}
	
	public void menu() throws JsonProcessingException {
		int opcao; 
		do {
			//TODO verificar o método abaixo (BUG)
			//brasileirao.setTimesJson();
			opcoes.exibir();
			opcao = escolherOpcao();
			
			switch(opcao) {
				case 1:
					inserirTimeUi();
					break;
				case 2:
					registrarPartidaUi();
					break;
				case 3:
					mostrarTabelaClassificacaoUi();
					break;
				case 4:
					brasileiraoServico.salvarArquivoJson(brasileirao);
					break;
				default:
					System.out.println("Opção inválida");
					brasileiraoServico.salvarArquivoJson(brasileirao);
					break;
			}
			System.out.println();
			
		} while(opcao != 4);
		
	}
	
	private void inserirTimeUi() {
		Time timeAdicionar = new Time();
		System.out.println();
		System.out.println("Nome do time: ");
		timeAdicionar.setNome(sc.next());
		brasileirao.inserirTime(timeAdicionar);
	}
	
	private void registrarPartidaUi() {
		Time time1, time2; 
		int id1, id2, placar1, placar2;
		
		System.out.println(brasileirao);
		System.out.println("Digite o ID do primeiro time: ");
		id1 = sc.nextInt();
		time1 = brasileirao.filtrarTimePorId(id1);
		
		System.out.println("Digite o placar do " + time1.getNome() + ": ");
		placar1 = sc.nextInt();
		
		System.out.println("Digite o ID do segundo time: ");
		id2 = sc.nextInt();
		time2 = brasileirao.filtrarTimePorId(id2);
		
		System.out.println("Digite o placar do " + time2.getNome() + ": ");
		placar2 = sc.nextInt();
		
		brasileirao.registrarPartida(new Jogo(time1, time2, placar1, placar2));
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