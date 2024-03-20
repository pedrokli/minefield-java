package br.com.cod3r.mine.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.mine.exception.ExplosaoException;

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
	
	@Test
	void testeValorPadraorMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();

		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, ()->{
			campo.abrir();
		});
		
	}
	
	@Test
	void testeAbrirComVizinhos1() {
		Campo campo11 = new Campo(1, 1);	

		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);

		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {
		
		Campo campo11 = new Campo(1, 1);	
		Campo campo12 = new Campo(1, 1);	
		campo12.minar();

		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);


		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
}
