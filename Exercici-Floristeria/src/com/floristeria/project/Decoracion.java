package com.floristeria.project;

public class Decoracion extends Precio {

	// Atributos

	public String Material;

	public Decoracion(String Material, String Precio) throws Exception {
		super(Precio);

		// Que no acepte campos vacios

		if (Material.equals(""))
			throw new Exception("Tienes que introducir una altura");
		if (Precio.equals(""))
			throw new Exception("Tienes que introducir un precio");

		this.Material = Material;

	}
	// Getters i Setters

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}


}
