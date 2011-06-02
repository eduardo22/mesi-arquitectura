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
	
/**	public boolean LeerDireccion(int procesador,String direccionMemoriaPrincipal){
		
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
*/
	
	public boolean LeerDireccion(int procesador,String direccionMemoriaPrincipal){
		
		Procesador p=procesadores.get(procesador);
		
		//String estado=p.cache.estado(direccionMemoriaPrincipal);
		
		boolean existe=false;
		
		int nCache=-1;
		
		
		if(direccionMemoriaPrincipal.equals("0x0")||direccionMemoriaPrincipal.equals("0x1")){
			existe=p.cache.lineas.get(0).direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)?true:false;
			nCache=0;
		}else{
			existe=p.cache.lineas.get(1).direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)?true:false;
			nCache=1;
		}
		System.out.println("existe = "+existe);
		//Existe dentro de la linea de cache indicada
		if(existe){
			for (Procesador pit : procesadores) {
				if(pit.cache.estado(direccionMemoriaPrincipal).equals("M")){
					if(!p.cache.lineas.get(nCache).Estado.equals("M"))
					memoria.ActualizarDireccion(direccionMemoriaPrincipal, "S", pit.cache.lineas.get(nCache).valor);
					if(pit.numero!=procesador){
						pit.cache.ActualizarEstado(direccionMemoriaPrincipal, "S");
						pit.cache.ActualizarValor(direccionMemoriaPrincipal, memoria.valor(direccionMemoriaPrincipal));
					}

				}
			}
			
			if(p.cache.estado(direccionMemoriaPrincipal).equals("I")){
				p.cache.ActualizarEstado(direccionMemoriaPrincipal, "S");
				//si alguien tiene estado E lo paso a S
				for (Procesador pit : procesadores) {
					if(pit.cache.estado(direccionMemoriaPrincipal).equals("E")){
						pit.cache.ActualizarEstado(direccionMemoriaPrincipal, "S");
					}
				}
			}
			
			
			
		}else{
			//no existe la direccion de memoria en cache osea se produce un fallo
			
			//verificar  modifcados para actualizar la memoria principal
			for (Procesador pit : procesadores) {
				if(pit.cache.estado(direccionMemoriaPrincipal).equals("M")){
					memoria.ActualizarDireccion(direccionMemoriaPrincipal, "S", pit.cache.lineas.get(nCache).valor);
				}
			}
			
			//Todos pasan a estado I
			for (Procesador pit : procesadores) {
				pit.cache.ActualizarEstado(direccionMemoriaPrincipal, "I");
				pit.cache.lineas.get(nCache).direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
			}
			
			//El que hiso la orden de escritura para a estado E por ser el primero en leer
			p.cache.ActualizarEstado(direccionMemoriaPrincipal, "E");
			p.cache.ActualizarValor(direccionMemoriaPrincipal, memoria.valor(direccionMemoriaPrincipal));
			
		}
		
		return true;
		
	}
	
	public void actualizarLeer(String direccionMemoriaPrincipal){
		for (Procesador p : procesadores) {
			LineaCache linea=null;
			if(direccionMemoriaPrincipal.equals("0x0")||direccionMemoriaPrincipal.equals("0x1")){
				linea=p.cache.lineas.get(0);
				
			}else{
				linea=p.cache.lineas.get(1);
			}
			
			if(!linea.direccionMemoriaPrinciapal.equals(direccionMemoriaPrincipal)){
				if(linea.Estado.equals("M")){
					memoria.ActualizarDireccion(direccionMemoriaPrincipal, "S", linea.valor);
				}
				linea.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
				linea.Estado="I";
			}else{
				if(linea.Estado.equals("E")){
					linea.Estado="S";
				}
			}
			
		}
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
	
	public void actualizarTodoCaches(int procesador,String direccionMemoriaPrincipal,String estado){
		int cont=0;
		for (Procesador p : procesadores) {
			cont=0;
			if(p.numero!=procesador)
			for (LineaCache lc : p.cache.lineas) {
				
				if(direccionMemoriaPrincipal.equals("0x0")||direccionMemoriaPrincipal.equals("0x1")){
					if(cont==0){
						lc.Estado=estado;
						lc.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
					}
					//linea=procesadores.get(procesador).cache.lineas.get(0);
				}else{
					if(cont==1){
						lc.Estado=estado;
						lc.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
					}
				}
				cont++;		
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
				if(!c.isEmpty()){
				int p=c.get(0);
				//System.out.println("el procesador "+p);
				int val=procesadores.get(p).cache.valor(direccionMemoriaPrincipal);
				memoria.ActualizarDireccion(direccionMemoriaPrincipal, "I", val);
				//actualizarCaches(procesador, direccionMemoriaPrincipal, "I");
				actualizarTodoCaches(procesador, direccionMemoriaPrincipal, "I");
				linea.valor=val+1;
				linea.Estado="M";
				linea.direccionMemoriaPrinciapal=direccionMemoriaPrincipal;
				}
				memoria.ActualizarDireccion(direccionMemoriaPrincipal, "I", memoria.valor(direccionMemoriaPrincipal));
				
				return true;
			}
		}else{
			//actualizarCaches(procesador, direccionMemoriaPrincipal, "I");
			actualizarTodoCaches(procesador, direccionMemoriaPrincipal, "I");
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
