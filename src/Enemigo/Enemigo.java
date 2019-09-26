package Enemigo;

import java.awt.Point;

import Entidad.Entidad;
import GUI.GUI;

/**
 * Clase abstracta Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */

public abstract class Enemigo extends Entidad {
	
	//Atributos especificos de un enemigo
	
	//Constructor
		protected Enemigo(Point p, int ancho , int alto) {
			super(p, ancho, alto);
		}
		
		/**
		 * Devuelve la velocidad de desplazamiento de la entidad.
		 * @return velocidad de desplazamiento de la entidad.
		 */
		public int getVelocidad(){
			return velocidad;
		}
		
		/**
		 * Establece la velocidad de desplazamiento de la entidad por la recibida como parametro.
		 * @param v velocidad a establecer.
		 */
		public void setVelocidad(int v){
			velocidad = v;		
		}
		
		/**
		 * Produce el movimiento de los enemigos
		 * @param v velocidad con la que se desplaza el enemigo
		 */
		public void Accionar(){
			pos.x-=velocidad;
			setGrafico(1);
			
			
		}
		
		public void morir() {
			puntosVida=0;
		}
		
		
		

}
