package juego;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.Timer;

import entorno.*;
import juego.Carretera.Sentido;



public class Juego extends InterfaceJuego
{
	
	private Entorno entorno;
	public static final String TITULO ="Boss Rabbit Rabber - Grupo 6 - v1";
	private Conejo conejo;
	
	private Carretera carretera1;
	/*private Carretera carretera2;
	private Carretera carretera3;
	private Carretera carretera4;
	private Carretera carretera5;
	private Carretera carretera6;
	private Carretera carretera7;
	private Carretera carretera8;
	*/
	private Trafico autos1;
	/*private Trafico autos2;
	private Trafico autos3;
	private Trafico autos4;
	private Trafico autos5;
	private Trafico autos6;
	private Trafico autos7;
	private Trafico autos8;
	*/
	private Kamehameha kamehameha;
	private Zanahorias zanahorias;
	private RayoConversorZanahoria rayoConversorZanahoria;
	private boolean juegoTerminado;
	private int puntosTotal, saltos;
	private Timer tiempoActivoKame;
	private Timer tiempoRecargaKame;
	private Timer tiempoActivoRayo;
	private Timer tiempoRecargaRayo;
	private Timer tiempoEsperaMovConejo;
	private Timer tiempoActivoZaWarudo;
	private boolean esperaMovConejo;
	private boolean recargaKame;
	private boolean recargaRayo;
	private int centesimasRecargaKame, segRecargaKame;
	private int centesimasRecargaRayo, segRecargaRayo;
	private int centesimasActivoZaWarudo, segActivoZaWarudo;
	private boolean ZaWarudo;
	public Juego()
	{
		
		this.entorno = new Entorno(this, TITULO, 800, 600);
		this.conejo = new Conejo();
		this.carretera1 = new Carretera();
		this.autos1 = new Trafico(4);
		this.establecerPosInicialConejo();
		this.carretera1.establecerTamano(entorno);
		this.carretera1.establecerPos(entorno,100);
		this.carretera1.establecerSentido(Sentido.DERECHA);
		this.autos1.crearAutos();
		this.autos1.posicionarAutos();
		this.juegoTerminado=false;
		this.puntosTotal=0;
		this.saltos=0;
		this.recargaKame=false;
		this.recargaRayo=false;
		this.centesimasRecargaKame=0;
		this.segRecargaKame=0;
		this.centesimasRecargaRayo=0;
		this.segRecargaRayo=0;
		this.zanahorias=new Zanahorias();
		this.esperaMovConejo=false;
		this.ZaWarudo=false;
		this.centesimasActivoZaWarudo=0;
		this.segActivoZaWarudo=0;
		this.entorno.iniciar();
	}
	
	
	
	public void tick()
	{
		if(!juegoTerminado()) {
			dibujarTodo();
			movimientoConejo();
			conejoAtrasado();
			avanzarTodo();
			atropellaConejo(autos1);
			resetearCarreteraDesaparece(carretera1);
			dispararKamehameha();
			autoTocaLimite(autos1, carretera1);
			escribirSaltos();
			escribirPuntajeTotal();
			escribirTiempoRecargaKame();
			dispararRayoConversor();
			zanahoriasActivas();
			comerZanahoria();
			resetearZanahoria();
			escribirTiempoRecargaRayo();
			detenerTiempo();
			escribirTiempoActivoZaWarudo();
			
		}
		else {
			juegoTerminado();
		}
	}
	private boolean juegoTerminado() {
		if(juegoTerminado) {
			entorno.cambiarFont("Arial", 120, Color.WHITE);
			entorno.escribirTexto("PERDISTE", entorno.ancho()/8, entorno.alto()/2);
			return true;
		}
		if(puntosTotal>=100) {
			entorno.cambiarFont("Arial", 120, Color.WHITE);
			entorno.escribirTexto("GANASTE", entorno.ancho()/8, entorno.alto()/2);
			return true;
		}
		return false;
	}
	private void dibujarTodo() {
		carretera1.dibujar(entorno);
		conejo.dibujar(entorno);
		autos1.dibujarAutos(entorno);
	}
	private void establecerPosInicialConejo() {
		conejo.setX(entorno.ancho()/2);
		conejo.setY((entorno.alto()/2)+200);
	}
	
	private void movimientoConejo() {
		if(!esperaMovConejo) {
			if(entorno.sePresiono('w') || entorno.sePresiono(entorno.TECLA_ARRIBA)) {
				if(!conejoTocaLimiteSuperior()) {
					conejo.moverseArriba();
					saltos++;
					puntosTotal++;
					esperaMovConejo=true;
					tiempoEsperaMovConejo();
				}
			}
			if(entorno.sePresiono('a') || entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
				if(!conejoTocaLimiteIzquierdo()) {
					conejo.moverseIzquierda();
					esperaMovConejo=true;
					tiempoEsperaMovConejo();
				}
			}
			if(entorno.sePresiono('d') || entorno.sePresiono(entorno.TECLA_DERECHA)) {
				if(!conejoTocaLimiteDerecho()) {
					conejo.moverseDerecha();
					esperaMovConejo=true;
					tiempoEsperaMovConejo();
				}
			}
		}
	}
	
	private void avanzarTodo() {
		if(!ZaWarudo) {
		conejo.avanzar();
		carretera1.avanzar();
		autos1.avanzarAutosPorCarretera(carretera1, 1);
		}
	}
	public boolean verificarDesapareceCarretera(Carretera carretera) {
		if(carretera.getY()>=entorno.alto()+50) {
			return true;
		}
		return false;
	}
	private void resetearCarreteraDesaparece(Carretera carretera) {
		if(verificarDesapareceCarretera(carretera)) {
			carretera.setY(-50);
		}
	}
	
	private boolean conejoTocaLimiteDerecho() {
		if(conejo.getX()>=entorno.ancho()) {
			return true;
		}
		return false;
	}
	private boolean conejoTocaLimiteIzquierdo() {
		if(conejo.getX()<=0) {
			return true;
		}
		return false;
	}
	private boolean conejoTocaLimiteSuperior() {
		if(conejo.getY()<100) {
			return true;
		}
		return false;
	}
	private boolean conejoTocaLimiteInferior() {
		if(conejo.getY()>=entorno.alto()+50) {
			return true;
		}
		return false;
	}
	private void conejoAtrasado() {
		if(conejoTocaLimiteInferior()) {
			juegoTerminado=true;
		}
	}
	private void atropellaConejo(Trafico autos) {
		for(int i=0;i<autos.getAutos().length;i++) {
			if(autos.getAutos()[i]!=null) {
				if(colisionConejoAuto(autos.getAutos()[i])) {
					juegoTerminado=true;
				}
			}
		}
	}
	private boolean colisionConejoAuto(Auto auto) {
		return conejo.getX() > auto.getX() - (conejo.getAncho()/0.9) &&
				conejo.getX() < auto.getX() +(conejo.getAncho()/0.9) &&
				conejo.getY() > auto.getY() - (conejo.getAlto()/1.5) &&
				conejo.getY() < auto.getY() + (conejo.getAlto()/1.5);
	}
	
	private void dispararKamehameha() {
		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && recargaKame==false) {
			kamehameha=conejo.dispararKamehameha();
			kamehamehaTiempoActivo();
			kamehamehaTiempoRecarga();
			recargaKame=true;
			centesimasRecargaKame=0;
			segRecargaKame=3;
		}
		if(kamehameha!=null) {
			kamehameha.establecerPos(conejo);
			kamehameha.dibujar(entorno);
			kamehameha.movimientoAtaque();
			destruirAutoConKame(autos1);	
		}
		
	}
	private boolean colisionKamehamehaAuto(Auto auto) {
		return kamehameha.getX() > auto.getX() - (kamehameha.getAncho()) &&
				kamehameha.getX() < auto.getX() +(kamehameha.getAncho()) &&
				kamehameha.getY() > auto.getY() - (kamehameha.getAlto()/2) &&
				kamehameha.getY() < auto.getY() + (kamehameha.getAlto()/1.5);
	}
	private void destruirAutoConKame(Trafico autos) {
		for(int i=0;i<autos.getAutos().length;i++) {
			if(autos.getAutos()[i]!=null && kamehameha!=null) {
				if(colisionKamehamehaAuto(autos.getAutos()[i])) {
					autos.getAutos()[i]=null;
					kamehameha=null;
					puntosTotal+=5;
					
				}
			}
		}
	}
	private void autoTocaLimite(Trafico autos, Carretera carretera) {
		for (int i=0; i<autos.getAutos().length;i++) {
			if(autos.getAutos()[i]!=null) {
				resetearAuto(autos.getAutos()[i], carretera);
			}
		}
	}
	private void resetearAuto(Auto auto, Carretera carretera) {
		if(carretera.getSentido().equals(Sentido.DERECHA) && auto.getX()>=entorno.ancho()+50) {
			auto.setX(-50);
		}
		else if(carretera.getSentido().equals(Sentido.IZQUIERDA) && auto.getX()<=-50) {
			auto.setX(entorno.ancho()+50);
		}
	}
	private void escribirSaltos() {
		entorno.cambiarFont("Arial Black", 20, Color.white);
		entorno.escribirTexto("Saltos: "+ saltos, 150, 20);
	}
	private void escribirPuntajeTotal() {
		entorno.cambiarFont("Arial Black", 20, Color.white);
		entorno.escribirTexto("Puntos: "+ puntosTotal, 20, 20);
	}
	private void kamehamehaTiempoActivo() {
		tiempoActivoKame=new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				kamehameha=null;
				tiempoActivoKame.stop();
				
			}
		});
		tiempoActivoKame.start();
	}
	private void kamehamehaTiempoRecarga() {
		tiempoRecargaKame=new Timer(4000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				recargaKame=false;
				tiempoRecargaKame.stop();
				
			}
		});
		tiempoRecargaKame.start();
	}
	private void escribirTiempoRecargaKame() {
		if(recargaKame) {
			centesimasRecargaKame++;
			if(centesimasRecargaKame>=100) {
				segRecargaKame--;
				centesimasRecargaKame=0;
			}
			entorno.cambiarFont("Arial Black", 20, Color.WHITE);
			entorno.escribirTexto("Recarga Kamehameha: "+ segRecargaKame, 300, 20);
		}
		
	}
	private void dispararRayoConversor() {
		if(entorno.sePresiono('r') && recargaRayo==false) {
			rayoConversorZanahoria=conejo.disparararRayoConversor();
			rayoConversorZanahoria.establecerPosX(conejo);
			rayoConversorZanahoria.establecerPosY(conejo);
			recargaRayo=true;
			rayoConvTiempoActivo();
			rayoConvTiempoRecarga();
			centesimasRecargaRayo=0;
			segRecargaRayo=3;
			
		}
		if(rayoConversorZanahoria!=null) {
			rayoConversorZanahoria.dibujar(entorno);
			rayoConversorZanahoria.movimietoAtaque();
			convertirAutosEnZanahoria(autos1);
		}
	}
	private void rayoConvTiempoActivo() {
		tiempoActivoRayo=new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rayoConversorZanahoria=null;
				tiempoActivoRayo.stop();
				
			}
		});
		tiempoActivoRayo.start();
	}
	private void rayoConvTiempoRecarga() {
		tiempoRecargaRayo=new Timer(4000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				recargaRayo=false;
				tiempoRecargaRayo.stop();
				
			}
		});
		tiempoRecargaRayo.start();
	}
	private boolean colisionRayoConversorAuto(Auto auto) {
		return rayoConversorZanahoria.getX() > auto.getX() - (rayoConversorZanahoria.getAncho()) &&
				rayoConversorZanahoria.getX() < auto.getX() +(rayoConversorZanahoria.getAncho()) &&
				rayoConversorZanahoria.getY() > auto.getY() - (rayoConversorZanahoria.getAlto()/2) &&
				rayoConversorZanahoria.getY() < auto.getY() + (rayoConversorZanahoria.getAlto()/1.5);
	}
	private void convertirAutosEnZanahoria(Trafico autos) {
		for(int i=0;i<autos.getAutos().length;i++) {
			if(autos.getAutos()[i]!=null && rayoConversorZanahoria!=null) {
				if(colisionRayoConversorAuto(autos.getAutos()[i])) {
					Zanahoria zanahoria = new Zanahoria();
					zanahoria.setX(autos.getAutos()[i].getX());
					zanahoria.setY(autos.getAutos()[i].getY());
					zanahorias.zanahorias.add(zanahoria);
					autos.getAutos()[i]=null;
					rayoConversorZanahoria=null;
				}
			}
		}
	}
	public void zanahoriasActivas() {
		for(int i=0;i<zanahorias.zanahorias.size();i++) {
			if(zanahorias.zanahorias.get(i)!=null) {
				zanahorias.zanahorias.get(i).dibujar(entorno);
				if(!ZaWarudo) {
				zanahorias.zanahorias.get(i).avanzar();
				}
			}
		}
	}
	private boolean colisionConejoZanahoria(Zanahoria zanahoria) {
		return conejo.getX() > zanahoria.getX() - (conejo.getAncho()/2) &&
				conejo.getX() < zanahoria.getX() +(conejo.getAncho()/2) &&
				conejo.getY() > zanahoria.getY() - (conejo.getAlto()/2) &&
				conejo.getY() < zanahoria.getY() + (conejo.getAlto()/2);
	}
	private void comerZanahoria() {
		for(int i=0;i<zanahorias.zanahorias.size();i++) {
			if(zanahorias.zanahorias.get(i)!=null) {
				if(colisionConejoZanahoria(zanahorias.zanahorias.get(i))) {
					zanahorias.zanahorias.remove(i);
					puntosTotal+=2;
				}
			}
		}
	}
	private void resetearZanahoria() {
		for(int i=0;i<zanahorias.zanahorias.size();i++) {
			if(zanahorias.zanahorias.get(i)!=null) {
				if(zanahorias.zanahorias.get(i).getY()>=entorno.alto()+50) {
					zanahorias.zanahorias.get(i).setY(-50);
				}
			}
		}
		
	}
	private void escribirTiempoRecargaRayo() {
		if(recargaRayo) {
			centesimasRecargaRayo++;
			if(centesimasRecargaRayo>=100) {
				segRecargaRayo--;
				centesimasRecargaRayo=0;
			}
			entorno.cambiarFont("Arial Black", 20, Color.WHITE);
			entorno.escribirTexto("Recarga Rayo Conversor: "+ segRecargaRayo, 300, 40);
		}
		
	}
	private void tiempoEsperaMovConejo() {
		tiempoEsperaMovConejo=new Timer(200,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				esperaMovConejo=false;
				tiempoEsperaMovConejo.stop();
				
			}
		});
		tiempoEsperaMovConejo.start();
	}
	private void detenerTiempo() {
		if(entorno.sePresiono('z') && ZaWarudo==false) {
			ZaWarudo=true;
			tiempoActivoZaWarudo();
			Herramientas.play("./resources/sonido/zaWarudo.wav");
			this.centesimasActivoZaWarudo=0;
			this.segActivoZaWarudo=10;
		}
	}
	private void tiempoActivoZaWarudo() {
		tiempoActivoZaWarudo=new Timer(11000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZaWarudo=false;
				tiempoActivoZaWarudo.stop();
				
			}
		});
		tiempoActivoZaWarudo.start();
	}
	private void escribirTiempoActivoZaWarudo() {
		if(ZaWarudo) {
			centesimasActivoZaWarudo++;
			if(centesimasActivoZaWarudo>=100) {
				segActivoZaWarudo--;
				centesimasActivoZaWarudo=0;
			}
			entorno.cambiarFont("Arial Black", 20, Color.YELLOW);
			entorno.escribirTexto("Za Warudo: "+ segActivoZaWarudo, 600, 20);
		}
		
	}
}