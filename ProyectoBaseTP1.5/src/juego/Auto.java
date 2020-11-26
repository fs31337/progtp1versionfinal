package juego;

import java.awt.Color;

import entorno.*;
import juego.Carretera.Sentido;

public class Auto {
	private double x,y,ancho,alto;
	
	
	public Auto() {
		this.x=0;
		this.y=0;
		this.ancho=30;
		this.alto=30;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getAncho() {
		return this.ancho;
	}
	public double getAlto() {
		return this.alto;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.green);
	}
	public void avanzarPorCarretera(Carretera carretera, double velocidad) {
		this.y=carretera.getY();
		if(carretera.getSentido().equals(Sentido.DERECHA)) {
			this.x+=velocidad;
		}
		else if(carretera.getSentido().equals(Sentido.IZQUIERDA)) {
			this.x-=velocidad;
		}
		
	}
	


}
