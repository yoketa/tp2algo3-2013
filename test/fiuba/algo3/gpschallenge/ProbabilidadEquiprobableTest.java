package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.ProbabilidadEquiprobable;
import fiuba.algo3.gpschallenge.modelo.Vector;
import fiuba.algo3.gpschallenge.modelo.Vehiculo;

public class ProbabilidadEquiprobableTest {

	@Test
	public void testCalcularDeberiaRetornarUnValorDeProbabilidadValido() {
		ProbabilidadEquiprobable probabilidadEquiprobable = new ProbabilidadEquiprobable();
		
		assertTrue( 0 < probabilidadEquiprobable.calcular());
		assertTrue( 1 > probabilidadEquiprobable.calcular());
	}

}
