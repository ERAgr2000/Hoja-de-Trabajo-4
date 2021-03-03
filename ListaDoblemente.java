import java.util.Objects;

public class ListaDoblemente<T> extends Listas
{
	private NodoCompuesto<T> nodo;
	
	public void push(Object t)
	{
		NodoCompuesto<T> new_nodo = new NodoCompuesto(t.toString());
		if (!Objects.isNull(nodo) )
		{
			new_nodo.setNodos(nodo);
		}
		nodo = new_nodo;
		
	}
	
	public Object pop()
	{
		
		String informacion = nodo.getInfo().toString();
		nodo = (NodoCompuesto)nodo.getNodoSig();
		return informacion;
		
	}
	
	
}