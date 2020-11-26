package juego;

import java.awt.Color;

import entorno.Entorno;

public class Carretera {
	private double x,y,ancho,alto;
	private Sentido sentido;
	enum Sentido{
		DERECHA,IZQUIERDA
	}
	public Carretera() {
		this.y=0;
		this.x=0;
		this.alto=0;
		this.ancho=0;
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
	public void establecerTamaño(Entorno entorno) {
		this.alto=50;
		this.ancho=entorno.ancho();
	}
	public void establecerPos(Entorno entorno,double y) {
		this.x=entorno.ancho()/2;
		this.y=y;
	}
	public void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.BLUE);
	}
	public void avanzar() {
		this.y+=0.2;
	}
	
	public void establecerSentido(Sentido sentido) {
		this.sentido=sentido;
	}
}
