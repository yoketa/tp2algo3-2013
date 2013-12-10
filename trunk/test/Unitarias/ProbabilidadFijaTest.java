package Unitarias;


import modelo.probabilidades.ProbabilidadFija;
import excepciones.ValorDeProbabilidadInvalidoException;

import org.junit.Assert;
import org.junit.Test;

public class ProbabilidadFijaTest {

	@Test
	public void testCalcularDeberiaRetornarElValorDeProbabilidadFijado() {
		double x = 0.2;
		
		try {
			ProbabilidadFija probabilidadFija = new ProbabilidadFija(x);
			Assert.assertEquals( x , probabilidadFija.calcular(), 0);
		}
		catch ( ValorDeProbabilidadInvalidoException ex) {
			System.out.println(ex.toString());
		}		
	}
	
	@Test
	public void testProbabilidadFijaDeberiaLanzarValorDeProbabilidadInvalidoExceptionSiIntentaCrearConUnValorInvalido() {
		double x = 1.1;
		
		try {
			ProbabilidadFija probabilidadFija = new ProbabilidadFija(x);
			Assert.assertEquals( x , probabilidadFija.calcular(), 0);
		}
		catch ( ValorDeProbabilidadInvalidoException ex) {
			System.out.println(ex.toString());
		}		
	}
}


