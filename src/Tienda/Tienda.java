package Tienda;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import Entidad.Entidad;
import GUI.GUI;
import Juego.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Clase Tienda que extiende de Juego.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Tienda extends JButton {
	private static final long serialVersionUID = 1L;

	// Lista de botones
	LinkedList<Tienda> listadeBotones = new LinkedList<Tienda>();;
	Entidad entidad;
	Juego juego;

	// Crea los botones de las torres
	private  void agregarBotones() {
		// Se crea el boton Torre1
		Tienda Torre1 = new BotonT1();
		// Se crea el boton Torre2
		Tienda Torre2 = new BotonT2();
		// Se crea el boton Torre3
		Tienda Torre3 = new BotonT3();
		// Se crea el boton Torre4
		Tienda Torre4 = new BotonT4();
		// Se crea el boton Torre5
		Tienda Torre5 = new BotonT5();
		// Se crea el boton Comprar
		Tienda Comprar = new BotonComprar("Comprar");
		// Se agregan los botones a la lista
		listadeBotones.addLast(Torre1);
		listadeBotones.addLast(Torre2);
		listadeBotones.addLast(Torre3);
		listadeBotones.addLast(Torre4);
		listadeBotones.addLast(Torre5);
		listadeBotones.addLast(Comprar);
	}

	 public void crearBotones(GUI gui) {
		int x = 0;
		int i = 1;
		agregarBotones();
		//crea los botones que esten en la lista
		for (Tienda aUXButton : listadeBotones) {
			aUXButton.setForeground(new java.awt.Color(155, 017, 030));
			aUXButton.setBackground(new java.awt.Color(0, 0, 0));
			aUXButton.setFont(new java.awt.Font("cambria", 12, 33));
			aUXButton.setHorizontalAlignment(SwingConstants.CENTER);
			aUXButton.setBorderPainted(true);
			aUXButton.setVisible(true);
			aUXButton.setLayout(null);
			if (aUXButton.getText().equals("Comprar")) {
				aUXButton.setBounds(0, 600, 200, 100);
			} else {
				aUXButton.setBounds(0, x, 200, 100);
				aUXButton.setText("Torre " + i);
				aUXButton.setEnabled(false);
				x += 100;
				i++;
			}

			gui.agregarBotones(aUXButton);
			aUXButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aUXButton.AccionarBoton(gui, listadeBotones);

				}
			});
		}
	}

	public void AccionarBoton(GUI gui, LinkedList<Tienda> tiendas) {
	}

}// Fin clase Tienda
