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

	public BrasileiraoServico getBrasileiraoServico() {
		return brasileiraoServico;
	}

	public void inserirTime(Time time) {
		times.add(time);
		ordenarTimes();
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