package buscaminas.businessLogic.domain.container;

import java.util.Random;

import buscaminas.businessLogic.domain.objects.Casilla;
import buscaminas.businessLogic.domain.objects.Contador;
import buscaminas.businessLogic.domain.objects.Mina;
import buscaminas.businessLogic.domain.objects.Vacio;
import buscaminas.businessLogic.domain.utilities.Configuracion;


public class Tablero {

	private Casilla[][] tablero;
	private Configuracion configuracion;

	public Tablero(){
	}

	public Tablero(Configuracion conf) {
		System.out.println("creando tablero");
		tablero = new Casilla[conf.getNumF()][conf.getNumC()];
		
		this.configuracion = conf;
		
		// llenamos el tablero
		crearTablero();
		
		// localizamos unas casillas con otras
		organizarTablero();
		
		introducirContadoresYBlancos(conf);
		System.out.println("tablero pintado");
	}

	private void introducirContadoresYBlancos(Configuracion conf) {
		
/*
		for (int i = 0; i < conf.getNumF(); i++) {
			for (int j = 0; j < conf.getNumC(); i++) {
				if (!(tablero[i][j] instanceof Mina)) {
					Contador cont = new Contador(i, j, false, 0);

					for (int posf = i - 1; posf <= posf + 1; i++) {
						for (int posc = j - 1; posc <= j + 1; j++) {
							if ((posf >= 0) && (posf < conf.getNumF())
									&& ((posc >= 0) && (posc < conf.getNumC()))) {
								// si hay mina
								if (tablero[posf][posc] != null) {
									cont.setValor(cont.getValor() + 1);
								}

							}
						}
					}
					// No hay minas, asi que vacio
					if (cont.getValor() == 0) {
						tablero[i][j] = new Vacio(i, j, false);
					}
					// Se encontraron minas
					else {
						tablero[i][j] = cont;
					}
				}
			}
		}
		*/
	}

	private void crearTablero() {
		int fila = configuracion.getNumF();
		int columna = configuracion.getNumC();
		
		// llenamos el array bidimensional de objetos casilla
		for(int i = 0; i < fila; i++){
			Casilla[] array = tablero[i];
			for(int j = 0; j < columna; j++){
				array[j] = new Casilla(i,j);
			}
		}
		
		// algunas de las casillas serán minas aleatoriamente
		int minas = configuracion.getNumM();
		while(true){
			for(int i = 0; i < fila; i++){
				Casilla[] array = tablero[i];
				for(int j = 0; j < columna; j++){
					Casilla casilla = array[j];
					if(minas > 0){
						if(hacerMina()){
							casilla.setEsMina(true);
							minas--;
						}
					}else break;
				}
				if(minas == 0){
					break;
				}
			}
			if(minas == 0){
				break;
			}
		}
	}
	
	public void organizarTablero(){
		int fila = configuracion.getNumF();
		int columna = configuracion.getNumC();
		for(int i = 0; i < fila; i++){
			Casilla[] array = tablero[i];
			for(int j = 0; j < columna; j++){
				Casilla casilla = array[j];
				getColindantes(casilla);
			}
		}
	}
	
	// método que captura las casillas colindantes
	public void getColindantes(Casilla c){
		Casilla casilla = (Casilla) c;
		int x = casilla.getX();
		int y = casilla.getY();
		
		
		// comprobamos a la izquierda
		if(x-1 >= 0) casilla.setIzCasilla(tablero[x-1][y]);
		// comprobamos a la derecha
		if(x+1 <= configuracion.getNumF()-1) casilla.setDeCasilla(tablero[x+1][y]);
		// comprobamos arriba
		if(y-1 >= 0) casilla.setArCasilla(tablero[x][y-1]);
		// comprobamos abajo
		if(y+1 <= configuracion.getNumC()-1) casilla.setAbCasilla(tablero[x][y+1]);
	}
	
	// método ejecutado cuando seleccionas un cuadrante
	public void setSeleccion(int x, int y){
		Casilla casilla = (Casilla) tablero[x][y];
		casilla.setDescubierta(true);
		if(casilla.isEsMina()){
			System.out.println("Has perdido");
		}else{
			
		}
	}
	
	// si obtenido aleatoriamente es par -> TRUE
	public boolean hacerMina(){
		Random random = new Random();
		int  n = random.nextInt(100) + 1;
		if(n % 2 == 0){
			return true;
		}else return false;
	}
	
	public String pintarTablero(){
		int fila = configuracion.getNumF();
		int columna = configuracion.getNumC();
		String table = "";
		for(int i = 0; i < fila; i++){
			table += " \t ";
			for(int j = 0; j < columna; j++){
				String casilla = tablero[i][j].toString();
				table += casilla;
			}
			table += " \n ";
		}
		return table;
	}

	public boolean desvelarCasilla(int x, int y, boolean inicial) {
		/*
		boolean esMina = false;
		if (tablero[x][y] instanceof Mina && inicial) {
			esMina = true;
			((Mina) tablero[x][y]).setMostrada(true);
		} else if (tablero[x][y] instanceof Contador) {
			((Contador) tablero[x][y]).setMostrada(true);
		} else if (tablero[x][y] instanceof Vacio
				&& !((Vacio) tablero[x][y]).getMostrada()) {
			((Vacio) tablero[x][y]).setMostrada(true);
			if (x >= 0 && x < tablero.length && y - 1 >= 0
					&& y - 1 < tablero[0].length)
				desvelarCasilla(x, y - 1, false);
			if (x >= 0 && x < tablero.length && y + 1 >= 0
					&& y + 1 < tablero[0].length)
				desvelarCasilla(x, y + 1, false);
			if (x - 1 >= 0 && x - 1 < tablero.length && y >= 0
					&& y < tablero[0].length)
				desvelarCasilla(x - 1, y, false);
			if (x + 1 >= 0 && x + 1 < tablero.length && y >= 0
					&& y < tablero[0].length)
				desvelarCasilla(x + 1, y, false);
		}
		return esMina;
		*/
		return false;
	}

	public boolean hasGanado() {
		
		/*
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (this.tablero[i][j] instanceof Vacio) {
					Vacio v = (Vacio) tablero[i][j];
					if (!v.getMostrada()) {
						return false;
					}
				} else if (this.tablero[i][j] instanceof Contador) {
					Contador c = (Contador) tablero[i][j];
					if (!c.getMostrada()) {
						return false;
					}
				}
			}
		}
		*/
		return true;

	}

	public static void main(String[] args) {

	}

}
