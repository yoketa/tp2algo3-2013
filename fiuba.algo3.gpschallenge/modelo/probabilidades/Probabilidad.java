package modelo.probabilidades;

public abstract class Probabilidad {
	
	public double probabilidad;
	
	public Probabilidad () {
		this.probabilidad = 0;
	}
	
	public double calcular(){
		return this.probabilidad;
	}
}
