package GUI;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Entidad.Entidad;
import Hilo.HiloSonido;
import Juego.Juego;
import Objetos.Bomba;
import Objetos.BombaExplosion;
import Objetos.CampoProteccion;
import Sonidos.sonidosMp3;
import Tienda.Boton;
import Tienda.BotonComprar;
import Tienda.BotonT1;
import Tienda.BotonT2;
import Tienda.BotonT3;
import Tienda.BotonT4;
import Tienda.BotonT5;
import Tienda.TiendaJuego;
import TiendaPersonaje.*;

/**
 * Clase GUI .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class GUI extends JFrame {// Interfaz grafica del juego

	private static final long serialVersionUID = 1L;
	// Frame y panel
	private JFrame frameInicio, frameJuego, frameFinal;
	private JLayeredPane panel, panelPrincipal, panelJuego, panelTorres, panelJugador;

	// Atributos de la GUI
	private Juego j;
	private TiendaJuego tienda;
	private sonidosMp3 mp3;
	private HiloSonido h;

	// ****Labels****
	private JLabel fondo;
	private JLabel fondo2;
	private JLabel fondo3;
	private JLabel Monedas;
	private JLabel Puntaje;

	// ****Sonidos****
	// ****Botones****
	private JButton startButton;
	private JButton botonSonido;

	private static GUI instance;

	/**
	 * Constructor de la GUII. Crea la aplicacion.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = GUI.getInstance();
					window.frameInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static GUI getInstance() {
		if (instance == null)
			instance = new GUI();
		return instance;

	}

	/**
	 * Ejecuta la aplicacion GUI.
	 * 
	 * @param args arrglo de String.
	 */

	private GUI() {
		// sonidos = Sonidos.getInstace();
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
		startButton.setFocusPainted(false);
		startButton.setBorderPainted(true);
		frameInicio.add(startButton, 0);// Agrega el boton al frame

		// sonidos.crearSonidos();

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** Elimina la ventana anterior */
				frameInicio.dispose();
				iniciarJuego();
				h = HiloSonido.getInstace();
				try {
					// mp3.abrirArchivo("bsound1");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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
		frameJuego.setBounds(0, 0, 1200, 720);
		frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuego.setLocationRelativeTo(null);
		frameJuego.setLayout(null);
		frameJuego.setResizable(false);
		frameJuego.setTitle("Proyecto de TDP 2019");
		frameJuego.setVisible(true);

		// *********Se crean los paneles*********
		panelPrincipal = new JLayeredPane();// Panel juego principal
		panelPrincipal.setBounds(0, 0, 1200, 700);
		panelPrincipal.setLayout(null);

		panelTorres = new JLayeredPane();// Panel donde se compran las torres
		panelTorres.setBounds(1000, 0, 200, 700);

		panelJugador = new JLayeredPane();// Panel del jugador con la vida etc
		panelJugador.setBounds(0, 600, 1000, 120);

		panelJuego = new JLayeredPane();// Panel donde se ejecuta el juego (MAPA)
		panelJuego.setBounds(0, 0, 1000, 600);

		// ************Se crean los JLabel con sus imagenes************
		fondo = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/FondoTorres.png")));
		fondo.setBounds(0, 0, 200, 700);

		fondo2 = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/FondoJugador1.png")));
		fondo2.setBounds(0, 0, 1000, 120);
		// fondo2.setBackground(new java.awt.Color(204, 0, 0));

		fondo3 = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Mapa3.png")));
		fondo3.setBounds(0, 0, 1000, 600);

		Puntaje = new JLabel("Puntaje : 0");
		Puntaje.setBounds(300, 0, 200, 50);
		Puntaje.setBackground(new java.awt.Color(255, 215, 0));
		Puntaje.setForeground(new java.awt.Color(255, 255, 255));
		Puntaje.setFont(new java.awt.Font("cambria", 15, 20));
		Puntaje.setVisible(true);

		Monedas = new JLabel("Monedas : 10000");
		Monedas.setBounds(0, 0, 200, 50);
		Monedas.setForeground(new java.awt.Color(255, 215, 0));
		Monedas.setBackground(new java.awt.Color(255, 215, 0));
		Monedas.setFont(new java.awt.Font("cambria", 15, 20));
		Monedas.setVisible(true);

		botonSonido = new JButton("Sonido");// Crea el boton
		botonSonido.setBounds(820, 0, 180, 50);
		botonSonido.setForeground(new java.awt.Color(155, 017, 030));
		botonSonido.setBackground(new java.awt.Color(0, 0, 0));
		botonSonido.setFont(new java.awt.Font("cambria", 10, 20));
		botonSonido.setHorizontalAlignment(SwingConstants.CENTER);
		botonSonido.setFocusPainted(false);
		botonSonido.setBorderPainted(true);

		botonSonido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mp3 = h.getSoudtrack();
				mp3.pausa();
			}
		});

		// Se agregan los JLabel a sus respectivos paneles
		panelJugador.add(Puntaje, 0);
		panelJugador.add(Monedas, 0);
		panelTorres.add(fondo, -1);
		panelJugador.add(fondo2, -1);
		panelJuego.add(fondo3, -1);
		panelJugador.add(botonSonido, 0);

		// Se setea el panel principal con el contenedor del frame y se agregan los
		// demas paneles al panel principal
		frameJuego.setContentPane(panelPrincipal);
		panelPrincipal.add(panelTorres);
		panelPrincipal.add(panelJugador);
		panelPrincipal.add(panelJuego);

		panelJuego.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				j.clickEnEntidades(new Point(x, y));
			}
		});

		// Inicio el juego
		j = Juego.getInstance();
		j.establecerGrafica(this);
		j.iniciarJuego();

		// Se crean los botones
		tienda = TiendaJuego.getInstance();
		crearBotones();

	}// FIN iniciarJuego
	
	public void agregarCampo(){
		
		panelJuego.addMouseListener(new MouseAdapter() {
			
			int cont = 0;

			public void mouseClicked(MouseEvent e) {
				if (cont == 0) {
					
					int x = e.getX();
					int y = e.getY();
					
					Point nuevoPunto = new Point(x,y);
					j.clickEnJugadores(nuevoPunto);
					
				}
				cont++;
			
			
		}
		});
	}
	
	public void agregarBomba(BombaExplosion b){
		
		//Point punto = null;
		
		panelJuego.addMouseListener(new MouseAdapter() {
			int cont = 0;
			public void mouseClicked(MouseEvent e){
				if (cont == 0) { 
					int x = e.getX();
					int y = e.getY();
					switch (y / 100) {
					case 0:
						y = 0;
						break;
					case 1:
						y = 100;
						break;
					case 2:
						y = 200;
						break;
					case 3:
						y = 300;
						break;
					case 4:
						y = 400;
						break;
					case 5:
						y = 500;
						break;
					case 6:
						y = 600;
						break;
					}
					switch (x / 100) {
					case 0:
						x = 0;
						break;
					case 1:
						x = 100;
						break;
					case 2:
						x = 200;
						break;
					case 3:
						x = 300;
						break;
					case 4:
						x = 400;
						break;
					case 5:
						x = 500;
						break;

					}
					if (x > 500)
						x = 500;
					Point punto = new Point(x,y);
					b.setPosition(punto);
					j.agregarEntidad(b,true);
					cont++;
					
					
					
				}
			}
			
			
			
		});
		
	}
	
	

	public void agregarTorre(Entidad ste) {

		// Evento del teclado
		panelJuego.addMouseListener(new MouseAdapter() {
			int cont = 0;

			public void mouseClicked(MouseEvent e) {
				if (cont == 0) {
					int x = e.getX();
					int y = e.getY();
					switch (y / 100) {
					case 0:
						y = 0;
						break;
					case 1:
						y = 100;
						break;
					case 2:
						y = 200;
						break;
					case 3:
						y = 300;
						break;
					case 4:
						y = 400;
						break;
					case 5:
						y = 500;
						break;
					case 6:
						y = 600;
						break;
					}
					switch (x / 100) {
					case 0:
						x = 0;
						break;
					case 1:
						x = 100;
						break;
					case 2:
						x = 200;
						break;
					case 3:
						x = 300;
						break;
					case 4:
						x = 400;
						break;
					case 5:
						x = 500;
						break;

					}
					if (x > 500)
						x = 500;
					tienda.agregarEntidad(x, y);
					cont++;
				}
			}
		});

	}

	public void crearBotones() {
		Boton torre1 = new BotonT1(tienda, this);
		Boton torre2 = new BotonT2(tienda, this);
		Boton torre3 = new BotonT3(tienda, this);
		Boton torre4 = new BotonT4(tienda, this);
		Boton torre5 = new BotonT5(tienda, this);
		Boton Comprar = new BotonComprar(tienda, this);
		BotonPwup pwup1 = CProteccion.getInstance();
		BotonPwup pwup2 = Bombas.getInstance();
		BotonPwup pwup3 = new PowerUp3(this);
		BotonPwup pwup4 = new PowerUp4(this);
		BotonPwup pwup5 = new PowerUp5(this);

		Comprar.setFocusable(false);
		torre1.setFocusable(false);
		torre2.setFocusable(false);
		torre3.setFocusable(false);
		torre4.setFocusable(false);
		torre5.setFocusable(false);

		agregarBotones(torre1);
		agregarBotones(torre2);
		agregarBotones(torre3);
		agregarBotones(torre4);
		agregarBotones(torre5);
		agregarBotones(Comprar);

		panelJugador.add(pwup1, 1);
		panelJugador.add(pwup2, 1);
		panelJugador.add(pwup3, 1);
		panelJugador.add(pwup4, 1);
		panelJugador.add(pwup5, 1);

	}

	public void agregarAlJuego(JLabel j) {
		if (j != null)
			panelJuego.add(j, 0);
	}

	public void eliminarEntidad(JLabel grafico) {
		panelJuego.repaint();
		Timer timer = new Timer(4000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelJuego.remove(grafico);
				panelJuego.repaint();
			}
		});
		timer.start();

	}

	// Agrega los botones al panel de torres
	public void agregarBotones(JButton B) {
		panelTorres.add(B, 0);
	}

	public void actualizarEstadisticas(int puntaje, int cantMonedas) {
		Puntaje.setText("Puntaje : " + puntaje);
		Monedas.setText("Monedas : " + cantMonedas);

	}

	public void perder() {
		crearFrameFinal();

		JLabel imagenganeButton = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/gameOver.png")));
		imagenganeButton.setBounds(0, 0, 640, 480);
		frameFinal.add(imagenganeButton, 0);
		frameFinal.setTitle("Perdiste");
		frameFinal.setVisible(true);
		
		mp3 = new sonidosMp3();
		mp3.abrirArchivo("SadViolin");

	}

	public void ganar() {
		crearFrameFinal();

		JLabel imagenganeButton = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/tenor.gif")));
		imagenganeButton.setBounds(100, 0, 400, 400);
		frameFinal.setTitle("Ganaste");
		frameFinal.setVisible(true);
		frameFinal.getContentPane().setBackground(Color.BLACK);
		frameFinal.add(imagenganeButton, 0);
		
		mp3 = new sonidosMp3();
		mp3.abrirArchivo("smokeEvd");
	}

	// Crea el frame del fin del juego y el boton reiniciar
	private void crearFrameFinal() {
		frameJuego.dispose();
		frameFinal = new JFrame();// Crea la ventana donde se desarrolla el juego
		frameFinal.setBounds(0, 0, 640, 480);
		frameFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFinal.setLocationRelativeTo(null);
		frameFinal.setLayout(null);
		frameFinal.setResizable(false);

//		reiniciar = new JButton("Reiniciar");// Crea el boton
//		reiniciar.setBounds(500, 200, 200, 50);
//		reiniciar.setForeground(new java.awt.Color(155, 017, 030));
//		reiniciar.setBackground(new java.awt.Color(0, 0, 0));
//		reiniciar.setFont(new java.awt.Font("cambria", 10, 20));
//		reiniciar.setHorizontalAlignment(SwingConstants.CENTER);
//		reiniciar.setFocusPainted(false);
//		reiniciar.setBorderPainted(true);
//		reiniciar.setVisible(true);
//
//		reiniciar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				reiniciarJuego();
//			}
//		});
//		frameFinal.add(reiniciar);
	}

	private void reiniciarJuego() {
		mp3.stop();
		frameFinal.dispose();
		iniciar();

	}

}// Fin GUI
