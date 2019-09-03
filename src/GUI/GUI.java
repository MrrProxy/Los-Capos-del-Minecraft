package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {// Interfaz grafica del juego

	// Frame y panel
	private JFrame frameInicio, frameJuego;
	private JLayeredPane panel, panelPrincipal, panelJuego, panelTorres, panelJugador;

	// Atributos de la GUI
	private JLabel fondo;
	private JLabel fondo2;
	private JLabel fondo3;
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
				iniciarJuego();
			}

		});
	}// Fin inicializar

	/*
	 * Inicializa el frame principal,
	 */
	public void iniciarJuego() {
		/**
		 * Se crea la ventana principal, donde se desarrolla el juego
		 */
		// *********Se crea el frame*********
		frameJuego = new JFrame();// Crea la ventana donde se desarrolla el juego
		frameJuego.setBounds(0, 0, 800, 600);
		frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuego.setLocationRelativeTo(null);
		frameJuego.setResizable(false);
		frameJuego.setTitle("Proyecto de TDP 2019");
		frameJuego.setVisible(true);

		// *********Se crean los paneles*********
		panelPrincipal = new JLayeredPane();// Panel juego principal
		panelPrincipal.setBounds(0, 0, 800, 600);

		panelTorres = new JLayeredPane();// Panel donde se compran las torres
		panelTorres.setBounds(550, 0, 250, 450);
		panelTorres.setBackground(Color.green);

		panelJugador = new JLayeredPane();// Panel del jugador con la vida etc
		panelJugador.setBounds(0, 450, 800, 150);
		panelJugador.setBackground(new java.awt.Color(204, 0, 0));

		panelJuego = new JLayeredPane();// Panel donde se ejecuta el juego (MAPA)
		panelJuego.setBounds(0, 0, 550, 450);
		panelJuego.setForeground(Color.red);

		// ************Se crean los JLabel con sus imagenes************
		fondo = new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/MinecraftFondo1.jpg")));
		fondo.setBounds(0, 0, 250, 450);

		fondo2 = new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/MinecraftFondo2.jpg")));
		fondo2.setBounds(0, 0, 800, 150);
		fondo2.setBackground(new java.awt.Color(204, 0, 0));

		fondo3 = new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/materia-oscura.jpg")));
		fondo3.setBounds(0, 0, 800, 570);
		
		//Se agregan los JLabel a sus respectivos paneles
		panelTorres.add(fondo, -1);
		panelJugador.add(fondo2, -1);
		panelJuego.add(fondo3, -1);

		// Se setea el panel principal con el contenedor del frame y se agregan los
		// demas paneles al panel principal
		frameJuego.setContentPane(panelPrincipal);//
		panelPrincipal.add(panelTorres);
		panelPrincipal.add(panelJugador);
		panelPrincipal.add(panelJuego);

	}
}
