package presenter;

import java.awt.Color;

import model.Juego;
import view.PantallaGanaste;
import view.PantallaInicio;
import view.PantallaJuego;

public class Controller{
	private Juego juego;
	private PantallaInicio pantallaInicio;
	private PantallaJuego pantallaJuego;
	private PantallaGanaste pantallaGanaste;

	
	protected void abrirPantallaInicio() {
		pantallaInicio = new PantallaInicio(this);
		pantallaInicio.getPantallaInicio().setVisible(true);
	}

	public void iniciarJuego(Integer nivel) {
		juego = new Juego();
		juego.iniciarJuego(nivel);
	}

	public void abrirPantallaJuego(String nombreUsuario) {
		pantallaJuego = new PantallaJuego(this, nombreUsuario);
		pantallaJuego.getPantallaJuego().setVisible(true);
	}

	public void irAMenu() {
		pantallaInicio = new PantallaInicio(this);
		pantallaInicio.getPantallaInicio().setVisible(true);
	}
	
	public void abrirPantallaGanaste(String nombreUsuario, String tiempoDeJuego) {
		pantallaGanaste = new PantallaGanaste(nombreUsuario, tiempoDeJuego);
		pantallaGanaste.getPantallaGanaste().setVisible(true);
	}

	public int tamanioGrilla() {
		return juego.tamanioGrilla();
	}

	public Color nuevoColorCelda(int x, int y) {
		return juego.cambiarColorCelda(x, y);
	}

	public boolean validarColoresVecinos(int x, int y) {
		return juego.validarColoresVecinos(x, y);
	}

	public boolean grillaCompleta() {
		return juego.verificarGrilla();
	}

	public void reiniciarCeldayVecinos(int x, int y) {
		juego.reiniciarCeldayVecinos(x, y);
	}
}
