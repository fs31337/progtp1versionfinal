package juego;

import java.awt.Image;

import entorno.*;

public class Tren {
	private double x,y,ancho,alto,angulo,velocidad;
	private Image imagen;
	
	public Tren(double x, double y, double ancho, double alto, double velocidad) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.velocidad=velocidad;
		this.imagen = Herramientas.cargarImagen("./resources/tren/tren.png");
		
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
	public void asignarX(double x) {
		this.x=x;
	}
	public void asignarY(double y) {
		this.y=y;
	}
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, angulo, 0.7);
	}
	
	public void avanzarPorVia(Via via) {
		this.x+=velocidad;
		this.y=via.obtenerY();
	}
	
	public void detener(double y) {
		this.y=y;
		this.x-=velocidad;	
	}
	
}
