package com.uce.edu.demo.gerencia.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleados {

	@Id
	@Column(name="empl_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empl_id_seq1")
	@SequenceGenerator(name = "empl_id_seq1", sequenceName = "empl_id_seq1", allocationSize = 1)
	private Integer id;
	@Column(name="empl_nombre")
	private String nombre;
	@Column(name="empl_apellido")
	private String apellido;
	
	@ManyToOne
	@JoinColumn(name="empl_id_gerente")
	private Gerente gerente;

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", gerente=" + gerente + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
}
