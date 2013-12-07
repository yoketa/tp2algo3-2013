package modelo.juego;

import org.jdom.Attribute;
import org.jdom.Element;

public class Vector {

	private int x;
	private int y;

	public Vector(int x,int y){
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@SuppressWarnings("unchecked")
	public Element serializarXML() {
		Element element = new Element("Vector");
		
		Attribute att1 = new Attribute("x", String.valueOf(Integer.valueOf(x).toString()));
		Attribute att2 = new Attribute("y", String.valueOf(Integer.valueOf(y).toString()));
		element.getAttributes().add(att1);
		element.getAttributes().add(att2);
		return element;
	}
	
	public static Vector cargarDesdeXML(Element element) {
		String valorX = element.getAttributeValue("x");
		String valorY = element.getAttributeValue("y");
		Vector vector = new Vector(Integer.parseInt(valorX),Integer.parseInt(valorY)); 
		
		return vector;
	}

}
