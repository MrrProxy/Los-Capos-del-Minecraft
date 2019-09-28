package GUI;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Entidad.Entidad;
import Juego.Juego;
import Sonidos.Sonidos;
import Tienda.Boton;
import Tienda.BotonComprar;
import Tienda.BotonSonido;
import Tienda.BotonT1;
import Tienda.BotonT2;
import Tienda.BotonT3;
import Tienda.BotonT4;
import Tienda.BotonT5;
import Tienda.TiendaJuego;

/**
 * Clase GUI .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class GUI extends JFrame  {// Interfaz grafica del juego

	private static final long serialVersionUID = 1L;
	// Frame y panel
	private JFrame frameInicio, frameJuego;
	private JLayeredPane panel, panelPrincipal, panelJuego, panelTorres, panelJugador;

	// Atributos de la GUI
	private Juego j;
	private TiendaJuego tienda;
	// ****Labels****
	private JLabel fondo;
	private JLabel fondo2;
	private JLabel fondo3;
	private JLabel Titulo2;
	
	// ****Sonidos****
	private Sonidos sonidos;
	// ****Botones****
	private JButton startButton;

	private static GUI instance;

	/**
	 * Constructor de la GUII. Crea la aplicacion.
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
		sonidos=Sonidos.getInstace();
		iniciar();
	}

	/*
	 * Inicializa los atributos de la gui, crea la intefaz grafica
	 */
	private void iniciar() {
		// ****************Frame******************
		frameInicio = new JFrame();// Inicializa el frame
		frameInicio.setBounds(0, 0, 800, 600);// Setea el tama�o del frame
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
		
		sonidos.crearSonidos();
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** Elimina la ventana anterior */
				frameInicio.dispose();
				iniciarJuego();
				sonidos.playLoop(2);
				
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
		// frameJuego.setBackground(Color.RED);

		// *********Se crean los paneles*********
		panelPrincipal = new JLayeredPane();// Panel juego principal
		panelPrincipal.setBounds(0, 0, 1200, 700);
		panelPrincipal.setLayout(null);

		panelTorres = new JLayeredPane();// Panel donde se compran las torres
		panelTorres.setBounds(1000, 0, 200, 700);

		panelJugador = new JLayeredPane();// Panel del jugador con la vida etc
		panelJugador.setBounds(0, 600, 800, 150);
		
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

		Titulo2 = new JLabel("PANEL 2");
		Titulo2.setBounds(0, 0, 400, 100);
		Titulo2.setForeground(Color.BLACK);
		Titulo2.setBackground(new java.awt.Color(0, 0, 0));
		Titulo2.setFont(new java.awt.Font("cambria", 15, 40));

		// Se agregan los JLabel a sus respectivos paneles
		panelTorres.add(fondo, -1);
		panelJugador.add(fondo2, -1);
		panelJuego.add(fondo3, -1);

		

		// Se setea el panel principal con el contenedor del frame y se agregan los
		// demas paneles al panel principal
		frameJuego.setContentPane(panelPrincipal);
		panelPrincipal.add(panelTorres);
		panelPrincipal.add(panelJugador);
		panelPrincipal.add(panelJuego);

		// Inicio el juego
		j = Juego.getInstance();
		j.establecerGrafica(this);
		j.iniciarJuego();
		
		// Se crean los botones
		tienda = TiendaJuego.getInstance();
		crearBotones();
		
	

	}// FIN iniciarJuego

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
					tienda.agregarEntidad(x, y);
					cont++;
				}
			}
		});

	}
	public void crearBotones() {
		Boton torre1=new BotonT1(tienda,this);
		Boton torre2=new BotonT2(tienda,this);
		Boton torre3=new BotonT3(tienda,this);
		Boton torre4=new BotonT4(tienda,this);
		Boton torre5=new BotonT5(tienda,this);
		Boton Comprar=new BotonComprar(tienda,this);
		Boton Sonido=new BotonSonido(tienda,this);
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
		agregarBotones(Sonido);
	}
	public void agregarAlJuego(JLabel j) {
		if (j != null)
			panelJuego.add(j, 0);

	}
	
	public void eliminarEntidad(JLabel grafico) {
		panelJuego.remove(grafico);
		panelJuego.revalidate();
		panelJuego.repaint();	
	}

	// Agrega los botones al panel de torres
	public void agregarBotones(JButton B) {
		panelTorres.add(B, 0);

	}
}// Fin GUI
