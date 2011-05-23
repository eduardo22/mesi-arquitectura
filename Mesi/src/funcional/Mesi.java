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
		
		
		if(direccionMemoriaPrincipal.equals("0x0")||direccionMemoriaPrincipal.equals("0x0")){
			linea=procesadores.get(procesador).cache.lineas.get(0);
		}else{
			linea=procesadores.get(procesador).cache.lineas.get(1);
		}
		if(linea.direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)){
			if(linea.Estado.equals("E")||linea.Estado.equals("M")||linea.Estado.equals("S")){
				linea.aciertos++;
				return true;
			}else if(linea.Estado.equals("I")){
				linea.fallos++;
				if(linea.Estado.equals("I")){
					for (Procesador p : procesadores) {
						for (LineaCache lc : p.cache.lineas) {
							if(lc.Estado.equals("M")){
								memoria.ActualizarDireccion(lc.direccionMemoriaPrinciapal, "S", lc.valor);
							}
						}
					}
				}
				linea.valor=memoria.valor(direccionMemoriaPrincipal);
				linea.Estado=verificarCompartir(procesador, direccionMemoriaPrincipal)?"S":"E";
				return true;
			}
		}else{
			linea.fallos++;
			linea.valor=memoria.valor(direccionMemoriaPrincipal);
			linea.Estado=verificarCompartir(procesador, direccionMemoriaPrincipal)?"S":"E";
			return true;
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
	public boolean escribirDireccion(int procesador,String direccionMemoriaPrincipal){
		LineaCache linea=null;
		if(direccionMemoriaPrincipal.equals("0x0")||direccionMemoriaPrincipal.equals("0x1")){
			linea=procesadores.get(procesador).cache.lineas.get(0);
		}else{
			linea=procesadores.get(procesador).cache.lineas.get(1);
		}
		if(linea.direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)){
			String estado=linea.Estado;
			if(estado.equals("M")){
				linea.valor++;
			}else if(estado.equals("E")){
				memoria.ActualizarDireccion(direccionMemoriaPrincipal, "I", linea.valor);
				linea.valor++;
			}else if(estado.equals("S")){
				memoria.ActualizarDireccion(direccionMemoriaPrincipal, "I", linea.valor);
				linea.valor++;
				actualizarCaches(procesador, direccionMemoriaPrincipal, "I");
				return true;
			}else if(estado.equals("I")){
				memoria.ActualizarDireccion(direccionMemoriaPrincipal, "I", linea.valor);
				linea.valor++;
				actualizarCaches(procesador, direccionMemoriaPrincipal, "I");
				return true;
			}
		}
		return false;
	}

}
