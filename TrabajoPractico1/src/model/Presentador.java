package model;

import java.util.Random;

public class Presentador {

	private Celda[][] grilla;
	private ValidadorDeColoresVecinos validadorDeColoresVecinos;

	public Presentador() {
		this.validadorDeColoresVecinos = new ValidadorDeColoresVecinos();
	}

	public void iniciarJuego(int nivel) {
		switch(nivel) {
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
	
	
	public Boolean validarVecinos(Celda celda) {
		Boolean esValido = validadorDeColoresVecinos.validar(grilla, celda);
		if(!esValido) System.out.println("El color coincide con al menos 1 vecino");
		return esValido;
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

	public Celda getCelda(int x, int y) {
		try {
			return grilla[x][y];
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error buscando celda, coordenadas inválidas");
			throw e;
		}
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

	public int tamanioGrilla() {
		return grilla.length;
	}
	
	public void reiniciarCeldayVecinos(Integer x, Integer y) {
		Celda celda = grilla[x][y];
		celda.setColor(null);
		
		// L:left, R:right, U:up, D:down
		if(x-1 >= 0) {
			Celda celdaL = grilla[x-1][y];
			celdaL.setColor(ColordeCelda.GREY);
		}
		if(x+1 <= grilla.length) {
			Celda celdaR = grilla[x+1][y];
			celdaR.setColor(ColordeCelda.GREY);
		}
		if(y+1 <= grilla.length) {
			Celda celdaU = grilla[x][y+1];
			celdaU.setColor(ColordeCelda.GREY);
		}
			
		if(y-1 >= 0) {
			Celda celdaD = grilla[x][y-1];
			celdaD.setColor(ColordeCelda.GREY);	
		}	
	}
	
}
