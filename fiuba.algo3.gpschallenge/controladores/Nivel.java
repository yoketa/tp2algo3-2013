package controladores;

import java.util.ArrayList;
import java.util.List;

import modelo.juego.Ranking;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Obstaculo;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.sorpresas.CambioDeVehiculo;
import modelo.sorpresas.Sorpresa;
import modelo.sorpresas.SorpresaDesfavorable;
import modelo.sorpresas.SorpresaFavorable;
import modelo.vehiculo.Auto;
import modelo.vehiculo.ComparadorVehiculosPorPuntaje;
import modelo.vehiculo.Vehiculo;

import org.jdom.Attribute;
import org.jdom.Element;

public class Nivel {

	public static String nivelPath = "C:\\Persistencia\\Nivel.xml";
	public static String nivelFacilPath = "C:\\Level\\NivelFacil.xml";
	public static String nivelMedioPath = "C:\\Level\\NivelMedio.xml";
	public static String nivelDificilPath = "C:\\Level\\NivelDificil.xml";
	public static String nivelSorpresaPath = "C:\\Persistencia\\Sorpresa.xml";
	public static String nivelObstaculoPath = "C:\\Persistencia\\Obstaculo.xml";
	
	private String dificultad = "";
	private List<Sorpresa> sorpresas;
	private List<Obstaculo> obstaculos;
	public Nivel(){
		this.sorpresas = new ArrayList<Sorpresa>();
		this.obstaculos = new ArrayList<Obstaculo>();
	}
	
	
	/**
	 * agrego un obstaculo al nivel
	 * @param unObstaculo
	 */
	public void agregarUnObstaculo(Obstaculo unObstaculo){
		obstaculos.add(unObstaculo);
	}

	
	/**
	 * agrego una sorpresa al nivel
	 *@param unaSaorpresa
	 */
	public void agregarUnaSorpresa(Sorpresa unaSorpresa){
		sorpresas.add(unaSorpresa);
	}
	
	/**
	 * agrego una lista de sorpresas al nivel
	 *@param sorpresas
	 */
	public void agregarSorpresas (List<Sorpresa> sorpresas){
		this.sorpresas= sorpresas;
	}
	
	/**
	 * agrego una lista de obstaculs al nivel
	 *@param obstaculos
	 */
	public void agregarObstaculos (List<Obstaculo> obstaculos){
		this.obstaculos= obstaculos;
	}
	
	public List<Sorpresa> getSorpresas(){
		return sorpresas;
	}
	
	public List<Obstaculo> getObstaculos(){
		return obstaculos;
	}
	
	// BEGIN Serialización
	public Element serializarXML() {
		Element element = new Element("Nivel");
		
		for (Sorpresa sorpresa : sorpresas) {
			Element entradaSorpresa = new Element("Sorpresa");
			entradaSorpresa.addContent(sorpresa.serializarXML());
			element.addContent(entradaSorpresa);
		}
		
		for (Obstaculo obstaculo : obstaculos) {
			Element entradaObstaculo = new Element("Obstaculo");
			entradaObstaculo.addContent(obstaculo.serializarXML());
			element.addContent(entradaObstaculo);
		}
		return element;
	}
	
	public static Nivel cargarDesdeXML(Element element) {
		List<Sorpresa> sorpresas = new ArrayList<Sorpresa>();
		List<Obstaculo> obstaculos = new ArrayList<Obstaculo>();
		for (Object sorpresaGuardada : element.getChildren()) {
			
				
				Sorpresa miSorpresa= null;
				if ((((Element)sorpresaGuardada).getChild("SorpresaFavorable")) != null){
					SorpresaFavorable tipoSorpresa = null;
					tipoSorpresa = SorpresaFavorable.cargarDesdeXML(((Element)sorpresaGuardada).getChild("SorpresaFavorable"));
					miSorpresa=tipoSorpresa;	
				}
				if ((((Element)sorpresaGuardada).getChild("SorpresaDesfavorable")) != null){
					SorpresaDesfavorable tipoSorpresa;
					tipoSorpresa = SorpresaDesfavorable.cargarDesdeXML(((Element)sorpresaGuardada).getChild("SorpresaDesfavorable"));
					miSorpresa=tipoSorpresa;	
				}
				if ((((Element)sorpresaGuardada).getChild("CambioDeVehiculo")) != null){
					CambioDeVehiculo tipoSorpresa;
					tipoSorpresa = CambioDeVehiculo.cargarDesdeXML(((Element)sorpresaGuardada).getChild("CambioDeVehiculo"));
					miSorpresa=tipoSorpresa;	
				}
				
				Obstaculo miObstaculo= null;
				if ((((Element)sorpresaGuardada).getChild("Pozo")) != null){
					Pozo tipoObstaculo = null;
					tipoObstaculo = Pozo.cargarDesdeXML(((Element)sorpresaGuardada).getChild("Pozo"));
					miObstaculo =tipoObstaculo;	
				}
				if ((((Element)sorpresaGuardada).getChild("Piquete")) != null){
					Piquete tipoObstaculo = null;
					tipoObstaculo = Piquete.cargarDesdeXML(((Element)sorpresaGuardada).getChild("Piquete"));
					miObstaculo = tipoObstaculo;	
				}
				if ((((Element)sorpresaGuardada).getChild("ControlPolicial")) != null){
					ControlPolicial tipoObstaculo = null;
					tipoObstaculo = ControlPolicial.cargarDesdeXML(((Element)sorpresaGuardada).getChild("ControlPolicial"));
					miObstaculo = tipoObstaculo;	
				}
				
			if(miSorpresa != null){
			sorpresas.add(miSorpresa);
			}
			if(miObstaculo != null){
				obstaculos.add(miObstaculo);
				}
			
		}
		
		Nivel nivel = new Nivel ();
		nivel.agregarSorpresas(sorpresas);
		nivel.agregarObstaculos(obstaculos);
		return nivel;
	}	
	// END Serialización

	/* Devuelve el path de dónde cargar el nivel según la dificultad
	 * elegida
	 * 
	 * */
	public static String GetNivelPath(String dificultad) {
		switch (dificultad) {
		case "Facil":
			return Nivel.nivelFacilPath;
		case "Moderado":
			return Nivel.nivelMedioPath;
		case "Dificil":
			return Nivel.nivelDificilPath;
		default:
			return "";
		}
	}
	
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	public String getDificultad() {
		return this.dificultad;
	}
}
