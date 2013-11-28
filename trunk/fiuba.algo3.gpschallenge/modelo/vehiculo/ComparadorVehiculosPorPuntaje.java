package modelo.vehiculo;


@SuppressWarnings("rawtypes")
public class ComparadorVehiculosPorPuntaje implements java.util.Comparator{
	
	public int compare(Object o1, Object o2){
		if(o1 instanceof Vehiculo && o2 instanceof Vehiculo && o1 != null && o2 != null){
			Vehiculo vehiculo1 = (Vehiculo)o1;
			Vehiculo vehiculo2 = (Vehiculo)o2;
			if(vehiculo1.getPuntaje()<vehiculo2.getPuntaje())
				return -1;
			else if (vehiculo1.getPuntaje()>vehiculo2.getPuntaje())
				return 1;
			else return 0;
		}
		else throw new IllegalArgumentException();
	}

}
