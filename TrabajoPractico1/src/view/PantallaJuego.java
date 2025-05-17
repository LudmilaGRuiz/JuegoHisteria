package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Celda;
import model.Cronometro;
import model.Juego;
import presenter.Controller;

import java.awt.SystemColor;

public class PantallaJuego {

	private JFrame pantallaJuego;
	private JTextField tituloJuego;
	private Controller controller;
	private Juego presenter;
	private String nombreUsuario;
	private JLabel lblTiempo;

	/**
	 * @wbp.parser.constructor
	 */

	public PantallaJuego(Controller controller, String nombreUsuario, Juego presenter) {
		this.nombreUsuario = nombreUsuario;
		this.presenter = presenter;
		this.setController(controller);
		initialize();
		this.iniciarCronometro(lblTiempo);
	}

	public void iniciarCronometro(JLabel lblTiempo) {
		Cronometro cronometro = new Cronometro(lblTiempo);
		cronometro.iniciar();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setPantallaJuego(new JFrame());
		getPantallaJuego().setResizable(false);
		getPantallaJuego().setSize(1280, 800);
		getPantallaJuego().setLocationRelativeTo(null);
		getPantallaJuego().getContentPane().setLayout(null);
		pantallaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		lblTiempo = new JLabel("00:00:00");
		lblTiempo.setFont(new Font("Showcard Gothic", Font.PLAIN, 60));
		lblTiempo.setForeground(Color.BLACK);
		lblTiempo.setBounds(100, 60, 400, 100);
		pantallaJuego.getContentPane().add(lblTiempo);		
		
		JButton btnReglas = new JButton("¿Como jugar?");
		btnReglas.setFont(new Font("Arial", Font.BOLD, 16));
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        // Crear nueva ventana (puede ser JDialog o JFrame)
		        JDialog reglasDialog = new JDialog();
		        reglasDialog.setTitle("Reglas del Juego");
		        reglasDialog.setSize(600, 400);
		        reglasDialog.setLocationRelativeTo(null); // Centrar la ventana

		        JTextArea reglas = new JTextArea("Se busca colorear completamente una grilla de 5×5, pero evitando que dos celdas\r\n"
		        		+ "vecinas tengan el mismo color. Inicialmente, todas las celdas están sin colorear.\r\n"
		        		+ "En cada turno, el jugador hace click sobre una celda, y este click tiene el efecto\r\n"
		        		+ "de cambiar el color de esa casilla a uno aleatorio de entre 6 posibles. La dificultad\r\n"
		        		+ "consiste en que si este nuevo color coincide con el de alguna casilla vecina, la casilla "
		        		+ "cambiada y todas sus vecinas se apagarán!");
		        reglas.setEditable(false);
		        reglas.setLineWrap(true);
		        reglas.setWrapStyleWord(true);
		        reglas.setFont(new Font("Arial", Font.PLAIN, 16));

		        JScrollPane scroll = new JScrollPane(reglas);
		        reglasDialog.getContentPane().add(scroll);

		        reglasDialog.setModal(true); // Bloquea la ventana principal mientras esta está abierta
		        reglasDialog.setVisible(true);
			}
		});
		btnReglas.setBounds(140, 300, 160, 40);
		pantallaJuego.getContentPane().add(btnReglas);
		
		JButton btnMenu = new JButton("Volver al menu");
		btnMenu.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        controller.irAMenu(presenter);
		        pantallaJuego.dispose();
		        
			}
		});
		btnMenu.setBounds(140, 450, 160, 40);
		pantallaJuego.getContentPane().add(btnMenu);

		JPanel juego = new JPanel();
		juego.setBounds(452, 0, 812, 761);
		juego.setBackground(SystemColor.windowBorder);
		juego.setPreferredSize(new Dimension(800, 800));
//		juego.setLayout(new GridLayout(5,5));			//descomentar para ver el design
		juego.setLayout(new GridLayout(presenter.tamanioGrilla(), presenter.tamanioGrilla())); //comentar para ver el design
		getPantallaJuego().getContentPane().add(juego);

		JButton[][] botones = new JButton[presenter.tamanioGrilla()][presenter.tamanioGrilla()];
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBackground(Color.gray);
				final int x = i;
				final int y = j;
				botones[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						presenter.cambiarColor(x, y);
						Celda celda = presenter.getCelda(x, y);
						Color color = presenter.colorAwt(celda.getColor());
						botones[x][y].setBackground(color);
						
						if(presenter.validarColoresVecinos(x,y)) 
							reiniciarBotones();
						
						if(presenter.verificarGrilla()) {
							pantallaJuego.dispose();
							controller.pantallaGanaste(nombreUsuario, lblTiempo.getText());
						}
					}					
					private void reiniciarBotones() {
				    	presenter.reiniciarCeldayVecinos(x,y);
				    	botones[x][y].setBackground(Color.gray);
				    	if(x-1 >= 0)
				    		botones[x-1][y].setBackground(Color.gray);				    	
				    	if(x+1 < botones[0].length)
				    		botones[x+1][y].setBackground(Color.gray);				    	
				    	if(y-1 >= 0)
				    		botones[x][y-1].setBackground(Color.gray);				    	
				    	if(y+1 < botones.length)
				    	botones[x][y+1].setBackground(Color.gray);
					}
				});
				juego.add(botones[i][j]);
			}
		}
	}

	public JFrame getPantallaJuego() {
		return pantallaJuego;
	}

	public void setPantallaJuego(JFrame pantallaJuego) {
		this.pantallaJuego = pantallaJuego;
	}

	public JTextField getTituloJuego() {
		return tituloJuego;
	}

	public void setTituloJuego(JTextField tituloJuego) {
		this.tituloJuego = tituloJuego;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

}
