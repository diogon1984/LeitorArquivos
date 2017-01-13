package br.com.diogo.leitor.io;

import java.util.List;
import java.util.Scanner;

import br.com.diogo.leitor.search.Pesquisa;

public class Console {
	
	private CsvReader arquivo;
	private Pesquisa pesquisa;
	
	
	
	public void init(){
		
		System.out.printf("CONSULTA DADOS ARQUIVO \n\n");
		Scanner ler = new Scanner(System.in);

		System.out.printf("Informe o caminho do arquivo:\n");
		String caminho = ler.nextLine();
		
		arquivo = new CsvReader(caminho);
		arquivo.processaArquivo();
		
		pesquisa = new Pesquisa(arquivo);
		
		
	}
	
	public void solicitaComando(){
		Scanner ler = new Scanner(System.in);

		System.out.printf("Informe o comando\n");
		String comando = ler.nextLine();
		verificaComando(comando);
	}
	
	public void verificaComando(String comando){
		
		
		if (pesquisa == null){
			System.out.println("pesquisa2 null");
		}
		String[] frase= comando.split(" ");
		
		String iniComando = frase[0];
		String segComando = frase[1];
		String terComando = "";
		
		if(!segComando.equals("*"))
			terComando = frase[2];
		
		
		switch (iniComando) {
	    case "count":
	    	switch (segComando){
	    	case "*":
	    		System.out.println("Total sem Vazio: " + pesquisa.totalRegistros());
				System.out.println("Total com Vazio: " + pesquisa.totalRegistrosComVazio());
	    		break;
	    	case "distinct":
	    		System.out.println("Total Distinct: " + pesquisa.totalRegistrosDistinct(terComando));
	    		break;
	    	default:
	  	      System.out.println("Comando Invalido.");
	  	      break;
	    	}
	      break;
	    case "filter":
	    	System.out.println("Filtro Resultado: ");
			List<String[]> resultado = pesquisa.filtraLinhaRegistros(segComando,terComando);
			
			System.out.println(resultado.size());
			for(int j=0;j<resultado.size();j++){
				for(int y=0;y<resultado.get(j).length;y++){
					System.out.print(resultado.get(j)[y] + " ");
				}
				System.out.println("");
			}
	      break;
	    case "sair":
	      System.out.println("Returning...");
	      break;
	    default:
	      System.out.println("Comando Invalido.");
	      break;
	    }
	}
	
}
