package com.floristeria.view;
import com.floristeria.project.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
//import java.util.List;
import java.util.Scanner;

//import com.coets.project.Accion;

/**
 * @author angel
 *
 */
public class main_floristeria {

	//private static FloristeriaRepo a�adir = new FloristeriaRepo();

	public static void main(String[] args) throws Exception  {
		
		
		
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.print("Ingrese nombre floristeria: ");
		String nombreFloristeria = userInput.next();
				
		Floristeria floristeria = new Floristeria(nombreFloristeria);
		
		
		
		muestraMenu();
		int accion = userInput.nextInt();
		
		while (accion != 0) {
			if (!(accion == 0)) {
                //A�ADE ARBOLES
				if (accion == 1) {

					afegirArbre(floristeria, userInput);
				}
				
				//A�ADE FLORES
				if (accion == 2) {

					afegirFlor(floristeria, userInput);
				}

				//3 A�ade decoraciones
				
				if (accion == 3) {

					afegirDecoracio(floristeria, userInput);
				
				}

				
				
				// Cas 4 = Stock
				
				if (accion == 4) {
					stock(floristeria);
				}

			   }

			muestraMenu();
			accion = userInput.nextInt();
		}
		
		userInput.close();
		System.out.println("\n Muchas gracias!! \n Hasta la pr�xima!!");
	}
		
	
	public static void muestraMenu() {
		System.out.println("\nElige lo que deseas hacer:");
		System.out.println("[1] A�ADE ARBOL");
		System.out.println("[2] A�ADE FLOR");
		System.out.println("[3] A�ADE DECORACION ");
		System.out.println("[4] STOCK");
		System.out.println("[0] SALIR");
	}

	public static void menu1() {
		System.out.println("[1] plastico   + [2] madera  ");
	}
	
	
	
	public Floristeria crearFloristeria(String nombre) {
		return new Floristeria(nombre);
	}
	
	
	
	public static void afegirArbre(Floristeria floristeria, Scanner userInput) {
		System.out.print("Ingrese altura: ");
		String altura = userInput.next();
		
		System.out.print("Ingrese precio: ");
		String precio = userInput.next();
		
		try {
			floristeria.addArbol( new Arbol(altura, precio) );
		} catch (Exception e) {
			System.out.println("No se ha podido a�adir el arbol por el siguiente motivo: " + e.getMessage());
		}
	}
	
	
	
	public static void afegirFlor(Floristeria floristeria, Scanner userInput) {
		System.out.print("ingrese color:    ");
		String color = userInput.next();
		System.out.print("ingrese precio:     ");
		String precio = userInput.next();

		try {
			
			floristeria.addFlor( new Flor(color, precio) );
			
		} catch (Exception e) {
			System.out.println("No se ha podido a�adir la flor por el siguiente motivo: " + e.getMessage());
		}
	}
	
	
	
	
	public static void afegirDecoracio(Floristeria floristeria, Scanner userInput) {
		System.out.print("ingrese material:    ");
		menu1();
		
		String material = "";
		String opcion1 = "";
		
		do{
			try{
				opcion1 = userInput.nextLine();
			}catch(InputMismatchException e1) {
				System.out.println("Por favor escoge entra el n�mero de la opci�n de material que deseas.");
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
					System.out.println("El material introducido es desconocido. No se podr� crear la decoraci�n.");
	    }
			
		System.out.println("ingrese precio:     ");
		String precio = userInput.next();
		
		try {
			
			floristeria.addDecoracion( new Decoracion(material, precio) );
			
		} catch (Exception e) {
			System.out.println("No se ha podido a�adir la decoraci�n por el siguiente motivo: " + e.getMessage());
		}
		
		//System.out.println( a�adir.getAllArbols().size());
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
		

		System.out.print("\n\tDECORACI�:\n\t\t");
		floristeria.getDecoraciones().forEach( (decoracion) -> System.out.print("X ") );
		
		System.out.println("\n -----------------------\n\n");
	}
	
	

}
