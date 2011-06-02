package funcional;

import java.util.*;

public class Cache {

	public List<LineaCache> lineas;
	public Map<String, List<String>> mapeo;
	public int codigo;

	public Cache(int codigo) {
		this.codigo = codigo;
		lineas = new ArrayList<LineaCache>();
		lineas.add(new LineaCache("0x" + (codigo * 2), 0));
		lineas.add(new LineaCache("0x" + (codigo * 2 + 1), 1));
	}

	public int valor(String direccion) {

		if (direccion.equals("0x0") || direccion.equals("0x1")) {
			return lineas.get(0).valor;
			
		} else {
			return lineas.get(1).valor;
		}
		
	}

	public String estado(String direccion) {

		if (direccion.equals("0x0") || direccion.equals("0x1")) {
			return lineas.get(0).Estado;
			
		} else {
			return lineas.get(1).Estado;
		}

	}

	public void ActualizarValor(String direccion, int valor) {

		if (direccion.equals("0x0") || direccion.equals("0x1")) {
			lineas.get(0).valor = valor;
			return;
		} else {
			lineas.get(1).valor = valor;
			return;
		}

	}

	public void ActualizarEstado(String direccion, String estado) {

		if (direccion.equals("0x0") || direccion.equals("0x1")) {
			lineas.get(0).Estado = estado;
			return;
		} else {
			lineas.get(1).Estado = estado;
			return;
		}

	}

}
