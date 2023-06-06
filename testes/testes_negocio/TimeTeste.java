package testes_negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.Time;

class TimeTeste {
	private Time time;
	
	@BeforeEach
	void setUp() {
		time = new Time("Time Teste");
	}
	
	@Test
	void toStringTeste() {
		assertEquals("Time [id=" + (Time.getSequencia() - 1) + ", nome=Time Teste]", time.toString());
	}
	
	@Test
	void getIdTeste() {
		assertEquals(Time.getSequencia() - 1, time.getId());
	}
	
	@Test
	void getNomeTeste() {
		assertEquals("Time Teste", time.getNome());
	}
	
	@Test
	void setNomeTeste() {
		time.setNome("Time AZ");
		
		assertEquals("Time AZ", time.getNome());
	}
	
	@Test
	void getPontosTeste() {
		assertEquals(0, time.getPontos());
	}
	
	@Test
	void setPontosTeste() {
		time.setPontos(3);
		
		assertEquals(3, time.getPontos());
	}
	
	@Test
	void getNumeroJogosTeste() {
		assertEquals(0, time.getNumeroJogos());
	}
	
	@Test
	void setNumeroJogosTesteTeste() {
		time.setNumeroJogos(1);
		
		assertEquals(1, time.getNumeroJogos());
	}
	
	@Test
	void getNumeroVitoriasTeste() {
		assertEquals(0, time.getNumeroVitorias());
	}
	
	@Test
	void setNumeroVitoriasTeste() {
		time.setNumeroVitorias(1);
		
		assertEquals(1, time.getNumeroVitorias());
	}
	
	@Test
	void getNumeroEmpatesTeste() {
		assertEquals(0, time.getNumeroEmpates());
	}
	
	@Test
	void setNumeroEmpatesTeste() {
		time.setNumeroEmpates(1);
		
		assertEquals(1, time.getNumeroEmpates());
	}
	
	@Test
	void getNumeroDerrotasTeste() {
		assertEquals(0, time.getNumeroDerrotas());
	}
	
	@Test
	void setNumeroDerrotasTeste() {
		time.setNumeroDerrotas(1);
		
		assertEquals(1, time.getNumeroDerrotas());
	}
	
	@Test
	void getGolsProTeste() {
		assertEquals(0, time.getGolsPro());
	}
	
	@Test
	void setGolsProTeste() {
		time.setGolsPro(1);
		
		assertEquals(1, time.getGolsPro());
	}
	
	@Test
	void getGolsSofridosTeste() {
		assertEquals(0, time.getGolsSofridos());
	}
	
	@Test
	void setGolsSofridosTeste() {
		time.setGolsSofridos(1);
		
		assertEquals(1, time.getGolsSofridos());
	}
	
	@Test
	void getPercentualAproveitamentoTeste() {
		assertEquals(0, time.getPercentualAproveitamento());
	}
	
	@Test
	void setPercentualAproveitamentoTeste() {
		time.setPercentualAproveitamento(10);
		
		assertEquals(10, time.getPercentualAproveitamento());
	}
	
	@Test
	void adicionaNumeroJogosTeste() {
		time.adicionaNumeroJogos();
		
		assertEquals(1, time.getNumeroJogos());
	}
	
	@Test
	void adicionarGolsProTeste() {
		time.adicionarGolsPro(3);
		
		assertEquals(3, time.getGolsPro());
	}
	
	@Test
	void adicionarGolsSofridos() {
		time.adicionarGolsSofridos(3);
		
		assertEquals(3, time.getGolsSofridos());
	}
	
	@Test
	void adicionarVitoriaTeste() {
		time.adicionarVitoria();
		
		assertEquals(1, time.getNumeroVitorias());
	}
	
	@Test
	void adicionarDerrotaTeste() {
		time.adicionarDerrota();
		
		assertEquals(1, time.getNumeroDerrotas());
	}
	
	@Test
	void adicionarPontosParaVitoriaTeste() {
		time.adicionarPontos(3);
		
		assertEquals(3, time.getPontos());
	}
	
	@Test
	void adicionarPontosParaEmpateTeste() {
		time.adicionarPontos(1);
		
		assertEquals(1, time.getPontos());
	}
	
	@Test
	void adicionarEmpateTeste() {
		time.adicionarEmpate();
		
		assertEquals(1, time.getNumeroEmpates());
	}
	
}