package buscaminas.businessLogic.domain.objects;

public class Casilla {
	
	private boolean esMina,descubierta;
	private int x,y;
	private Casilla arCasilla,abCasilla,deCasilla,izCasilla;
	
	public Casilla(int x, int y){
		esMina = false; // inicialmente ninguna de las casillas es mina
		descubierta = false;
		this.x = x;
		this.y = y;
		// inicialmente la casilla no sabra cuales la rodean
		arCasilla = null;	// mina de arriba
		abCasilla = null;	// mina de abajo
		deCasilla = null;	// mina de la derecha
		izCasilla = null;	// mina de la aizquierda
	}

	public boolean isEsMina() {
		return esMina;
	}

	public void setEsMina(boolean esMina) {
		this.esMina = esMina;
	}

	public Casilla getArCasilla() {
		return arCasilla;
	}

	public void setArCasilla(Casilla arCasilla) {
		this.arCasilla = arCasilla;
	}

	public Casilla getAbCasilla() {
		return abCasilla;
	}

	public void setAbCasilla(Casilla abCasilla) {
		this.abCasilla = abCasilla;
	}

	public Casilla getDeCasilla() {
		return deCasilla;
	}

	public void setDeCasilla(Casilla deCasilla) {
		this.deCasilla = deCasilla;
	}

	public Casilla getIzCasilla() {
		return izCasilla;
	}

	public void setIzCasilla(Casilla izCasilla) {
		this.izCasilla = izCasilla;
	}
	
	public int getNumero(){
		return 0;
	}
	
	public String toString(){
		if(!descubierta){
			return "#";
		}else{
			if(esMina){
				return "*";
			}else{
				return " ";
			}
			
		}
	}

	public boolean isDescubierta() {
		return descubierta;
	}

	public void setDescubierta(boolean descubierta) {
		this.descubierta = descubierta;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
