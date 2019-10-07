package Hilo;

import Juego.Juego;
import Mapa.Nivel;

public class HiloPrincipal extends Thread {
	//Atributos
		
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
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				nivel.cargarEntidadesAlJuego();
				juego.Accionar();

				
			}
			
		}
}

