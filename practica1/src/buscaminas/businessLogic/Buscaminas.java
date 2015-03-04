package buscaminas.businessLogic;

import buscaminas.businessLogic.domain.container.Tablero;
import buscaminas.businessLogic.domain.utilities.Configuracion;
import buscaminas.businessLogic.domain.utilities.ValoresDeJuego;
import buscaminas.Manager;

public class Buscaminas {
	private ValoresDeJuego valores;
	private Configuracion configure;
	private Tablero tab;

	public Buscaminas() {
	}

	public Buscaminas( int config) {
		valores = new ValoresDeJuego();
		configure = new Configuracion(config);
		tab = new Tablero();
	}

	public void setValores(ValoresDeJuego valores) {
		this.valores = valores;
	}

	public ValoresDeJuego getValores() {
		return this.valores;
	}

	public void config(Configuracion config) {
		this.configure = config;
	}

	public Configuracion config() {
		return this.configure;
	}

	public void setTab(Tablero tab) {
		this.tab = tab;
	}

	public Tablero getTab() {
		return this.tab;
	}

	public void Jugar() {
		
		
	}

	public static void main(String[] args) {
Buscaminas b=new Buscaminas();
b.Jugar();
	}

}
