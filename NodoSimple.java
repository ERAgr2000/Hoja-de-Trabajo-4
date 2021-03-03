public class NodoSimple<T> extends Nodos{
	
	private Nodos nodoSig;
	private T informacion;
	
	public NodoSimple(T t)
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