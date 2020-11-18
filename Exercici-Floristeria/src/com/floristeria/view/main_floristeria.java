package com.floristeria.view;
import com.floristeria.project.*;


import java.util.Scanner;

import javax.swing.JOptionPane;

//import com.coets.project.Accion;

public class main_floristeria {

	public static void main(String[] args) {
	
		//Explicacion
		System.out.println("Creación de una floristeria:");
		
		//Preguntar al user quina acció vol fer: Crear Floristeria o Salir. 
		
				Scanner pregunta_user = new Scanner (System.in);
				int respuesta_user=0;
				
				boolean check = true;
				while(check) {
					System.out.println("Quieres crear floristeria, ver el stock o salir: \n 1 - Crear floristeria \n 2 - Ver Stock \n 3 - Salir");
				respuesta_user = pregunta_user.nextInt();
				
				switch (respuesta_user) {
				
				//Fer 3 casos. Cas 1= Crear floristeria. Cas 2 = Ver Stock Cas 3= Salir
				//Cas 1 = Crear floristeria
				//Ha contestado 1="Crear floristeria". Pedirle que añada arbol: altura y precio.
				
					case 1:
					
					//Introducir nombre floristeria
					String pregunta_nombre  = new String ();
					pregunta_nombre = JOptionPane.showInputDialog("Introduce el nombre de la floristeria");
					
					//CREAR FLORISTERIA
						
					
					//Imprimir nombre floristeria
					
					System.out.println("Bienvenido. Has creado tu floristeria " + pregunta_nombre +"A continuacion, debes introducir arboles, flores y decoracion"); 
					
//					Scanner datos_arbol = new Scanner(System.in);
//					System.out.println("Crear arbol. Introduce la altura");
//					int datos_arbol_altura = datos_arbol.nextInt();
//					
//					System.out.println("Crear arbol. Introduce el precio");
//					int datos_arbol_precio = datos_arbol.nextInt();
					
					
					//Introducir arboles	
					int UsuarioIntroduceArbol;
					do {
						String AskArbolAltura = JOptionPane.showInputDialog("Introduce la altura del arbol");
						Arbol.Altura (AskArbolAltura);	
						String AskArbolPrecio = JOptionPane.showInputDialog("Introduce el precio del arbol");
						Arbol.Precio (AskArbolPrecio);
						
						UsuarioIntroduceArbol = JOptionPane.showConfirmDialog(null, "Quieres introducir otro Arbol?", null, JOptionPane.YES_NO_OPTION);		
					
					} while (UsuarioIntroduceArbol==0);
					
					//Imprimir propietats del arbol
					
					System.out.println("Nuevo arbol. Altura: " + Arbol.Altura + ". Precio: " + Arbol.Precio);
					
				
					
					
		//Cas 3 = Salir
				case 3:	
					check = false;
					break;


				
				
				}
		}
		}

	

}
