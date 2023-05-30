package negocio;

import java.util.ArrayList;

public class Brasileirao {
	private ArrayList<Time> times;
	private final BrasileiraoServico brasileiraoServico;
	
	public Brasileirao() {
		times = new ArrayList<>();
		brasileiraoServico = new BrasileiraoServico();
	}
	
	@Override
	public String toString() {
		return "Brasileirao [times=" + times + "]";
	}

	public void inserirTime(Time time) {
		times.add(time);
	}
	
	public void registrarPartida(Jogo jogo) {
		jogo.getTime1().setNumeroJogos(jogo.getTime1().getNumeroJogos() + 1);
		jogo.getTime2().setNumeroJogos(jogo.getTime2().getNumeroJogos() + 1);
		
		jogo.getTime1().setGolsPro(jogo.getTime1().getGolsPro() + jogo.getGolsTime1());
		jogo.getTime2().setGolsPro(jogo.getTime2().getGolsPro() + jogo.getGolsTime2());
		
		jogo.getTime1().setGolsSofridos(jogo.getTime1().getGolsSofridos() + jogo.getGolsTime2());
		jogo.getTime2().setGolsSofridos(jogo.getTime2().getGolsSofridos() + jogo.getGolsTime1());
		
		if (jogo.getGolsTime1() > jogo.getGolsTime2()) {
			jogo.getTime1().setNumeroVitorias(jogo.getTime1().getNumeroVitorias() + 1);
			jogo.getTime1().setPontos(jogo.getTime1().getPontos() + 3);
			
			jogo.getTime2().setNumeroDerrotas(jogo.getTime2().getNumeroDerrotas() + 1);
		} else if (jogo.getGolsTime1() < jogo.getGolsTime2()) {
			jogo.getTime2().setNumeroVitorias(jogo.getTime2().getNumeroVitorias() + 1);
			jogo.getTime2().setPontos(jogo.getTime2().getPontos() + 3);
			
			jogo.getTime1().setNumeroDerrotas(jogo.getTime1().getNumeroDerrotas() + 1);
		} else {
			jogo.getTime1().setPontos(jogo.getTime1().getPontos() + 1);
			jogo.getTime2().setPontos(jogo.getTime2().getPontos() + 1);
					
			jogo.getTime1().setNumeroEmpates(jogo.getTime1().getNumeroEmpates() + 1);
			jogo.getTime2().setNumeroEmpates(jogo.getTime2().getNumeroEmpates() + 1);
		}
		
		jogo.getTime1().calcularAproveitamento();
		jogo.getTime2().calcularAproveitamento();
	}
	
	public void mostrarTabelaClassificacao() {
		for (Time time : times) 
			System.out.println(time.info());
	}
	
	public Time filtrarTimePorId(int id) {
		for (Time time : times) {
			if(time.getId() == id)
				return time;
		}
		return null;
	}

	public ArrayList<Time> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<Time> times) {
		this.times = times;
	}
	
	public void setTimesJson() {
		setTimes(brasileiraoServico.carregarArquivoJson());
	}
}