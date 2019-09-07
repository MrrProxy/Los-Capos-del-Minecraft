package GUI;

import java.awt.event.*;
import java.time.Year;
import java.util.Random;
import java.awt.*;
import java.applet.*;

import javax.swing.*;

import Enemigo.Araña;
import Enemigo.Zombie;
import Juego.Juego;
import Entidad.*;
import Hilo.HiloPrincipal;

/**
 * Clase GUI .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class GUI extends JFrame {// Interfaz grafica del juego

	// Frame y panel
	private JFrame frameInicio, frameJuego;
	private JLayeredPane panel, panelPrincipal, panelJuego, panelTorres, panelJugador;

	// Atributos de la GUI
	private Juego j ;
	private HiloPrincipal tiempo;

	// ****Labels****
	private JLabel fondo;
	private JLabel fondo2;
	private JLabel fondo3;
	private JLabel Titulo2;
	// ****Botones****
	private JButton startButton;
	private JButton Comprar;
	private JButton Torre1;

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
		fondo = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/MinecraftFondo2.jpg")));
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
		frameJuego.setBounds(0, 0, 1000, 800);
		frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuego.setLocationRelativeTo(null);
		frameJuego.setLayout(null);
		frameJuego.setResizable(false);
		frameJuego.setTitle("Proyecto de TDP 2019");
		frameJuego.setVisible(true);
		// frameJuego.setBackground(Color.RED);

		// *********Se crean los paneles*********
		panelPrincipal = new JLayeredPane();// Panel juego principal
		panelPrincipal.setBounds(0, 0, 1000, 700);
		panelPrincipal.setLayout(null);

		panelTorres = new JLayeredPane();// Panel donde se compran las torres
		panelTorres.setBounds(800, 0, 200, 700);

		panelJugador = new JLayeredPane();// Panel del jugador con la vida etc
		panelJugador.setBounds(0, 600, 800, 100);

		panelJuego = new JLayeredPane();// Panel donde se ejecuta el juego (MAPA)
		panelJuego.setBounds(0, 0, 800, 600);

		// ************Se crean los JLabel con sus imagenes************
		fondo = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/GREEN.jpg")));
		fondo.setBounds(0, 0, 800, 600);

		fondo2 = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/RED.jpg")));
		fondo2.setBounds(0, 0, 800, 150);
		fondo2.setBackground(new java.awt.Color(204, 0, 0));

		fondo3 = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/GameMap.png")));
		fondo3.setBounds(0, 0, 800, 600);

		Titulo2 = new JLabel("PANEL 2");
		Titulo2.setBounds(0, 0, 400, 100);
		Titulo2.setForeground(Color.BLACK);
		Titulo2.setBackground(new java.awt.Color(0, 0, 0));
		Titulo2.setFont(new java.awt.Font("cambria", 15, 40));

		// Se agregan los JLabel a sus respectivos paneles
		panelTorres.add(fondo, -1);
		panelJugador.add(fondo2, -1);
		panelJugador.add(Titulo2, 0);
		panelJuego.add(fondo3, -1);

		// Se crea el boton Comprar
		Comprar = new JButton("Comprar");// Crea el boton
		Comprar.setBounds(0, 600, 200, 100);
		Comprar.setForeground(new java.awt.Color(155, 017, 030));
		Comprar.setBackground(new java.awt.Color(0, 0, 0));
		Comprar.setFont(new java.awt.Font("cambria", 12, 33));
		Comprar.setHorizontalAlignment(SwingConstants.CENTER);
		Comprar.setBorderPainted(true);
		Comprar.setVisible(true);

		// Se crea el boton Torre1
		Torre1 = new JButton("Torre1");// Crea el boton
		Torre1.setBounds(0, 0, 200, 100);
		Torre1.setForeground(new java.awt.Color(155, 017, 030));
		Torre1.setBackground(new java.awt.Color(0, 0, 0));
		Torre1.setFont(new java.awt.Font("cambria", 12, 33));
		Torre1.setHorizontalAlignment(SwingConstants.CENTER);
		Torre1.setBorderPainted(true);
		Torre1.setVisible(false);

		// Agrego las entidades que tenga en el mapa.
		//agregarEntidades();

		// Agrego los botones al panel torre
		panelTorres.add(Comprar);
		panelTorres.add(Torre1);

		// Se setea el panel principal con el contenedor del frame y se agregan los
		// demas paneles al panel principal
		frameJuego.setContentPane(panelPrincipal);
		panelPrincipal.add(panelTorres);
		panelPrincipal.add(panelJugador);
		panelPrincipal.add(panelJuego);

		// Inicio el juego
		j = new Juego(this);
		tiempo = new HiloPrincipal(j);
		tiempo.start();
		// *************ActionListener Botones*******************

		// Accion del boton Comprar
		Comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Torre1.setVisible(true);
				Comprar.setEnabled(false);
			}

		});

		Torre1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarTorre();
				Torre1.setVisible(false);
				Comprar.setEnabled(true);
			}

		});

	}

	/*
	 * Metodo para agregar entidades tanto graficamente como logicamente. Solo está
	 * implementado para una sola entidad, pero deberia recorrer una lista de
	 * entidades y de ahi ir agregando todas al mapa en el momento deseado.
	 */
	/*public void agregarEntidades() {
		Entidad malos[];
		malos = new Zombie[3];

		for (int i = 0; i < malos.length; i++) {
			//System.out.println("Entreeeeeeeeeeeeeeee");
			int valorX = (int) (Math.random() * 800) + 1;
			int valorY = (int) (Math.random() * 600) + 1;
			//System.out.println("X es igual a " + valorX + "Y es igual a: " + valorY);
			malos[i] = new Zombie(new Point(valorX, valorY), 42, 42);
			panelJuego.add(malos[i].getGrafico(), 0);

		}*/
		

	//}

	public void agregarTorre() {

		Zombie e = new Zombie(new Point(0, 0), 150, 150);
		j.agregarEntidad(e);
		JLabel nuevo = new JLabel(e.obtenerGrafico());

		// Evento del teclado
		panelJuego.addMouseListener(new MouseAdapter() {
			int cont = 0;

			public void mouseClicked(MouseEvent e) {
				if (cont == 0) {
					int x = e.getX();
					int y = e.getY();
					nuevo.setBounds(x, y, 41, 42);
					cont++;
				}
			}
		});
		panelJuego.add(nuevo, 0);

	}
	
	public void agregarAlJuego(JLabel j) {
		panelJuego.add(j,0);
		
	}

}// Fin GUI
