package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.*;

public class Conejo {
	private double x,y,ancho,alto,velocidad;
	private Image imagen;
	private Image[] imgconejos;
	
	public Conejo() {
		this.x=0;
		this.y=0;
		this.ancho=30;
		this.alto=30;
		this.velocidad=40;
		cargarImagenes();
		imagen = imgconejos[0];  //imagen inicial
		
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
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, 0);
	}
	public void moverseArriba() {
		y-=velocidad;
		imagen=imgconejos[0];
	}
	
	public void moverseIzquierda() {
		x-=velocidad;
		imagen=imgconejos[1];
	}
	public void moverseDerecha() {
		x+=velocidad;
		imagen=imgconejos[2];
	}
	public void avanzar() {
		this.y+=0.2;
	}
	private void cargarImagenes() {
		try {
				Image conejoarr = Herramientas.cargarImagen("./resources/conejo/conejoarr.png");
				Image conejoizq = Herramientas.cargarImagen("./resources/conejo/conejoizq.png");
				Image conejoder = Herramientas.cargarImagen("./resources/conejo/conejoder.png");
				imgconejos = new Image [] {conejoarr,conejoizq,conejoder};
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
	}
	
	public Kamehameha dispararKamehameha() {
		Kamehameha kamehameha = new Kamehameha(this.x,this.y);
		return kamehameha;
	}
	public RayoConversorZanahoria disparararRayoConversor() {
		RayoConversorZanahoria rayoConversorZanahoria = new RayoConversorZanahoria();
		return rayoConversorZanahoria;
	}
}
