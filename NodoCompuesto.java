public class NodoCompuesto<T> extends Nodos{
	
	private Nodos nodoSig;
	private Nodos nodoAnt;
	private T informacion;
	
	public NodoCompuesto(T t)
	{
		informacion = t;
	}
	
	public Nodos getNodoSig()
	{
		return nodoSig;
	}
	
	public T getInfo()
	{
		return informacion;
	}
	
	public void setNodos(Nodos nodos)
	{
		nodoSig = nodos;
	}
}