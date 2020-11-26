package juego;

import java.util.ArrayList;

import entorno.Entorno;

public class Zanahorias {
	ArrayList<Zanahoria>zanahorias;
	public Zanahorias() {
		zanahorias=new ArrayList<Zanahoria>();
	}
	public void dibujar(Entorno entorno) {
		for(Zanahoria zanahoria: zanahorias) {
			zanahoria.dibujar(entorno);
		}
	}
	public void avanzar() {
		for(Zanahoria zanahoria: zanahorias) {
			zanahoria.avanzar();
		}
	}
}
