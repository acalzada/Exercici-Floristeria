package com.floristeria.view;
import com.floristeria.project.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
//import java.util.List;
import java.util.Scanner;

//import com.coets.project.Accion;

/**
 * MAIN_APP
 * @author Miriam, Rossini, angel
 *
 */
public class main_floristeria {

	// Declaración de constantes para cada una de las acciones.
	// Facilita el poder cambiar la asociación entre acción y código a entrar por el usuario sin tener que modificar código del main.
	// También facilita la lectura del código.
	
	private static final  String AÑADIR_ARBOL = "1";
	private static final  String AÑADIR_FLOR = "2";
	private static final  String AÑADIR_DECORACION = "3";
	private static final  String MUESTRA_ESTOCK = "4";
	private static final  String SALIR = "0";
	
	public static void main(String[] args) throws Exception  {
		
		// Se usará este scanner para obtener las acciones a realizar por el usuario.
		Scanner userInput = new Scanner(System.in);
		
		// Forzamos al usuario a crear una floristeria para poder continuar.
		Floristeria floristeria = crearFloristeria();
		
		
		// Aquí ya podemos empezar a trabajar con la floristeria.
		String action;
		do {
			muestraMenu();
			action = userInput.next();
			
			switch(action) {
			
				case AÑADIR_ARBOL:
									afegirArbre(floristeria);
									break;
				
				case AÑADIR_FLOR:
									afegirFlor(floristeria);
									break;
					
				case AÑADIR_DECORACION:
									afegirDecoracio(floristeria);
									break;
				
				case MUESTRA_ESTOCK:
									stock(floristeria);
									break;
									
				case SALIR:
									userInput.close();
									System.out.println("\n Muchas gracias!! \n Hasta la próxima!!");				
			}
		}while(!action.equals(SALIR));
	}		
	
	
	
	// Metodos de ayuda al Main
	
	
	/**
	 * Mostrar el menu de opciones disponibles para el usuario.
	 */
	public static void muestraMenu() {
		System.out.println("\nElige lo que deseas hacer:");
		System.out.println("[" + AÑADIR_ARBOL      + "] AÑADE ARBOL");
		System.out.println("[" + AÑADIR_FLOR       + "] AÑADE FLOR");
		System.out.println("[" + AÑADIR_DECORACION + "] AÑADE DECORACION ");
		System.out.println("[" + MUESTRA_ESTOCK    + "] STOCK");
		System.out.println("[" + SALIR             + "] SALIR");
	}

	
	
	
	/**
	 * MEtodo para crear la floristeria.
	 * 
	 * @return Floristeria. Devuelve una instancia del objeto Floristeria.
	 */
	public static Floristeria crearFloristeria() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Ingrese nombre floristeria: ");
		String nombreFloristeria = userInput.next();
		userInput.close();		
		return new Floristeria(nombreFloristeria);
	}
	
	
	
	/**
	 * MEtodo para añadir un arbol a la floristeria.
	 * 
	 * @param floristeria La instancia de Floristeria donde queremos añadir el arbol.
	 */
	public static void afegirArbre(Floristeria floristeria) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Ingrese altura: ");
		String altura = userInput.next();
		
		System.out.print("Ingrese precio: ");
		String precio = userInput.next();
		
		try {
			floristeria.addArbol( new Arbol(altura, precio) );
		} catch (Exception e) {
			System.out.println("No se ha podido añadir el arbol por el siguiente motivo: " + e.getMessage());
		}finally {
			userInput.close();
		}
	}
	
	
	
	/**
	 * Metodo para añadir una Flor a la floristeria
	 * 
	 * @param floristeria La instancia de Floristeria donde queremos añadir el arbol.
	 */
	public static void afegirFlor(Floristeria floristeria) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("ingrese color:    ");
		String color = userInput.next();
		System.out.print("ingrese precio:     ");
		String precio = userInput.next();

		try {
			
			floristeria.addFlor( new Flor(color, precio) );
			
		} catch (Exception e) {
			System.out.println("No se ha podido añadir la flor por el siguiente motivo: " + e.getMessage());
		}finally {
			userInput.close();
		}
	}
	
	
	
	
	/**
	 * Imprimir las opciones de materiales para decoración.
	 */
	private static void menu1() {
		System.out.println("[1] plastico   + [2] madera  ");
	}
	
	
	/**
	 * Metodo para añadir una Decoracion a la floristeria.
	 * 
	 * @param floristeria La instancia de Floristeria donde queremos añadir el arbol.
	 */
	public static void afegirDecoracio(Floristeria floristeria) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("ingrese material:    ");
		menu1();
		
		String material = "";
		String opcion1 = "";
		
		do{
			try{
				opcion1 = userInput.nextLine();
			}catch(InputMismatchException e1) {
				System.out.println("Por favor escoge entra el número de la opción de material que deseas.");
				menu1();
			}
		}while(!opcion1.equals("1") && !opcion1.contentEquals("2"));
		
		
		switch(opcion1) {
		
			case("1"):
					System.out.println("material:   plastico");
		       		material = "plastico";
		       		break;
			
			case("2"):
		    		System.out.println("material:   madera");
		    		material = "madera";
		    		break;
		    
			default:
					System.out.println("El material introducido es desconocido. No se podrá crear la decoración.");
	    }
			
		System.out.println("ingrese precio:     ");
		String precio = userInput.next();
		
		try {
			
			floristeria.addDecoracion( new Decoracion(material, precio) );
			
		} catch (Exception e) {
			System.out.println("No se ha podido añadir la decoración por el siguiente motivo: " + e.getMessage());
		}finally {
			userInput.close();
		}
		
		//System.out.println( añadir.getAllArbols().size());
	}
	
	
	/**
	 * Muestra el estoc de Arboles, Flores y Decoraciones de la floristeria.
	 * 
	 * Usa expresiones Lambda para imprimir "los elementos" que hay de cada tipo.
	 *   
	 * @param floristeria Instancia de la floristeria sobre la cual se quiere saber el estock.
	 */
	public static void stock(Floristeria floristeria) {
		
		System.out.println("\n\n ------   STOCK   ------\n");
		
		System.out.print("\tARBRES:\n\t\t");
		floristeria.getArboles().forEach( (arbol) -> System.out.print("T ") );


		System.out.print("\n\tFLORS:\n\t\t");
		floristeria.getFlores().forEach( (flor) -> System.out.print("Y ") );
		

		System.out.print("\n\tDECORACIÓ:\n\t\t");
		floristeria.getDecoraciones().forEach( (decoracion) -> System.out.print("X ") );
		
		System.out.println("\n -----------------------\n\n");
	}
	
	

}
