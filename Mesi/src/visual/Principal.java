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
	}
	public void draw(){
		vp.plot();
	}
	public void mouseMoved(){
		if(vp.getBoton()!=null)setCursor(new Cursor(Cursor.HAND_CURSOR));
		else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	public void mouseClicked(){
		if(vp.getBoton()!=null){
			if(vp.getBoton()[1]<=4)mesi.LeerDireccion(vp.getBoton()[0]-1, "0x"+(vp.getBoton()[1]-1));
			else mesi.escribirDireccion(vp.getBoton()[0]-1, "0x"+(vp.getBoton()[1]-5));
		}
	}
}
