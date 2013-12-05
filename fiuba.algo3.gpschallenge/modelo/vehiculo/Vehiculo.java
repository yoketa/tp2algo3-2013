package modelo.vehiculo;

import modelo.interfaces.EstadoVehiculo;

import java.util.Observable;
import modelo.juego.Nivel;
import modelo.juego.Vector;

import org.jdom.Attribute;
import org.jdom.Element;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;



public class Vehiculo extends Observable implements ObjetoPosicionable, ObjetoVivo {

	private String piloto;
	private Vector posicion;
	private Vector direccion;
	private Vector direccionAFinalDeCuadra;
	private double puntaje;
	private int movimientos;
	private EstadoVehiculo estadoActual;
	
	private final int X=0;
	private final int Y=0;
	final Vector SUBIR = new Vector(0,-Nivel.tama�oCalle);
	final Vector BAJAR = new Vector(0,Nivel.tama�oCuadra);
	final Vector DERECHA = new Vector(Nivel.tama�oCuadra,0);
	final Vector IZQUIERDA = new Vector(-Nivel.tama�oCalle,0);
	 
	final Vector SUBIRCUADRA = new Vector(0,-Nivel.tama�oCuadra);
	final Vector BAJARCUADRA = new Vector(0,Nivel.tama�oCalle);
	final Vector DERECHACUADRA = new Vector(Nivel.tama�oCalle,0);
	final Vector IZQUIERDACUADRA = new Vector(-Nivel.tama�oCuadra,0);


	public static Vehiculo crearConPilotoYVehiculo(String piloto,EstadoVehiculo estadoInicial) {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPiloto(piloto);
		vehiculo.setEstado(estadoInicial);
		vehiculo.setPuntaje(0);
		vehiculo.setMovimientos(0);
		
		return vehiculo;
	}

	public Vehiculo(){
		this.posicion = new Vector(this.X,this.Y);
		this.direccion = new Vector(0,0);
	}
	
	public Vehiculo(int x, int y){
		this.posicion = new Vector(x,y);
		this.puntaje = 0;
	}
	
	private void setPiloto(String piloto) {
		this.piloto = piloto;
		ActualizarObservadores();
	}

	public String getPiloto() {
		return this.piloto;
	}

	@Override
	public int getY() {
		return this.posicion.getY();
	}

	@Override
	public int getX() {
		return this.posicion.getX();
	}
	
	public Vector getDireccion(){
		return this.direccion;
	}
	
	private void setMovimientos(int i) {
		this.movimientos = i;
	}
	
	public void setX(int x)  {
		this.posicion.setX(x);
				
	}

	public void setY(int y) {
		this.posicion.setY(y);
	}
	
	public Vector getPosicion() {
		return this.posicion;
	}
	
	public int getMovimientos() {
		return this.movimientos;
	}
	public void setPosicion(Vector vector){
		this.posicion = vector;
	}

	public double getPuntaje() {
		return this.puntaje;
	}
	
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
		ActualizarObservadores();
	}
	
	public EstadoVehiculo getEstado() {
		return this.estadoActual;
	}
	
	public void setEstado(EstadoVehiculo estado) {
		this.estadoActual = estado;
		ActualizarObservadores();
	}
	
	public void sumarMovimientos(int movimientoNuevo) {
		this.movimientos = this.movimientos + movimientoNuevo;
	}

	// Mueve el vehiculo a mitad de cuadra en una direccion
	public void mover() {
		
		this.posicion.setX(this.posicion.getX() + direccion.getX());
		this.posicion.setY(this.posicion.getY() + direccion.getY());
		
		this.movimientos++;
	}
	
	// No debe haber un evento que no te permita el avance
	public void avanzarAFinalDeCuadra() {
		
		this.posicion.setX(this.posicion.getX() + direccionAFinalDeCuadra.getX());
		this.posicion.setY(this.posicion.getY() + direccionAFinalDeCuadra.getY());
	}
	
	public void pegarLaVuelta() {

		this.posicion.setX(this.posicion.getX() + (direccion.getX()*(-1)));
		this.posicion.setY(this.posicion.getY() + (direccion.getY()*(-1)));
	}

	public void penalizacionDesfavorable() {
		this.estadoActual.penalizacionDesfavorable(this);
	}
	
	public void penalizacionFavorable() {
		this.estadoActual.penalizacionFavorable(this);
	}
	
	public void pasaPorPozo() {
		this.estadoActual.pasaPorPozo(this);
	}
	
	public void piquete() {
		this.estadoActual.piquete(this);
	}
	
	public void controlPolicial(double probabilidad) {
		this.estadoActual.controlPolicial(this,probabilidad);
	}
	
	public void cambiarEstado() {
		this.estadoActual.cambiarEstado(this);
	}

	public Element serializarXML() {
		Element element = new Element("Vehiculo");
		Attribute att1 = new Attribute("puntaje",Double.valueOf(puntaje).toString());
		Attribute att2 = new Attribute("piloto",String.valueOf(piloto).toString());
		Attribute att3 = new Attribute("movimientos",Integer.valueOf(movimientos).toString());
		element.getAttributes().add(att1);
		element.getAttributes().add(att2);
		element.getAttributes().add(att3);
		element.addContent(posicion.serializarXML());
		element.addContent(estadoActual.serializarXML());
		return element;
	}
	
	public static Vehiculo cargarDesdeXML(Element element) {
		String valorPuntaje = element.getAttributeValue("puntaje");
		String valorPiloto = element.getAttributeValue("piloto");
		String valorMovimientos = element.getAttributeValue("movimientos");
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		EstadoVehiculo estado = null;
			if ((element.getChild("Auto")) != null){
				estado = new Auto();
				estado = Auto.cargarDesdeXML(element.getChild("Auto"));
			}
			if ((element.getChild("Moto")) != null){
				estado = new Moto();
				estado = Moto.cargarDesdeXML(element.getChild("Moto"));
			}
			if ((element.getChild("CuatroXCuatro")) != null){
				estado = new CuatroXCuatro();
				estado = CuatroXCuatro.cargarDesdeXML(element.getChild("CuatroXCuatro"));
			}
			
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo(valorPiloto,estado);
		vehiculo.setPuntaje(Double.parseDouble(valorPuntaje)); 
		vehiculo.setMovimientos(Integer.parseInt(valorMovimientos));	
		vehiculo.setPosicion(vector);
		return vehiculo;
	}
	
	public void subir() {
		this.direccion = SUBIR;
		this.direccionAFinalDeCuadra = SUBIRCUADRA;
		this.mover();
	}
	
	public void bajar() {
		this.direccion = BAJAR;
		this.direccionAFinalDeCuadra = BAJARCUADRA;
		this.mover();
	}
	
	public void derecha() {
		this.direccion = DERECHA;
		this.direccionAFinalDeCuadra = DERECHACUADRA;
		this.mover();
	}
	
	public void izquierda() {
		this.direccion = IZQUIERDA;
		this.direccionAFinalDeCuadra = IZQUIERDACUADRA;
		this.mover();
	}
	
	public void ActualizarObservadores()
	{
		setChanged();
		notifyObservers();		
	}

	@Override
	public void vivir() {
				
	}
}
