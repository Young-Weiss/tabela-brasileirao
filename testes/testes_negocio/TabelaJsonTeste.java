package testes_negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.TabelaJson;

class TabelaJsonTeste {
	private TabelaJson tabelaJson;
	
	@BeforeEach
	void setUp() {
		tabelaJson = new TabelaJson();
	}
	
	@Test
	void estaVaziaRetornaFalseCasoArquivoNaoEstaVazio() throws IOException {
		FileWriter fw = new FileWriter(tabelaJson.getTabelaJson());
		fw.write("Algum texto...");
		fw.flush();
		
		assertFalse(tabelaJson.estaVazia());
		
		tabelaJson.getTabelaJson().delete();
	}
	
	@Test
	void estaVaziaRetornaTrueCasoArquivoEstaVazio() throws IOException {
		FileWriter fw = new FileWriter(tabelaJson.getTabelaJson());
		fw.write("");
		fw.flush();
		
		assertTrue(tabelaJson.estaVazia());
	}
	
	@Test
	void estaVaziaRetornaIOExceptionCasoArquivoInvalido() {
		tabelaJson.getTabelaJson().delete();
		tabelaJson.estaVazia();
		
		assertThrows(IOException.class, () -> tabelaJson.estaVazia());
	}
	
	@Test
	void setTabelaJsonTeste() {
		File file = new File("teste.txt");
		tabelaJson.setTabelaJson(file);
		
		assertEquals(tabelaJson.getTabelaJson().getPath(), file.getPath());
		
		file.delete();
	}

}
