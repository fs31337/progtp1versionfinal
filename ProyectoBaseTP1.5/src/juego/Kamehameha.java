package juego;

import java.awt.Color;

import entorno.Entorno;

public class Kamehameha {
	private double x,y,ancho,alto;
	
	public Kamehameha() {
		this.x=-50;
		this.y=-50;
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
	public void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.cyan);
	}
	public void movimientoAtaque() {
		this.alto+=1.5;
	}
	public void establecerPos(Conejo conejo) {
		this.y=conejo.getY()-(alto/2);
		this.x=conejo.getX();
	}
}
