package com.floristeria.project;

public class Flor {

		//Atributos
	
		public String Color;
		public String Precio;
	
	
		public Flor (String Color, String Precio) throws Exception {
		
		
		//Que no acepte campos vacios
		
		if (Color.equals(""))
			throw new Exception("Tienes que introducir un color");
		if (Precio.equals(""))
			throw new Exception("Tienes que introducir un precio");
		
		
		//Constructores
		
		this.Color = Color;
		this.Precio = Precio;
		
}
		// Getters i Setters

		public String getColor() {
			return Color;
		}
		public void setColor(String color) {
			Color = color;
		}

		public String getPrecio() {
			return Precio;
		}
		public void setPrecio(String precio) {
			Precio = precio;
		}


}

