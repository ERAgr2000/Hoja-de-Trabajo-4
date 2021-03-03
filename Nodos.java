public abstract class Nodos<T> implements INodo{
	
	private Nodos nodoSig;
	private T informacion;
	
	public Nodos getNodoSig()
	{
		return nodoSig;
	}
}