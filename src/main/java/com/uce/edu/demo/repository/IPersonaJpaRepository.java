package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	public Persona buscarPorId(Integer id);
	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar (Integer id);
	
	public Persona buscarPorCedula(String cedula);
	public Persona buscarPorCedulaTyped(String cedula);
	public Persona buscarPorCedulaNamed(String cedula);
	public Persona buscarPorCedulaTypedNamed(String cedula);
	
	public List<Persona> buscarPorApellido(String apellido);
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);
	
	public List<Persona> buscarPorGenero(String genero);
	public List<Persona> buscarPorNombre(String nombre);
	
	public int actualizarPorApellido(String genero, String apellido);
	public int eliminarPorGenero(String genero);
	
	public Persona buscarPorCedulaNative(String cedula);
	public Persona buscarPorCedulaNativeNamed(String cedula);
	public Persona buscarPorCedulaCriteriaApi(String cedula);
}
