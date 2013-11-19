package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.ProbabilidadEquiprobable;
import fiuba.algo3.gpschallenge.modelo.ProbabilidadFija;

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
