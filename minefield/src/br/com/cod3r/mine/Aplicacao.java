package br.com.cod3r.mine;

import br.com.cod3r.mine.model.Tabuleiro;
import br.com.cod3r.mine.view.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		new TabuleiroConsole(tabuleiro);
		
	}

}
