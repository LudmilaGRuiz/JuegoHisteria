package controller;

import model.Presentador;
import view.PantallaInicio;
import view.PantallaJuego;

public class Controller{
	
	public void irAMenu(Presentador presenter) {
		PantallaInicio inicio = new PantallaInicio(presenter);
		inicio.getPantallaInicio().setVisible(true);
	}

	public void abrirJuego(String nombreUsuario, Presentador presenter) {
		PantallaJuego juego = new PantallaJuego(this, nombreUsuario, presenter);
		juego.getPantallaJuego().setVisible(true);
	}

}
