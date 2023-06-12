package testes_negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Rule;
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
		
		fw.close();
		
	    FileWriter clearWriter = new FileWriter(tabelaJson.getTabelaJson());
	    clearWriter.write("");
	    clearWriter.close();
	}
	
	@Test
	void estaVaziaRetornaTrueCasoArquivoEstaVazio() throws IOException {
		FileWriter fw = new FileWriter(tabelaJson.getTabelaJson());
		fw.write("");
		fw.flush();
		fw.close();
		
		assertTrue(tabelaJson.estaVazia());
	}
	
	@Test
	void estaVaziaRetornaIOExceptionCasoArquivoInvalido() {
		tabelaJson.setTabelaJson(null);
		
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
