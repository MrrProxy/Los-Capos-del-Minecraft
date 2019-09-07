package Entidad;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase abstracta Entidad.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public abstract class Entidad {
	
	//Atributos especificos de una entidad
	protected int width = 42;
	protected int height= 42;
	protected JLabel grafico;
	protected Icon imagen[];
	protected int puntaje;
	protected int puntosVida;
	protected int ancho;
	protected int alto;
	protected Point pos;
	protected int danioImpacto;
	protected int velocidad;//Velocidad es solo del enemigo es correcto tenerla en la Entidad PREGUNTAR
	

	// constructor
	protected Entidad(Point p, int ancho, int alto) {
		pos = p;
		this.ancho = ancho;
		this.alto = alto;
		this.imagen = new Icon[4];
	}
	
		//******METODOS******
	
	public void mover(int Velocidad){	
		System.out.println("ENTRE 2 "+pos.x+"y es igual a  "+pos.y);
		pos.x+=Velocidad;
		setGrafico(1);
		
	}
	
		/**
		 * Devuelve el puntaje de la entidad.
		 * @return puntaje de la entidad.
		 */
		public int getPuntaje() {
			return puntaje;
		}
		
		/**
		 * Establece el puntaje de la entidad por la recibida como parametro.
		 * @param p puntaje a establecer.
		 */
		public void setPuntaje(int p) {
			puntaje = p;
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
		 * Devuelve la cantidad de vidas que tiene la entidad.
		 * @return Cantidad de vidas.
		 */
		public int cantVidas() {
			return puntosVida;
		}
		
		
		/**
		 * Devuelve verdadero si la entidad no tiene mas vida, caso contrario falso.
		 * @return verdadero si la entidad murio, caso contrario falso.
		 */
		public boolean estoyMuerto() {
			return cantVidas() <= 0;
		}
		
		
		/**
		 * Devuelve la posicision de la entidad.
		 * @return posicision de la entidad.
		 */
		public Point obtenerPosicion(){
			return pos;
		}
		
		/**
		 * Establece la posicion de la entidad con la posicion recibida por parametro.
		 * @param p posicion a asignar.
		 */
		public void setPosition(Point p) {
			pos = p;
		}
		
		/**
		 * Devuelve el grafico de la entidad.
		 * @return grafico de la entidad.
		 */
		public JLabel getGrafico(){
			if(this.grafico == null){
				this.grafico = new JLabel(imagen[0]);
				this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
			}
			return grafico;
		}
		
		/**
		 * Establece el grafico de la entidad.
		 * @param dir numero de grafico.
		 */
		public void setGrafico(int dir){
			if(this.grafico != null){
				this.grafico.setIcon(this.imagen[dir]);
				this.grafico.setBounds(this.pos.x-30, this.pos.y, width, height);
			}
		}
		
		/**
		 * Devuelve el daño de impacto que ocaciona la entidad en porcentaje.
		 * @return Daño de impacto que ocasiona.
		 */
		public int obtenerDanio() {
			return danioImpacto;
		}
		
		/**
		 * Establece el daño de impacto que ocaciona la entidad en porcentaje. Requiere que el valor sea entre 0 a 100.
		 * @param d Daño de impacto.
		 */
		public void establecerDanio(int d) {
			danioImpacto = d;
		}
		
		/**
		 * Devuelve la altura de la entidad.
		 * @return altura entidad.
		 */
		public int altoEntidad() {
			return height;
		}
		
		/**
		 * Devuelve el ancho de la entidad.
		 * @return ancho entidad.
		 */
		public int anchoEntidad() {
			return width;
		}
		
	
}
