package main;

import com.fasterxml.jackson.core.JsonProcessingException;

import ui.UI;

public class Main {

	public static void main(String[] args) {
		UI ui = new UI();
		
		try {
			ui.menu();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}  
}