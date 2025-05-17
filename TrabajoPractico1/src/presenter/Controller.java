package presenter;

import model.Juego;
import view.PantallaGanaste;
import view.PantallaInicio;
import view.PantallaJuego;

public class Controller{
	
	public void irAMenu(Juego presenter) {
		PantallaInicio inicio = new PantallaInicio(presenter);
		inicio.getPantallaInicio().setVisible(true);
	}

	public void abrirJuego(String nombreUsuario, Juego presenter) {
		PantallaJuego juego = new PantallaJuego(this, nombreUsuario, presenter);
		juego.getPantallaJuego().setVisible(true);
	}

	public void pantallaGanaste(String nombreUsuario, String tiempoDeJuego) {
		new PantallaGanaste(nombreUsuario, tiempoDeJuego);
	}
}
