package br.com.diogo.leitor.teste;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.diogo.leitor.io.CsvReader;
import br.com.diogo.leitor.search.Pesquisa;

public class TestaConsole {
		 
	public static void main(String[] args)  {
		
		System.out.printf("CONSULTA DADOS ARQUIVO \n\n");
		Scanner ler = new Scanner(System.in);

		System.out.printf("Informe o caminho do arquivo:\n");
		String arquivo = ler.nextLine();
		
//		String arquivo = "C:\\Users\\Diogo-HP\\Documents\\Involves\\cidadest.csv";
		CsvReader csv = new CsvReader(arquivo);
		Pesquisa pes = new Pesquisa(csv);
		
		csv.processaArquivo();
		String[] cabecalho = csv.getCabecalho();
		List<String[]> dados = csv.getDados();
		
		
		System.out.println("Total sem Vazio: " + pes.totalRegistros());
		System.out.println("Total com Vazio: " + pes.totalRegistrosComVazio());
		
		System.out.println("Total Distinct: " + pes.totalRegistrosDistinct("capital"));
		
		System.out.println("Filtro Resultado: ");
		List<String[]> resultado = pes.filtraLinhaRegistros("microregion","Cacoal");
//			

		for(int j=0;j<resultado.size();j++){
			for(int y=0;y<resultado.get(j).length;y++){
				System.out.print(resultado.get(j)[y] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("");
		

	//	System.out.printf("\nConteudo do arquivo texto:\n");
		
	}
	
	
}
