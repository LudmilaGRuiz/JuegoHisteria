package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Presentador;

import java.awt.SystemColor;

public class PantallaJuego {

	private JFrame pantallaJuego;
	private JTextField tituloJuego;
	private Controller controller;
	private Presentador presenter;

	/**
	 * @wbp.parser.constructor
	 */
	public PantallaJuego(Controller controller) {
		//this.recordHistorico = presenter.getRecord();
		this.setController(controller);
		initialize();
	}
	
	public PantallaJuego(Controller controller, Presentador presenter) {
		this.presenter = presenter;
		this.setController(controller);
		initialize();
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

		JPanel puntos = new JPanel();
		puntos.setBounds(0, 0, 1264, 1);
		puntos.setBackground(new Color(255, 255, 255));
		getPantallaJuego().getContentPane().add(puntos);
		puntos.setLayout(null);

		JPanel juego = new JPanel();
		juego.setBounds(452, 0, 812, 761);
		juego.setBackground(SystemColor.windowBorder);
		juego.setPreferredSize(new Dimension(800, 800));
		juego.setLayout(new GridLayout(presenter.tamañoGrilla(), presenter.tamañoGrilla()));
		getPantallaJuego().getContentPane().add(juego);

		JButton[][] botones = new JButton[presenter.tamañoGrilla()][presenter.tamañoGrilla()];
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBackground(Color.gray);
				final int x = i;
				final int y = j;
				botones[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						presenter.cambiarColor(x, y);
				        botones[x][y].setBackground(presenter.colorAwt(presenter.getColor(x, y)));
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
