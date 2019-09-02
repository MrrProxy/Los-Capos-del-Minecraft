package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {//Interfaz grafica del juego
	
	//Frame y panel
	private JFrame frameInicio, frameJuego;
	private JLayeredPane panel, panel2;

	// Atributos de la  GUI
	private JLabel fondo;
	private JLabel fondo2;
	private JButton startButton;

	/**
	 * Ejecuta la aplicacion GUI.
	 * 
	 * @param args arrglo de String.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frameInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la GUII. Crea la aplicacion.
	 */
	public GUI() {
		iniciar();
	}

	/*
	 * Inicializa los atributos de la gui, crea la intefaz grafica
	 */
	private void iniciar() {
		// ****************Frame******************
		frameInicio = new JFrame();// Inicializa el frame
		frameInicio.setBounds(0, 0, 800, 600);// Setea el tamaño del frame
		frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicio.getContentPane().setLayout(null);
		frameInicio.setLocationRelativeTo(null);
		frameInicio.setResizable(false);
		frameInicio.setTitle("Proyecto de TDP 2019");// Titulo
		frameInicio.setVisible(true);
		panel = new JLayeredPane();
		frameInicio.setContentPane(panel);// Agrega el frame al panel

		// ****************Fondo******************
		fondo = new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/MinecraftFondo2.jpg")));
		fondo.setSize(800, 570);
		frameInicio.add(fondo, -1);// Agrega el fondo al frame

		// ***************Boton Start*************
		startButton = new JButton("Start");// Crea el boton
		startButton.setBounds(300, 400, 180, 70);
		startButton.setForeground(new java.awt.Color(155, 017, 030));
		startButton.setBackground(new java.awt.Color(0, 0, 0));
		startButton.setFont(new java.awt.Font("cambria", 15, 50));
		startButton.setHorizontalAlignment(SwingConstants.CENTER);
		startButton.setBorderPainted(true);
		frameInicio.add(startButton);// Agrega el boton al frame

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** Elimina la ventana anterior */
				frameInicio.dispose();

				/**
				 * Se crea la ventana principal, donde se desarrolla el juego
				 */
				frameJuego = new JFrame();
				frameJuego.setBounds(0, 0, 800, 600);
				frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameJuego.getContentPane().setLayout(null);
				frameJuego.setLocationRelativeTo(null);
				frameJuego.setResizable(false);
				frameJuego.setTitle("Proyecto de TDP 2019");
				frameJuego.setVisible(true);
				panel2 = new JLayeredPane();
				frameJuego.setContentPane(panel2);
				fondo2 = new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/MinecraftFondo1.jpg")));
				fondo2.setBounds(0, 0, 800, 570);
				frameJuego.add(fondo2, -1);

				iniciarJuego();
			}

		});
	}// Fin inicializar

	/*
	 * Inicializa el frame principal, 
	 */
	public void iniciarJuego() {

	}
}
