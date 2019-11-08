package TiendaPersonaje;

import javax.swing.ImageIcon;
import GUI.GUI;

public class Bombas extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	private static Bombas instance;

	private Bombas(GUI gui) {
		super(gui);
		this.setBounds(300, 40, 100, 50);
		this.setText("Bombas");

	}
	
	public static Bombas getInstance(){
		if (instance==null)
			instance=new Bombas(GUI.getInstance());
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
