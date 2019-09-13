package Juego;


import java.awt.Point;
import java.util.Random;

import Enemigo.Enemigo;
import Enemigo.Zombie;
import Entidad.Entidad;
import GUI.GUI;
import Mapa.Mapa;
import Personaje.SteveDiamante;

/**
 * Clase Juego .
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Juego {
	protected int cantMonedas;
	protected Mapa map;
	private GUI gui;
	private Enemigo malos[];
	private Entidad buenoEntidad;
	
	//Constructor
	public Juego(GUI gui){
		map = new Mapa();
		
		int arreglo [] = new int[6];
		arreglo[0]=40;
		arreglo[1]=135;
		arreglo[2]=230;
		arreglo[3]=325;
		arreglo[4]=415;
		arreglo[5]=415;
		
		
		malos = new Zombie[10];

		for (int i = 0; i < malos.length; i++) {
			int valorX = (int) (1 * 800);
			int random = (int)(Math.random()*((5-0+1))+0); //Calcula random entre 0 y 5
			int valorY = arreglo[random];
			malos[i] = new Zombie(new Point(valorX, valorY), 42, 42);
			buenoEntidad=new SteveDiamante(new Point(valorX, valorY), 77, 77);
			gui.agregarAlJuego(buenoEntidad.getGrafico(2));
			gui.agregarAlJuego(malos[i].getGrafico(1));
		}
		
		
	}
	
	//Agrega entidad grafica
	public void agregarEntidad(Entidad e){
			map.agregarEntidadMap(e);
	}
	
	public boolean mapavacio(Entidad e) {
		return map.EstaVacioLugar(e);
	}
	public void establecerGrafica(GUI g) {
		if(gui == null)
			gui = g;
	}
	//Inicia el juego
	/*public void iniciarJuego() {
		
		entidad = new Zombie(new Point(750, 50), 41, 42);
		gui.add(entidad.getGrafico());
		
	}*/
		
	
	
	public void mover(){
		//System.out.print("EMTRE");
		for(int i = 0; i < malos.length; i++){
			malos[i].mover(-1);
		}
		}
	}
	
	
