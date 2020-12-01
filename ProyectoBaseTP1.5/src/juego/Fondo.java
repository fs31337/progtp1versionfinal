package juego;

import java.awt.Image;
import entorno.*;


public class Fondo {
	private double x,y;
	private int ancho,alto;
	private Image imagen;
	
	public Fondo(double y) {
		this.x=200;
		this.y=y;
		this.alto=0;
		this.ancho=0;	
		this.imagen = Herramientas.cargarImagen("./resources/fondo/pasto1.png"); 
	}

	public double obtenerX() { //getX
		return x;
	}	

	public void asignarX(double x) { //setX
		this.x = x;
	}

	public double obtenerY() { //getY
		return y;
	}

	public void asignarY(double y) { //setY
		this.y = y;
	}

	public int obtenerAncho() {	//getAncho
		return ancho;
	}

	public void asignarAncho(int ancho) { //setAncho
		this.ancho = ancho;
	}
	
	public int obtenerAlto() { //getAlto
		return alto;
	}

	public void asignarAlto(int alto) { //setAlto
		this.alto = alto;
	}	

	public void dibujarFondo(Entorno entorno) {	
		entorno.dibujarImagen(imagen, x, y, 0, 1.5);
	}
	
	public void avanzar() {
		this.y+=0.2;
	}
	
	public void detener() {
		this.y+=0.2;
	}
	

	
}