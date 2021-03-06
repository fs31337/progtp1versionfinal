package juego;

import java.awt.Image;
import java.util.Random;

import entorno.*;
import juego.Carretera.Sentido;

public class Auto {
	private double x,y,ancho,alto,angulo;
	private Image imagen;
	private Image[] autos;
	
	public Auto() {
		this.x=0;
		this.y=-200;
		this.ancho=30;
		this.alto=30;
		cargarImagenes();
		this.imagen = autos[nRandom()];
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
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, angulo, 0.7);
	}
	public void avanzarPorCarretera(Carretera carretera, double velocidad) {
		this.y=carretera.obtenerY();
		if(carretera.obtenerSentido().equals(Sentido.DERECHA)) {
			this.x+=velocidad;
			this.angulo = 1.57;
		}
		else if(carretera.obtenerSentido().equals(Sentido.IZQUIERDA)) {
			this.x-=velocidad;
			this.angulo = 17.27;
		}		
	}	
	private void cargarImagenes() {
		try {
			Image auto1 = Herramientas.cargarImagen("./resources/cars/red.png");
			Image auto2 = Herramientas.cargarImagen("./resources/cars/lightblue.png");
			Image auto3 = Herramientas.cargarImagen("./resources/cars/yellow.png");
			Image auto4 = Herramientas.cargarImagen("./resources/cars/pink.png");
			Image auto5 = Herramientas.cargarImagen("./resources/cars/green.png");
			autos = new Image[] {auto1,auto2,auto3,auto4,auto5};
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
	}
	
	private int nRandom() {
		int numero = (int) (Math.random() * 5);
		return numero;
	}
	


}
