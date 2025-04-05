package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	private ArrayList<BotonConID> botones;

	/**
	 * @wbp.parser.constructor
	 */

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
		pantallaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel puntos = new JPanel();
		puntos.setBounds(0, 0, 1264, 1);
		puntos.setBackground(new Color(255, 255, 255));
		getPantallaJuego().getContentPane().add(puntos);
		puntos.setLayout(null);

		JPanel juego = new JPanel();
		juego.setBounds(452, 0, 812, 761);
		juego.setBackground(SystemColor.windowBorder);
		juego.setPreferredSize(new Dimension(800, 800));
		// juego.setLayout(new GridLayout(5,5)); //descomentar para ver el design
		juego.setLayout(new GridLayout((int) Math.sqrt(presenter.tamanioGrilla()), (int) Math.sqrt(presenter.tamanioGrilla()))); // comentar
																															// para
																															// ver
																															// el
																															// design
		getPantallaJuego().getContentPane().add(juego);

		botones = new ArrayList<BotonConID>();

		for (int i = 0; i < presenter.tamanioGrilla(); i++) {
			botones.add(new BotonConID(i));
			botones.get(i).setBackground(Color.gray);

			final int index = i;
			botones.get(index).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					presenter.cambiarColor(index);
					botones.get(index).setBackground(presenter.colorAwt(presenter.getColor(index)));
					if (presenter.validarColoresVecinos(index)) {
						PantallaJuego.this.volverGris(presenter.reiniciarCeldayVecinos(index));
					}
					presenter.estadoCeldas();
				}
			});
			juego.add(botones.get(index));
		}
	}

	public JFrame getPantallaJuego() {
		return pantallaJuego;
	}

	public void volverGris(ArrayList<Integer> lista) {
		for (Integer i : lista) {
			this.botones.get(i).setBackground(Color.gray);
		}
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
