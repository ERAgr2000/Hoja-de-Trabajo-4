import java.util.Objects;

public class ListaEncadenada<T> extends Listas
{
	private NodoSimple<T> nodo;
	
	public void push(Object t)
	{
		NodoSimple<T> new_nodo = new NodoSimple(t.toString());
		if (!Objects.isNull(nodo) )
		{
			new_nodo.setNodos(nodo);
		}
		nodo = new_nodo;
		
	}
	
	public Object pop()
	{
		
		String informacion = nodo.getInfo().toString();
		nodo = (NodoSimple)nodo.getNodoSig();
		return informacion;
		
	}
	
	
}