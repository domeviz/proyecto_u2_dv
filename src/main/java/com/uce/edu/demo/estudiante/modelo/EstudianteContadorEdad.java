package com.uce.edu.demo.estudiante.modelo;

import java.io.Serializable;

public class EstudianteContadorEdad implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String edad;
	private Long numero;
	
	public EstudianteContadorEdad() {
		
	}

	public EstudianteContadorEdad(String edad, Long numero) {
		this.edad = edad;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "EstudianteContadorEdad [edad=" + edad + ", numero=" + numero + "]";
	}
	
	//SET Y GET
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
}
