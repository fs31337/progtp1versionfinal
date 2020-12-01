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
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, 0, 0.04);
		}
	
	public void movimientoAtaque() {
		this.y-=1.5;
	}
	public void establecerPosX(Conejo conejo) {
		this.x=conejo.obtenerX();
	}
	public void establecerPosY(Conejo conejo) {
		this.y=conejo.obtenerY();
	}
	
	
}
