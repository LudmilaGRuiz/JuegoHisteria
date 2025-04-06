package model;

import view.PantallaGanaste;
import view.PantallaJuego;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Presentador {

	private Grilla grilla;
	private JOptionPane JOptionPane;
	//private ValidadorDeColoresVecinos validadorDeColoresVecinos;

	public Presentador() {
		//this.validadorDeColoresVecinos = new ValidadorDeColoresVecinos();
	}

	public void iniciarJuego(int nivel) {
		switch (nivel) {
			case 1 -> grilla = new Grilla(3);
			case 2 -> grilla = new Grilla(5);
			case 3 -> grilla = new Grilla(6);
			case 4 -> grilla = new Grilla(7);
			case 5 -> grilla = new Grilla(8);
			case 6 -> grilla = new Grilla(9);
		}
	}

	private ColordeCelda colorRandom() {
		Random rand = new Random();
		ColordeCelda[] colores = ColordeCelda.values();
		return colores[rand.nextInt(colores.length)];
	}

	public int tamanioGrilla() {
		return this.grilla.getGrilla().size();
	}

	public void cambiarColor(int celda) {
		ColordeCelda nuevoColor = colorRandom();
		this.getCelda(celda).setColor(nuevoColor);
	}

	public ColordeCelda getColor(int celda) {
		return this.getCelda(celda).getColor();
	}

	public Celda getCelda(int celda) {
		return grilla.getGrilla().get(celda);
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

	public Celda getCeldaPorID(int idCelda) {
		return this.grilla.getGrilla().get(idCelda);
	}

	public Boolean validarColoresVecinos(int idCelda) {
		ColordeCelda ColorCeldaElegida = getCeldaPorID(idCelda).getColor();
		ArrayList<Celda> vecinosDeCelda = this.grilla.getListaVecinos(idCelda);
		for (Celda vecino : vecinosDeCelda) {
			if (vecino.getColor() != null && vecino.getColor().equals(ColorCeldaElegida)) {
				System.out.println("Reiniciando celda y vecinos");
				return true;
			}
		}
		return false;

	}

	public ArrayList<Integer> reiniciarCeldayVecinos(int idCelda) {
		ArrayList<Celda> celdasAReiniciar = new ArrayList<Celda>();
		ArrayList<Celda> listaVecinos = grilla.getListaVecinos(idCelda);
		for (Celda vecino : listaVecinos) {
			celdasAReiniciar.add(vecino);
		}
		celdasAReiniciar.add(getCeldaPorID(idCelda));
		ArrayList<Integer> idsCeldasAReiniciar = new ArrayList<Integer>();

		for (Celda celdaAReiniciar : celdasAReiniciar) {
			celdaAReiniciar.setColor(null);
			idsCeldasAReiniciar.add(celdaAReiniciar.getID());
			System.out.println("Reiniciando celda: " + celdaAReiniciar.getID());
		}
		return idsCeldasAReiniciar;
	}

	public void estadoCeldas() {
		int contador = 0;
		for (Celda celdita : this.grilla.getGrilla()) {
			if (celdita.getColor() == null) {
				contador++;
			}
		}
		System.out.println("Cantidad de celdas sin color: " + contador);

		if (contador == 0) {
			new PantallaGanaste();
		}
	}
}
