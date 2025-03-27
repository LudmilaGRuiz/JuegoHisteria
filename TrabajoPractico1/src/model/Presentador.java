package model;

import java.util.Random;

public class Presentador {
	private Celda[][] grilla;
	
	public void iniciarJuego(int nivel) {
		switch(nivel) {
		case 0 -> throw new RuntimeException("Ingrese un nivel valido");
		case 1 -> crearGrilla(5);
		case 2 -> crearGrilla(6);
		case 3 -> crearGrilla(7);
		case 4 -> crearGrilla(8);
		case 5 -> crearGrilla(9);
		}
	}
		
	public void crearGrilla(int tamaño) {
		this.grilla = new Celda[tamaño][tamaño];
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				grilla[i][j] = new Celda(i, j);
			}
		}
		
	}
	private ColordeCelda colorRandom () {
		Random rand = new Random();
		ColordeCelda[] colores = ColordeCelda.values();
		return colores[rand.nextInt(colores.length)];
	}
	
	public void cambiarColor (int x, int y) {
		ColordeCelda nuevoColor = colorRandom ();
		grilla[x][y].setColor(nuevoColor);
	}
	
	public ColordeCelda getColor(int x, int y) {
	    return grilla[x][y].getColor();
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

	public int tamañoGrilla() {
		return grilla.length;
	}
	
}
