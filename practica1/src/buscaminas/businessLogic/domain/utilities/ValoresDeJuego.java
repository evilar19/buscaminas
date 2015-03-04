package buscaminas.businessLogic.domain.utilities;

public class ValoresDeJuego {
private int mov=0;
private double puntos=0;
private long inicio;
private long fin;
	
public ValoresDeJuego(){
	this.inicio=System.currentTimeMillis();
}
public ValoresDeJuego(long inicio){
	this.inicio=inicio;
}
public void setMov(int mov){
	this.mov=mov;
}
public int getMov(){
	return this.mov;
}
public void setPuntos(double puntos){
	this.puntos=puntos;
}
public double getPuntos(){
	return this.puntos;
}
public void setInicio(long inicio){
	this.inicio=inicio;
}
public long getInicio(){
	return this.inicio;
}
public void setFin(int fin){
	this.fin=fin;
}
public long getFin(){
	return this.fin;
}
public String toString(){
	
	return "movimientos:"+Integer.toString(mov)+" puntos:"+String.valueOf(puntos);
}
public String calcularTiempoActual(){
	long tActual=System.currentTimeMillis();
	tActual=tActual-inicio;
	return createStringDeTiempo(tActual);
}
public String calcularTiempoCompleto(){
	return createStringDeTiempo(fin-inicio);
}
private String createStringDeTiempo(long tiempo){
int seconds = (int) (tiempo / 1000) % 60 ;
int minutes = (int) ((tiempo / (1000*60)) % 60);
int hours = (int) ((tiempo / (1000*60*60)) % 24);
return hours + ":" + minutes + ":" + seconds;
}
	public static void main(String[] args) {
	ValoresDeJuego v =new ValoresDeJuego();
	System.out.println("Prueba calcular tiempo actual "+v.calcularTiempoActual());
	
	}

}
