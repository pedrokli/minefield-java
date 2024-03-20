package br.com.cod3r.mine.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo viznho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(viznho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo viznho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(viznho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1EmCima() {
		Campo viznho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(viznho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Embaixo() {
		Campo viznho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(viznho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo viznho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(viznho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo viznho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(viznho);
		
		assertFalse(resultado);
	}
	
	
}
