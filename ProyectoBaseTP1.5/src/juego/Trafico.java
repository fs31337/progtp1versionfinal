package juego;

import entorno.Entorno;

public class Trafico {
	private Auto autos[];
	public Trafico(int cantAutos) {
		autos=new Auto[cantAutos];
	}
	public Auto[] getAutos() {
		return this.autos;
	}
	public void crearAutos() {
		for(int i=0;i<autos.length;i++) {
			Auto auto = new Auto();
			autos[i] = auto;
		}
	}
	public void posicionarAutos() {
		int posX=0;
		for(int i=0;i<autos.length;i++) {
			if(autos[i]!=null) {
				autos[i].setX(posX);
				posX+=200;
			}
		}
	}
	public void avanzarAutosPorCarretera(Carretera carretera,double velocidad) {
		for(int i=0;i<autos.length;i++) {
			if(autos[i]!=null) {
				autos[i].avanzarPorCarretera(carretera, velocidad);
			}
		}
	}
	public void dibujarAutos(Entorno entorno) {
		for(int i=0;i<autos.length;i++) {
			if(autos[i]!=null) {
				autos[i].dibujar(entorno);
			}
		}
	}
}
