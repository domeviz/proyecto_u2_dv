package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.modelo.EstudianteSencillo;

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
	
	//NativeQuery
	public Estudiante buscarPorCedulaNombreApellidoNative(String cedula, String nombre, String apellido);
	public List<Estudiante> buscarPorEdadNative(String edad);
	
	//NativeQuery y NamedQuery
	public List<Estudiante> buscarPorApellidoEdadNativeNamed(String apellido, String edad);
	public Estudiante buscarPorCedulaNativeNamed(String cedula);
	
	//Criteria API
	public List<Estudiante> buscarDinamicamentePorApellidoCursoGeneroCriteriaAPI(String apellido, String curso, String genero);
	public Estudiante buscarDinamicamentePorApellidoEdadGeneroCriteriaAPI(String apellido, String edad, String genero);
	
	//JPA DTO y sentencias de agregacion
	public List<EstudianteSencillo> buscarPorCursoSencillo(String curso);
	public List<EstudianteContadorEdad> buscarCantidadPorEdad();
}
