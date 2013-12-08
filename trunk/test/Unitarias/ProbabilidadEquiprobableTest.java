package Unitarias;

import static org.junit.Assert.*;
import junit.framework.Assert;
import modelo.juego.Vector;
import modelo.probabilidades.ProbabilidadEquiprobable;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class ProbabilidadEquiprobableTest {

	@Test
	public void testCalcularDeberiaRetornarUnValorDeProbabilidadValido() {
		ProbabilidadEquiprobable probabilidadEquiprobable = new ProbabilidadEquiprobable();
		
		assertTrue( 0 < probabilidadEquiprobable.calcular());
		assertTrue( 1 > probabilidadEquiprobable.calcular());
	}

}
