package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;
import PowerUps.Temporizador;

public class Temp extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	private static  Temp instance;

	public Temp(GUI gui) {
		super(gui);
		this.setEnabled(false);
		this.setBounds(500, 40, 100, 50);
		this.setText("Temporizador ");

	}
	
	public static Temp getInstance() {
		if (instance == null)
			instance = new Temp(GUI.getInstance());
		return instance;

	}

	protected ImageIcon getIconoBoton() {
		return null;
		}

	protected void accionarBoton() {
		Temporizador t = new Temporizador(null,0,0);
		t.activarPowerUp();
		restarContador();
	}


	
}
