package com.uce.edu.demo.estudiante.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")

//Named
@NamedQuery(name = "Estudiante.buscarPorCedula", query = "SELECT e FROM Estudiante e WHERE e.cedula=: datoCedula")
@NamedQuery(name = "Estudiante.buscarPorApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido=: datoApellido ORDER BY e.apellido ASC")

//TypedNamed
@NamedQuery(name = "Estudiante.buscarPorCedulaApellido", query = "SELECT e FROM Estudiante e WHERE e.cedula=: datoCedula AND e.apellido=: datoApellido")
@NamedQuery(name = "Estudiante.buscarPorEdad", query = "SELECT e FROM Estudiante e WHERE e.edad=: datoEdad")

//NativeNamed
@NamedNativeQueries({
	@NamedNativeQuery(name="Estudiante.buscarPorCedulaNativeNamed",query="SELECT * FROM estudiante WHERE cedula = :datoCedula", resultClass=Estudiante.class),
	@NamedNativeQuery(name="Estudiante.buscarPorApellidoEdadNativeNamed",query="SELECT * FROM estudiante WHERE apellido = :datoApellido AND edad= :datoEdad", resultClass=Estudiante.class)
})

public class Estudiante {

	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="cedula")
	private String cedula;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="edad")
	private String edad;
	@Column(name="genero")
	private String genero;
	@Column(name="curso")
	private String curso;

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", edad=" + edad + ", genero=" + genero + ", curso=" + curso + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
