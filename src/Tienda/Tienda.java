package Tienda;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.util.LinkedList;
import GUI.GUI;
/**
 * Clase Tienda que extiende de Juego.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Tienda extends JButton{
	//Lista de botones
	LinkedList<JButton> listadeButtons=new LinkedList<JButton>();
	
	
	//Crea los botones de las torres 
	public void  crearBotones(GUI gui) {
		JButton Button;
		int x=0;
			for (int i=0;i<5;i++) {
				Button= new JButton("Torre "+i);
				Button.setBounds(0, x, 200, 100);
				Button.setForeground(new java.awt.Color(155, 017, 030));
				Button.setBackground(new java.awt.Color(0, 0, 0));
				Button.setFont(new java.awt.Font("cambria", 12, 33));
				Button.setHorizontalAlignment(SwingConstants.CENTER);
				Button.setBorderPainted(true);
				Button.setVisible(true);
				listadeButtons.add(Button);
				x+=100;
				gui.agregarBotones(Button);
			}
		
	}


}
