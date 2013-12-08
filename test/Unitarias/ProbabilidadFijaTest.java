package Unitarias;

import static org.junit.Assert.*;
import junit.framework.Assert;
import modelo.probabilidades.ProbabilidadEquiprobable;
import modelo.probabilidades.ProbabilidadFija;

import org.junit.Test;

public class ProbabilidadFijaTest {

	@Test
	public void testCalcularDeberiaRetornarElValorDeProbabilidadFijado() {
		double x = 0.2;
		ProbabilidadFija probabilidadFija = new ProbabilidadFija(x);
		
		assertTrue( 0 < probabilidadFija.calcular());
		assertTrue( 1 > probabilidadFija.calcular());
		Assert.assertEquals( x , probabilidadFija.calcular());
	}
}
