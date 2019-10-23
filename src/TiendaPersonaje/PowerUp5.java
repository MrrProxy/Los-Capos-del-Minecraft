package TiendaPersonaje;

import java.awt.Color;

import javax.swing.ImageIcon;
import GUI.GUI;

public class PowerUp5 extends BotonPwup {
	
	private static final long serialVersionUID = 1L;

	public PowerUp5(GUI gui) {
		super(gui);
		this.setBounds(600, 40, 100, 50);
		this.setText("Pwup5 ");

	}

	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Boton4.png"));
	}

	@Override
	protected void accionarBoton() {
		this.setForeground(Color.RED);
		
	}


	
}
