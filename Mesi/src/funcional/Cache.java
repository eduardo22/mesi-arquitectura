package funcional;

import java.util.*;
public class Cache {

	public List<LineaCache> lineas;
	public Map<String,List<String>> mapeo;
	public int codigo;
	
	public Cache(int codigo){
		this.codigo=codigo;
		lineas=new ArrayList<LineaCache>();
		lineas.add(new LineaCache("0x"+(codigo*2),0));
		lineas.add(new LineaCache("0x"+(codigo*2+1),1));
	}
	
	public int valor(String direccion){
		
		for (LineaCache lc : lineas) {
			if(lc.direccionMemoriaPrinciapal.equals(direccion))return lc.valor;
		}
		return -1;
	}
	
	public String estado(String direccion){
		
		for (LineaCache lc : lineas) {
			if(lc.direccionMemoriaPrinciapal.equals("direccion"))return lc.Estado;
		}
		return null;
	}
	
	public void ActualizarValor(String direccion,int valor){
		
		for (LineaCache lc : lineas) {
			if(lc.direccionMemoriaPrinciapal.equals("direccion")){
				lc.valor=valor;
				return;
			}
		}
		
	}
	
	public void ActualizarEstado(String direccion,String estado){
		
		for (LineaCache lc : lineas) {
			if(lc.direccionMemoriaPrinciapal.equals("direccion")){
				lc.Estado=estado;
				return;
			}
		}
	}
	
}
