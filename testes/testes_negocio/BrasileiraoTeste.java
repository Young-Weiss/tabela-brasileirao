package testes_negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
		assertEquals("Brasileirao [times=[]]", brasileirao.toString());
	}
	
	@Test
	void mostrarTabelaClassificacaoRetornaNullQuandoTimesEstaVazio() {
		brasileirao.deletarTimePorId(1);
		
		assertTrue(brasileirao.getTimes().isEmpty());
	}
	
	@Test
	void mostrarTabelaClassificacaoRetornaClassificacaoQuandoTimesNaoEhNull() {
		brasileirao.inserirTime(new Time("Time Teste"));
		
		assertTrue(!brasileirao.getTimes().isEmpty());
	}
	
	@Test
	void filtrarTimePorIdRetornaTimeQuandoEncontrado() {
		Time timeEsperado = brasileirao.filtrarTimePorId(1);
		
		assertEquals(timeEsperado, brasileirao.filtrarTimePorId(1));
	}
	
	@Test
	void filtrarTimePorIdRetornaNullQuandoNaoEncontrado() {
		assertEquals(null, brasileirao.filtrarTimePorId(2));
	}
	
	@Test
	void getTimeTeste() {
		ArrayList<Time> esperado = new ArrayList<>();
		
		assertEquals(esperado, brasileirao.getTimes());
	}
	
	@Test
	void setTimeTeste() {
		ArrayList<Time> novaLista = new ArrayList<Time>(List.of(new Time("Time AZ")));
		brasileirao.setTimes(novaLista);
		
		assertEquals(novaLista.toString(), brasileirao.getTimes().toString());
	}
}