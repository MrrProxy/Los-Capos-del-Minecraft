package Tienda;

import java.util.LinkedList;

import javax.swing.JButton;

import Entidad.Entidad;
import GUI.GUI;
import Juego.Juego;

public class FabricaBoton extends JButton implements AbstractFactoryBoton {
	
	private static final long serialVersionUID = 1L;

	public FabricaBoton() {
		
	}

	public AbstractFactoryBoton getFabricaBoton() {
		return new FabricaBoton();
	}

	public BotonT1 getBoton1() {
		return new BotonT1();
	}

	public BotonT2 getBoton2() {
		return new BotonT2();
	}

	public BotonT3 getBoton3() {
		return new BotonT3();
	}

	public BotonT4 getBoton4() {
		return new BotonT4();
	}

	public BotonT5 getBoton5() {
		return new BotonT5();
	}

	public BotonComprar getBotonComprar(String s) {
		return new BotonComprar(s);
	}

	public void AccionarBoton(GUI gui,LinkedList<FabricaBoton> botones) {
		
		
	}

	public void Accionar(Entidad entidad,LinkedList<FabricaBoton> botones,GUI gui) {
		Juego juego=Juego.getInstance();
		
		
		//Controlo que disponga de la plata para comprar la torre
		int precio=entidad.getPrecioPersonaje();
		int monedas=juego.getCantMonedas();
		if(precio<=monedas) {
			gui.agregarTorre(entidad);
			juego.setCantMonedas(monedas-precio);
		}
		//Habilito el boton comprar y desabilito el resto
		for(FabricaBoton tienda : botones) {
			if(tienda.getText().equals("Comprar"))
				tienda.setEnabled(true);
			else {
				tienda.setEnabled(false);
			}
			
		}
		
	}


}
