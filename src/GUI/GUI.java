package GUI;

import java.awt.event.*;
import java.security.PublicKey;
import java.awt.*;

import javax.swing.*;

import Entidad.Entidad;
import Juego.Juego;
import Personaje.SteveCuero;
import Personaje.SteveDiamante;
import Personaje.SteveHierro;
import Personaje.SteveOro;
import Personaje.SteveRed;
import Hilo.HiloPrincipal;
import Tienda.Tienda;

/**
 * Clase GUI .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class GUI extends JFrame {// Interfaz grafica del juego

	private static final long serialVersionUID = 1L;
	// Frame y panel
	private JFrame frameInicio, frameJuego;
	private JLayeredPane panel, panelPrincipal, panelJuego, panelTorres, panelJugador;

	// Atributos de la GUI
	private Juego j;
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
	private JButton Torre2;
	private JButton Torre3;
	private JButton Torre4;
	private JButton Torre5;

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
		frameJuego.setBounds(0, 0, 1000, 720);
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
		panelJugador.setBounds(0, 600, 800, 150);

		panelJuego = new JLayeredPane();// Panel donde se ejecuta el juego (MAPA)
		panelJuego.setBounds(0, 0, 800, 600);

		// ************Se crean los JLabel con sus imagenes************
		fondo = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/GREEN.jpg")));
		fondo.setBounds(0, 0, 800, 600);

		fondo2 = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/JugadorFondo.png")));
		fondo2.setBounds(0, 0, 800, 100);
		// fondo2.setBackground(new java.awt.Color(204, 0, 0));

		fondo3 = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/GameMap.png")));
		fondo3.setBounds(0, 0, 800, 600);

		Titulo2 = new JLabel("PANEL 2");
		Titulo2.setBounds(0, 0, 400, 100);
		Titulo2.setForeground(Color.BLACK);
		Titulo2.setBackground(new java.awt.Color(0, 0, 0));
		Titulo2.setFont(new java.awt.Font("cambria", 15, 40));

		// Se agregan los JLabel a sus respectivos paneles
		panelTorres.add(fondo, 0);
		panelJugador.add(fondo2, -1);
		// panelJugador.add(Titulo2, 0);
		panelJuego.add(fondo3, -1);
		botones();
		
		// Se setea el panel principal con el contenedor del frame y se agregan los
		// demas paneles al panel principal
		frameJuego.setContentPane(panelPrincipal);
		panelPrincipal.add(panelTorres);
		panelPrincipal.add(panelJugador);
		panelPrincipal.add(panelJuego);
		
	//	Tienda tienda=new Tienda();
		//tienda.crearBotones(this);
		//repaint();


		// Inicio el juego
		j = new Juego(this);
		tiempo = new HiloPrincipal(j);
		tiempo.start();

	}// FIN iniciarJuego

		
	/*
	 * Metodo para agregar entidades tanto graficamente como logicamente. Solo está
	 * implementado para una sola entidad, pero deberia recorrer una lista de
	 * entidades y de ahi ir agregando todas al mapa en el momento deseado.
	 */
	/*
	 * public void agregarEntidades() { Entidad malos[]; malos = new Zombie[3];
	 * 
	 * for (int i = 0; i < malos.length; i++) {
	 * //System.out.println("Entreeeeeeeeeeeeeeee"); int valorX = (int)
	 * (Math.random() * 800) + 1; int valorY = (int) (Math.random() * 600) + 1;
	 * //System.out.println("X es igual a " + valorX + "Y es igual a: " + valorY);
	 * malos[i] = new Zombie(new Point(valorX, valorY), 42, 42);
	 * panelJuego.add(malos[i].getGrafico(), 0);
	 * 
	 * }
	 */

	// }

	public void agregarTorre(Entidad ste) {
		
		// Evento del teclado
		panelJuego.addMouseListener(new MouseAdapter() {
			int cont = 0;

			public void mouseClicked(MouseEvent e) {
				if (cont == 0) {
					int x = e.getX();
					int y = e.getY();
					if (x > 400)
						x = 400;
					if (y < 100)
						y = 40;
					ste.setPosition(new Point(x, y));
					panelJuego.add(ste.getGrafico(2), 0);
					j.agregarEntidad(ste);
					cont++;
					Comprar.setEnabled(true);
				}
			}
		});

	}

	public void agregarAlJuego(JLabel j) {
		panelJuego.add(j, 0);

	}

	public void botones() {
		// Se crea el boton Comprar
		Comprar = new JButton("Comprar");// Crea el boton
		Comprar.setBounds(0, 600, 202, 100);
		Comprar.setForeground(new java.awt.Color(155, 017, 030));
		Comprar.setBackground(new java.awt.Color(0, 0, 0));
		Comprar.setFont(new java.awt.Font("cambria", 12, 33));
		Comprar.setHorizontalAlignment(SwingConstants.CENTER);
		Comprar.setBorderPainted(true);
		Comprar.setVisible(true);

		// Se crea el boton Torre1
		Torre1 = new JButton("Torre 1");
		Torre1.setBounds(0, 0, 200, 100);
		Torre1.setForeground(new java.awt.Color(155, 017, 030));
		Torre1.setBackground(new java.awt.Color(0, 0, 0));
		Torre1.setFont(new java.awt.Font("cambria", 12, 33));
		Torre1.setHorizontalAlignment(SwingConstants.CENTER);
		Torre1.setBorderPainted(true);
		Torre1.setVisible(false);

		// Se crea el boton Torre2
		Torre2 = new JButton("Torre2");
		Torre2.setBounds(0, 100, 200, 100);
		Torre2.setForeground(new java.awt.Color(155, 017, 030));
		Torre2.setBackground(new java.awt.Color(0, 0, 0));
		Torre2.setFont(new java.awt.Font("cambria", 12, 33));
		Torre2.setHorizontalAlignment(SwingConstants.CENTER);
		Torre2.setBorderPainted(true);
		Torre2.setVisible(false);

		// Se crea el boton Torre3
		Torre3 = new JButton("Torre3");
		Torre3.setBounds(0, 200, 200, 100);
		Torre3.setForeground(new java.awt.Color(155, 017, 030));
		Torre3.setBackground(new java.awt.Color(0, 0, 0));
		Torre3.setFont(new java.awt.Font("cambria", 12, 33));
		Torre3.setHorizontalAlignment(SwingConstants.CENTER);
		Torre3.setBorderPainted(true);
		Torre3.setVisible(false);

		// Se crea el boton Torre4
		Torre4 = new JButton("Torre4");
		Torre4.setBounds(0, 300, 200, 100);
		Torre4.setForeground(new java.awt.Color(155, 017, 030));
		Torre4.setBackground(new java.awt.Color(0, 0, 0));
		Torre4.setFont(new java.awt.Font("cambria", 12, 33));
		Torre4.setHorizontalAlignment(SwingConstants.CENTER);
		Torre4.setBorderPainted(true);
		Torre4.setVisible(false);

		// Se crea el boton Torre5
		Torre5 = new JButton("Torre5");
		Torre5.setBounds(0, 400, 200, 100);
		Torre5.setForeground(new java.awt.Color(155, 017, 030));
		Torre5.setBackground(new java.awt.Color(0, 0, 0));
		Torre5.setFont(new java.awt.Font("cambria", 12, 33));
		Torre5.setHorizontalAlignment(SwingConstants.CENTER);
		Torre5.setBorderPainted(true);
		Torre5.setVisible(false);

		Torre1.setEnabled(false);
		Torre2.setEnabled(false);
		Torre3.setEnabled(false);
		Torre4.setEnabled(false);
		Torre5.setEnabled(false);
		
		panelTorres.add(Comprar);
		panelTorres.add(Torre1);
		panelTorres.add(Torre2);
		panelTorres.add(Torre3);
		panelTorres.add(Torre4);
		panelTorres.add(Torre5);
		

		// *************ActionListener Botones*******************

		// Accion del boton Comprar
		Comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Torre1.setVisible(true);
				Torre2.setVisible(true);
				Torre3.setVisible(true);
				Torre4.setVisible(true);
				Torre5.setVisible(true);

				Torre1.setEnabled(true);
				Torre2.setEnabled(true);
				Torre3.setEnabled(true);
				Torre4.setEnabled(true);
				Torre5.setEnabled(true);

				Comprar.setEnabled(false);
			}

		});

		Torre1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entidad ste = new SteveDiamante(new Point(0, 0), 70, 70);
				agregarTorre(ste);
				Torre1.setEnabled(false);
				Torre2.setEnabled(false);
				Torre3.setEnabled(false);
				Torre4.setEnabled(false);
				Torre5.setEnabled(false);
			}

		});

		Torre2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entidad ste = new SteveCuero(new Point(0, 0), 70, 70);
				agregarTorre(ste);				
				Torre1.setEnabled(false);
				Torre2.setEnabled(false);
				Torre3.setEnabled(false);
				Torre4.setEnabled(false);
				Torre5.setEnabled(false);
				Comprar.setEnabled(true);
			}

		});

		Torre3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entidad ste = new SteveHierro(new Point(0, 0), 70, 70);
				agregarTorre(ste);				
				Torre1.setEnabled(false);
				Torre2.setEnabled(false);
				Torre3.setEnabled(false);
				Torre4.setEnabled(false);
				Torre5.setEnabled(false);
				Comprar.setEnabled(true);
			}

		});

		Torre4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entidad ste = new SteveOro(new Point(0, 0), 70, 70);
				agregarTorre(ste);				
				Torre1.setEnabled(false);
				Torre2.setEnabled(false);
				Torre3.setEnabled(false);
				Torre4.setEnabled(false);
				Torre5.setEnabled(false);
				Comprar.setEnabled(true);
			}

		});

		Torre5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entidad ste = new SteveRed(new Point(0, 0), 70, 70);
				agregarTorre(ste);				
				Torre1.setEnabled(false);
				Torre2.setEnabled(false);
				Torre3.setEnabled(false);
				Torre4.setEnabled(false);
				Torre5.setEnabled(false);
				Comprar.setEnabled(true);
			}

		});
		// Agrego los botones al panel torre
		panelTorres.add(Comprar,0);
		panelTorres.add(Torre1, 0);
		panelTorres.add(Torre2, 0);
		panelTorres.add(Torre3, 0);
		panelTorres.add(Torre4, 0);
		panelTorres.add(Torre5, 0);

	}
	
	//Agrega los botones al panel de torres
	public void agregarBotones(JButton B) {
		panelTorres.add(B,0);
		repaint();
		
	}

}// Fin GUI
