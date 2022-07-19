package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

public interface IPersonaJpaService {

	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(int id);

	public Persona buscarPorId(int id);
	
	public Persona buscarPorCedula(String cedula);
	
	public List<Persona> buscarPorApellido(String apellido);
	
	public List<Persona> buscarPorGenero(String genero);
	
	public List<Persona> buscarPorNombre(String nombre);
	
	public int actualizarPorApellido(String genero, String apellido);
	
	public int eliminarPorGenero(String genero);
	
	public Persona buscarPorCedulaTyped(String cedula);
	
	public Persona buscarPorCedulaNamed(String cedula);
	
	public Persona buscarPorCedulaTypedNamed(String cedula);
	
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);
	
	public Persona buscarPorCedulaNative(String cedula);
	
	public Persona buscarPorCedulaNativeNamed(String cedula);
	
	public Persona buscarPorCedulaCriteriaApi(String cedula);
	
	public Persona buscarDinamicamente(String nombre, String apellido, String genero);
	
	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero);
	
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido);
	
	public List<PersonaContadorGenero> buscarCantidadPorGenero();
}
