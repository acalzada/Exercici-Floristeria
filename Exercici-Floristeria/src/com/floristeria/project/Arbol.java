package com.floristeria.project;

public class Arbol extends Precio {

	// Atributos de arbol

	public String Altura;

	public Arbol(String Altura, String Precio) throws Exception {
		super(Precio);

		// Que no acepte campos vacios

		if (Altura.equals(""))
			throw new Exception("Tienes que introducir una altura");
		if (Precio.equals(""))
			throw new Exception("Tienes que introducir un precio");

		this.Altura = Altura;

	}
	// Getters i Setters

	public String getAltura() {
		return Altura;
	}

	public void setAltura(String altura) {
		Altura = altura;
	}

}