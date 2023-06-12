package negocio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BrasileiraoServico {
	private TabelaJson tabelaJson;
	private ObjectMapper objectMapper;
	
	public BrasileiraoServico() {
		tabelaJson = new TabelaJson();
		objectMapper = new ObjectMapper();
	}
	
	public TabelaJson getTabelaJson() {
		return tabelaJson;
	}

	public void setTabelaJson(TabelaJson tabelaJson) {
		this.tabelaJson = tabelaJson;
	}



	public ArrayList<Time> carregarArquivoJson() {
		ObjectMapper objectMapper = new ObjectMapper();
	    File arquivoJson = tabelaJson.getTabelaJson();

	    try {
	    	if (tabelaJson.estaVazia()) return new ArrayList<Time>();
	    	
	    	Brasileirao brasileirao = objectMapper.readValue(arquivoJson, Brasileirao.class);
	        ArrayList<Time> times = brasileirao.getTimes();

	        return times;
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
 
	    return new ArrayList<Time>();
	} 
	
	public void salvarArquivoJson(Brasileirao brasileirao) throws JsonProcessingException {
		String tabelaSalvar = javaParaJson(brasileirao);
		
		try (FileWriter fw = new FileWriter(tabelaJson.getTabelaJson(), false)) {
			fw.write(tabelaSalvar);
			//TODO testando abaixo
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String javaParaJson(Brasileirao brasileirao) throws JsonProcessingException {
		return objectMapper.writeValueAsString(brasileirao);
	}
}