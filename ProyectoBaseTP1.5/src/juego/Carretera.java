package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Carretera {
	private double x,y,ancho,alto;
	private Sentido sentido;
	private Image imagen;
	private Image[] calles;
	
	enum Sentido{
		DERECHA,IZQUIERDA
	}
	public Carretera(int imagen) {
		this.y=0;
		this.x=0;
		this.alto=0;
		this.ancho=0;
		cargarImagenes();
		this.imagen = calles[imagen-1];
	}
	public double getY() {
		return this.y;
	}
	public void setY(double y) {
		this.y=y;
	}
	public Sentido getSentido() {
		return this.sentido;
	}
	public void establecerTamano(Entorno entorno) {
		this.alto=50;
		this.ancho=entorno.ancho();
	}
	public void establecerPos(Entorno entorno,double y) {
		this.x=entorno.ancho()/2;
		this.y=y;
	}
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, 0,0.6);
	}
	public void avanzar() {
		this.y+=0.2;
	}
	public void detener() {
		this.y+=0.2;
	}
	
	public void establecerSentido(Sentido sentido) {
		this.sentido=sentido;
	}
	
	private void cargarImagenes() {
		try {
				Image calle1 = Herramientas.cargarImagen("./resources/fondo/calle1.png");
				Image calle2 = Herramientas.cargarImagen("./resources/fondo/calle2.png");
				Image calle3 = Herramientas.cargarImagen("./resources/fondo/calle3.png");
				Image calle4 = Herramientas.cargarImagen("./resources/fondo/calle4.png");
				calles = new Image [] {calle1,calle2,calle3,calle4};
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
	}
	
}
