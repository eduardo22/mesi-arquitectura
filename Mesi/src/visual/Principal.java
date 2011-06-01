package visual;
import java.awt.*;
import processing.core.*;
import funcional.*;
public class Principal extends PApplet{
	private static final long serialVersionUID = 1L;
	public Mesi mesi;
	VisualPrincipal vp;
	boolean estaAnimando = false, acercaDe = false;
	public void setup(){
		size(800, 600);
		vp = new VisualPrincipal(this);
		mesi = new Mesi();
	}
	public void draw(){
		if(!acercaDe){
			vp.fillInt(vp.colorFondo);
			rect(0,0,width,height);
			vp.plot();
			fill(255);
			text("Acerca de...", width-43, 20);
			text("Reiniciar", 43, 20);
		}
		else {
			vp.fillInt(vp.colorFondo);
			rect(0,0,width,height);
			PImage img = loadImage("../res/logo30anosazul.jpg");
			img.resize((int)(width*.75), (int)(height*.75));
			image(img, width*0.125f, height*0.125f);
			fill(255);
			text("Volver...", width-43, 20);
		}
	}
	public void mouseMoved(){
		if(!acercaDe&&!estaAnimando&&vp.getBoton()!=null)setCursor(new Cursor(Cursor.HAND_CURSOR));
		else if(!estaAnimando&&mouseX>=width-85&&mouseX<width&&mouseY<=23&&mouseY>0)setCursor(new Cursor(Cursor.HAND_CURSOR));
		else if(!estaAnimando&&mouseX>=10&&mouseX<78&&mouseY<=23&&mouseY>0)setCursor(new Cursor(Cursor.HAND_CURSOR));
		else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	public void mouseClicked(){
		if(!acercaDe&&!estaAnimando&&vp.getBoton()!=null){
			estaAnimando=true;
			vp.inicializarAnimacion(vp.getBoton()[0]-1);
			if(vp.getBoton()[1]<=4)mesi.LeerDireccion(vp.getBoton()[0]-1, "0x"+(vp.getBoton()[1]-1));
			else mesi.escribirDireccion(vp.getBoton()[0]-1, "0x"+(vp.getBoton()[1]-5));
			System.out.println(mesi.toString());
		}
		else{
			 if(!estaAnimando&&mouseX>=width-85&&mouseX<width&&mouseY<=23&&mouseY>0)acercaDe=!acercaDe;
			 if(!estaAnimando&&mouseX>=10&&mouseX<78&&mouseY<=23&&mouseY>0) mesi = new Mesi();
		}
	}
}
