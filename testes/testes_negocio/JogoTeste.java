package testes_negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.Jogo;
import negocio.Time;

class JogoTeste {
	private Jogo jogo;
	Time timeA, timeB;
	
	@BeforeEach
	void setUp() {
		timeA = new Time("Time A");
		timeB = new Time("Time B");
		jogo = new Jogo(timeA, timeB, 0, 0);
	}
	
	@Test
	void getTime1Teste() {
		assertEquals(timeA, jogo.getTime1());
	}
	
	@Test
	void setTime1Teste() {
		Time novoTime =new Time("Time Teste");
		jogo.setTime1(novoTime);
		
		assertEquals(novoTime, jogo.getTime1());
	}
	
	@Test
	void getTime2Teste() {
		assertEquals(timeB, jogo.getTime2());
	}
	
	@Test
	void setTime2Teste() {
		Time novoTime = new Time("Time Teste 2");
		jogo.setTime2(novoTime);
		
		assertEquals(novoTime, jogo.getTime2());
	}

	@Test
	void getGolsTime1Teste() {
		assertEquals(0, jogo.getGolsTime1());
	}
	
	@Test
	void setGolsTime1Teste() {
		jogo.setGolsTime1(3);
		
		assertEquals(3, jogo.getGolsTime1());
	}
	
	@Test
	void getGolsTime2Teste() {
		assertEquals(0, jogo.getGolsTime2());
	}
	
	@Test
	void setGolsTime2Teste() {
		jogo.setGolsTime2(2);
		assertEquals(2, jogo.getGolsTime2());
	}
}