package funcional;

public class LineaMemoria {
	public String direccion;
	public String Estado;
	public int aciertos;
	public int fallos;
	public int valor;
	public int numero;
	
	public LineaMemoria(String direccion, int numero){
		this.direccion=direccion;
		this.numero=numero;
		Estado = "I";
	}
}
