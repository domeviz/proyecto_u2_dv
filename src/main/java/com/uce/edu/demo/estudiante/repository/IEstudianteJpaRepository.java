package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	public Estudiante buscarPorId(Integer id);
	
	public void insertar(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public void eliminar(Integer id);
	
	// TypedQuery
	public Estudiante buscarPorIdTyped(Integer id);
	public List<Estudiante> buscarPorNombreTyped(String nombre);

	// NamedQuery
	public Estudiante buscarPorCedulaNamed(String cedula);
	public List<Estudiante> buscarPorApellidoNamed(String apellido);

	// TypedQuery y NamedQuery
	public List<Estudiante> buscarPorCedulaApellidoTypedNamed(String cedula, String apellido);
	public List<Estudiante> buscarPorEdadTypedNamed(String edad);
	
}
