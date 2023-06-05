package negocio;

import java.text.DecimalFormat;
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
		ordenarTimes();
	}

	public void mostrarTabelaClassificacao() {
		DecimalFormat df = new DecimalFormat("#");

		System.out.printf("%22s%s%22s\n", "", "Brasileirão", "");
		System.out.printf("%-15s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %n", "Clube", "Pts", "PJ", "VIT", "E", "DER",
				"GM", "GC", "APR\n");

		for (Time time : times)
			System.out.printf("%-15s %-4d %-4d %-4d %-4d %-4d %-4d %-4d %-3s%% %n", time.getNome(), time.getPontos(),
					time.getNumeroJogos(), time.getNumeroVitorias(), time.getNumeroEmpates(), time.getNumeroDerrotas(),
					time.getGolsPro(), time.getGolsSofridos(), df.format(time.getPercentualAproveitamento()));
	}

	public Time filtrarTimePorId(int id) {
		for (Time time : times) {
			if (time.getId() == id)
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

	public void ordenarTimes() {
		times.sort(new TimePorPontosComparator().reversed());
	}

	public boolean deletarTimePorId(int id) {
		Time timeASerDeletado = filtrarTimePorId(id);

		for (Time time : times) {
			if (time.equals(timeASerDeletado)) {
				times.remove(timeASerDeletado);
				break;
			}
		}
		
		ordenarTimes();
		return timeASerDeletado == null ? false : true;
	}
}