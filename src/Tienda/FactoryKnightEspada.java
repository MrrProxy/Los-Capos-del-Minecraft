package Tienda;

import java.awt.Point;

import Entidad.Entidad;
import Personaje.KnightEspada;

public class FactoryKnightEspada implements Factory{
	
	
	public Entidad getEntidad() {
		Entidad toReturn=new KnightEspada(new Point(0,0),70,70);
		return toReturn;
	}

}
