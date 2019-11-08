package TiendaPersonaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GUI.GUI;

public abstract class BotonPwup extends JButton {

	private static final long serialVersionUID = 1L;

	// Atributos
	protected int contadorPremio;

	// Constructor
	protected BotonPwup(GUI gui) {
		contadorPremio=0;
		// this.setIcon(this.getIconoBoton());
		this.setForeground(new java.awt.Color(155, 017, 030));
		this.setBackground(new java.awt.Color(0, 0, 0));
		this.setFont(new java.awt.Font("cambria", 4, 18));
		this.setText("holass");
		this.setVisible(true);
		this.setLayout(null);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionarBoton();
			}
		});
	}
	
	public void sumarContador(){
		contadorPremio++;
		System.out.println(contadorPremio);
		System.out.println("que onda");
		setEnabled(true);
	}
	
	public void restarContador(){
		System.out.print("entree");
		contadorPremio--;
		if (contadorPremio==0)
			this.setEnabled(false);
	}

	// Preguntar si es correcto dejarlo protected para poder redefinirlo(no tendria
	// sentido dejarlo privado)?¡
	protected abstract void accionarBoton();

	protected abstract ImageIcon getIconoBoton();
}
