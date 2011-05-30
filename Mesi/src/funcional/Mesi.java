package funcional;

import java.util.ArrayList;
import java.util.List;

public class Mesi {
	public List<Procesador> procesadores;
	public MemoriaPrincipal memoria;

	public Mesi(){
		procesadores=new ArrayList<Procesador>();
		procesadores.add(new Procesador(0));
		procesadores.add(new Procesador(1));
		procesadores.add(new Procesador(2));
		memoria=new MemoriaPrincipal();
	}
	
	public boolean LeerDireccion(int procesador,String direccionMemoriaPrincipal){
		
		LineaCache linea=null;
		
		
		if(direccionMemoriaPrincipal.equals("0x0")||direccionMemoriaPrincipal.equals("0x1")){
			linea=procesadores.get(procesador).cache.lineas.get(0);
		}else{
			linea=procesadores.get(procesador).cache.lineas.get(1);
		}
		
		if(linea.Estado.equals("E")||linea.Estado.equals("M")||linea.Estado.equals("S")){
			if(linea.direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)){
				linea.aciertos++;
				return true;
			}else{
				linea.fallos++;
				linea.valor=memoria.valor(direccionMemoriaPrincipal);
				linea.Estado=memoria.estado(direccionMemoriaPrincipal);
				linea.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
				return true;
			}
			
		}else if(linea.Estado.equals("I")){
			
			if(memoria.estado(direccionMemoriaPrincipal).equals("I")){
				List<Integer> c=contienenDireccionValida(direccionMemoriaPrincipal);
				int p=c.get(0);
				System.out.println("el procesador "+p);
				int val=procesadores.get(p).cache.valor(direccionMemoriaPrincipal);
				//procesadores.get(p).cache.ActualizarEstado(direccionMemoriaPrincipal, "S");
				actualizarCaches(procesador, direccionMemoriaPrincipal, "S");
				memoria.ActualizarDireccion(direccionMemoriaPrincipal, "S", val);
				linea.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
				linea.valor=val;
				linea.Estado="S";
				return true;
			}else{
				linea.fallos++;
				linea.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
				linea.valor=memoria.valor(direccionMemoriaPrincipal);
				List<Integer> c=contienenDireccionValida(direccionMemoriaPrincipal);
				if(c.isEmpty()){
					linea.Estado="E";
				}
				else{
					linea.Estado="S";
					actualizarCaches(procesador, direccionMemoriaPrincipal, "S");
				}
				return true;
			}
	
		}
		return false;
	}
	
	public boolean verificarCompartir(int procesador,String direccionMemoriaPrincipal){
		for (Procesador p : procesadores) {
			if(p.numero!=procesador)
			for (LineaCache lc : p.cache.lineas) {
				if(lc.direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)){
						if(!lc.Estado.equals("I")){
							lc.Estado="S";
							return true;
						}
				}
			}
		}
		return false;
	}
	
	public void actualizarCaches(int procesador,String direccionMemoriaPrincipal,String estado){
		for (Procesador p : procesadores) {
			if(p.numero!=procesador)
			for (LineaCache lc : p.cache.lineas) {
				if(lc.direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)){
						lc.Estado=estado;
				}
			}
		}
		
	}
	
	public List<Integer> contienenDireccionValida(String direccionMemoriaPrincipal){
		List<Integer> lista=new ArrayList<Integer>();
		for (Procesador p : procesadores) {
			for (LineaCache l : p.cache.lineas) {
				if(l.direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)&&(!l.Estado.equals("I"))){
					lista.add(p.numero);
				}
			}
		}
		return lista;
	}
	
	
	public boolean escribirDireccion(int procesador,String direccionMemoriaPrincipal){
		LineaCache linea=null;
		if(direccionMemoriaPrincipal.equals("0x0")||direccionMemoriaPrincipal.equals("0x1")){
			linea=procesadores.get(procesador).cache.lineas.get(0);
		}else{
			linea=procesadores.get(procesador).cache.lineas.get(1);
		}
		
		if(memoria.estado(direccionMemoriaPrincipal).equals("I")){
			if(linea.Estado.equals("M")){
				linea.valor++;
				return true;
			}else{
				List<Integer> c=contienenDireccionValida(direccionMemoriaPrincipal);
				int p=c.get(0);
				System.out.println("el procesador "+p);
				int val=procesadores.get(p).cache.valor(direccionMemoriaPrincipal);
				memoria.ActualizarDireccion(direccionMemoriaPrincipal, "I", val);
				actualizarCaches(procesador, direccionMemoriaPrincipal, "I");
				linea.valor=val+1;
				linea.Estado="M";
				linea.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
				return true;
			}
		}else{
			actualizarCaches(procesador, direccionMemoriaPrincipal, "I");
			linea.valor=memoria.valor(direccionMemoriaPrincipal)+1;
			linea.Estado="M";
			linea.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
			memoria.ActualizarDireccion(direccionMemoriaPrincipal, "I", memoria.valor(direccionMemoriaPrincipal));
			return true;
		}
		
		
	}
	
	public String toString(){
		String res="memoria"+"\n";
		for (LineaMemoria l : memoria.lineas) {
			res+=l.toString();
		}
		for (Procesador p : procesadores) {
			res+="procesador "+p.numero+"\n";
			for (LineaCache l : p.cache.lineas) {
				res+=l.toString()+"\n";
			}
		}
		return res;
	}

}
