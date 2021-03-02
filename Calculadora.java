import java.util.ArrayList; 

public class Calculadora<T extends Stacks>
{
	private Stacks<String> stack = new ArrayList();
	private static Calculadora calculadora = new Calculadora();

    private Calculadora() 
	{
		
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
				stack.add(character_actual.toString());
			}
			else if(character_actual == '+')
			{
				String last = stack.pop();//
				stack.remove(stack.size() - 1);
				Float numB = Float.parseFloat(last);
				
				
				last = stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				Float numA = Float.parseFloat(last);
				
				resultado = numA + numB;
				String resStr = resultado.toString();
				stack.add(resStr);
				System.out.println("SUMA");
			}
			else if(character_actual == '-')
			{
				String last = stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				Float numB = Float.parseFloat(last);
				
				
				last = stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				Float numA = Float.parseFloat(last);
				
				resultado = numA - numB;
				String resStr = resultado.toString();
				stack.add(resStr);
				System.out.println("RESt");
			}
			else if(character_actual == '*')
			{
				String last = stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				Float numB = Float.parseFloat(last.toString());
				
				
				last = stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				Float numA = Float.parseFloat(last.toString());
				
				resultado = numA * numB;
				String resStr = resultado.toString();
				stack.add(resStr);
								System.out.println("MULT");
			}
			else if(character_actual == '/')
			{
				String last = stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				Float numB = Float.parseFloat(last.toString());
				
				
				last = stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				Float numA = Float.parseFloat(last.toString());
				
				resultado = numA/numB;
				String resStr = resultado.toString();
				stack.add(resStr);
				System.out.println("DIV");
			}
		}
		
		String last = stack.get(stack.size() - 1);
		resultado = Float.parseFloat(last.toString());
		return resultado;
	}
	
	public static Calculadora getinstance()
	{
		return calculadora;
	}
}