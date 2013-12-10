package Unitarias;


import modelo.probabilidades.ProbabilidadFija;
import excepciones.ValorDeProbabilidadInvalidoException;

import org.junit.Assert;
import org.junit.Test;

public class ProbabilidadFijaTest {

	@Test
	public void testCalcularDeberiaRetornarElValorDeProbabilidadFijado() throws ValorDeProbabilidadInvalidoException {
		double x = 0.2;
		
		ProbabilidadFija probabilidadFija = new ProbabilidadFija(x);
		Assert.assertEquals( x , probabilidadFija.calcular(), 0);		
	}
	
	@Test
	public void testProbabilidadFijaDeberiaLanzarValorDeProbabilidadInvalidoExceptionSiIntentaCrearConUnValorInvalido() {
		double x = 1.1;
		
		ProbabilidadFija probabilidadFija = new ProbabilidadFija(x);
		Assert.assertEquals( x , probabilidadFija.calcular(), 0);		
	}
}

