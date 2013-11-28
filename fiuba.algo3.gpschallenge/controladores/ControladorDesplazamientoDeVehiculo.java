package controladores;
import java.awt.event.*;

import modelo.vehiculo.Vehiculo;

public class ControladorDesplazamientoDeVehiculo {
	
		private Vehiculo vehiculo;
		
		public ControladorDesplazamientoDeVehiculo (Vehiculo vehiculo)
		{
			this.vehiculo = vehiculo;
		}
		
		private class EscuchaBotonSubir implements ActionListener
		{	public void actionPerformed(ActionEvent e)
			{
				vehiculo.subir();
			}	
		}
		
		public ActionListener getListenerBotonSubir() {
			return new EscuchaBotonSubir();
		}
		
		private class EscuchaBotonBajar implements ActionListener
		{	public void actionPerformed(ActionEvent e)
			{		
				vehiculo.bajar();
			}
		}

		public ActionListener getListenerBotonBajar() {
			return new EscuchaBotonBajar();
		}
		
		private class EscuchaBotonDerecha implements ActionListener
		{	public void actionPerformed(ActionEvent e)
			{	
				vehiculo.derecha();
			}
		}
		
		public ActionListener getListenerBotonDerecha() {
			return new EscuchaBotonDerecha();
		}
		
		private class EscuchaBotonIzquierda implements ActionListener
		{	public void actionPerformed(ActionEvent e)
			{	
				vehiculo.izquierda();
			}
		}
		
		public ActionListener getListenerBotonIzquierda() {
			return new EscuchaBotonIzquierda();
		}

}
