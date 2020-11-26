package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Zanahoria {
	private double x,y,ancho,alto;
	private Image imagen;
	public Zanahoria() {
		this.x=20;
		this.y=20;
		this.ancho=20;
		this.alto=20;
		this.imagen=Herramientas.cargarImagen("./resources/carrot.png");
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
		entorno.dibujarImagen(imagen, x, y, 0,0.6);
	}
	public void avanzar() {
		this.y+=0.2;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
}
