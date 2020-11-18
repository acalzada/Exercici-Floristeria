package com.floristeria.project;

import java.util.ArrayList;
import java.util.List;

public class Arbol {
	
		//Atributos
	
		public static String Altura;
		public static String Precio;
	
	
		public Arbol (String Altura, String Precio) throws Exception {
		
		
		//Que no acepte campos vacios
		
		if (Altura.equals(""))
			throw new Exception("Tienes que introducir una altura");
		if (Precio.equals(""))
			throw new Exception("Tienes que introducir un precio");
		
		
		//Constructores
		
		this.Altura = Altura;
		this.Precio = Precio;
		
}
		// Getters i Setters

		public String getAltura() {
			return Altura;
		}
		public void setAltura(String altura) {
			Altura = altura;
		}

		public String getPrecio() {
			return Precio;
		}
		public void setPrecio(String precio) {
			Precio = precio;
		}

		//Metodos
		
		public void addAdbolAltura(String askArbolAltura) throws Exception {
			
			if (askArbolAltura.equals(""))
				throw new Exception("Tienes que introducir una altura");
			
			
			setAltura(askArbolAltura);
		}
		
		public void addAdbolPrecio (String askArbolPrecio) throws Exception {
			
			if (askArbolPrecio.equals(""))
				throw new Exception("Tienes que introducir un precio");
			
			
			setPrecio (askArbolPrecio);
}
}