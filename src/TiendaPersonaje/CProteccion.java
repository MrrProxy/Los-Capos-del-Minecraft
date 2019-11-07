package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;
import Juego.Juego;
import PowerUps.CampoProteccion;

public class CProteccion extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	
	private static  CProteccion instance;

	public CProteccion(GUI gui) {
		super(gui);
		this.setEnabled(false);
		this.setBounds(200, 40, 100, 50);
		this.setText("CampoProteccion ");

	}
	
	public static CProteccion getInstance() {
		if (instance == null)
			instance = new CProteccion(GUI.getInstance());
		return instance;

	}

	protected ImageIcon getIconoBoton() {
		return null;
	}

	@Override
	protected void accionarBoton() {
		
		GUI.getInstance().agregarCampo();
		restarContador();
		
		
		
		
		
	}

	

	
	


	
}
