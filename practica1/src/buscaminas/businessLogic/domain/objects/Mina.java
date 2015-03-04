package buscaminas.businessLogic.domain.objects;

public class Mina {
	private int x;
	private int y;
	private boolean mostrada;

	public Mina(int x, int y, boolean mostrada) {
		this.x = x;
		this.y = y;
		this.mostrada = mostrada;
	}

	public Mina() {

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
			return "*";
		} else
			return "#";
	}

	public static void main(String args[]) {

		Mina m = new Mina();
		m.setX(5);
		m.setY(7);

		System.out.println("casilla x:" + m.getX());
		System.out.println("casilla y:" + m.getY());

		m.setMostrada(true);
		String prueba = m.toString();
		System.out.println(prueba);

	}
}