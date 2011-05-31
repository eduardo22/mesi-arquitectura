package visual;
import processing.core.*;
public class VisualPrincipal{
	private Principal parent;
	private final int colorFondo = 0x2B3F60, colorEstado = 0x6f88c3, colorAceptacion = 0xa46834,
	colorProc = 0xD9C777, colorBus = 0xB4B7C1;
	private int cacheDesde = -1;
	private int posAnimado;
	private int pasoAnimacion;
	final int anchoProc = 150, altoProc = 120, altoCache = 70, altoMP = 150, anchoBus = 12;
	VisualPrincipal(Principal parent){
		this.parent = parent;
		parent.background(colorFondo);
	}
	private void fillInt(int color){
		parent.fill(parent.red(color), parent.green(color), parent.blue(color));
	}
	public void inicializarAnimacion(int cacheDesde){
		this.cacheDesde = cacheDesde;
		posAnimado = 0;
		pasoAnimacion = 0;
	}
	public void plot(){
		dibujarProcesador("Procesador 1", parent.width/6, parent.height/5);
		dibujarProcesador("Procesador 2", parent.width/2, parent.height/5);
		dibujarProcesador("Procesador 3", 5*parent.width/6, parent.height/5);
		dibujarBuses();
		if(cacheDesde>=0)dibujarAnimado();
		dibujarCache(1, parent.width/6, 2*parent.height/5);
		dibujarCache(2, parent.width/2, 2*parent.height/5);
		dibujarCache(3, 5*parent.width/6, 2*parent.height/5);
		dibujarMemoriaPrincipal(parent.width/2, 4*parent.height/5);
	}
	private void dibujarAnimado(){
		parent.fill(255);
		if(pasoAnimacion==0){
			if(cacheDesde==0){
				int pos1 = 3*parent.height/5 - parent.height/10 - anchoBus/2-(parent.height/5+altoProc/2)+anchoBus/2-4;
				int pos2 = pos1+parent.width/2-anchoProc/4-anchoBus/2-(parent.width/6-anchoProc/4-anchoBus/2+anchoBus)+anchoBus+anchoBus/4-3;
				int pos3 = pos2+3*parent.height/5 - parent.height/10 - (parent.height/5+altoProc/2)+anchoBus/2-4;
				int pos4 = pos1-(parent.width/6-anchoProc/4-anchoBus/2)+5*parent.width/6-anchoProc/4-anchoBus/2;
				int pos5 = pos4+3*parent.height/5 - parent.height/10 - (parent.height/5+altoProc/2)+anchoBus/2-4;
				if(posAnimado<=pos1)parent.rect(parent.width/6-anchoProc/4-anchoBus/2+2, parent.height/5+altoProc/2+posAnimado, anchoBus-4, anchoBus-4);
				else if(posAnimado<=pos2)parent.rect(parent.width/6-anchoProc/4-anchoBus/2+2-pos1+posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
				else if(posAnimado<=pos3){
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2+pos2-posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2-pos2+posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
					parent.rect(parent.width/6-anchoProc/4-anchoBus/2+2-pos1+posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
				}
				else if(posAnimado<=pos4)parent.rect(parent.width/6-anchoProc/4-anchoBus/2+2-pos1+posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
				else if(posAnimado<=pos5)parent.rect(5*parent.width/6-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2+pos4-posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
				else {
					pasoAnimacion++;
					posAnimado = 0;
				}
			}
			if(cacheDesde==1){
				int pos1 = 3*parent.height/5 - parent.height/10 - anchoBus/2-(parent.height/5+altoProc/2)+anchoBus/2-4;
				int pos2 = pos1+3*parent.height/5 - parent.height/10 - (parent.height/5+altoProc/2)+anchoBus/2-4;
				int pos3 = pos1-(parent.width/2-anchoProc/4-anchoBus/2)+5*parent.width/6-anchoProc/4-anchoBus/2;
				int pos4 = pos3+pos1+anchoBus;
				if(posAnimado<=pos1)parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2, parent.height/5+altoProc/2+posAnimado, anchoBus-4, anchoBus-4);
				else if(posAnimado<=pos2){
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2-pos1+posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2-pos1+posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2+pos1-posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
				}
				else if(posAnimado<=pos3){
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2-pos1+posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2+pos1-posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
				}
				else if(posAnimado<=pos4){
					parent.rect(parent.width/6-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2+pos3-posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
					parent.rect(5*parent.width/6-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2+pos3-posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
				}
				else {
					posAnimado = 0;
					pasoAnimacion++;
				}
			}
			if(cacheDesde==2){
				int pos1 = 3*parent.height/5 - parent.height/10 - anchoBus/2-(parent.height/5+altoProc/2)+anchoBus/2-4;
				int pos2 = pos1+parent.width/2-anchoProc/4-anchoBus/2-(parent.width/6-anchoProc/4-anchoBus/2+anchoBus)+anchoBus+anchoBus/4-3;
				int pos3 = pos2+3*parent.height/5 - parent.height/10 - (parent.height/5+altoProc/2)+anchoBus/2-4;
				int pos4 = pos1-(parent.width/6-anchoProc/4-anchoBus/2)+5*parent.width/6-anchoProc/4-anchoBus/2;
				int pos5 = pos4+3*parent.height/5 - parent.height/10 - (parent.height/5+altoProc/2)+anchoBus/2-4;
				if(posAnimado<=pos1)parent.rect(5*parent.width/6-anchoProc/4-anchoBus/2+2, parent.height/5+altoProc/2+posAnimado, anchoBus-4, anchoBus-4);
				else if(posAnimado<=pos2)parent.rect(5*parent.width/6-anchoProc/4-anchoBus/2+2+pos1-posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
				else if(posAnimado<=pos3){
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2+pos2-posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2-pos2+posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
					parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2+pos2-posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
				}
				else if(posAnimado<=pos4)parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2+pos2-posAnimado, 3*parent.height/5 - parent.height/10 - anchoBus/2+2, anchoBus-4, anchoBus-4);
				else if(posAnimado<=pos5)parent.rect(parent.width/6-anchoProc/4-anchoBus/2+2, 3*parent.height/5 - parent.height/10 - anchoBus/2+pos4-posAnimado+anchoBus/2-4, anchoBus-4, anchoBus-4);
				else {
					pasoAnimacion++;
					posAnimado = 0;
				}
			}
		}
		else if(pasoAnimacion==1){
			int pos1 = 4*parent.height/5-anchoProc/2-(3*parent.height/5 + anchoBus/2)+anchoBus-2;
			int pos2 = pos1+3*parent.height/5-anchoBus/2 - (parent.height/5+altoProc/2)+anchoBus-4;
			int pos3 = pos1+parent.width/2-anchoProc/4-anchoBus/2-(parent.width/6+anchoProc/4-anchoBus/2);
			int pos4 = pos1-(parent.width/2+anchoProc/4-anchoBus/2)+5*parent.width/6+anchoProc/4-anchoBus/2;
			int pos5 = pos3+3*parent.height/5-anchoBus/2+2-(parent.height/5+altoProc/2)+anchoBus/2-4;
			int pos6 = pos4+3*parent.height/5-anchoBus/2+2-(parent.height/5+altoProc/2)+anchoBus/2-4;
			if(posAnimado<=pos1)parent.rect(parent.width/2+anchoProc/4-anchoBus/2+2, 4*parent.height/5-anchoProc/2-posAnimado, anchoBus-4, anchoBus-4);
			else if(posAnimado<=pos2){
				parent.rect(parent.width/2+anchoProc/4-anchoBus/2+2, 3*parent.height/5-anchoBus/2-posAnimado+pos1, anchoBus-4, anchoBus-4);
				parent.rect(parent.width/2+anchoProc/4-anchoBus/2+2-pos1+posAnimado, 3*parent.height/5-anchoBus/2+2, anchoBus-4, anchoBus-4);
				parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2+pos1-posAnimado, 3*parent.height/5-anchoBus/2+2, anchoBus-4, anchoBus-4);
			}
			else if(posAnimado<=pos3){
				parent.rect(parent.width/2+anchoProc/4-anchoBus/2+2-pos1+posAnimado, 3*parent.height/5-anchoBus/2+2, anchoBus-4, anchoBus-4);
				parent.rect(parent.width/2-anchoProc/4-anchoBus/2+2+pos1-posAnimado, 3*parent.height/5-anchoBus/2+2, anchoBus-4, anchoBus-4);
			}
			else if(posAnimado<=pos4){
				parent.rect(parent.width/2+anchoProc/4-anchoBus/2+2-pos1+posAnimado, 3*parent.height/5-anchoBus/2+2, anchoBus-4, anchoBus-4);
				parent.rect(parent.width/6+anchoProc/4-anchoBus/2+2, 3*parent.height/5-anchoBus/2+2+pos3-posAnimado, anchoBus-4, anchoBus-4);
			}
			else if(posAnimado<=pos5){
				parent.rect(parent.width/6+anchoProc/4-anchoBus/2+2, 3*parent.height/5-anchoBus/2+2+pos3-posAnimado, anchoBus-4, anchoBus-4);
				parent.rect(5*parent.width/6+anchoProc/4-anchoBus/2+2, 3*parent.height/5-anchoBus/2+2+pos4-posAnimado, anchoBus-4, anchoBus-4);
			}
			else if(posAnimado<=pos6)parent.rect(5*parent.width/6+anchoProc/4-anchoBus/2+2, 3*parent.height/5-anchoBus/2+2+pos4-posAnimado, anchoBus-4, anchoBus-4);
			else {
				pasoAnimacion=-1;
				parent.estaAnimando=false;
				cacheDesde=-1;
			}
		}
		posAnimado+=4;
	}
	private void dibujarBuses(){
		fillInt(colorEstado);
		parent.rect(parent.width/6-anchoProc/4-anchoBus/2, parent.height/5+altoProc/2, anchoBus, 2*parent.height/5-altoCache/2-(parent.height/5+altoProc/2));
		parent.rect(parent.width/2-anchoProc/4-anchoBus/2, parent.height/5+altoProc/2, anchoBus, 2*parent.height/5-altoCache/2-(parent.height/5+altoProc/2));
		parent.rect(5*parent.width/6-anchoProc/4-anchoBus/2, parent.height/5+altoProc/2, anchoBus, 2*parent.height/5-altoCache/2-(parent.height/5+altoProc/2));
		fillInt(colorBus);
		parent.rect(parent.width/6+anchoProc/4-anchoBus/2, parent.height/5+altoProc/2, anchoBus, 2*parent.height/5-altoCache/2-(parent.height/5+altoProc/2));
		parent.rect(parent.width/2+anchoProc/4-anchoBus/2, parent.height/5+altoProc/2, anchoBus, 2*parent.height/5-altoCache/2-(parent.height/5+altoProc/2));
		parent.rect(5*parent.width/6+anchoProc/4-anchoBus/2, parent.height/5+altoProc/2, anchoBus, 2*parent.height/5-altoCache/2-(parent.height/5+altoProc/2));
		fillInt(colorEstado);
		parent.beginShape();
		parent.vertex(-1, 3*parent.height/5 - parent.height/10 - anchoBus/2);
		parent.vertex(parent.width/6-anchoProc/4-anchoBus/2, 3*parent.height/5 - parent.height/10 - anchoBus/2);
		parent.vertex(parent.width/6-anchoProc/4-anchoBus/2, 2*parent.height/5+altoCache/2);
		parent.vertex(parent.width/6-anchoProc/4-anchoBus/2+anchoBus, 2*parent.height/5+altoCache/2);
		parent.vertex(parent.width/6-anchoProc/4-anchoBus/2+anchoBus, 3*parent.height/5 - parent.height/10 - anchoBus/2);
		parent.vertex(parent.width/2-anchoProc/4-anchoBus/2, 3*parent.height/5 - parent.height/10 - anchoBus/2);
		parent.vertex(parent.width/2-anchoProc/4-anchoBus/2, 2*parent.height/5+altoCache/2);
		parent.vertex(parent.width/2-anchoProc/4-anchoBus/2+anchoBus, 2*parent.height/5+altoCache/2);
		parent.vertex(parent.width/2-anchoProc/4-anchoBus/2+anchoBus, 3*parent.height/5 - parent.height/10 - anchoBus/2);
		parent.vertex(5*parent.width/6-anchoProc/4-anchoBus/2, 3*parent.height/5 - parent.height/10 - anchoBus/2);
		parent.vertex(5*parent.width/6-anchoProc/4-anchoBus/2, 2*parent.height/5+altoCache/2);
		parent.vertex(5*parent.width/6-anchoProc/4-anchoBus/2+anchoBus, 2*parent.height/5+altoCache/2);
		parent.vertex(5*parent.width/6-anchoProc/4-anchoBus/2+anchoBus, 3*parent.height/5 - parent.height/10 - anchoBus/2);
		parent.vertex(parent.width+1, 3*parent.height/5 - parent.height/10 - anchoBus/2);
		parent.vertex(parent.width+1, 3*parent.height/5 - parent.height/10 + anchoBus/2);		
		parent.vertex(parent.width/2-anchoProc/4+anchoBus/2, 3*parent.height/5 - parent.height/10 + anchoBus/2);
		parent.vertex(parent.width/2-anchoProc/4+anchoBus/2, 4*parent.height/5-anchoProc/2);
		parent.vertex(parent.width/2-anchoProc/4-anchoBus/2, 4*parent.height/5-anchoProc/2);
		parent.vertex(parent.width/2-anchoProc/4-anchoBus/2, 3*parent.height/5 - parent.height/10 + anchoBus/2);		
		parent.vertex(-1, 3*parent.height/5 - parent.height/10 + anchoBus/2);
		parent.endShape();
		fillInt(colorBus);
		parent.beginShape();
		parent.vertex(-1, 3*parent.height/5 - anchoBus/2);
		parent.vertex(parent.width/6+anchoProc/4-anchoBus/2, 3*parent.height/5 - anchoBus/2);
		parent.vertex(parent.width/6+anchoProc/4-anchoBus/2, 2*parent.height/5+altoCache/2);
		parent.vertex(parent.width/6+anchoProc/4-anchoBus/2+anchoBus, 2*parent.height/5+altoCache/2);
		parent.vertex(parent.width/6+anchoProc/4-anchoBus/2+anchoBus, 3*parent.height/5 - anchoBus/2);
		parent.vertex(parent.width/2+anchoProc/4-anchoBus/2, 3*parent.height/5 - anchoBus/2);
		parent.vertex(parent.width/2+anchoProc/4-anchoBus/2, 2*parent.height/5+altoCache/2);
		parent.vertex(parent.width/2+anchoProc/4-anchoBus/2+anchoBus, 2*parent.height/5+altoCache/2);
		parent.vertex(parent.width/2+anchoProc/4-anchoBus/2+anchoBus, 3*parent.height/5 - anchoBus/2);
		parent.vertex(5*parent.width/6+anchoProc/4-anchoBus/2, 3*parent.height/5 - anchoBus/2);
		parent.vertex(5*parent.width/6+anchoProc/4-anchoBus/2, 2*parent.height/5+altoCache/2);
		parent.vertex(5*parent.width/6+anchoProc/4-anchoBus/2+anchoBus, 2*parent.height/5+altoCache/2);
		parent.vertex(5*parent.width/6+anchoProc/4-anchoBus/2+anchoBus, 3*parent.height/5 - anchoBus/2);
		parent.vertex(parent.width+1, 3*parent.height/5 - anchoBus/2);
		parent.vertex(parent.width+1, 3*parent.height/5 + anchoBus/2);		
		parent.vertex(parent.width/2+anchoProc/4+anchoBus/2, 3*parent.height/5 + anchoBus/2);
		parent.vertex(parent.width/2+anchoProc/4+anchoBus/2, 4*parent.height/5-anchoProc/2);
		parent.vertex(parent.width/2+anchoProc/4-anchoBus/2, 4*parent.height/5-anchoProc/2);
		parent.vertex(parent.width/2+anchoProc/4-anchoBus/2, 3*parent.height/5 + anchoBus/2);		
		parent.vertex(-1, 3*parent.height/5 + anchoBus/2);
		parent.endShape();
	}
	private void dibujarMemoriaPrincipal(int x, int y){
		fillInt(colorProc);
		parent.rect(x-anchoProc/2, y-altoMP/2, anchoProc, altoMP);
		parent.rect(x-anchoProc/2, y-altoMP/2, anchoProc, (float)(altoProc*0.25));
		parent.textSize(18);
		fillInt(0);
		parent.text("Memoria Princ.", x, y-altoMP/2+(float)(altoProc*0.25) - parent.getFontMetrics(parent.getFont()).getHeight()/2);
		fillInt(colorAceptacion);
		parent.rect(x-anchoProc/2+4, y-altoMP/2+(float)(altoProc*0.25)+3, (float)(anchoProc*0.75)-8, (altoMP-4-(float)(altoProc*0.25))/4-2);
		parent.rect(x-anchoProc/2+4, y-altoMP/2+(float)(altoProc*0.25)+2+(altoMP-4-(float)(altoProc*0.25))/4+1, (float)(anchoProc*0.75)-8, (altoMP-4-(float)(altoProc*0.25))/4-2);
		parent.rect(x-anchoProc/2+4, y-altoMP/2+(float)(altoProc*0.25)+2+2*(altoMP-4-(float)(altoProc*0.25))/4+1, (float)(anchoProc*0.75)-8, (altoMP-4-(float)(altoProc*0.25))/4-2);
		parent.rect(x-anchoProc/2+4, y-altoMP/2+(float)(altoProc*0.25)+2+3*(altoMP-4-(float)(altoProc*0.25))/4+1, (float)(anchoProc*0.75)-8, (altoMP-4-(float)(altoProc*0.25))/4-2);		
		parent.rect(x+((float)(anchoProc*0.25)), y-altoMP/2+(float)(altoProc*0.25)+3, (float)(anchoProc*0.25)-4, (altoMP-4-(float)(altoProc*0.25))/4-2);
		parent.rect(x+((float)(anchoProc*0.25)), y-altoMP/2+(float)(altoProc*0.25)+2+(altoMP-4-(float)(altoProc*0.25))/4+1, (float)(anchoProc*0.25)-4, (altoMP-4-(float)(altoProc*0.25))/4-2);
		parent.rect(x+((float)(anchoProc*0.25)), y-altoMP/2+(float)(altoProc*0.25)+2+2*(altoMP-4-(float)(altoProc*0.25))/4+1, (float)(anchoProc*0.25)-4, (altoMP-4-(float)(altoProc*0.25))/4-2);
		parent.rect(x+((float)(anchoProc*0.25)), y-altoMP/2+(float)(altoProc*0.25)+2+3*(altoMP-4-(float)(altoProc*0.25))/4+1, (float)(anchoProc*0.25)-4, (altoMP-4-(float)(altoProc*0.25))/4-2);		
		fillInt(colorProc);
		parent.textSize(14);
		parent.text("0x0", x-anchoProc/2+((float)(anchoProc*0.75)-4)/2, y-altoMP/2+(float)(altoProc*0.25)+3+(altoMP-4-(float)(altoProc*0.25))/4-2-parent.getFontMetrics(parent.getFont()).getHeight()/2);
		parent.text("0x1", x-anchoProc/2+((float)(anchoProc*0.75)-4)/2, y-altoMP/2+(float)(altoProc*0.25)+2+(altoMP-4-(float)(altoProc*0.25))/4+1+(altoMP-4-(float)(altoProc*0.25))/4-2-parent.getFontMetrics(parent.getFont()).getHeight()/2);
		parent.text("0x2", x-anchoProc/2+((float)(anchoProc*0.75)-4)/2, y-altoMP/2+(float)(altoProc*0.25)+2+2*(altoMP-4-(float)(altoProc*0.25))/4+1+(altoMP-4-(float)(altoProc*0.25))/4-2-parent.getFontMetrics(parent.getFont()).getHeight()/2);
		parent.text("0x3", x-anchoProc/2+((float)(anchoProc*0.75)-4)/2, y-altoMP/2+(float)(altoProc*0.25)+2+3*(altoMP-4-(float)(altoProc*0.25))/4+1+(altoMP-4-(float)(altoProc*0.25))/4-2-parent.getFontMetrics(parent.getFont()).getHeight()/2);		
		parent.text(parent.mesi.memoria.lineas.get(0).Estado, x+((float)(anchoProc*0.25))+(float)((anchoProc*0.25)-4)/2, y-altoMP/2+(float)(altoProc*0.25)+3+(altoMP-4-(float)(altoProc*0.25))/4-2-parent.getFontMetrics(parent.getFont()).getHeight()/2);
		parent.text(parent.mesi.memoria.lineas.get(0).Estado, x+((float)(anchoProc*0.25))+(float)((anchoProc*0.25)-4)/2, y-altoMP/2+(float)(altoProc*0.25)+2+(altoMP-4-(float)(altoProc*0.25))/4+1+(altoMP-4-(float)(altoProc*0.25))/4-2-parent.getFontMetrics(parent.getFont()).getHeight()/2);
		parent.text(parent.mesi.memoria.lineas.get(0).Estado, x+((float)(anchoProc*0.25))+(float)((anchoProc*0.25)-4)/2, y-altoMP/2+(float)(altoProc*0.25)+2+2*(altoMP-4-(float)(altoProc*0.25))/4+1+(altoMP-4-(float)(altoProc*0.25))/4-2-parent.getFontMetrics(parent.getFont()).getHeight()/2);
		parent.text(parent.mesi.memoria.lineas.get(0).Estado, x+((float)(anchoProc*0.25))+(float)((anchoProc*0.25)-4)/2, y-altoMP/2+(float)(altoProc*0.25)+2+3*(altoMP-4-(float)(altoProc*0.25))/4+1+(altoMP-4-(float)(altoProc*0.25))/4-2-parent.getFontMetrics(parent.getFont()).getHeight()/2);
	}
	private void dibujarCache(int cache, int x, int y){
		fillInt(colorProc);
		parent.rect(x-anchoProc/2, y-altoCache/2, anchoProc, altoCache);
		parent.rect(x-anchoProc/2, y-altoCache/2, anchoProc, (float)(altoProc*0.25));
		parent.textSize(18);
		fillInt(0);
		parent.text("Cache " + cache, x, y-altoCache/2+(float)(altoProc*0.25) - parent.getFontMetrics(parent.getFont()).getHeight()/2);
		fillInt(colorProc);
		parent.rect(x-anchoProc/2, y-altoCache/2+(float)(altoProc*0.25), (float)(anchoProc*0.2), (altoCache-(float)(altoProc*0.25))/2);
		parent.rect(x-anchoProc/2+(float)(anchoProc*0.2), y-altoCache/2+(float)(altoProc*0.25), (float)(anchoProc*0.3), (altoCache-(float)(altoProc*0.25))/2);
		parent.rect(x-anchoProc/2+(float)(anchoProc*0.5), y-altoCache/2+(float)(altoProc*0.25), (float)(anchoProc*0.25), (altoCache-(float)(altoProc*0.25))/2);
		parent.rect(x-anchoProc/2+(float)(anchoProc*0.75), y-altoCache/2+(float)(altoProc*0.25), (float)(anchoProc*0.25), (altoCache-(float)(altoProc*0.25))/2);
		parent.rect(x-anchoProc/2, y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2,(float)(anchoProc*0.2), (altoCache-(float)(altoProc*0.25))/2);
		parent.rect(x-anchoProc/2+(float)(anchoProc*0.2), y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2, (float)(anchoProc*0.3), (altoCache-(float)(altoProc*0.25))/2);
		parent.rect(x-anchoProc/2+(float)(anchoProc*0.5), y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2, (float)(anchoProc*0.25), (altoCache-(float)(altoProc*0.25))/2);
		parent.rect(x-anchoProc/2+(float)(anchoProc*0.75), y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2, (float)(anchoProc*0.25), (altoCache-(float)(altoProc*0.25))/2);
		parent.textSize(14);
		fillInt(colorFondo);
		parent.text(parent.mesi.procesadores.get(cache-1).cache.lineas.get(0).Estado, x-anchoProc/2+((float)(anchoProc*0.2))/2, y-altoCache/2+(float)(altoProc*0.25)+parent.getFontMetrics(parent.getFont()).getHeight());
		parent.text(parent.mesi.procesadores.get(cache-1).cache.lineas.get(0).direccionMemoriaPrinciapal, x-anchoProc/2+((float)(anchoProc*0.3))/2+(float)(anchoProc*0.2), y-altoCache/2+(float)(altoProc*0.25)+parent.getFontMetrics(parent.getFont()).getHeight());
		parent.text(parent.mesi.procesadores.get(cache-1).cache.lineas.get(0).aciertos+"", x-anchoProc/2+((float)(anchoProc*0.25))/2+(float)(anchoProc*0.5), y-altoCache/2+(float)(altoProc*0.25)+parent.getFontMetrics(parent.getFont()).getHeight());
		parent.text(parent.mesi.procesadores.get(cache-1).cache.lineas.get(0).fallos+"", x-anchoProc/2+((float)(anchoProc*0.25))/2+(float)(anchoProc*0.75), y-altoCache/2+(float)(altoProc*0.25)+parent.getFontMetrics(parent.getFont()).getHeight());
		parent.text(parent.mesi.procesadores.get(cache-1).cache.lineas.get(1).Estado, x-anchoProc/2+((float)(anchoProc*0.2))/2, y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2+parent.getFontMetrics(parent.getFont()).getHeight());
		parent.text(parent.mesi.procesadores.get(cache-1).cache.lineas.get(1).direccionMemoriaPrinciapal, x-anchoProc/2+((float)(anchoProc*0.3))/2+(float)(anchoProc*0.2),y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2+parent.getFontMetrics(parent.getFont()).getHeight());
		parent.text(parent.mesi.procesadores.get(cache-1).cache.lineas.get(1).aciertos+"", x-anchoProc/2+((float)(anchoProc*0.25))/2+(float)(anchoProc*0.5), y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2+parent.getFontMetrics(parent.getFont()).getHeight());
		parent.text(parent.mesi.procesadores.get(cache-1).cache.lineas.get(1).fallos+"", x-anchoProc/2+((float)(anchoProc*0.25))/2+(float)(anchoProc*0.75), y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2+parent.getFontMetrics(parent.getFont()).getHeight());		
	}
	private void dibujarProcesador(String nombre, float x, float y){
		parent.textAlign(PApplet.CENTER);
		parent.textSize(18);
		parent.stroke(0);
		fillInt(colorProc);
		parent.rect(x-anchoProc/2, y-altoProc/2, anchoProc, altoProc);
		parent.rect(x-anchoProc/2, y-altoProc/2, anchoProc, (float)(altoProc*0.25));
		parent.fill(0);
		parent.text(nombre, x, y-altoProc/2 + (float)(altoProc*0.25) - parent.getFontMetrics(parent.getFont()).getHeight()/2);
		fillInt(colorAceptacion);
		parent.rect(x-anchoProc/2+3, y-(float)(altoProc*0.25)+4, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		parent.rect(x-anchoProc/2+3, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		parent.rect(x-anchoProc/2+3, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		parent.rect(x-anchoProc/2+3, y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		parent.rect(x+3, y-(float)(altoProc*0.25)+4, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		parent.rect(x+3, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		parent.rect(x+3, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		parent.rect(x+3, y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		fillInt(colorProc);
		parent.textSize(12);
		parent.text("Leer 0x0", x-anchoProc/4, y-(float)(altoProc*0.25)+4+((float)(altoProc*0.75)/4-4)/2+parent.getFontMetrics(parent.getFont()).getHeight()/3);
		parent.text("Leer 0x1", x-anchoProc/4, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2+((float)(altoProc*0.75)/4-4)/2+parent.getFontMetrics(parent.getFont()).getHeight()/3);
		parent.text("Leer 0x2", x-anchoProc/4, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1+((float)(altoProc*0.75)/4-4)/2+parent.getFontMetrics(parent.getFont()).getHeight()/3);
		parent.text("Leer 0x3", x-anchoProc/4, y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1+((float)(altoProc*0.75)/4-4)/2+parent.getFontMetrics(parent.getFont()).getHeight()/3);
		parent.text("Escr. 0x0", x+anchoProc/4, y-(float)(altoProc*0.25)+4+((float)(altoProc*0.75)/4-4)/2+parent.getFontMetrics(parent.getFont()).getHeight()/3);
		parent.text("Escr. 0x1", x+anchoProc/4, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2+((float)(altoProc*0.75)/4-4)/2+parent.getFontMetrics(parent.getFont()).getHeight()/3);
		parent.text("Escr. 0x2", x+anchoProc/4, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1+((float)(altoProc*0.75)/4-4)/2+parent.getFontMetrics(parent.getFont()).getHeight()/3);
		parent.text("Escr. 0x3", x+anchoProc/4, y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1+((float)(altoProc*0.75)/4-4)/2+parent.getFontMetrics(parent.getFont()).getHeight()/3);
	}
	public Integer getBoton(int x, int y){
		if(parent.mouseX>=x-anchoProc/2+3&&parent.mouseX<=x-anchoProc/2+3+anchoProc/2-6&&parent.mouseY>=y-(float)(altoProc*0.25)+4&&parent.mouseY<=y-(float)(altoProc*0.25)+4+(float)(altoProc*0.75)/4-4)return 1;
		if(parent.mouseX>=x-anchoProc/2+3&&parent.mouseX<=x-anchoProc/2+3+anchoProc/2-6&&parent.mouseY>=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2&&parent.mouseY<=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2+(float)(altoProc*0.75)/4-4)return 2;
		if(parent.mouseX>=x-anchoProc/2+3&&parent.mouseX<=x-anchoProc/2+3+anchoProc/2-6&&parent.mouseY>=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1&&parent.mouseY<=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1+(float)(altoProc*0.75)/4-4)return 3;
		if(parent.mouseX>=x-anchoProc/2+3&&parent.mouseX<=x-anchoProc/2+3+anchoProc/2-6&&parent.mouseY>=y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1&&parent.mouseY<=y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1+(float)(altoProc*0.75)/4-4)return 4;
		if(parent.mouseX>=x+3&&parent.mouseX<=x+3+anchoProc/2-6&&parent.mouseY>=y-(float)(altoProc*0.25)+4&&parent.mouseY<=y-(float)(altoProc*0.25)+4+(float)(altoProc*0.75)/4-4)return 5;
		if(parent.mouseX>=x+3&&parent.mouseX<=x+3+anchoProc/2-6&&parent.mouseY>=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2&&parent.mouseY<=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2+(float)(altoProc*0.75)/4-4)return 6;
		if(parent.mouseX>=x+3&&parent.mouseX<=x+3+anchoProc/2-6&&parent.mouseY>=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1&&parent.mouseY<=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1+(float)(altoProc*0.75)/4-4)return 7;
		if(parent.mouseX>=x+3&&parent.mouseX<=x+3+anchoProc/2-6&&parent.mouseY>=y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1&&parent.mouseY<=y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1+(float)(altoProc*0.75)/4-4)return 8;
		return null;
	}
	public int[] getBoton(){
		if(getBoton(parent.width/6, parent.height/5)!=null)return new int[]{1, getBoton(parent.width/6, parent.height/5)};
		if(getBoton(parent.width/2, parent.height/5)!=null)return new int[]{2, getBoton(parent.width/2, parent.height/5)};
		if(getBoton(5*parent.width/6, parent.height/5)!=null)return new int[]{3, getBoton(5*parent.width/6, parent.height/5)};
		return null;
	}
}
