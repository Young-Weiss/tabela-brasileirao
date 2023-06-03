package negocio;

public class Jogo {
	private Time time1;
	private Time time2;
	private int golsTime1;
	private int golsTime2;
	
	public Jogo(Time time1, Time time2, int golsTime1, int golsTime2) {
		this.time1 = time1;
		this.time2 = time2;
		this.golsTime1 = golsTime1;
		this.golsTime2 = golsTime2;
		
		registrarPartida();
	} 

	private void registrarPartida() {
		time1.adicionaNumeroJogos();
		time2.adicionaNumeroJogos();

		time1.adicionarGolsPro(golsTime1);
		time2.adicionarGolsPro(golsTime2);

		time1.adicionarGolsSofridos(golsTime2);
		time2.adicionarGolsSofridos(golsTime1);

		if (golsTime1 > golsTime2) {
			time1.adicionarVitoria();
			time2.adicionarDerrota();
			
			time1.adicionarPontos(3); 
		} else if (golsTime1 < golsTime2) {
			time2.adicionarVitoria();
			time1.adicionarDerrota();
			
			time2.adicionarPontos(3);
		} else {
			time1.adicionarPontos(1);
			time2.adicionarPontos(1);

			time1.adicionarEmpate();
			time2.adicionarEmpate();
		}

		time1.calcularAproveitamento();
		time2.calcularAproveitamento();
	}

	public Time getTime1() {
		return time1;
	}

	public void setTime1(Time time1) {
		this.time1 = time1;
	}

	public Time getTime2() {
		return time2;
	}

	public void setTime2(Time time2) {
		this.time2 = time2;
	}

	public int getGolsTime1() {
		return golsTime1;
	}

	public void setGolsTime1(int golsTime1) {
		this.golsTime1 = golsTime1;
	}

	public int getGolsTime2() {
		return golsTime2;
	}

	public void setGolsTime2(int golsTime2) {
		this.golsTime2 = golsTime2;
	}
}