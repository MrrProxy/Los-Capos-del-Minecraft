package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;

public class PowerUp4 extends BotonPwup {
	
	private static final long serialVersionUID = 1L;

	public PowerUp4(GUI gui) {
		super(gui);
		this.setBounds(500, 40, 100, 50);
		this.setText("Pwup4 ");

	}

	protected ImageIcon getIconoBoton() {
		return null;
		}

	@Override
	protected void accionarBoton() {
		
	}


	
}
