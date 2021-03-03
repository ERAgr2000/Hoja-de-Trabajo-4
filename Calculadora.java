import java.util.ArrayList; 

public class Calculadora
{
	private Stacks stack;
	private static Calculadora calculadora = new Calculadora();

    private Calculadora() 
	{
		
    }
	
	private Calculadora(Stacks pila) 
	{
		stack = pila;
    }
	
	public static void setinstance(Stacks pila)
	{
		calculadora = new Calculadora(pila);
	}
	//Calcular, hace el calculo de la expresion postfix
	//Parametro el string de postfix
	//Devuelve el valor en Number
	public Float calcular(String postfix)
	{
		Float resultado = 0f;
		for(int i = 0; i< postfix.length(); i= i+1){
				
			//variables para guardar informacion temporal
			Character character_actual = postfix.charAt(i);
			char operador;
			
			if( Character.isDigit(character_actual) )
			{
				stack.push((Object)character_actual);
			}
			else if(character_actual == '+')
			{
				String last = stack.pop().toString();//
				//stack.remove(stack.size() - 1);
				Float numB = Float.parseFloat(last);
				//System.out.println(numB);
				
				last = stack.pop().toString();
				//stack.remove(stack.size() - 1);
				Float numA = Float.parseFloat(last);
				
				resultado = numA + numB;
				String resStr = resultado.toString();
				stack.push(resStr);
				//System.out.println("SUMA");
			}
			else if(character_actual == '-')
			{
				String last = stack.pop().toString();
				//stack.remove(stack.size() - 1);
				Float numB = Float.parseFloat(last);
				
				
				last = stack.pop().toString();
				//stack.remove(stack.size() - 1);
				Float numA = Float.parseFloat(last);
				
				resultado = numA - numB;
				String resStr = resultado.toString();
				stack.push(resStr);
				//System.out.println("RESt");
			}
			else if(character_actual == '*')
			{
				String last = stack.pop().toString();
				//stack.remove(stack.size() - 1);
				Float numB = Float.parseFloat(last.toString());
				
				
				last = stack.pop().toString();
				//stack.remove(stack.size() - 1);
				Float numA = Float.parseFloat(last.toString());
				
				resultado = numA * numB;
				String resStr = resultado.toString();
				stack.push(resStr);
			}
			else if(character_actual == '/')
			{
				String last = stack.pop().toString();
				//stack.remove(stack.size() - 1);
				Float numB = Float.parseFloat(last.toString());
				
				
				last = stack.pop().toString();
				//stack.remove(stack.size() - 1);
				Float numA = Float.parseFloat(last.toString());
				
				resultado = numA/numB;
				String resStr = resultado.toString();
				stack.push(resStr);
			}
		}
		
		Object last = stack.pop();
		resultado = Float.parseFloat(last.toString());
		return resultado;
	}
	
	public static Calculadora getinstance()
	{
		return calculadora;
	}
}