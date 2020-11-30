package juego;

import javax.sound.sampled.Clip;
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
	
	private Fondo fondo;
	
	private Conejo conejo;
	
	private Carretera carretera1;
	private Carretera carretera2;
	private Carretera carretera3;
	private Carretera carretera4;
	private Carretera carretera5;
	private Carretera carretera6;
	private Carretera carretera7;
	private Carretera carretera8;	

	private Auto[] autos1;
	private Auto[] autos2;
	private Auto[] autos3;
	private Auto[] autos4;
	private Auto[] autos5;
	private Auto[] autos6;
	private Auto[] autos7;
	private Auto[] autos8;
	
	private Via via;
	private Tren tren;
	
	
	private Kamehameha [] kames;
	
	
	private Zanahoria[] zanahorias;
	private RayoConversorZanahoria rayoConversorZanahoria[];
	
	
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
	private boolean musicaReproducida;
	public Juego()
	{
		
		this.entorno = new Entorno(this, TITULO, 800, 647);
		this.fondo = new Fondo(200);
		
		this.conejo = new Conejo();
		this.establecerPosInicialConejo();
		
		kames = new Kamehameha [5];
		zanahorias = new Zanahoria[15];
		rayoConversorZanahoria = new RayoConversorZanahoria[5];
		
		this.carretera1 = new Carretera(1);		
		this.carretera1.establecerTamano(entorno);
		this.carretera1.establecerPos(entorno,-127);
		this.carretera1.establecerSentido(Sentido.DERECHA);			
		this.carretera2 = new Carretera(2);		
		this.carretera2.establecerTamano(entorno);
		this.carretera2.establecerPos(entorno,-57);
		this.carretera2.establecerSentido(Sentido.IZQUIERDA);			
		this.carretera3 = new Carretera(3);		
		this.carretera3.establecerTamano(entorno);
		this.carretera3.establecerPos(entorno,13);
		this.carretera3.establecerSentido(Sentido.DERECHA);		
		this.carretera4 = new Carretera(4);		
		this.carretera4.establecerTamano(entorno);
		this.carretera4.establecerPos(entorno, 83);
		this.carretera4.establecerSentido(Sentido.IZQUIERDA);
		
		this.carretera5 = new Carretera(1);		
		this.carretera5.establecerTamano(entorno);
		this.carretera5.establecerPos(entorno,260);
		this.carretera5.establecerSentido(Sentido.DERECHA);			
		this.carretera6 = new Carretera(2);		
		this.carretera6.establecerTamano(entorno);
		this.carretera6.establecerPos(entorno,330);
		this.carretera6.establecerSentido(Sentido.IZQUIERDA);			
		this.carretera7 = new Carretera(3);		
		this.carretera7.establecerTamano(entorno);
		this.carretera7.establecerPos(entorno,400);
		this.carretera7.establecerSentido(Sentido.DERECHA);		
		this.carretera8 = new Carretera(4);		
		this.carretera8.establecerTamano(entorno);
		this.carretera8.establecerPos(entorno,470);
		this.carretera8.establecerSentido(Sentido.IZQUIERDA);		
		
		this.via = new Via(entorno.ancho()/2,170,entorno.ancho());
		this.tren = new Tren(-300,via.getY(),500,60,5);
		
		this.autos1 = new Auto[5];
		this.crearAutos(autos1);
		this.posicionarAutos(autos1);
		this.autos2 = new Auto[5];
		this.crearAutos(autos2);
		this.posicionarAutos(autos2);
		this.autos3 = new Auto[5];
		this.crearAutos(autos3);
		this.posicionarAutos(autos3);
		this.autos4 = new Auto[5];
		this.crearAutos(autos4);
		this.posicionarAutos(autos4);
		this.autos5 = new Auto[5];
		this.crearAutos(autos5);
		this.posicionarAutos(autos5);
		this.autos6 = new Auto[5];
		this.crearAutos(autos6);
		this.posicionarAutos(autos6);
		this.autos7 = new Auto[5];
		this.crearAutos(autos7);
		this.posicionarAutos(autos7);
		this.autos8 = new Auto[5];
		this.crearAutos(autos8);
		this.posicionarAutos(autos8);
		
		this.juegoTerminado=false;
		this.puntosTotal=0;
		this.saltos=0;
		this.recargaKame=false;
		this.recargaRayo=false;
		this.centesimasRecargaKame=0;
		this.segRecargaKame=0;
		this.centesimasRecargaRayo=0;
		this.segRecargaRayo=0;
		
		this.esperaMovConejo=false;
		this.ZaWarudo=false;
		this.centesimasActivoZaWarudo=0;
		this.segActivoZaWarudo=0;
		this.musicaReproducida=false;
		this.entorno.iniciar();
	}
	
	
	
	public void tick()
	{
		if(!juegoTerminado()) {
			resetearFondo();
			dibujarTodo();
			movimientoConejo();
			conejoAtrasado();
			avanzarTodo();
			atropellaConejo(autos1);
			atropellaConejo(autos2);
			atropellaConejo(autos3);
			atropellaConejo(autos4);
			atropellaConejo(autos5);
			atropellaConejo(autos6);
			atropellaConejo(autos7);
			atropellaConejo(autos8);
			resetearCantAutos();
			resetearCarreteraDesaparece(carretera1);
			resetearCarreteraDesaparece(carretera2);
			resetearCarreteraDesaparece(carretera3);
			resetearCarreteraDesaparece(carretera4);
			resetearCarreteraDesaparece(carretera5);
			resetearCarreteraDesaparece(carretera6);
			resetearCarreteraDesaparece(carretera7);
			resetearCarreteraDesaparece(carretera8);
			dispararKamehameha();
			autoTocaLimite(autos1, carretera1);
			autoTocaLimite(autos2, carretera2);
			autoTocaLimite(autos3, carretera3);
			autoTocaLimite(autos4, carretera4);
			autoTocaLimite(autos5, carretera5);
			autoTocaLimite(autos6, carretera6);
			autoTocaLimite(autos7, carretera7);
			autoTocaLimite(autos8, carretera8);
			escribirSaltos();
			escribirPuntajeTotal();
			escribirTiempoRecargaKame();
			dispararRayoConversor();			
			comerZanahoria();
			resetearZanahoria();
			escribirTiempoRecargaRayo();
			detenerTiempo();
			escribirTiempoActivoZaWarudo();
			destruirAutosConKames();
			convertirAutosEnZanahoria();
			resetearTren();
			resetearVia();
			trenAtropellaConejo();
			trenDetieneKame();
			trenDetieneRayo();
		}
		else {
			juegoTerminado();
		}
	}
	private boolean juegoTerminado() {
		if(juegoTerminado) {
			entorno.cambiarFont("Arial", 120, Color.WHITE);
			entorno.escribirTexto("PERDISTE", entorno.ancho()/8, entorno.alto()/2);
			if(this.musicaReproducida==false) {
				Herramientas.play("./resources/sonido/oof.wav");
				this.musicaReproducida=true;
			}
			return true;
		}
		if(puntosTotal>=100) {
			entorno.cambiarFont("Arial", 120, Color.WHITE);
			entorno.escribirTexto("GANASTE", entorno.ancho()/8, entorno.alto()/2);
			if(this.musicaReproducida==false) {
				Herramientas.play("./resources/sonido/wins.wav");
				this.musicaReproducida=true;
			}
			return true;
		}
		return false;
	}
	private void dibujarTodo() {
		fondo.dibujarFondo(entorno);
		carretera1.dibujar(entorno);
		carretera2.dibujar(entorno);
		carretera3.dibujar(entorno);
		carretera4.dibujar(entorno);
		carretera5.dibujar(entorno);
		carretera6.dibujar(entorno);
		carretera7.dibujar(entorno);
		carretera8.dibujar(entorno);
		zanahoriasActivas();
		via.dibujar(entorno);
		conejo.dibujar(entorno);
		tren.dibujar(entorno);
		this.dibujarAutos(autos1);
		this.dibujarAutos(autos2);
		this.dibujarAutos(autos3);
		this.dibujarAutos(autos4);
		this.dibujarAutos(autos5);
		this.dibujarAutos(autos6);
		this.dibujarAutos(autos7);
		this.dibujarAutos(autos8);
	}
													//Conejo
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
					Herramientas.play("./resources/sonido/jump.wav");
					
				}
			}
			if(entorno.sePresiono('a') || entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
				if(!conejoTocaLimiteIzquierdo()) {
					conejo.moverseIzquierda();
					esperaMovConejo=true;
					tiempoEsperaMovConejo();
					Herramientas.play("./resources/sonido/jump.wav");
				}
			}
			if(entorno.sePresiono('d') || entorno.sePresiono(entorno.TECLA_DERECHA)) {
				if(!conejoTocaLimiteDerecho()) {
					conejo.moverseDerecha();
					esperaMovConejo=true;
					tiempoEsperaMovConejo();
					Herramientas.play("./resources/sonido/jump.wav");
				}
			}
		}
	}	
	private void tiempoEsperaMovConejo() {
		tiempoEsperaMovConejo=new Timer(180,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				esperaMovConejo=false;
				tiempoEsperaMovConejo.stop();				
			}
		});
		tiempoEsperaMovConejo.start();
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
	
	private void avanzarTodo() {
		if(!ZaWarudo) {
		conejo.avanzar();
		fondo.avanzar();
		tren.avanzarPorVia(via);
		carretera1.avanzar();
		carretera2.avanzar();
		carretera3.avanzar();
		carretera4.avanzar();
		carretera5.avanzar();
		carretera6.avanzar();
		carretera7.avanzar();
		carretera8.avanzar();
		this.avanzarAutosPorCarretera(autos1,carretera1, 1);
		this.avanzarAutosPorCarretera(autos2,carretera2, 0.8);
		this.avanzarAutosPorCarretera(autos3,carretera3, 0.4);
		this.avanzarAutosPorCarretera(autos4,carretera4, 0.67);
		this.avanzarAutosPorCarretera(autos5,carretera5, 1);
		this.avanzarAutosPorCarretera(autos6,carretera6, 0.85);
		this.avanzarAutosPorCarretera(autos7,carretera7, 0.5);
		this.avanzarAutosPorCarretera(autos8,carretera8, 0.4);
		this.via.avanzar();
		}
	}
	
	private void resetearFondo() {
		if(this.fondo.getY()>=entorno.alto()-200) {
			this.fondo.setY(200);;
		}
	}
																//Kamehameha
	
	private void dispararKamehameha() {
		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && recargaKame==false) {
			if(kames[4]!=null) {
				for(int i=0;i<kames.length;i++) {
					kames[i]=null;
				}
			}
			for(int i=0;i<kames.length;i++) {
				if(kames[i]==null) {
					kames[i]=conejo.dispararKamehameha();
					break;
				}
			}
			kamehamehaTiempoActivo();
			kamehamehaTiempoRecarga();
			recargaKame=true;
			centesimasRecargaKame=0;
			segRecargaKame=5;//5 original
			Herramientas.play("./resources/sonido/kamehameha.wav");
		}
		for(int j=0;j<kames.length;j++) {
			if(kames[j]!=null) {
				kames[j].dibujar(entorno);
				kames[j].movimientoAtaque(); 				
			}
		}		
	}
	private boolean colisionKamehamehaAuto(Auto auto,Kamehameha kamehameha) {
		return kamehameha.getX() > auto.getX() - (kamehameha.getAncho()*1.5) &&
				kamehameha.getX() < auto.getX() +(kamehameha.getAncho()*1.5) &&
				kamehameha.getY() > auto.getY() - (kamehameha.getAlto()/2) &&
				kamehameha.getY() < auto.getY() + (kamehameha.getAlto()/1.5);
	}
	private void destruirAutoConKame(Auto[] autos) {
		for(int i=0;i<autos.length;i++) {
			for(int j=0;j<kames.length;j++) {
				if(autos[i]!=null && kames[j]!=null) {
					if(colisionKamehamehaAuto(autos[i],kames[j])) {
						autos[i]=null;
						kames[j]=null;
						puntosTotal+=5;					
				}
			}
		  }
		}
	}	
	private void kamehamehaTiempoActivo() {
		tiempoActivoKame=new Timer(2500,new ActionListener() { //2500 original
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<kames.length;i++) {
					if(kames[i]!=null) {
					kames[i]=null;
					}
				}
				tiempoActivoKame.stop();
				
			}
		});
		tiempoActivoKame.start();
	}
	
	private void kamehamehaTiempoRecarga() {
		tiempoRecargaKame=new Timer(6000,new ActionListener() { //6000 original
			
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
															//Rayo Conversor
	private void dispararRayoConversor() {
		if(entorno.sePresiono('r') && recargaRayo==false) {
			if(rayoConversorZanahoria[4]!=null) {
				for(int i=0;i<rayoConversorZanahoria.length;i++) {
					rayoConversorZanahoria[i]=null;
				}
			}
			for(int i=0;i<rayoConversorZanahoria.length;i++) {
				if(rayoConversorZanahoria[i]==null) {
					rayoConversorZanahoria[i]=conejo.disparararRayoConversor();
					break;
				}
			}
			rayoConvTiempoActivo();
			rayoConvTiempoRecarga();
			recargaRayo=true;
			centesimasRecargaRayo=0;
			segRecargaRayo=3;
			Herramientas.play("./resources/sonido/Rayo_Laser.wav");			
		}
		for(int j=0;j<rayoConversorZanahoria.length;j++) {
			if(rayoConversorZanahoria[j]!=null) {
				rayoConversorZanahoria[j].dibujar(entorno);
				rayoConversorZanahoria[j].movimientoAtaque(); 				
			}
		}	
	}
	private void rayoConvTiempoActivo() {
		tiempoActivoRayo=new Timer(2500,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<rayoConversorZanahoria.length;i++) {
					if(rayoConversorZanahoria[i]!=null) {
					rayoConversorZanahoria[i]=null;
					}
				}
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
	private boolean colisionRayoConversorAuto(Auto auto, RayoConversorZanahoria rayoConversorZanahoria) {
		return rayoConversorZanahoria.getX() > auto.getX() - (rayoConversorZanahoria.getAncho()) &&
				rayoConversorZanahoria.getX() < auto.getX() +(rayoConversorZanahoria.getAncho()) &&
				rayoConversorZanahoria.getY() > auto.getY() - (rayoConversorZanahoria.getAlto()/2) &&
				rayoConversorZanahoria.getY() < auto.getY() + (rayoConversorZanahoria.getAlto()/1.5);
	}
	private void convertirAutosEnZanahoria(Auto[] autos) {
		for(int i=0;i<autos.length;i++) {
			for (int j=0;j<rayoConversorZanahoria.length;j++) {
				if(autos[i]!=null && rayoConversorZanahoria[j]!=null) {
					if(colisionRayoConversorAuto(autos[i],rayoConversorZanahoria[j])) {
						Zanahoria zanahoria = new Zanahoria(autos[i].getX(),autos[i].getY());
						this.agregarZanahoria(zanahoria);
						autos[i]=null;
						rayoConversorZanahoria[j]=null;
					}
				}
			}
			
		}
	}
	public void agregarZanahoria(Zanahoria zanahoria) {
		if(zanahorias[14]!=null) {
				for(int j=0;j<zanahorias.length;j++) {
					zanahorias[j]=null;
				}
		}
		for(int i=0;i<zanahorias.length;i++) {
			
			if (zanahorias[i]==null) {
				zanahorias[i]=zanahoria;
				break;
			}			
		}
	}
	public void zanahoriasActivas() {
		for(int i=0;i<zanahorias.length;i++) {
			if(zanahorias[i]!=null) {
				zanahorias[i].dibujar(entorno);
				if(!ZaWarudo) {
				zanahorias[i].avanzar();
				}
			}
		}
	}
	private boolean colisionConejoZanahoria(Zanahoria zanahoria) {
		return conejo.getX() > zanahoria.getX() - (conejo.getAncho()/1.5) &&
				conejo.getX() < zanahoria.getX() +(conejo.getAncho()/1.5) &&
				conejo.getY() > zanahoria.getY() - (conejo.getAlto()/1.5) &&
				conejo.getY() < zanahoria.getY() + (conejo.getAlto()/1.5);
	}	
	private void comerZanahoria() {
		for(int i=0;i<zanahorias.length;i++) {
			if(zanahorias[i]!=null) {
				if(colisionConejoZanahoria(zanahorias[i])) {
					zanahorias[i]=null;
					puntosTotal+=2;
					Herramientas.play("./resources/sonido/zanahoria.wav");
				}
			}
		}
	}
	private void resetearZanahoria() {
		for(int i=0;i<zanahorias.length;i++) {
			if(zanahorias[i]!=null) {
				if(zanahorias[i].getY()>=entorno.alto()+50) {
					zanahorias[i].setY(-50);
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
	
														//Za Warudo
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
													
													//Autos
	public void crearAutos(Auto autos[]) {
		for(int i=0;i<autos.length;i++) {
			Auto auto = new Auto();
			autos[i] = auto;
		}
	}
	public void posicionarAutos(Auto autos[]) {
		int posX=0;
		for(int i=0;i<autos.length;i++) {
			if(autos[i]!=null) {
				autos[i].setX(posX);
				posX+=200;
			}
		}
	}
	public void avanzarAutosPorCarretera(Auto autos[],Carretera carretera,double velocidad) {
		for(int i=0;i<autos.length;i++) {
			if(autos[i]!=null) {
				autos[i].avanzarPorCarretera(carretera, velocidad);
			}
		}
	}
	public void dibujarAutos(Auto autos[]) {
		for(int i=0;i<autos.length;i++) {
			if(autos[i]!=null) {
				autos[i].dibujar(entorno);
			}
		}
	}
	private void destruirAutosConKames() {
		destruirAutoConKame(autos1);
		destruirAutoConKame(autos2);	
		destruirAutoConKame(autos3);	
		destruirAutoConKame(autos4);	
		destruirAutoConKame(autos5);	
		destruirAutoConKame(autos6);	
		destruirAutoConKame(autos7);	
		destruirAutoConKame(autos8);
	}
	private void convertirAutosEnZanahoria() {
		convertirAutosEnZanahoria(autos1);
		convertirAutosEnZanahoria(autos2);
		convertirAutosEnZanahoria(autos3);
		convertirAutosEnZanahoria(autos4);
		convertirAutosEnZanahoria(autos5);
		convertirAutosEnZanahoria(autos6);
		convertirAutosEnZanahoria(autos7);
		convertirAutosEnZanahoria(autos8);
	}
	private void autoTocaLimite(Auto[] autos, Carretera carretera) {
		for (int i=0; i<autos.length;i++) {
			if(autos[i]!=null) {
				resetearAuto(autos[i], carretera);
			}
		}
	}
	private void resetearAuto(Auto auto, Carretera carretera) {
		if(carretera.getSentido().equals(Sentido.DERECHA) && auto.getX()>=entorno.ancho()+50) {
			auto.setX(-100);
		}
		else if(carretera.getSentido().equals(Sentido.IZQUIERDA) && auto.getX()<=-50) {
			auto.setX(entorno.ancho()+100);
		}
	}
	private void atropellaConejo(Auto[] autos) {
		for(int i=0;i<autos.length;i++) {
			if(autos[i]!=null) {
				if(colisionConejoAuto(autos[i])) {
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
																//Carreteras
	
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
	private void resetearCantAutos() {
		if(verificarDesapareceCarretera(carretera1)) {
			this.crearAutos(autos1);
			this.posicionarAutos(autos1);			
		}
		if(verificarDesapareceCarretera(carretera2)) {
			this.crearAutos(autos2);
			this.posicionarAutos(autos2);			
		}
		if(verificarDesapareceCarretera(carretera3)) {
			this.crearAutos(autos3);
			this.posicionarAutos(autos3);			
		}
		if(verificarDesapareceCarretera(carretera4)) {
			this.crearAutos(autos4);
			this.posicionarAutos(autos4);			
		}
		if(verificarDesapareceCarretera(carretera5)) {
			this.crearAutos(autos5);
			this.posicionarAutos(autos5);			
		}
		if(verificarDesapareceCarretera(carretera6)) {
			this.crearAutos(autos6);
			this.posicionarAutos(autos6);			
		}
		if(verificarDesapareceCarretera(carretera7)) {
			this.crearAutos(autos7);
			this.posicionarAutos(autos7);			
		}
		if(verificarDesapareceCarretera(carretera8)) {
			this.crearAutos(autos8);
			this.posicionarAutos(autos8);			
		}
	}
	
	private void resetearTren() {
		if(tren.getX()>=entorno.ancho()+5500) {
			tren.setX(-300);
		}
		if(tren.getY()>=entorno.alto()+50) {
			tren.setY(-100);
		}
	}
	private void resetearVia() {
		if(via.getY()>=entorno.alto()+50) {
			via.setY(-50);
		}
	}
	
	
														//Puntajes
	private void escribirSaltos() {
		entorno.cambiarFont("Arial Black", 20, Color.white);
		entorno.escribirTexto("Saltos: "+ saltos, 150, 20);
	}
	private void escribirPuntajeTotal() {
		entorno.cambiarFont("Arial Black", 20, Color.white);
		entorno.escribirTexto("Puntos: "+ puntosTotal, 20, 20);
	}
	private boolean colisionConejoTren() {
		return tren.getX() > conejo.getX() - (tren.getAncho()/2) &&
				tren.getX() < conejo.getX() +(tren.getAncho()/2) &&
				tren.getY() > conejo.getY() - (tren.getAlto()/2) &&
				tren.getY() < conejo.getY() + (tren.getAlto()/2);
	}
	private void trenAtropellaConejo() {
		if(colisionConejoTren()) {
			juegoTerminado=true;
		}
	}
	private boolean colisionKamehamehaTren(Kamehameha kamehameha) {
		return kamehameha.getX() > tren.getX() - (kamehameha.getAncho()*10) &&
				kamehameha.getX() < tren.getX() +(kamehameha.getAncho()*10) &&
				kamehameha.getY() > tren.getY() - (kamehameha.getAlto()) &&
				kamehameha.getY() < tren.getY() + (kamehameha.getAlto());
	}
	private void trenDetieneKame() {
		for(int i=0;i<kames.length;i++) {
			if(kames[i]!=null) {
				if(colisionKamehamehaTren(kames[i])) {
					kames[i]=null;
				}
			}
		}
	}
	private boolean colisionRayoTren(RayoConversorZanahoria rayoConversorZanahoria) {
		return rayoConversorZanahoria.getX() > tren.getX() - (rayoConversorZanahoria.getAncho()*10) &&
				rayoConversorZanahoria.getX() < tren.getX() +(rayoConversorZanahoria.getAncho()*10) &&
				rayoConversorZanahoria.getY() > tren.getY() - (rayoConversorZanahoria.getAlto()) &&
				rayoConversorZanahoria.getY() < tren.getY() + (rayoConversorZanahoria.getAlto());
	}
	private void trenDetieneRayo() {
		for(int i=0;i<rayoConversorZanahoria.length;i++) {
			if(rayoConversorZanahoria[i]!=null) {
				if(colisionRayoTren(rayoConversorZanahoria[i])) {
					rayoConversorZanahoria[i]=null;
				}
			}
		}
	}
}
