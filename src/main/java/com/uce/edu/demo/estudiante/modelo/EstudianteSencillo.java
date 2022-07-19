package com.uce.edu.demo.estudiante.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private String cedula;
	
	public EstudianteSencillo() {
		
	}

	public EstudianteSencillo(String nombre, String apellido, String cedula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "EstudianteSencillo [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]";
	}
	
	//SET Y GET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
