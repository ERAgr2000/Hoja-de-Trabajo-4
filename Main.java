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
		private static String operadores = "+-/*";
		
		/*
		Transforma un string de infix a postfix
		infixText es el texto que se espera cambiar a postfix
		devuevle un string que es en forma postfix
		*/
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
					postfix = postfix + " " + character_actual;
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
						postfix = postfix + " " + operador;
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
						operadores_xUsar = operadores_xUsar + " " + character_actual;
					}
				}
			}
			if(j>0)
			{
				String temp = "";
				for (Character item: operadores_parentesis)
				{
					temp = item +  " " + temp;
				}
				postfix = postfix + " " + temp;
			}	
			postfix = postfix + operadores_xUsar;
			return postfix;
	  	}
		
		/*
		Lee lo que hay escrito en un archivo
		devuelve un String que es lo leido en el archivo
		*/
		public static String readFileAsString() throws Exception 
		{ 
			String data = ""; 
			data = new String(Files.readAllBytes(Paths.get(path))); 
			return data; 
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
	
	public static void main(String args[]) throws Exception
	{
		
		String postfix = Convert.getPostfix();
		System.out.println(postfix);
	}

}