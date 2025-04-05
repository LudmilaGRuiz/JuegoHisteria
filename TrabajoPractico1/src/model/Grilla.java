package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Grilla {
	private ArrayList<Celda> grilla;
	private HashMap<Integer, ArrayList<Celda>> listaVecinos;

	public Grilla(int tamanio) {
		this.grilla = new ArrayList<Celda>();
		this.listaVecinos = new HashMap<Integer, ArrayList<Celda>>();

		for (int i = 0; i < tamanio*tamanio; i++) {
			Celda celda = new Celda(i);
			grilla.add(celda);
			listaVecinos.put(i, new ArrayList<Celda>());
		}
		for (int i = 0; i < tamanio*tamanio; i++) {
			if ((i + 1) % tamanio != 0) {
				listaVecinos.get(i).add(grilla.get(i + 1));
				listaVecinos.get(i + 1).add(grilla.get(i));
			}
			if (i + tamanio < tamanio * tamanio) {
				listaVecinos.get(i).add(grilla.get(i + tamanio));
				listaVecinos.get(i + tamanio).add(grilla.get(i));
			}
		}

	}

	public ArrayList<Celda> getGrilla() {
		return grilla;
	}

	public void setGrilla(ArrayList<Celda> grilla) {
		this.grilla = grilla;
	}

	public HashMap<Integer, ArrayList<Celda>> getListaVecinosEntera() {
		return listaVecinos;
	}

    public ArrayList<Celda> getListaVecinos(int celda) {
        return listaVecinos.get(celda);
    }

}
