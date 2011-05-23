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
	
}
