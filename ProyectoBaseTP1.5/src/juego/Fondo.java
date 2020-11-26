package juego;

import java.awt.Image;
import entorno.*;


public class Fondo {
	private double x,y;
	private int ancho,alto;
	private Image imagen;
	
	public Fondo(double y) {
		this.x=0;
		this.y=y;
		this.alto=0;
		this.ancho=0;	
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
	
	private void cargarImagenes() {
		try {
				this.imagen = Herramientas.cargarImagen("./resources/fondo/pasto1.png");
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
	}

	private void dibujarFondo(Entorno entorno) {	
		entorno.dibujarImagen(imagen, x, y, 0, 1.5);
	}
	

	
}