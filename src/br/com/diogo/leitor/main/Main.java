package br.com.diogo.leitor.main;

import br.com.diogo.leitor.io.Console;

public class Main {
		 
	public static void main(String[] args)  {
		Console console = new Console();
		
		console.init();
		console.solicitaComando();
	}
	
	
}
