package ui_teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.UI;

class UITeste {
	private UI ui;
	
	@BeforeEach
	void setUp() {
		ui = new UI();
	}
	
	@Test
	void menuNaoDeveRetornarException() {
		assertDoesNotThrow(() -> ui.menu());
	}
}