package modelo.juego;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Obstaculo;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.sorpresas.CambioDeVehiculo;
import modelo.sorpresas.Sorpresa;
import modelo.sorpresas.SorpresaDesfavorable;
import modelo.sorpresas.SorpresaFavorable;
import modelo.vehiculo.Vehiculo;

public class Partida {
	private String usuario;
	private Vehiculo vehiculo;
	private List<Sorpresa> sorpresas;
	private List<Obstaculo> obstaculos;
	private String partidaPath; ;
	
	public Partida(Vehiculo vehiculo){
		this.sorpresas = new ArrayList<Sorpresa>();
		this.obstaculos = new ArrayList<Obstaculo>();
		this.vehiculo = vehiculo;
		this.partidaPath = "partidas/Partida "+this.vehiculo.getPiloto()+".xml";
	}

	public void setUsuario(String usuario){
		this.usuario = usuario;	
	}
		public void agregarUnObstaculo(Obstaculo unObstaculo){
			obstaculos.add(unObstaculo);
		}

		
		/**
		 * agrego una sorpresa 
		 *@param unaSaorpresa
		 */
		public void agregarUnaSorpresa(Sorpresa unaSorpresa){
			sorpresas.add(unaSorpresa);
		}
		
		/**
		 * agrego una lista de sorpresas 
		 *@param sorpresas
		 */
		public void agregarSorpresas (List<Sorpresa> sorpresas){
			this.sorpresas= sorpresas;
		}
		
		/**
		 * agrego una lista de obstaculo
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
	
		
		public void setVehiculo(Vehiculo vehiculo){
			this.vehiculo = vehiculo;
		} 
		
		public Vehiculo getVehiculo(){
			return this.vehiculo;
		}
		
		public String getPath(){
			return this.partidaPath;
		}
		
		public Element serializarXML() {
			Element element = new Element("Partida");
			element.addContent(vehiculo.serializarXML());
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

		
		
		public static Partida cargarDesdeXML(Element element) {
			List<Sorpresa> sorpresas = new ArrayList<Sorpresa>();
			List<Obstaculo> obstaculos = new ArrayList<Obstaculo>();
			Vehiculo vehiculo = Vehiculo.cargarDesdeXML(element.getChild("Vehiculo"));
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
			
			Partida partida = new Partida (vehiculo);
			partida.agregarSorpresas(sorpresas);
			partida.agregarObstaculos(obstaculos);
			return partida;
		}	

}

