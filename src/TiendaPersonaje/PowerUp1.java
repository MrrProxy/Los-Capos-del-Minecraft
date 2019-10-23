package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;

public class PowerUp1 extends BotonPwup {
	
	private static final long serialVersionUID = 1L;

	public PowerUp1(GUI gui) {
		super(gui);
		this.setBounds(200, 40, 100, 50);
		this.setText("Pwup1 ");

	}

	protected ImageIcon getIconoBoton() {
		return null;
	}

	@Override
	protected void accionarBoton() {
		
	}


	
}
