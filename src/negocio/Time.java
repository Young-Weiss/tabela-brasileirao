package negocio;

public class Time {
	private static int sequencia = 1;
	private int id;
	private String nome; 
	private int pontos;
	private int numeroJogos;
	private int numeroVitorias;
	private int numeroEmpates;
	private int numeroDerrotas;
	private int golsPro;
	private int golsSofridos;
	private double percentualAproveitamento;
	
	public Time() {
		this.id = sequencia++;
	}
	
	public Time(String nome) {
		this();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + "]";
	}
	
	public String info() {
		return "Time [id=" + id + ", nome=" + nome + ", pontos=" + pontos + ", numeroJogos=" + numeroJogos
				+ ", numeroVitorias=" + numeroVitorias + ", numeroEmpates=" + numeroEmpates + ", numeroDerrotas="
				+ numeroDerrotas + ", golsPro=" + golsPro + ", golsSofridos=" + golsSofridos
				+ ", percentualAproveitamento=" + percentualAproveitamento + "]";
	}

	public void calcularAproveitamento() {
		percentualAproveitamento = ((double) pontos / ((double) numeroJogos * 3)) * 100;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getNumeroJogos() {
		return numeroJogos;
	}

	public void setNumeroJogos(int numeroJogos) {
		this.numeroJogos = numeroJogos;
	}

	public int getNumeroVitorias() {
		return numeroVitorias;
	}

	public void setNumeroVitorias(int numeroVitorias) {
		this.numeroVitorias = numeroVitorias;
	}

	public int getNumeroEmpates() {
		return numeroEmpates;
	}

	public void setNumeroEmpates(int numeroEmpates) {
		this.numeroEmpates = numeroEmpates;
	}

	public int getNumeroDerrotas() {
		return numeroDerrotas;
	}

	public void setNumeroDerrotas(int numeroDerrotas) {
		this.numeroDerrotas = numeroDerrotas;
	}

	public int getGolsPro() {
		return golsPro;
	}

	public void setGolsPro(int golsPro) {
		this.golsPro = golsPro;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}

	public double getPercentualAproveitamento() {
		return percentualAproveitamento;
	}

	public void setPercentualAproveitamento(double percentualAproveitamento) {
		this.percentualAproveitamento = percentualAproveitamento;
	}
}