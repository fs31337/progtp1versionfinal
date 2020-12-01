package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Zanahoria {
	private double x,y,ancho,alto;
	private Image imagen;
	
	public Zanahoria(double x, double y) {
		this.x=x;
		this.y=y;
		this.ancho=20;
		this.alto=20;
		this.imagen=Herramientas.cargarImagen("./resources/carrot.png");
	}
	public double obtenerX() {
		return this.x;
	}
	public double obtenerY() {
		return this.y;
	}
	public double obtenerAncho() {
		return this.ancho;
	}
	public double obtenerAlto() {
		return this.alto;
	}
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, 0,0.6);
	}
	public void avanzar() {
		this.y+=0.2;
	}
	public void detener() {
		this.y-=0.2;
	}
	public void asignarX(double x) {
		this.x=x;
	}
	public void asignarY(double y) {
		this.y=y;
	}
}
