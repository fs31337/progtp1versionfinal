package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.*;
import juego.Carretera.Sentido;

public class Tren {
	private double x,y,ancho,alto,angulo,velocidad;
	private Image imagen;
	
	public Tren() {
		this.x=-300;
		this.y=170;
		this.ancho=600;
		this.alto=60;
		this.velocidad=5;
		//cargarImagenes();
		
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
	public void setY(double y) {
		this.y=y;
	}
	public void dibujar(Entorno entorno) {
		//entorno.dibujarImagen(imagen, x, y, angulo, 0.7);
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, angulo, Color.blue);
	}
	public void avanzar() {	
			this.y+=0.2;
			//this.angulo = 1.57;		
	}
	public void avanzarPorVia() {
		this.x+=velocidad;
	}
	
	public void detener(double y,double velocidad) {
		this.y=y;
		this.x-=velocidad;	
	}
	
	private void cargarImagenes() {
		try {
			Image tren = Herramientas.cargarImagen("./resources/tren/tren.png");		
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
	}


}
