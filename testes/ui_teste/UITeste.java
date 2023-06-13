package ui_teste;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import ui.UI;

class UITeste {
	@AfterEach
	public void tearDown() {
		UI ui = new UI();
    	ui.getBrasileiraoServico().getTabelaJson().limpar();
	}
	 
    @Test
    void inserirTime() throws JsonProcessingException {
    	//input -> Cria Time Teste e sai
    	String input = "1\nTime Teste\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        UI ui = new UI();
        ui.menu();
        
        assertEquals(1, ui.getBrasileirao().getTimes().size());
    }
    
    @Test
    void deletarTimeDeletaTimeExistente() throws JsonProcessingException {
    	//input -> Deleta Time Teste e sai
    	String input = "2\n1\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        UI ui = new UI();
        ui.menu();
        
        assertEquals(0, ui.getBrasileirao().getTimes().size());
    }
    
    @Test
    void registrarPartidaQuandoTemDoisTimesDiferentes() throws JsonProcessingException {
    	//input -> Cria Time A e Time B registra uma partida entre eles e sai
    	System.out.println("-----Debugar abaixo:-----");
    	String input = "1\nTime A\n1\nTime B\n3\n5\n0\n6\n0\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        UI ui = new UI(); 
        ui.menu();
        
        assertEquals(2, ui.getBrasileirao().getTimes().size());
    }
    
    @Test
    void mostrarTabelaClassificacaoVaziaSemNenhumTime() {
    	//input -> mostra tabela classificação e sai
    	String input = "4\n5";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    	
    	UI ui = new UI();
    	
    	assertDoesNotThrow(() -> ui.menu());
    }
     
    @Test
    void mostrarTabelaClassificacaoVaziaComTime() {
    	//input -> insere time, mostra tabela classificação e sai
    	String input = "1\nTime A\n4\n5";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    	
    	UI ui = new UI();
    	
    	assertDoesNotThrow(() -> ui.menu());
    }
    
    @Test
    void menuOpcaoInvalidaExibeMensagemDeErro() {
    	//input -> digite opção inválida, depois opção para sair
    	String input = "-1\n5";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    	
    	UI ui = new UI();
		
    	assertDoesNotThrow(() -> ui.menu());
    } 
    
    @Test
    void deletarTimeExibeErroQuandoIdEhInvalido() {
    	//input -> tenta deletar time por id inválido e depois sai
    	String input = "2\n-1\n5";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    	
    	UI ui = new UI();
		
    	assertDoesNotThrow(() -> ui.menu());
    }
    
    @Test
    void registrarPartidaExibeErroQuandoTamanhoTimesEhMenorQueDois() {
    	//input -> tenta registrar partida e sai
    	String input = "3\n5";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    	
    	UI ui = new UI();
		
    	assertEquals(0, ui.getBrasileirao().getTimes().size());
    	assertDoesNotThrow(() -> ui.menu());
    }  
    
    @Test
    void registrarPartidaLoopEnquantoPlacarTime1EhNegativo() throws JsonProcessingException {
    	//input -> Cria Time B, registra partida entre Time A e B e testa placar negativo e sai
    	String input = "1\nTime A\n1\nTime B\n3\n1\n-10\n0\n2\n-10\n0\n5";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    	
    	UI ui = new UI();
		ui.menu();
		
		System.out.println(ui.getBrasileirao().getTimes());
    	assertEquals(2, ui.getBrasileirao().getTimes().size());
    } 
}