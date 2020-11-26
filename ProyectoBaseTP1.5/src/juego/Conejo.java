package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.*;

public class Conejo {
	private double x,y,ancho,alto,velocidad;
	private Image imagen;
	
	public Conejo() {
		this.x=0;
		this.y=0;
		this.ancho=30;
		this.alto=30;
		this.velocidad=40;
		imagenInicial();
		
	}
	//Getters {
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
	public double getVelocidad() {
		return this.velocidad;
	}
	// } Getters
	
	// Setters {
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	public void setAncho(double ancho) {
		this.ancho=ancho;
	}
	public void setAlto(double alto) {
		this.alto=alto;
	}
	// } Setters
	private void imagenInicial() {
		imagen=Herramientas.cargarImagen("./resources/conejo/conejoarr.png");
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, 0);
	}
	public void moverseArriba() {
		y-=velocidad;
		imagen=Herramientas.cargarImagen("./resources/conejo/conejoarr.png");
	}
	
	public void moverseIzquierda() {
		x-=velocidad;
		imagen=Herramientas.cargarImagen("./resources/conejo/conejoizq.png");
	}
	public void moverseDerecha() {
		x+=velocidad;
		imagen=Herramientas.cargarImagen("./resources/conejo/conejoder.png");
	}
	public void avanzar() {
		this.y+=0.2;
	}
	
	public Kamehameha dispararKamehameha() {
		Kamehameha kamehameha = new Kamehameha();
		return kamehameha;
	}
	public RayoConversorZanahoria disparararRayoConversor() {
		RayoConversorZanahoria rayoConversorZanahoria = new RayoConversorZanahoria();
		return rayoConversorZanahoria;
	}
}
