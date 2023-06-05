package negocio;

import java.util.Comparator;

public class TimePorPontosComparator implements Comparator<Time> {

	@Override
	public int compare(Time time1, Time time2) {
		return Integer.valueOf(time1.getPontos()).compareTo(Integer.valueOf(time2.getPontos()));
	}
}