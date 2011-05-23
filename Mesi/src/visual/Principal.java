package visual;
import java.awt.*;
import processing.core.*;
import funcional.*;
public class Principal extends PApplet{
	private static final long serialVersionUID = 1L;
	public Mesi mesi;
	VisualPrincipal vp;
	public void setup(){
		size(800, 600);
		vp = new VisualPrincipal(this);
		mesi = new Mesi();
		noLoop();
	}
	public void draw(){
		vp.plot();
	}
	public void mouseMoved(){
		if(vp.getBoton()!=null)setCursor(new Cursor(Cursor.HAND_CURSOR));
		else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
