package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;

public class PowerUp2 extends BotonPwup {
	
	private static final long serialVersionUID = 1L;

	public PowerUp2(GUI gui) {
		super(gui);
		this.setBounds(300, 40, 100, 50);
		this.setText("Pwup2 ");

	}

	protected ImageIcon getIconoBoton() {
		return null;
	}

	@Override
	protected void accionarBoton() {
		
	}


	
}
