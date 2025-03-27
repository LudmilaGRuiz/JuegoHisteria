package model;

import java.util.ArrayList;

public class Celda {
	private int coordX, coordY;
	private ArrayList<Celda> vecinos;
	private ColordeCelda color;

	public Celda(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.vecinos = new ArrayList<Celda>();
		this.color = null;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public ArrayList<Celda> getVecinos() {
		return vecinos;
	}

	public void setVecinos(ArrayList<Celda> vecinos) {
		this.vecinos = vecinos;
	}

	public ColordeCelda getColor() {
		return color;
	}

	public void setColor(ColordeCelda color) {
		this.color = color;
	}

}
