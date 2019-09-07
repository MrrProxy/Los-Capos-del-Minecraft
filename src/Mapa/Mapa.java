package Mapa;

import java.awt.Point;

import Entidad.Entidad;

public class Mapa {
	
	protected Entidad [][] Celdas;
	
	public Mapa(){
		Celdas= new Entidad[600][800];
	}
	
	public void agregarEntidadMap(Entidad e){
		
		int x = e.obtenerPosicion().x;
		int y = e.obtenerPosicion().y;
		
		if (Celdas[x][y]==null)
			Celdas[x][y]=e;
		
		
		
		
		
		
	}

}
