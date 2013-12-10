package Unitarias;

import static org.junit.Assert.*;
import modelo.probabilidades.ProbabilidadEquiprobable;
import org.junit.Test;

import excepciones.ValorDeProbabilidadInvalidoException;

public class ProbabilidadEquiprobableTest {
	
	@Test
	public void testCalcularDeberiaRetornarUnValorDeProbabilidadValidoSinoLanzarUnaException() throws ValorDeProbabilidadInvalidoException {

		ProbabilidadEquiprobable probabilidadEquiprobable = new ProbabilidadEquiprobable();
		assertTrue( 0 <= probabilidadEquiprobable.calcular());
		assertTrue( 1 >= probabilidadEquiprobable.calcular());		
	}
}

