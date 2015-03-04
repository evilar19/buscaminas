package buscaminas.businessLogic.domain.objects;

public class Vacio {
	private int x;
	private int y;
	private boolean mostrada;

	public Vacio(int x, int y, boolean mostrada) {
		this.x = x;
		this.y = y;
		this.mostrada = mostrada;
	}

	public Vacio() {

	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public void setMostrada(boolean mostrada) {
		this.mostrada = mostrada;
	}

	public boolean getMostrada() {
		return this.mostrada;
	}

	public String toString() {
		if (this.mostrada == true) {
			return " ";
		} else
			return "#";
	}

	public static void main(String args[]) {

		Vacio v = new Vacio();
		v.setX(5);
		v.setY(7);

		System.out.println("casilla x:" + v.getX());
		System.out.println("casilla y:" + v.getY());

		v.setMostrada(true);
		String prueba = v.toString();
		System.out.println(prueba);

	}
}
