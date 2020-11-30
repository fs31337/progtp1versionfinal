package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class RayoConversorZanahoria {
	private double x,y,ancho,alto;
	private Image imagen;
	
	public RayoConversorZanahoria(double x, double y) {
		this.x=x;
		this.y=y;
		this.alto=30;
		this.ancho=30;
		this.imagen=Herramientas.cargarImagen("./resources/spells/conversorzanahoria4.png");
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
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, 0, 0.04);
		}
	public void movimientoAtaque() {
		this.y-=1.5;
	}
	public void establecerPosX(Conejo conejo) {
		this.x=conejo.getX();
	}
	public void establecerPosY(Conejo conejo) {
		this.y=conejo.getY();
	}
	
	
}
