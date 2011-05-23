package funcional;

public class Procesador {
	
	public Cache cache;
	int numero;
	
	public Procesador(int numero){
		this.numero=numero;
		cache = new Cache(numero);
	}
	
	public boolean LeerDireccion(String direccion){
		return false;
	}
	public boolean EscribirDireccion(String direccion){
		return false;
	}

}
