package buscaminas.businessLogic.domain.container;

import java.util.Random;
import buscaminas.businessLogic.domain.objects.Contador;
import buscaminas.businessLogic.domain.objects.Mina;
import buscaminas.businessLogic.domain.objects.Vacio;
import buscaminas.businessLogic.domain.utilities.Configuracion;


public class Tablero {

	private Object[][] tablero;

	public Tablero() {
	}

	public Tablero(Configuracion conf) {

		tablero = new Object[conf.getNumF()][conf.getNumC()];

		crearTablero(conf);

		introducirContadoresYBlancos(conf);
	}

	private void introducirContadoresYBlancos(Configuracion conf) {

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
	}

	private void crearTablero(Configuracion conf) {
		int contador = 0;
		Random numAl = new Random();

		do {
			if (tablero[numAl.nextInt(conf.getNumF())][numAl.nextInt(conf
					.getNumC())] == null) {
				tablero[numAl.nextInt(conf.getNumF())][numAl.nextInt(conf
						.getNumC())] = new Mina();
				contador++;
			} else
				tablero[numAl.nextInt(conf.getNumF())][numAl.nextInt(conf
						.getNumC())] = new Mina();
			contador++;

		} while (contador < conf.getNumM());

	}
	
	public String pintarTablero(Configuracion conf){
		String tab;
		for(int i=0;i<conf.getNumF();i++){
			
		}
	}

	public boolean desvelarCasilla(int x, int y, boolean inicial) {
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
	}

	public boolean hasGanado() {
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
		return true;

	}

	public static void main(String[] args) {

	}

}
