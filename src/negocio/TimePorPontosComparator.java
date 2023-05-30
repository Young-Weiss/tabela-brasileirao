package negocio;

import java.util.Comparator;

public class TimePorPontosComparator implements Comparator<Time>{

	@Override
	public int compare(Time o1, Time o2) {
		if (o1.getPontos() > o2.getPontos()) return 1;
		else if (o1.getPontos() < o2.getPontos()) return -1;
		return 0;
	}
}