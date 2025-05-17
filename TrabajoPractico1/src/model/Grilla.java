package model;

import java.util.ArrayList;

public class Grilla {
	private Celda[][] grilla;

	public Grilla(int tamanio) {
		this.grilla = new Celda[tamanio][tamanio];
		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < tamanio; j++) {
				grilla[i][j] = new Celda(i, j);
			}
		}
	}

    public ArrayList<Celda> getListaVecinos(int x, int y) {
        ArrayList<Celda> listaVecinos = new ArrayList<Celda>();
        if(x+1<grilla.length)
        	listaVecinos.add(grilla[x+1][y]);
        if(x-1>=0)
        	listaVecinos.add(grilla[x-1][y]);
        if(y+1<grilla.length)
        	listaVecinos.add(grilla[x][y+1]);
        if(y-1>=0)
        	listaVecinos.add(grilla[x][y-1]); 
        return listaVecinos;
    }

	public boolean verificarGrilla() {
		if(grilla==null || grilla.length==0)
			return false;
		int contador = 0;
		for (int fila=0; fila<grilla.length; fila++)
			for (int col=0; col<grilla.length; col++)
				if (grilla[fila][col]!=null && grilla[fila][col].getColor()==ColordeCelda.GREY) 
					contador++;
		return contador == 0;
	}

	public void setColorCelda(int x, int y, ColordeCelda nuevoColor) {
		grilla[x][y].setColor(nuevoColor);
	}
	
	public Celda getCelda(int x, int y) {
		return grilla[x][y];
	}
	
	public int getLength() {
		return grilla.length;
	}
}
