package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;

public class PowerUp3 extends BotonPwup {
	
	private static final long serialVersionUID = 1L;

	public PowerUp3(GUI gui) {
		super(gui);
		this.setBounds(400, 40, 100, 50);
		this.setText("Pwup3 ");

	}

	protected ImageIcon getIconoBoton() {
		return null;
	}

	@Override
	protected void accionarBoton() {
		
	}


	
}
