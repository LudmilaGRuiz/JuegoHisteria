package model;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
	private Grilla grilla;
	//private ValidadorDeColoresVecinos validadorDeColoresVecinos;

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

	private ColordeCelda colorRandom() {
		Random rand = new Random();
		ColordeCelda[] colores = ColordeCelda.values();
		return colores[rand.nextInt(colores.length-1)];
	}

	public int tamanioGrilla() {
		return this.grilla.getLength();
	}

	public void cambiarColor (int x, int y) {
		ColordeCelda nuevoColor = colorRandom ();
		grilla.getCelda(x, y).setColor(nuevoColor);
	}

	public ColordeCelda getColor(int x, int y) {
		return grilla.getCelda(x, y).getColor();
	}

	public Celda getCelda(int x, int y) {
		return grilla.getCelda(x, y);
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
		for (Celda vecino : vecinosDeCelda) {
			if (vecino.getColor() != null && vecino.getColor().equals(ColorCeldaElegida)) {
				System.out.println("Reiniciando celda y vecinos");
				return true;
			}
		}
		return false;

	}

	public void reiniciarCeldayVecinos(int x, int y) {
		Celda celda = grilla.getCelda(x, y);
		celda.setColor(ColordeCelda.GREY);
		
		// L:left, R:right, U:up, D:down
		if(x-1 >= 0) {
			Celda celdaL = grilla.getCelda(x-1, y);
			celdaL.setColor(ColordeCelda.GREY);
		}
		if(x+1 < grilla.getLength()) {
			Celda celdaR = grilla.getCelda(x+1, y);
			celdaR.setColor(ColordeCelda.GREY);
		}
		if(y+1 < grilla.getLength()) {
			Celda celdaU = grilla.getCelda(x, y+1);
			celdaU.setColor(ColordeCelda.GREY);
		}
			
		if(y-1 >= 0) {
			Celda celdaD = grilla.getCelda(x,y-1);
			celdaD.setColor(ColordeCelda.GREY);	
		}	
	}

	public boolean verificarGrilla() {
		return grilla.verificarGrilla();
	}
}
