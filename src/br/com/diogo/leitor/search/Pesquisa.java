package br.com.diogo.leitor.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.diogo.leitor.io.CsvReader;

public class Pesquisa {
	
	private CsvReader arquivo;

	public Pesquisa(CsvReader arquivo) {
		this.arquivo = arquivo;
	}
	
	public int totalRegistros(){
		int total=0;
		List<String[]> dados = arquivo.getDados();
		for(int i=0;i<dados.size();i++){
			for(int j=0;j<dados.get(j).length;j++){
				if(!dados.get(i)[j].trim().equals(""))
				total++;
			}
		}
		
		return total;
	}
	
	public int totalRegistrosComVazio(){
		int total=0;
		List<String[]> dados = arquivo.getDados();
		for(int i=0;i<dados.size();i++){
			total+= dados.get(i).length;
		}
		
		return total;
	}
	
	public int totalRegistrosDistinct(String propriedade){
		int posCol = -1;
		String[] cabecalho = arquivo.getCabecalho();
		Set<String> distinct = new HashSet<>();
		
		for(int i=0;i<cabecalho.length;i++){
			if(cabecalho[i].equals(propriedade))
				posCol = i;
		}
		
		List<String[]> dados = arquivo.getDados();
		for(int i=0;i<dados.size();i++){
			distinct.add(dados.get(i)[posCol]);
		}
	
		return distinct.size();
	}
	
	public List<String[]> filtraLinhaRegistros(String propriedade, String valor){
		int total=0;
		int posCol = -1;
		String[] cabecalho = arquivo.getCabecalho();
		List<String[]> resultado = new ArrayList<String[]>();
		
		for(int i=0;i<cabecalho.length;i++){
			if(cabecalho[i].equals(propriedade))
				posCol = i;
		}
		resultado.add(cabecalho);
		List<String[]> dados = arquivo.getDados();
		
		for(int i=0;i<dados.size();i++){
			if(dados.get(i)[posCol].equals(valor))		
				resultado.add(dados.get(i));
		}
		
		return resultado;
	}
	
}
