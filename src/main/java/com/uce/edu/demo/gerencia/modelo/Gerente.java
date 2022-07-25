package com.uce.edu.demo.gerencia.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gerente")
public class Gerente {

	@Id
	@Column(name="gere_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gere_id_seq")
	@SequenceGenerator(name = "gere_id_seq", sequenceName = "gere_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="gere_nombre")
	private String nombre;
	@Column(name="gere_apellido")
	private String apellido;
	@Column(name="gere_sucursal")
	private String sucursal;
	
	@OneToMany(mappedBy="gerente",cascade = CascadeType.ALL)
	private List<Empleados> empleados;

	@Override
	public String toString() {
		return "Gerente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", sucursal=" + sucursal
				+ ", empleados=" + empleados + "]";
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

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public List<Empleados> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleados> empleados) {
		this.empleados = empleados;
	}
	
}
