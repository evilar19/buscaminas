package buscaminas.businessLogic;

import java.util.Scanner;

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

	public Buscaminas(int config) {
		System.out.println("creando buscaminas");
		valores = new ValoresDeJuego();
		configure = new Configuracion(config);
		tab = new Tablero(configure);
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
		return tab;
	}

	public void Jugar() {
		Scanner on = new Scanner(System.in);
		System.out.println(tab.pintarTablero());
		boolean salir = true;
		while(salir){
			System.out.println("\b");
			System.out.println(tab.pintarTablero());
			System.out.print("Introduzca las coordenadas a marcar (X,Y): ");
			String cadena = on.nextLine();
			
			String[] strArray =  cadena.split(",");
			int x = Integer.parseInt(strArray[0]);
			int y = Integer.parseInt(strArray[1]);
			
			tab.setSeleccion(x,y);
			
			if(cadena.equals("F")){
				salir = false;
				break;
			}
			
		}

	}

}
