package Hilo;

import java.util.LinkedList;

import javax.swing.JLabel;

import Enemigo.Enemigo;
import Entidad.Entidad;
import Juego.Juego;

public class HiloPrincipal extends Thread {
	//Atributos
		
		private LinkedList<Enemigo> enemigos;
		private LinkedList<Entidad> entidades;
		private LinkedList<Enemigo> elimEnemigos;
		private LinkedList<Entidad> elimEntidades;
		private static HiloPrincipal instaceHiloPrincipal;
		
		public static HiloPrincipal getInstace() {
			if(instaceHiloPrincipal==null)
				instaceHiloPrincipal=new HiloPrincipal();
			return instaceHiloPrincipal;
		}
		
		//Constructor
		private HiloPrincipal(){
			Juego juego = Juego.getInstance();
			//enemigos = juego.obtenerEnemigos();
			entidades = juego.obtenerEntidades();
		}
		
		//Metodos
		
		@Override
		public void run() {
			Juego juego = Juego.getInstance();
			while(true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		
				elimEnemigos = new LinkedList<Enemigo>();
				elimEntidades = new LinkedList<Entidad>();
				juego.Accionar();
				
			}
			
		}
	
	//Metodos Privados
	
	/**
	 * Colisiona a los enemigos con las entidades y el jugador.
	 *
	private void colisionarEnemigos() {
		for(Enemigo enem : enemigos) {
			enem.mover();
			synchronized(entidades) {
			//Colisionar entidades
			for(Entidad ent: entidades) {
				if(colisionan(enem.getGrafico(1), ent.getGrafico(1))) {
					enem.colisionar(ent);
				}	
			}
			}
			//colisionar Jugador
			Juego juego = Juego.getInstance();
			if(colisionan(enem.getGrafico(1), juego.obtenerJugador().getGrafico())) {
				enem.colisionar(juego.obtenerJugador());
				verificarVidaJugador();
			}
			//agregar enemigo sin vida a eliminar
			if(enem.estoyMuerto()) {
				elimEnemigos.add(enem);
			}
		}
	}

	**
	 * Colisiona las entidades con los enemigos y jugador.
	 *
	private void colisionarEntidades() {
		synchronized(entidades) {
		for(Entidad ent : entidades) {
			ent.mover();
			
			//Colisionar entidades con enemigos
			for(Enemigo enem : enemigos) {
				if(colisionan(ent.getGrafico(), enem.getGrafico())) {
					ent.colisionar(enem);
				}					
			}
			
			//Colisionar entidades con entidades
			for(Entidad ent2: entidades) {
				if(colisionan(ent.getGrafico(), ent2.getGrafico())) {
					ent.colisionar(ent2);
				}	
			}
			
			//colisionar Jugador
			JuegoHilo juego = JuegoHilo.getInstance();
			if(colisionan(ent.getGrafico(), juego.obtenerJugador().getGrafico())) {
				ent.colisionar(juego.obtenerJugador());
				verificarVidaJugador();
			}
			
			//agregar entidad sin vida a eliminar
			if(ent.estoyMuerto()) {
				elimEntidades.add(ent);
			}
		}
		}
	}
	
	/**
	 * Elimina del juego a los enemigos muertos.
	 *
	private void elimEnemigos() {
		Juego juego = Juego.getInstance();
		for(Enemigo enem : elimEnemigos) {
			juego.eliminarEnemigo(enem);
		}
	}
	
	//Elimina del juego a las entidades muertas.
	private void elimEntidades() {
		Juego juego = JuegoHilo.getInstance();
		for(Entidad ent : elimEntidades) {
			juego.eliminarEntidad(ent);
		}
	}
	*/
	/**
	 * Devuelve verdadero si las entidades colisionan, caso contrario falso.
	 * @param l1 label de entidad 1.
	 * @param l2 label de entidad 2.
	 * @return verdadero si colisionan, caso contrario falso.
	 */
	private boolean colisionan(JLabel l1, JLabel l2) {
		boolean colisionan = false;
		
		int x_centro = l1.getX() + l1.getWidth();
		int y_centro = l1.getY() + l1.getHeight();
		int x_centro2 = l2.getX() + l2.getWidth();
		int y_centro2 = l2.getY() + l2.getHeight();
		
		if((x_centro > l2.getX()) && (x_centro < x_centro2))
			if((y_centro > l2.getY()) && (y_centro < y_centro2)) 
				colisionan = true;
		
		return colisionan;
	}
	
}

