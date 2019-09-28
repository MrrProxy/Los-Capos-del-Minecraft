package Hilo;

import java.util.LinkedList;

import Entidad.Entidad;
import Juego.Juego;
import Mapa.Nivel;

public class HiloPrincipal extends Thread {
	//Atributos
		
//		private LinkedList<Enemigo> enemigos;
//		private LinkedList<Entidad> entidades;
//		private LinkedList<Enemigo> elimEnemigos;
//		private LinkedList<Entidad> elimEntidades;
		private Nivel nivel;
		private static HiloPrincipal instaceHiloPrincipal;
		Juego juego;
		
		public static HiloPrincipal getInstace() {
			if(instaceHiloPrincipal==null)
				instaceHiloPrincipal=new HiloPrincipal();
			return instaceHiloPrincipal;
		}
		
		//Constructor
		private HiloPrincipal(){
			nivel = new Nivel();
			juego = Juego.getInstance();
		}
		
		//Metodos
		
		@Override
		public void run() {
			
			while(true) {
				try {
					Thread.sleep(70);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				nivel.cargarEntidadesAlJuego();
				juego.Accionar();
				colisionador();
				
			}
			
		}
	
		public synchronized void colisionador() {
			LinkedList<Entidad> entidades=new LinkedList<Entidad>(juego.getEntidades());
			Entidad aux=entidades.getFirst();
			for(Entidad e : entidades) {
					if(colisionan(aux,e)) {
						e.morir();
						aux.morir();
					}
				
			}
			
	
		}
		
	/**
	 * Devuelve verdadero si las entidades colisionan, caso contrario falso.
	 * @param l1 label de entidad 1.
	 * @param l2 label de entidad 2.
	 * @return verdadero si colisionan, caso contrario falso.
	 */
	private boolean colisionan(Entidad l1, Entidad l2) {
		boolean colisionan = false;
		
		int x_centro = l1.getPosition().x+ l1.anchoEntidad();
		int y_centro = l1.getPosition().y+ l1.altoEntidad();
		int x_centro2 = l2.getPosition().x+ l2.anchoEntidad();
		int y_centro2 = l2.getPosition().y+ l2.altoEntidad();
		
		if((x_centro > l2.getPosition().x) && (x_centro < x_centro2))
			if((y_centro > l2.getPosition().y) && (y_centro < y_centro2)) 
				colisionan = true;
		
		return colisionan;
	}
	
}

