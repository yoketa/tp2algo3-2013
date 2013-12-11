package excepciones;

public class OcupacionCoincidenteConOtroObjetoException extends Exception {
	
	/**
	 * Se lanzan cuando se trata de agregar objetos
	 * con una ocupación coincidentes en posicion.
	 * 
	 */
		private static final long serialVersionUID = 1;
		
		public OcupacionCoincidenteConOtroObjetoException(String mensaje) {
			super(mensaje);
		}

}
