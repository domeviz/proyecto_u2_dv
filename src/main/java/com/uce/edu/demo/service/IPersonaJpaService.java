package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {

	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(int id);

	public Persona buscarPorId(int id);
	
	public Persona buscarPorCedula(String cedula);
	
	public List<Persona> buscarPorApellido(String apellido);
	
	public List<Persona> buscarPorGenero(String genero);
	
	public List<Persona> buscarPorNombre(String nombre);
}
