package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
	private Grilla grilla;

	public Juego() {
	}

	public void iniciarJuego(int nivel) {
		switch(nivel) {
		case 1 -> grilla = new Grilla(5);
		case 2 -> grilla = new Grilla(6);
		case 3 -> grilla = new Grilla(7);
		case 4 -> grilla = new Grilla(8);
		case 5 -> grilla = new Grilla(9);
		}
	}

	public Color cambiarColorCelda (int x, int y) {
		ColordeCelda color = colorRandom ();
		grilla.setColorCelda(x, y, color);
		return colorAwt(color);
	}
	
	private ColordeCelda colorRandom() {
		Random rand = new Random();
		ColordeCelda[] colores = ColordeCelda.values();
		return colores[rand.nextInt(colores.length-1)];
	}

    public java.awt.Color colorAwt(ColordeCelda color) {
    	if (color == null) {
    		return java.awt.Color.GRAY;
    	}
        switch (color) {
            case RED:
                return java.awt.Color.RED;
            case BLUE:
                return java.awt.Color.BLUE;
            case GREEN:
                return java.awt.Color.GREEN;
            case YELLOW:
                return java.awt.Color.YELLOW;
            case ORANGE:
                return java.awt.Color.ORANGE;
            case MAGENTA:
                return java.awt.Color.MAGENTA;
            default:
                return java.awt.Color.GRAY;
        }
    }


	public boolean validarColoresVecinos(int x, int y) {
		ColordeCelda ColorCeldaElegida = getCelda(x,y).getColor();
		ArrayList<Celda> vecinosDeCelda = grilla.getListaVecinos(x,y);
		for (Celda vecino : vecinosDeCelda)
			if (vecino.getColor() != null && vecino.getColor().equals(ColorCeldaElegida))
				return true;
		return false;
	}

	public void reiniciarCeldayVecinos(int x, int y) {
		Celda celda = grilla.getCelda(x, y);
		celda.setColor(ColordeCelda.GREY);
		
		if(x-1 >= 0) {
			Celda celdaIzq = grilla.getCelda(x-1, y);
			celdaIzq.setColor(ColordeCelda.GREY);
		}
		if(x+1 < grilla.getLength()) {
			Celda celdaDer = grilla.getCelda(x+1, y);
			celdaDer.setColor(ColordeCelda.GREY);
		}
		if(y+1 < grilla.getLength()) {
			Celda celdaArriba = grilla.getCelda(x, y+1);
			celdaArriba.setColor(ColordeCelda.GREY);
		}	
		if(y-1 >= 0) {
			Celda celdaAbajo = grilla.getCelda(x,y-1);
			celdaAbajo.setColor(ColordeCelda.GREY);	
		}	
	}

	public ColordeCelda getColor(int x, int y) {
		return grilla.getCelda(x, y).getColor();
	}

	public int tamanioGrilla() {
		return grilla.getLength();
	}
	
	public Celda getCelda(int x, int y) {
		return grilla.getCelda(x, y);
	}
	
	public boolean verificarGrilla() {
		return grilla.verificarGrilla();
	}
}
