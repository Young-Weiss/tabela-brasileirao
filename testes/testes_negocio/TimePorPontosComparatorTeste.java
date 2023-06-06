package testes_negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.Time;
import negocio.TimePorPontosComparator;

class TimePorPontosComparatorTeste {
	private List<Time> listaTimes;
	private Time time1, time2, time3;
	
	@BeforeEach
	void setUp() {
		time1 = new Time("Time A");
		time2 = new Time("Time B");
		time3 = new Time("Time C");
		
		time1.setPontos(2);
		time2.setPontos(4);
		time3.setPontos(3);
		
		listaTimes = new ArrayList<>(List.of(time1, time2, time3));
	}
	
	@Test
	void ordenaTimesPorPontos() {
		listaTimes.sort(new TimePorPontosComparator().reversed());
		
		assertEquals(time2.getNome(), listaTimes.get(0).getNome());
		assertEquals(time3.getNome(), listaTimes.get(1).getNome());
		assertEquals(time1.getNome(), listaTimes.get(2).getNome());
	}
}