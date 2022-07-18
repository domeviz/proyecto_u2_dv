package com.uce.edu.demo.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.IEstudianteJpaRepository;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;
	
	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.eliminar(id);
	}

	@Override
	public Estudiante buscarPorId(int id) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorId(id);
	}

	@Override
	public Estudiante buscarPorIdTyped(Integer id) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorIdTyped(id);
	}

	@Override
	public List<Estudiante> buscarPorNombreTyped(String nombre) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreTyped(nombre);
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public List<Estudiante> buscarPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorApellidoNamed(apellido);
	}

	@Override
	public List<Estudiante> buscarPorCedulaApellidoTypedNamed(String cedula, String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaApellidoTypedNamed(cedula, apellido);
	}

	@Override
	public List<Estudiante> buscarPorEdadTypedNamed(String edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorEdadTypedNamed(edad);
	}

	@Override
	public Estudiante buscarPorCedulaNombreApellidoNative(String cedula, String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaNombreApellidoNative(cedula, nombre, apellido);
	}
	
	@Override
	public List<Estudiante> buscarPorEdadNative(String edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorEdadNative(edad);
	}

	@Override
	public List<Estudiante> buscarPorApellidoEdadNativeNamed(String apellido, String edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorApellidoEdadNativeNamed(apellido, edad);
	}

	@Override
	public Estudiante buscarPorCedulaNativeNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaNativeNamed(cedula);
	}

	@Override
	public List<Estudiante> buscarDinamicamentePorApellidoCursoGeneroCriteriaAPI(String apellido, String curso,
			String genero) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarDinamicamentePorApellidoCursoGeneroCriteriaAPI(apellido, curso, genero);
	}

	@Override
	public Estudiante buscarDinamicamentePorApellidoEdadGeneroCriteriaAPI(String apellido, String edad, String genero) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarDinamicamentePorApellidoEdadGeneroCriteriaAPI(apellido, edad, genero);
	}

}
