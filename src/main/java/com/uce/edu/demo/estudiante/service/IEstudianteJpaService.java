package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

public interface IEstudianteJpaService {

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(int id);

	public Estudiante buscarPorId(int id);

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
