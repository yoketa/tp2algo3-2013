package excepciones;

	public class ValorDeProbabilidadInvalidoException extends Exception {
		
		/**
		 * Se lanzan si el valor de probabilidad calculado es invalido
		 */
		
		private static final long serialVersionUID = 1L;
		
		public ValorDeProbabilidadInvalidoException(String mensaje) {
			super(mensaje);
		}

}
