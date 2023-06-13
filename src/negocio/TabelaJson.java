package negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TabelaJson {
	private File tabelaJson;
	
	public TabelaJson() {
		this.tabelaJson = new File("tabela.json");
	} 

	public File getTabelaJson() {
		return tabelaJson; 
	} 
 
	public void setTabelaJson(File tabelaJson) {
		this.tabelaJson = tabelaJson;
	}
	
	public boolean estaVazia() {
		try (BufferedReader br = new BufferedReader(new FileReader(tabelaJson))) {
			if (br.readLine() == null)
				return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void limpar() {
		try (FileWriter fw = new FileWriter(tabelaJson)) {
	        fw.write("");
	        fw.flush();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	}
}