package juego;

import java.awt.Image;
import entorno.*;


public class Fondo {
	private double x,y;
	private int ancho,alto;
	private Entorno entorno;
	private Image imagen;
	
	public Fondo(Entorno entorno, double y) {
		this.entorno=entorno;
		this.x=entorno.ancho()/2;
		this.y=y;
		this.alto=100;
		this.ancho=entorno.ancho();	
		cargarImagenes();
	}


	public double getX() {
		return x;
	}
	

	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public int getAncho() {
		return ancho;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}


	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public void iniciarComponentesEnTick() {
		dibujarFondo();
		avanzar();
		reiniciar();
	}
	
	private void cargarImagenes() {
		try {
				this.imagen = Herramientas.cargarImagen("./resources/fondo/pasto1.png");
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
	}

	private void dibujarFondo() {	
		entorno.dibujarImagen(imagen, x, y, 0, 1.5);
	}
	private void avanzar() {
		y+=0.2;
	}
	public void detener() {
		y-=0.2;
	}
	private void reiniciar() {
		if(y>entorno.alto()-150) {
			y=400;
		}
	}
}