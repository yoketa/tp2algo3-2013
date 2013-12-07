package persistencia;

import java.io.FileWriter;

import modelo.juego.Nivel;
import modelo.juego.Partida;
import modelo.juego.Ranking;
import modelo.vehiculo.Vehiculo;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;



public class Archivador {
	
	// BEGIN Archivo de Veh�culo
	public static void guardar(Vehiculo vehiculo, String pathArchivo) {
		try {
	        
			Element root = vehiculo.serializarXML();
	        Document document = new Document(root);

	        XMLOutputter outputter = new XMLOutputter();
	        outputter.setFormat(Format.getPrettyFormat());
	        
	        FileWriter writer = new FileWriter(pathArchivo);
	        outputter.output(document,writer);
	        writer.close();
	        
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static Vehiculo cargar(Vehiculo dummy, String pathArchivo) {
		try {
	        SAXBuilder builder = new SAXBuilder();
	        Document document = builder.build(pathArchivo);
	        
	        return Vehiculo.cargarDesdeXML(document.getRootElement());
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	// END Archivo de Veh�culo
	
	// BEGIN Archivo de Ranking
	public static void guardar(Ranking ranking, String pathArchivo) {
		try {
	        
			Element root = ranking.serializarXML();
	        Document document = new Document(root);

	        XMLOutputter outputter = new XMLOutputter();
	        outputter.setFormat(Format.getPrettyFormat());
	        
	        FileWriter writer = new FileWriter(pathArchivo);
	        outputter.output(document,writer);
	        writer.close();
	        
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static Ranking cargar(Ranking dummy, String pathArchivo) {
		try {
	        SAXBuilder builder = new SAXBuilder();
	        Document document = builder.build(pathArchivo);
	        
	        return Ranking.cargarDesdeXML(document.getRootElement());
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	// END Archivo de Ranking


	public static void guardar(Nivel nivel, String pathArchivo) {
		try {
	        
			Element root = nivel.serializarXML();
	        Document document = new Document(root);

	        XMLOutputter outputter = new XMLOutputter();
	        outputter.setFormat(Format.getPrettyFormat());
	        
	        FileWriter writer = new FileWriter(pathArchivo);
	        outputter.output(document,writer);
	        writer.close();
	        
	      } catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Nivel cargar(Nivel dummy, String pathArchivo) {
		try {
	        SAXBuilder builder = new SAXBuilder();
	        Document document = builder.build(pathArchivo);
	        
	        return Nivel.cargarDesdeXML(document.getRootElement());
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void guardar(Partida partida, String pathArchivo) {
		try {
	        
			Element root = partida.serializarXML();
	        Document document = new Document(root);

	        XMLOutputter outputter = new XMLOutputter();
	        outputter.setFormat(Format.getPrettyFormat());
	        
	        FileWriter writer = new FileWriter(pathArchivo);
	        outputter.output(document,writer);
	        writer.close();
	        
	      } catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Partida cargar(Partida dummy,String pathArchivo) {
		try {
	        SAXBuilder builder = new SAXBuilder();
	        Document document = builder.build(pathArchivo);
	        
	        return Partida.cargarDesdeXML(document.getRootElement());
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
