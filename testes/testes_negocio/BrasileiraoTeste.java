package testes_negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.Brasileirao;
import negocio.Time;

class BrasileiraoTeste {
	private Brasileirao brasileirao;
	
	@BeforeEach
	void setUp() {
		brasileirao = new Brasileirao();
	}
	
	@Test
	void construtorTeste() {
		assertTrue(brasileirao.getTimes().isEmpty());
	}
	
	@Test
	void toStringTeste() {
		brasileirao.inserirTime(new Time("Time Teste"));
		assertEquals("Brasileirao [times=[Time [id=1, nome=Time Teste]]]", brasileirao.toString());
	}

}
