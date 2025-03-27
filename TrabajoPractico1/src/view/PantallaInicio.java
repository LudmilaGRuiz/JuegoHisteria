package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import controller.Controller;
import model.Presentador;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class PantallaInicio {

	private Presentador presenter;
	private Controller controller;
	private JFrame pantallaInicio;
	private JTextField textField;
	private String nombreUsuario;
	private Integer nivel;
	

	/**
	 * Create the application.
	 */
	
	/**
	 * @wbp.parser.constructor
	 */
	public PantallaInicio() {
		
		initialize();
	}
	
	public PantallaInicio(Presentador presenter) {
		this.presenter = presenter;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		pantallaInicio = new JFrame();
		pantallaInicio.setResizable(false);
		pantallaInicio.setSize(1280, 800);
		pantallaInicio.setLocationRelativeTo(null);
		pantallaInicio.getContentPane().setLayout(null);
		pantallaInicio.getContentPane().setForeground(Color.WHITE);
		pantallaInicio.getContentPane().setBackground(SystemColor.textHighlight);
		pantallaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantallaInicio.setVisible(true);
		
		controller = new Controller();
		pantallaInicio.getContentPane().setLayout(null);
		
		JLabel lblMenuText = new JLabel("HISTERIA");
		lblMenuText.setBounds(380, 67, 479, 95);
		lblMenuText.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuText.setForeground(SystemColor.desktop);
		lblMenuText.setBackground(Color.BLACK);
		lblMenuText.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.BOLD, 95));
		pantallaInicio.getContentPane().add(lblMenuText);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1264, 24);
		pantallaInicio.getContentPane().add(toolBar);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Acerca de");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("¿Como jugar?");
		mntmNewMenuItem.setSelected(true);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Informacion");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.informacionDelTrabajo();
			}
		});
		mntmNewMenuItem_1.setSelected(true);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		textField = new JTextField();
		textField.setBounds(631, 279, 228, 29);
		pantallaInicio.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Ingrese su nombre:");
		lblNombre.setBounds(369, 279, 263, 31);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		pantallaInicio.getContentPane().add(lblNombre);

		
		JLabel lblNivelDeDificultad = new JLabel("Elige la dificultad:");
		lblNivelDeDificultad.setBounds(386, 373, 246, 31);
		lblNivelDeDificultad.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivelDeDificultad.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		pantallaInicio.getContentPane().add(lblNivelDeDificultad);
		
		JComboBox<String> inputNivel = new JComboBox<String>();
		inputNivel.setBounds(631, 373, 196, 31);
		inputNivel.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Principiante (5x5)", "Facil (6x6)", "Normal (7x7)", "Dificil (8x8)", "Experto (9x9)"}));
		pantallaInicio.getContentPane().add(inputNivel);
		
		JButton btnPlay = new JButton("Jugar");
		btnPlay.setBounds(520, 484, 228, 55);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String nombreIngresado = lblNombre.getText().trim(); 

				 nivel = inputNivel.getSelectedIndex();
				 nombreUsuario = nombreIngresado;
				 presenter.iniciarJuego(nivel);
				 controller.abrirJuego(nombreUsuario, presenter);
		            
		         pantallaInicio.setVisible(false);
			}
		});
		btnPlay.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlay.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		pantallaInicio.getContentPane().add(btnPlay);
	}
}
