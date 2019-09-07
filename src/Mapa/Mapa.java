package Mapa;

import Entidad.Entidad;

/**
 * Clase Mapa.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Mapa {
	
	//Atributos mapa
	protected Entidad [][] Celdas;
	
	//Constructor
	public Mapa(){
		Celdas= new Entidad[800][600];
	}
	
	public void agregarEntidadMap(Entidad e){
		
		int x = e.obtenerPosicion().x;
		int y = e.obtenerPosicion().y;
		
		if (Celdas[x][y]==null)
			Celdas[x][y]=e;
		
		
		
		
		
		
	}

}
