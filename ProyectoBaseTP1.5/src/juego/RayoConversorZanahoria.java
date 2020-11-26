package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;

public class RayoConversorZanahoria {
	private double x,y,ancho,alto;
	public RayoConversorZanahoria() {
		this.x=0;
		this.y=0;
		this.alto=30;
		this.ancho=30;
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
		entorno.dibujarRectangulo(x, y, ancho, alto, Herramientas.radianes(270), Color.orange);
	}
	public void movimietoAtaque() {
		this.y-=1.5;
	}
	public void establecerPosX(Conejo conejo) {
		this.x=conejo.getX();
	}
	public void establecerPosY(Conejo conejo) {
		this.y=conejo.getY();
	}
	
	
}
