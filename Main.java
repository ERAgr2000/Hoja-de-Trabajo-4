import java.io.*; 
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.File; 

public class Main{
	
	/*
	Clase statica dado que es unicamente por utilidad, no se necesitan instancias
	*/
	public static class Convert{
		
		private static String path = "datos.txt";
		private static String operadoresMayores = "/*";
		private static String operadoresMenores = "+-";
		
		/*
		Transforma un string de infix a postfix
		infixText es el texto que se espera cambiar a postfix
		devuevle un string que es en forma postfix
		*/
		private static String inf_postfix(String infixText)
		{
			String postfix = "";
			Stack<Character> operadores = new Stack<Character>();
			int j = 0;
			for(int i = 0; i< infixText.length(); i= i+1){
				
				//variables para guardar informacion temporal
				char character_actual = infixText.charAt(i);
				if(j>0)
				{
					String temporal_text = "";
					boolean condicion = true;
					while(condicion == true)
					{
						if(character_actual == ')' )
						{
							j=j-1;
							condicion = false;
						}else{
							character_actual = infixText.charAt(i);
							temporal_text = temporal_text + character_actual;
							i=i+1;
						}
						
					}
					i=i-1;
					postfix = postfix + inf_postfix(temporal_text);
					
					
				}
				else{				
					if( Character.isDigit(character_actual) )
					{
						postfix = postfix + character_actual;
					}
					else if(character_actual == '(')
					{
						j = j+1;
					}
					else if(operadores.size() > 0)
					{
						char operador = operadores.peek();
						if( operadoresMayores.indexOf(character_actual) != -1 && operadoresMenores.indexOf(operador)!= -1)
						{
							operadores.push((Character)character_actual);
						}
						else if( operadoresMayores.indexOf(character_actual) != -1 && operadoresMayores.indexOf(operador)!= -1)
						{
							postfix = postfix + operadores.pop();
							operadores.push((Character)character_actual);
						}
						else if( operadoresMenores.indexOf(character_actual) != -1 && operadoresMayores.indexOf(operador)!= -1)
						{
							postfix = postfix + operadores.pop();
							operadores.push((Character)character_actual);
						}
						else if( operadoresMenores.indexOf(character_actual) != -1 && operadoresMenores.indexOf(operador)!= -1)
						{
							postfix = postfix + operadores.pop();
							operadores.push((Character)character_actual);
						}
					}
					else
					{
						if( operadoresMayores.indexOf(character_actual) != -1 || operadoresMenores.indexOf(character_actual)!= -1)
						{
							operadores.push((Character)character_actual);
						}
					}
				}
			}
			while(operadores.size() > 0)
			{
				System.out.println(operadores);
				postfix = postfix + operadores.pop();
				
			}
			return postfix;
		}
		/*
		private static String inf_postfix(String infixText)
		{
			String postfix = "";
			String operadores_xUsar= "";
			int j =0;
			Stack<Character> operadores_parentesis = new Stack<Character>();
			
			for(int i = 0; i< infixText.length(); i= i+1){
				
				//variables para guardar informacion temporal
				char character_actual = infixText.charAt(i);
				char operador;
				
				if( Character.isDigit(character_actual) )
				{
					postfix = postfix + character_actual;
				}
				
				else if(character_actual == '(')
				{
					j = j+1;
				}
				else if(j > 0)
				{	
					if(character_actual == ')')
					{
						operador = operadores_parentesis.pop();
						postfix = postfix + operador;
						j=j-1;
					}
					else if( operadores.indexOf(character_actual) != -1)
					{
						operadores_parentesis.push((Character)character_actual);
					}
				}
				else
				{
					if( operadores.indexOf(character_actual) != -1)
					{
						//operadores_xUsar = operadores_xUsar + character_actual;
						
					}
				}
			}
			if(j>0)
			{
				String temp = "";
				for (Character item: operadores_parentesis)
				{
					temp = item + temp;
				}
				postfix = postfix + temp;
			}	
			//postfix = postfix + operadores_xUsar;
			return postfix;
	  	}
		*/
		
		/*
		Lee lo que hay escrito en un archivo
		devuelve un String que es lo leido en el archivo
		*/
		public static String readFileAsString() throws Exception 
		{ 
			String data = ""; 
			data = new String(Files.readAllBytes(Paths.get(path))); 
			return data.trim(); 
		}

		/*
		Metodo principal de la clase para la transformacion de los textos en infix a postfix
		devuelve el texto en postfix
		*/
		public static String getPostfix() throws Exception 
		{
			String string_infix = readFileAsString();
			String string_postfix = inf_postfix(string_infix);
			
			return string_postfix;
		}
	}
	
	private static Stacks usingstack(Integer option, boolean simple_doble) 
	{
		Stacks pilausar = null;
		if(simple_doble)
		{
			option = option +1;
		}

		switch(option){
			case 1:
				pilausar = new StacksArray();
				break;
			case 2:
				pilausar = new StacksVector();
				break;
			case 3:
				pilausar = new ListaEncadenada();
				break;
			case 4:
				pilausar = new ListaDoblemente();
				break;
		}
		return pilausar;
	}
	
	private static void print(Object o)
	{
		System.out.println(o.toString());
	}
	
	public static void main(String args[]) throws Exception
	{
		//Variables de almacenamiento
		Calculadora calculadora;
		Stacks pila;
		int option;
		boolean simple_doble = false;
		/*
		Obtiene de forma postfix lo que se debe calcular.
		*/
		String postfix = Convert.getPostfix();
		
		//Se le pide que seleccione el stack a usar
		while(true)
		{
			try
			{
				print("Que tipo de pila desea implementar en la calculadora?");
				print("1. ArrayList \n"+"2. Vector\n"+"3. Lista\n");
				Scanner sc=new Scanner(System.in);
				option= sc.nextInt();
				if(option == 3)
				{
					print("La desea doblemente encadenada? 			(ingrese true si es asi)");
					simple_doble = sc.nextBoolean();
					break;
				}
				else if(option >= 1 && option <= 3)
				{
					break;
				}
			}catch(Exception e)
			{
				print("Ingreso un dato invalido.");
			}
		}
		pila = usingstack(option, simple_doble);
		Calculadora.setinstance(pila);
		calculadora = Calculadora.getinstance();
		print("El resutlado es: "+ calculadora.calcular(postfix));
		
		
	}

}