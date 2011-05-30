package funcional;

public class LineaCache extends LineaMemoria{

	public String direccionMemoriaPrinciapal;
	
	public LineaCache(String direccion,int numero) {
		super(direccion, numero);
		direccionMemoriaPrinciapal="";
		Estado="I";
	}
	
	public String toString(){
		String res="";
		res+=numero+", "+direccion+ ", " + valor + ", "+ direccionMemoriaPrinciapal + ", " + Estado + " ,"+"\n";
		return res;
	}
}
