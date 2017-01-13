package br.com.diogo.leitor.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {


	private String caminhoArquivo;
	private String[] cabecalho;
	private List<String[]> dados = new ArrayList<String[]>();

	
	
	public CsvReader(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public void processaArquivo() {
	
		boolean ehCabecalho = true;
					
		FileReader arquivoFR;
		try {
			arquivoFR = new FileReader(caminhoArquivo);
		
		
		
		BufferedReader lerArq = new BufferedReader(arquivoFR);
		
		String linha = "";
		while ((linha = lerArq.readLine()) != null) {
			if (ehCabecalho){
				cabecalho = linha.split(",");
				ehCabecalho = false;
			}else {
				String[] row = linha.split(",");
				dados.add(row);
				
			}
			//arquivoFR.close();
		}
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
		
		
	}


	public String[] getCabecalho() {
		return cabecalho;
	}

	
	public List<String[]> getDados() {
		return dados;
	}
	
	public int getNumLinhas() {
		return dados.size();
	}

}
