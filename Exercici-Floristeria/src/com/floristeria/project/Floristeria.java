package com.floristeria.project;

import java.util.ArrayList;
import java.util.List;


public class Floristeria {

	//Atributos

	private String nombre;
	private List<Arbol> arboles;
	private List<Flor> flores;
	private List<Decoracion> decoraciones;
	
	//Constructor
	
	public Floristeria(String nombre) {

		this.nombre = nombre;
		
		System.out.println("Se ha creado la floristeria: " + this.nombre);
		
		this.arboles = new ArrayList<Arbol>();
		this.flores = new ArrayList<Flor>();
		this.decoraciones = new ArrayList<Decoracion>();
	}
	
	
	// Metodos para añadir elementos a la floristeria.
	
	
	public void addArbol(Arbol arbol) throws Exception{
		
		if( arbol == null ) throw new Exception("El arbol a añadir apunta a 'null'.") ;
		
		this.arboles.add(arbol);
	}
	
	
	public void addFlor(Flor flor) throws Exception{
		
		if( flor == null ) throw new Exception("La flor a añadir apunta a 'null'.") ;
		
		this.flores.add(flor);
	}
	
	
	public void addDecoracion(Decoracion decoracion) throws Exception{
		
		if( decoracion == null ) throw new Exception("La decoracion a añadir apunta a 'null'.") ;
		
		this.decoraciones.add(decoracion);
	}

	
	//Getters
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public List<Arbol> getArboles() {
		return this.arboles;
	}
	
	
	public List<Flor> getFlores() {
		return this.flores;
	}
	
	public List<Decoracion> getDecoraciones() {
		return this.decoraciones;
	}
	
		
	@Override
	public String toString() {
		
		return "Arboles: "      + this.arboles.size()      + "\n" +
			   "Flores: "       + this.flores.size()       + "\n" +
			   "Decoraciones: " + this.decoraciones.size() + "\n";
	}
	
}
