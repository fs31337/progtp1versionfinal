package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.*;
import juego.Carretera.Sentido;

public class Auto {
	private double x,y,ancho,alto;	
	private Image imagen;
	private Image auto1;
	private Image auto2;
	private Image auto3;
	private Image auto4;
	private Image auto5;
	private Image[] autos;
	
	public Auto() {
		this.x=0;
		this.y=0;
		this.ancho=30;
		this.alto=30;
		cargarImagenes();
		this.imagen = autos[nRandom()];
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
		entorno.dibujarImagen(imagen, x, y, 1.57, 0.7);
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
	public void detenerPorCarretera(Carretera carretera, double velocidad) {
		this.y=carretera.getY();
		if(carretera.getSentido().equals(Sentido.DERECHA)) {
			this.x-=velocidad;
		}
		else if(carretera.getSentido().equals(Sentido.IZQUIERDA)) {
			this.x+=velocidad;
		}
		
	}
	
	private void cargarImagenes() {
		try {
			this.auto1 = Herramientas.cargarImagen("./resources/cars/red.png");
			this.auto2 = Herramientas.cargarImagen("./resources/cars/lightblue.png");
			this.auto3 = Herramientas.cargarImagen("./resources/cars/yellow.png");
			this.auto4 = Herramientas.cargarImagen("./resources/cars/pink.png");
			this.auto5 = Herramientas.cargarImagen("./resources/cars/green.png");
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
		autos = new Image[] {auto1,auto2,auto3,auto4,auto5};
	}
	
	private int nRandom() {
		int numero = (int) (Math.random() * 5);
		return numero;
	}
	


}
