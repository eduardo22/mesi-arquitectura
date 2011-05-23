package visual;
import java.awt.Cursor;
import funcional.*;
import processing.core.*;
public class Principal extends PApplet{
	private static final long serialVersionUID = 1L;
	private final int colorFondo = 0x2B3F60, colorEstado = 0x6f88c3, colorAceptacion = 0xa46834,
	colorProc = 0xD9C777;
	Mesi mesi;
	final int anchoProc = 150, altoProc = 120, altoCache = 70;
	public void setup(){
		size(800, 600);
		mesi = new Mesi();
	}
	public void draw(){
		background(colorFondo);
		dibujar();
		noLoop();
		//translate(WIDTH/2, HEIGHT/2);
	}
	private void fillInt(int color){
		fill(red(color), green(color), blue(color));
	}
	private void dibujar(){
		dibujarProcesador("Procesador 1", width/6, height/5);
		dibujarProcesador("Procesador 2", width/2, height/5);
		dibujarProcesador("Procesador 3", 5*width/6, height/5);
		dibujarCache(1, width/6, 2*height/5);
		dibujarCache(2, width/2, 2*height/5);
		dibujarCache(3, 5*width/6, 2*height/5);
	}
	private void dibujarCache(int cache, int x, int y){
		fillInt(colorProc);
		rect(x-anchoProc/2, y-altoCache/2, anchoProc, altoCache);
		rect(x-anchoProc/2, y-altoCache/2, anchoProc, (float)(altoProc*0.25));
		textSize(18);
		fillInt(0);
		text("Cache " + cache, x, y-altoCache/2+(float)(altoProc*0.25) - getFontMetrics(getFont()).getHeight()/2);
		fillInt(colorProc);
		rect(x-anchoProc/2, y-altoCache/2+(float)(altoProc*0.25), (float)(anchoProc*0.2), (altoCache-(float)(altoProc*0.25))/2);
		rect(x-anchoProc/2+(float)(anchoProc*0.2), y-altoCache/2+(float)(altoProc*0.25), (float)(anchoProc*0.3), (altoCache-(float)(altoProc*0.25))/2);
		rect(x-anchoProc/2+(float)(anchoProc*0.5), y-altoCache/2+(float)(altoProc*0.25), (float)(anchoProc*0.25), (altoCache-(float)(altoProc*0.25))/2);
		rect(x-anchoProc/2+(float)(anchoProc*0.75), y-altoCache/2+(float)(altoProc*0.25), (float)(anchoProc*0.25), (altoCache-(float)(altoProc*0.25))/2);
		rect(x-anchoProc/2, y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2,(float)(anchoProc*0.2), (altoCache-(float)(altoProc*0.25))/2);
		rect(x-anchoProc/2+(float)(anchoProc*0.2), y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2, (float)(anchoProc*0.3), (altoCache-(float)(altoProc*0.25))/2);
		rect(x-anchoProc/2+(float)(anchoProc*0.5), y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2, (float)(anchoProc*0.25), (altoCache-(float)(altoProc*0.25))/2);
		rect(x-anchoProc/2+(float)(anchoProc*0.75), y-altoCache/2+(float)(altoProc*0.25)+(altoCache-(float)(altoProc*0.25))/2, (float)(anchoProc*0.25), (altoCache-(float)(altoProc*0.25))/2);
		textSize(14);
		fillInt(colorFondo);
		text(mesi.procesadores.get(cache-1).cache.lineas.get(0).Estado, x-anchoProc/2+((float)(anchoProc*0.2))/2, y-altoCache/2+(float)(altoProc*0.25)+getFontMetrics(getFont()).getHeight());
		text(mesi.procesadores.get(cache-1).cache.lineas.get(0).direccionMemoriaPrinciapal, x-anchoProc/2+((float)(anchoProc*0.2))/2+(float)(anchoProc*0.2), y-altoCache/2+(float)(altoProc*0.25)+getFontMetrics(getFont()).getHeight());
	}
	private void dibujarProcesador(String nombre, float x, float y){
		textAlign(CENTER);
		textSize(18);
		stroke(0);
		fillInt(colorProc);
		rect(x-anchoProc/2, y-altoProc/2, anchoProc, altoProc);
		rect(x-anchoProc/2, y-altoProc/2, anchoProc, (float)(altoProc*0.25));
		fill(0);
		text(nombre, x, y-altoProc/2 + (float)(altoProc*0.25) - getFontMetrics(getFont()).getHeight()/2);
		fillInt(colorAceptacion);
		rect(x-anchoProc/2+3, y-(float)(altoProc*0.25)+4, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		rect(x-anchoProc/2+3, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		rect(x-anchoProc/2+3, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		rect(x-anchoProc/2+3, y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		rect(x+3, y-(float)(altoProc*0.25)+4, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		rect(x+3, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		rect(x+3, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		rect(x+3, y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1, anchoProc/2-6, (float)(altoProc*0.75)/4-4);
		fillInt(colorProc);
		textSize(12);
		text("Leer 0x0", x-anchoProc/4, y-(float)(altoProc*0.25)+4+((float)(altoProc*0.75)/4-4)/2+getFontMetrics(getFont()).getHeight()/3);
		text("Leer 0x1", x-anchoProc/4, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2+((float)(altoProc*0.75)/4-4)/2+getFontMetrics(getFont()).getHeight()/3);
		text("Leer 0x2", x-anchoProc/4, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1+((float)(altoProc*0.75)/4-4)/2+getFontMetrics(getFont()).getHeight()/3);
		text("Leer 0x3", x-anchoProc/4, y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1+((float)(altoProc*0.75)/4-4)/2+getFontMetrics(getFont()).getHeight()/3);
		text("Escr. 0x0", x+anchoProc/4, y-(float)(altoProc*0.25)+4+((float)(altoProc*0.75)/4-4)/2+getFontMetrics(getFont()).getHeight()/3);
		text("Escr. 0x1", x+anchoProc/4, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2+((float)(altoProc*0.75)/4-4)/2+getFontMetrics(getFont()).getHeight()/3);
		text("Escr. 0x2", x+anchoProc/4, y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1+((float)(altoProc*0.75)/4-4)/2+getFontMetrics(getFont()).getHeight()/3);
		text("Escr. 0x3", x+anchoProc/4, y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1+((float)(altoProc*0.75)/4-4)/2+getFontMetrics(getFont()).getHeight()/3);
	}
	public Integer getBoton(int x, int y){
		if(mouseX>=x-anchoProc/2+3&&mouseX<=x-anchoProc/2+3+anchoProc/2-6&&mouseY>=y-(float)(altoProc*0.25)+4&&mouseY<=y-(float)(altoProc*0.25)+4+(float)(altoProc*0.75)/4-4)return 1;
		if(mouseX>=x-anchoProc/2+3&&mouseX<=x-anchoProc/2+3+anchoProc/2-6&&mouseY>=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2&&mouseY<=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2+(float)(altoProc*0.75)/4-4)return 2;
		if(mouseX>=x-anchoProc/2+3&&mouseX<=x-anchoProc/2+3+anchoProc/2-6&&mouseY>=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1&&mouseY<=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1+(float)(altoProc*0.75)/4-4)return 3;
		if(mouseX>=x-anchoProc/2+3&&mouseX<=x-anchoProc/2+3+anchoProc/2-6&&mouseY>=y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1&&mouseY<=y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1+(float)(altoProc*0.75)/4-4)return 4;
		if(mouseX>=x+3&&mouseX<=x+3+anchoProc/2-6&&mouseY>=y-(float)(altoProc*0.25)+4&&mouseY<=y-(float)(altoProc*0.25)+4+(float)(altoProc*0.75)/4-4)return 5;
		if(mouseX>=x+3&&mouseX<=x+3+anchoProc/2-6&&mouseY>=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2&&mouseY<=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/4+2+(float)(altoProc*0.75)/4-4)return 6;
		if(mouseX>=x+3&&mouseX<=x+3+anchoProc/2-6&&mouseY>=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1&&mouseY<=y-(float)(altoProc*0.25)+(float)(altoProc*0.75)/2+1+(float)(altoProc*0.75)/4-4)return 7;
		if(mouseX>=x+3&&mouseX<=x+3+anchoProc/2-6&&mouseY>=y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1&&mouseY<=y-(float)(altoProc*0.25)+3*(float)(altoProc*0.75)/4-1+(float)(altoProc*0.75)/4-4)return 8;
		return null;
	}
	private int[] getBoton(){
		if(getBoton(width/6, height/5)!=null)return new int[]{1, getBoton(width/6, height/5)};
		if(getBoton(width/2, height/5)!=null)return new int[]{2, getBoton(width/2, height/5)};
		if(getBoton(5*width/6, height/5)!=null)return new int[]{3, getBoton(5*width/6, height/5)};
		return null;
	}
	public void mouseMoved(){
		if(getBoton()!=null)setCursor(new Cursor(Cursor.HAND_CURSOR));
		else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
