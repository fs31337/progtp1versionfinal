package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.*;
import juego.Carretera.Sentido;

public class Tren {
	private double x,y,ancho,alto,angulo,velocidad;
	private Image imagen;
	
	public Tren(double x, double y, double ancho, double alto, double velocidad) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.velocidad=velocidad;
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
	
	public void avanzarPorVia(Via via) {
		this.x+=velocidad;
		this.y=via.getY();
	}
	
	public void detener(double y) {
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
