package vistas;

import java.util.Observable;
import java.util.Observer;

import modelo.vehiculo.Vehiculo;

public class VistaDeVehiculo implements Observer  {
	
	private Vehiculo modelo; 

	public VistaDeVehiculo(Vehiculo modelo)
	{	
		this.modelo = modelo;
		this.modelo.addObserver(this); 
	}

	public void update(Observable t, Object o)
	{	
		System.out.println("");
	}
	
}

