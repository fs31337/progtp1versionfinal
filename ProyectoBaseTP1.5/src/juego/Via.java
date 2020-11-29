package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import juego.Carretera.Sentido;

public class Via {
	private double x,y,ancho,alto,angulo,velocidad;
	private Image imagen;
	
	public Via(double x, double y, double ancho) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=70;
	}
	public double getY() {
		return this.y;
	}
	public void setY(double y) {
		this.y=y;
	}
	public void dibujar(Entorno entorno) {
		//entorno.dibujarImagen(imagen, x, y, 0,0.6);
		entorno.dibujarRectangulo(x, y, ancho, alto, angulo, Color.gray);
	}
	public void avanzar() {
		this.y+=0.2;
	}
	public void detener() {
		this.y+=0.2;
	}

	private void cargarImagenes() {
		try {
				
				//Agregar imagenes
			
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
	}
}
