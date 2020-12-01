package juego;

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
	
	public double obtenerX() { //getX
		return this.x;
	}
	public double obtenerY() { //getY
		return this.y;
	}
	public double obtenerAncho() { //getAncho
		return this.ancho;
	}
	public double obtenerAlto() { //getAlto
		return this.alto;
	}
	public double obtenerVelocidad() { //getVelocidad
		return this.velocidad;
	}	
	public void asignarX(double x) { //setX
		this.x=x;
	}
	public void asignarY(double y) { //setY
		this.y=y;
	}
	public void asignarAncho(double ancho) { //setAncho
		this.ancho=ancho;
	}
	public void asignarAlto(double alto) {	//setAlto
		this.alto=alto;
	}
	
	
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
		RayoConversorZanahoria rayoConversorZanahoria = new RayoConversorZanahoria(this.x,this.y);
		return rayoConversorZanahoria;
	}
}
