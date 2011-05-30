package funcional;

import java.util.List;
import java.util.ArrayList;

public class MemoriaPrincipal {
	
	public List<LineaMemoria> lineas;
	
	public MemoriaPrincipal(){
		this.lineas=new ArrayList<LineaMemoria>();
		this.lineas.add(new LineaMemoria("0x0",0));
		this.lineas.add(new LineaMemoria("0x1",1));
		this.lineas.add(new LineaMemoria("0x2",2));
		this.lineas.add(new LineaMemoria("0x3",3));
	}
	
	public int valor(String direccion){
		
		if(direccion.equals("0x0"))return lineas.get(0).valor;
		if(direccion.equals("0x1"))return lineas.get(1).valor;
		if(direccion.equals("0x2"))return lineas.get(2).valor;
		if(direccion.equals("0x3"))return lineas.get(3).valor;
		return -1;
	}
	
	public String estado(String direccion){
		
		if(direccion.equals("0x0"))return lineas.get(0).Estado;
		if(direccion.equals("0x1"))return lineas.get(1).Estado;
		if(direccion.equals("0x2"))return lineas.get(2).Estado;
		if(direccion.equals("0x3"))return lineas.get(3).Estado;
		return null;
	}
	
	public void ActualizarDireccion(String direccion,String estado,int valor){
		
		if(direccion.equals("0x0")){
			lineas.get(0).valor=valor;
			lineas.get(0).Estado=estado;
			
		}else if(direccion.equals("0x1")){
			lineas.get(1).valor=valor;
			lineas.get(1).Estado=estado;
		}else if(direccion.equals("0x2")){
			lineas.get(2).valor=valor;
			lineas.get(2).Estado=estado;
		}else if(direccion.equals("0x3")){
			lineas.get(3).valor=valor;
			lineas.get(3).Estado=estado;
		}
			
	}

}
