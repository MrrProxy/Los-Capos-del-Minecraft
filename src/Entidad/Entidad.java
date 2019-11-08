package Entidad;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.GUI;
import Juego.Juego;
import Visitor.Visitor;

/**
 * Clase abstracta Entidad.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public abstract class Entidad {
	
	//Atributos especificos de una entidad
	protected int width ;
	protected int height;
	protected int monedas;
	protected int puntosVida;
	protected int danioImpacto;
	protected int velocidad;
	protected int precioPersonaje;
	protected int alcance;
	protected boolean puedoAvanzar;
	protected Point pos;
	protected JLabel grafico;
	protected GUI gui;
	protected Juego juego;
	protected Visitor miVisitor;
	protected Icon imagen[];
	protected int estado;


	

	// constructor
	protected Entidad(Point p, int width, int height) {//Recibe todos los componentes del enemigo no recive velocidad
		pos = p;
		this.width = width;
		this.height = height;
		this.imagen = new Icon[4];
		juego=Juego.getInstance();
	}
	
	
		//******METODOS******
	
		/**
		 * Devuelve el puntaje de la entidad.
		 * @return puntaje de la entidad.
		 */
		public int getMonedas(){
			return monedas;
		}
		
		public void fuisteClickeado(){

		}
		
		public void addCampo(){
		}
			
		
		/**
		 * Devuelve la cantidad de vidas que tiene la entidad.
		 * @return Cantidad de vidas.
		 */
		public int getVida() {
			return puntosVida;
		}
		
		
		/**
		 * Devuelve verdadero si la entidad no tiene mas vida, caso contrario falso.
		 * @return verdadero si la entidad murio, caso contrario falso.
		 */
		public boolean estoyMuerto() {
			return puntosVida <= 0;
		}
		
		
		/**
		 * Devuelve la posicision de la entidad.
		 * @return posicision de la entidad.
		 */
		public Point getPosition(){
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
		 * @param La posicion en el arreglo de la imagen que se desea obtener
		 */
		public JLabel getGrafico(int i){
			if(this.grafico == null){
				this.grafico = new JLabel(imagen[i]);
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
				this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
			}
		}
		
		/**
		 * Devuelve el daño de impacto que ocaciona la entidad en porcentaje.
		 * @return Daño de impacto que ocasiona.
		 */
		public int getDanio() {
			return danioImpacto;
		}
		
		/**
		 * Establece el daño de impacto que ocaciona la entidad en porcentaje. Requiere que el valor sea entre 0 a 100.
		 * @param d Daño de impacto.
		 */
		public void setDanio(int d) {
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
		/**
		 * Produce todas las acciones de las entidades
		 * @param e Entidad
		 */
		public abstract void Accionar(); 
		public abstract void Aceptar(Visitor v);
		
		public void morir() {
			puntosVida=0;
		}
		
		/**
		 * Devuelve el precio de la torre que se desea comprar
		 * @return Precio del personaje
		 */
		public int getPrecioPersonaje() {
			return precioPersonaje;
		}
		
		/**
		 * Actualiza el precio del personaje
		 * @param precio
		 */
		public void setPrecioPersonaje(int precio) {
			precioPersonaje=precio;
		}
		public int getPuntaje() {
			return 0;
		}
		
		public void recibirDaño(int daño) {
			puntosVida=puntosVida-daño;
			
		}
		public Visitor getVisitor() {
			return miVisitor;
		}
		
		public Rectangle getRectangle() {
			return new Rectangle(this.getPosition().x + this.velocidad, this.getPosition().y, this.anchoEntidad(),
					this.altoEntidad());
		}
		public int getAlcance() {
			return alcance;
		}
		
		/**
		 * Devuelve verdadero si las entidades colisionan, caso contrario falso.
		 * 
		 * @param e2 entidad2
		 * @return verdadero si colisionan, caso contrario falso.
		 */
		public boolean chocan( Entidad e2) {
			

			boolean colisionan;
			Rectangle rectangle = this.getRectangle();
			Rectangle rectangle2 = e2.getRectangle();
			colisionan=rectangle.intersects(rectangle2);
			
				return colisionan;
		}
		
		public void setEstado(int e) {
			estado=e;
		}
	
}
