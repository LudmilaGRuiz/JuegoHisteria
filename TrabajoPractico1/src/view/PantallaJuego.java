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
import java.awt.SystemColor;
import presenter.Controller;


public class PantallaJuego {

	private JFrame pantallaJuego;
	private Controller controller;
	private JButton[][] botones;
	private String nombreUsuario;
	private JLabel lblTiempo;

	/**
	 * @wbp.parser.constructor
	 */

	public PantallaJuego(Controller controller, String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.controller = controller;
		initialize();
		this.iniciarCronometro(lblTiempo);
	}

	public void iniciarCronometro(JLabel lblTiempo) {
		Cronometro cronometro = new Cronometro(lblTiempo);
		cronometro.iniciar();
	}
	private void initialize() {
		
		pantallaJuego = new JFrame();
		pantallaJuego.setResizable(false);
		pantallaJuego.setSize(1280, 800);
		pantallaJuego.setLocationRelativeTo(null);
		pantallaJuego.getContentPane().setLayout(null);
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
		        reglasDialog.setLocationRelativeTo(null); 

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

		        reglasDialog.setModal(true); 
		        reglasDialog.setVisible(true);
			}
		});
		btnReglas.setBounds(140, 300, 160, 40);
		pantallaJuego.getContentPane().add(btnReglas);
		
		JButton btnMenu = new JButton("Volver al menu");
		btnMenu.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        controller.irAMenu();
		        pantallaJuego.dispose();
		        
			}
		});
		btnMenu.setBounds(140, 450, 160, 40);
		pantallaJuego.getContentPane().add(btnMenu);

		JPanel juego = new JPanel();
		juego.setBounds(452, 0, 812, 761);
		juego.setBackground(SystemColor.windowBorder);
		juego.setPreferredSize(new Dimension(800, 800));
		juego.setLayout(new GridLayout(controller.tamanioGrilla(), controller.tamanioGrilla()));
		pantallaJuego.getContentPane().add(juego);

		botones = new JButton[controller.tamanioGrilla()][controller.tamanioGrilla()];
		for (int i=0; i<botones.length; i++) {
			for (int j=0; j<botones[i].length; j++) {
				final int x = i;
				final int y = j;
				botones[x][y] = new JButton();
				botones[x][y].setBackground(Color.gray);
				botones[x][y].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Color color = controller.nuevoColorCelda(x, y);
						botones[x][y].setBackground(color);
						if(controller.validarColoresVecinos(x, y)) 
							PantallaJuego.this.reiniciarBotones(x, y);
						
						if(controller.grillaCompleta()) {
							pantallaJuego.dispose();
							controller.abrirPantallaGanaste(nombreUsuario, lblTiempo.getText());
						}
					}					
				});
				juego.add(botones[x][y]);
			}
		}
	}
	private void reiniciarBotones(int x, int y) {
    	controller.reiniciarCeldayVecinos(x,y);
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
	
	public JFrame getPantallaJuego() {
		return pantallaJuego;
	}
}
