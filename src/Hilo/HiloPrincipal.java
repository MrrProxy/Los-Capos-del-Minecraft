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
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//nivel.cargarEntidadesAlJuego();
				juego.Accionar();

				
			}
			
		}
}

