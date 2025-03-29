package controller;

import model.Presentador;
import view.PantallaInicio;
import view.PantallaJuego;

public class Controller{
	
	public void irAMenu(PantallaJuego juego, Presentador presenter) {
		juego.getPantallaJuego().setVisible(false);
		PantallaInicio inicio = new PantallaInicio(presenter);
	}

	public void abrirJuego(String nombreUsuario, Presentador presenter) {
		PantallaJuego juego = new PantallaJuego(this, presenter);
		juego.getPantallaJuego().setVisible(true);
	}

}
