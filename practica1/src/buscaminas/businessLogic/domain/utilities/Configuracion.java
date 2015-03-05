package buscaminas.businessLogic.domain.utilities;


public class Configuracion {
public static final int  T_PRIN=0;
public static final int  T_INT=1;
public static final int  T_EXP=2;
private int numF;
private int numC;
private int numM;


public Configuracion(){
}

public Configuracion(int select){
	if (select==0) {
		this.numF=8;
		this.numC=8;
		this.numM=10;
	}
	else if (select==1){
		this.numF=16;
		this.numC=16;
		this.numM=40;
	}
	else if(select==2) {
		this.numF=16;
		this.numC=30;
		this.numM=99;
	}
	
}
public void setNumF(int numF){
	this.numF=numF;
}
public int getNumF(){
	//System.out.println("devolviendo " + numF);
	return numF;
}
public void setNumC(int numC){
	this.numC=numC;
}
public int getNumC(){
	//System.out.println("devolviendo " + numC);
	return numC;
}
public void setNumM(int numM){
	this.numM=numM;
}
public int getNumM(){
	//System.out.println("devolviendo " + numC);
	return numM;
}

public static void main(String args[]){
	int nivel;
	System.out.println(Configuracion.T_PRIN);
	do{System.out.println("introduce nivel");
	 nivel=Utilidades.leerEntero();
	 if ((nivel<Configuracion.T_PRIN)||(nivel>Configuracion.T_EXP)){
		 System.out.println("EL numero introducido es incorrecto");
	 }
	 }while ((nivel<Configuracion.T_PRIN)||(nivel>Configuracion.T_EXP));
Configuracion c=new Configuracion(nivel);
	System.out.println("has elegido el nivel"+nivel);
	System.out.println("numero de filas"+c.getNumF());
	System.out.println("numero de columnas"+c.getNumC());
	System.out.println("numero de minas"+c.getNumM());

}
}