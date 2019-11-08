package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;
import PowerUps.*;

public class BombaBoton extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	private static BombaBoton instance;

	private BombaBoton(GUI gui) {
		super(gui);
		this.setBounds(300, 40, 100, 50);
		this.setText("Bombas");
		this.setEnabled(false);

	}
	
	public static BombaBoton getInstance(){
		if (instance==null)
			instance=new BombaBoton(GUI.getInstance());
		return instance;
		
	}

	protected ImageIcon getIconoBoton() {
		return null;
	}

	@Override
	protected void accionarBoton() {
		
		GUI.getInstance().agregarBomba(new BombaExplosion(null,80,80));
		
	}


	
}
