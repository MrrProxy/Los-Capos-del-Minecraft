package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;
import PowerUps.FuerzaDuplicada;

public class FDuplicada extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	
	private static  FDuplicada instance;

	public FDuplicada(GUI gui) {
		super(gui);
		this.setEnabled(false);
		this.setBounds(400, 40, 100, 50);
		this.setText("Fuerza Duplicada");

	}
	
	public static FDuplicada getInstance() {
		if (instance == null)
			instance = new FDuplicada(GUI.getInstance());
		return instance;

	}

	protected ImageIcon getIconoBoton() {
		return null;
	}

	@Override
	protected void accionarBoton() {
	    FuerzaDuplicada f = new FuerzaDuplicada(null,0,0);
	   f.activarPowerUp();
		restarContador();
	}

	
}
