import java.util.*;

public class StacksVector extends Stacks
{
	private Vector stack = new Vector(1,1);
	private int index_last = 0;
	
	public StacksVector()
	{
		stack.add(0);
	}
	
	public void push(Object t)
	{
		index_last = index_last+1;
		String character = t.toString();
		stack.add(character);
	}
	
	public Object pop()
	{
		
		String numero = stack.get(index_last).toString();
		stack.remove(index_last);
		index_last = index_last-1;
		return numero;
		
	}
}