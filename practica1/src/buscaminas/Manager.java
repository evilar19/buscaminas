package buscaminas;

import buscaminas.businessLogic.domain.utilities.Configuracion;
import buscaminas.businessLogic.*;
import buscaminas.businessLogic.domain.utilities.Utilidades;

public class Manager {

	private Buscaminas busc;
	
	
public void escribirMenuInicial(){
	System.out.println("--------------------------------------");
	System.out.println("|Buscaminas powered by deusto student |");
	System.out.println("--------------------------------------");
	System.out.println("Esta es la versión del buscaminas en java y orientada a objetos");
	System.out.println("Seleccione la opción adecuada:");
	System.out.println();
	System.out.println("1. jugar buscaminas");
	System.out.println("2. salir del juego");
	System.out.println();
	System.out.println("Introduzca la opción");
		
}
public void lanzarMenuInicial(){
	int opcion;
	escribirMenuInicial();
	opcion=Utilidades.leerEntero();
	if((opcion<1||opcion>2)){
		System.out.println("El numero introducido no es el correcto ");
		System.out.println("por favor introduzca de nuevo");
		opcion=Utilidades.leerEntero();
	}
	if (opcion==1){
		lanzarMenuConfiguracion();
	}
	else{
		System.out.println("HASTA LUEGO");
	}
	}
	public void escribirMenuConfiguracion(){
		System.out.println("Buscaminas powered by deusto student");
		System.out.println("Selecciona la configuracion deseada:");
		System.out.println("1. tablero para principiantes:");
		System.out.println("2. tablero para intermedios");
		System.out.println("3. tablero para expertos");
		System.out.println("4. 1volver");
		System.out.println();
		System.out.println("Introduzca la opción");
	}
	public void lanzarMenuConfiguracion(){
		int opcion;
		escribirMenuConfiguracion();
		opcion=Utilidades.leerEntero();
		if((opcion<1||opcion>4)){
			System.out.println("El numero introducido no es el correcto ");
			System.out.println("por favor introduzca de nuevo");
			opcion=Utilidades.leerEntero();
		}
		switch(opcion){
		case 1 :  busc=new Buscaminas(0);
				busc.Jugar();	
				break;
		case 2 : busc=new Buscaminas (1);break;
		case 3 : busc=new Buscaminas (2);break;
		default : lanzarMenuInicial();
		}
}

	public static void main(String[] args) {
	Manager m=new Manager();
		m.lanzarMenuInicial();

	}

}
