package TiendaPersonaje;

import java.awt.Color;

import javax.swing.ImageIcon;
import GUI.GUI;
import PowerUps.DuplicarVelocidadAtaque;
import PowerUps.FuerzaDuplicada;

public class VelocidadDuplicada extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	private static  VelocidadDuplicada instance;


	public VelocidadDuplicada(GUI gui) {
		super(gui);
		this.setEnabled(false);
		this.setBounds(600, 40, 100, 50);
		this.setText("VA");

	}
	
	public static VelocidadDuplicada getInstance() {
		if (instance == null)
			instance = new VelocidadDuplicada(GUI.getInstance());
		return instance;

	}


	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Boton4.png"));
	}

	@Override
	protected void accionarBoton() {
		 DuplicarVelocidadAtaque m = new DuplicarVelocidadAtaque(null,0,0);
		   m.activarPowerUp();
			restarContador();
		//this.setForeground(Color.RED);
		
	}


	
}
