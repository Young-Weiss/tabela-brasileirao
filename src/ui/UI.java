package ui;

import java.util.Scanner;

import negocio.Brasileirao;
import negocio.Jogo;
import negocio.Opcoes;
import negocio.Time;

public class UI {
	private Scanner sc;
	private Opcoes opcoes;
	private Brasileirao brasileirao;
	
	public UI() {
		sc = new Scanner(System.in);
		opcoes = new Opcoes();
		brasileirao = new Brasileirao();
	}
	
	public void menu() {
		int opcao; 
		do {
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
					//TODO continuar aqui
					break;
				case 4:
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
			
		} while(opcao != 4);
		
	}
	
	private void inserirTimeUi() {
		Time timeAdicionar = new Time();
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
		time1 = brasileirao.filtrarPorId(id1);
		
		System.out.println("Digite o placar do " + time1.getNome() + ": ");
		placar1 = sc.nextInt();
		
		System.out.println("Digite o ID do segundo time: ");
		id2 = sc.nextInt();
		time2 = brasileirao.filtrarPorId(id2);
		
		System.out.println("Digite o placar do " + time2.getNome() + ": ");
		placar2 = sc.nextInt();
		
		brasileirao.registrarPartida(new Jogo(time1, time2, placar1, placar2));
	}
	
	private int escolherOpcao() {
		System.out.println("Digite a opção desejada: ");
		return sc.nextInt();
	}
	
}