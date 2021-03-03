import java.util.*; 

public class StacksArray extends Stacks{
	
	private ArrayList<String> stack = new ArrayList();
	
	
	public void push(Object t)
	{
		String character = t.toString();
		stack.add(character);
	}
	
	public Object pop()
	{
		
		String numero = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return numero;
		
	}
	
}