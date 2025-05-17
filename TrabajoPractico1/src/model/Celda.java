package model;

public class Celda {
	private int coordX, coordY;
	private ColordeCelda color;

	public Celda(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.color = ColordeCelda.GREY;
	}

	public ColordeCelda getColor() {
		return color;
	}

	public void setColor(ColordeCelda color) {
		this.color = color;
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
}
