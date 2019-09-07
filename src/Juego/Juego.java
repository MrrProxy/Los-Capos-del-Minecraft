package Juego;

import Entidad.Entidad;
import Mapa.Mapa;

public class Juego {
	protected int cantMonedas;
	protected Mapa map;
	
	public Juego(){
		map = new Mapa();
	}
	
	public void agregarEntidad(Entidad e){
		map.agregarEntidadMap(e);
		
		
	}
	
	
}
