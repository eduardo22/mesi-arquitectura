package visual;
import java.awt.Cursor;
import java.awt.Font;

import processing.core.*;
public class Principal extends PApplet{
	private static final long serialVersionUID = 1L;
	private final int colorFondo = 0x2B3F60, colorEstado = 0x6f88c3, colorAceptacion = 0xa46834,
	colorProc = 0xD9C777;
	final int anchoProc = 150, altoProc = 120;
	public void setup(){
		size(800, 600);
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
		dibujarProcesador("Procesador 1", width/6, height/4);
		dibujarProcesador("Procesador 2", width/2, height/4);
		dibujarProcesador("Procesador 3", 5*width/6, height/4);
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
		if(getBoton(width/6, height/4)!=null)return new int[]{1, getBoton(width/6, height/4)};
		if(getBoton(width/2, height/4)!=null)return new int[]{2, getBoton(width/2, height/4)};
		if(getBoton(5*width/6, height/4)!=null)return new int[]{3, getBoton(5*width/6, height/4)};
		return null;
	}
	public void mouseMoved(){
		if(getBoton()!=null)setCursor(new Cursor(Cursor.HAND_CURSOR));
		else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
