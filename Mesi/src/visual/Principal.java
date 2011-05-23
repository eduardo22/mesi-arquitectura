package visual;
import processing.core.*;
public class Principal extends PApplet{
	private static final long serialVersionUID = 1L;
	private final int colorFondo = 0x2B3F60, colorEstado = 0x6f88c3, colorAceptacion = 0xa46834,
	colorProc = 0xD9C777;
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
		final int anchoProc = 150, altoProc = 120;
		dibujarProcesador("Procesador 1", width/6, height/4, anchoProc, altoProc);
		dibujarProcesador("Procesador 2", width/2, height/4, anchoProc, altoProc);
		dibujarProcesador("Procesador 3", 5*width/6, height/4, anchoProc, altoProc);
	}
	private void dibujarProcesador(String nombre, float x, float y, int anchoProc, int altoProc){
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
	}
	public void mouseMoved(){
		
	}
}
