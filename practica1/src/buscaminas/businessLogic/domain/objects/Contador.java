package buscaminas.businessLogic.domain.objects;

public class Contador {
	private int x;
	private int y;
	private boolean mostrada;
	private int valor;

	public Contador(int x, int y, boolean mostrada, int valor) {
		this.x = x;
		this.y = y;
		this.mostrada = mostrada;
		this.valor = valor;
	}

	public Contador() {
		this.x = 0;
		this.y = 0;
		this.mostrada = false;
		this.valor = 0;
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

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

	public void setMostrada(boolean mostrada) {
		this.mostrada = mostrada;
	}

	public boolean getMostrada() {
		return this.mostrada;
	}

	public String toString() {

		if (this.mostrada == true) {
			return Integer.toString(this.valor);
		} else
			return "#";
	}

	public static void main(String args[]) {

		Contador m = new Contador();
		m.setX(5);
		m.setY(7);
		m.setValor(8);

		System.out.println("casilla x:" + m.getX());
		System.out.println("casilla y:" + m.getY());

		m.setMostrada(true);
		String prueba = m.toString();
		System.out.println(prueba);

	}
}