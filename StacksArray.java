import java.util.*; 

public class StacksArray extends Stacks{
	
	private ArrayList<String> stack = new ArrayList();
	
	
	private void push(Object t)
	{
		String character = t.toString();
		stack.add(character);
	}
	
	public Object pop()
	{
		
		stack.get(stack.size() - 1);
		return new Object();
		
	}
	
}