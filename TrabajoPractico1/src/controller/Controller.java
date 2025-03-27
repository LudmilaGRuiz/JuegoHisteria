package controller;

import java.awt.EventQueue;

import model.Presentador;
import view.PantallaInicio;
import view.PantallaJuego;

public class Controller{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presentador presenter = new Presentador();
					PantallaInicio pntInicio = new PantallaInicio(presenter);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void irAMenu(PantallaJuego juego, Presentador presenter) {
		juego.getPantallaJuego().setVisible(false);
		PantallaInicio pntInicio = new PantallaInicio(presenter);
	}

	public void abrirJuego(String nombreUsuario, Presentador presenter) {
		PantallaJuego juego = new PantallaJuego(this, presenter);
		juego.getPantallaJuego().setVisible(true);
	}


}
