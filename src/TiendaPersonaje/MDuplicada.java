package TiendaPersonaje;

import java.awt.Color;

import javax.swing.ImageIcon;
import GUI.GUI;
import Objetos.DuplicarMonedas;
import Objetos.FuerzaDuplicada;

public class MDuplicada extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	private static  MDuplicada instance;


	public MDuplicada(GUI gui) {
		super(gui);
		this.setEnabled(false);
		this.setBounds(600, 40, 100, 50);
		this.setText("Duplicar Monedas ");

	}
	
	public static MDuplicada getInstance() {
		if (instance == null)
			instance = new MDuplicada(GUI.getInstance());
		return instance;

	}


	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Boton4.png"));
	}

	@Override
	protected void accionarBoton() {
		 DuplicarMonedas m = new DuplicarMonedas(null,0,0);
		   m.activarPowerUp();
			restarContador();
		//this.setForeground(Color.RED);
		
	}


	
}
