package model;

public class Celda {
	private int id;
	private ColordeCelda color;

	public Celda(int id) {
		this.id = id;
		this.color = null;
	}

	public int getID () {
		return id;
	}

	public void setID (int id) {
		this.id = id;
	}

	public ColordeCelda getColor() {
		if (color==null)
			return null;
		return color;
	}

	public void setColor(ColordeCelda color) {
		this.color = color;
	}

}
