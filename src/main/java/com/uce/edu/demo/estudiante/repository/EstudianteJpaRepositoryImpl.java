package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
		}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estudiante=this.buscarPorId(id);
		this.entityManager.remove(estudiante);
		}

	@Override
	public Estudiante buscarPorIdTyped(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.id=: datoId", Estudiante.class);
		myTypedQuery.setParameter("datoId", id);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre=: datoNombre ORDER BY e.nombre DESC", Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		return myTypedQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myNamedQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorCedula");
		myNamedQuery.setParameter("datoCedula", cedula);
		return (Estudiante)myNamedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		Query myNamedQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorApellido");
		myNamedQuery.setParameter("datoApellido", apellido);
		return (List<Estudiante>)myNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorCedulaApellidoTypedNamed(String cedula, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTNamedQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorCedulaApellido",Estudiante.class);
		myTNamedQuery.setParameter("datoCedula", cedula);
		myTNamedQuery.setParameter("datoApellido", apellido);
		return myTNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadTypedNamed(String edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTNamedQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorEdad",Estudiante.class);
		myTNamedQuery.setParameter("datoEdad", edad);
		return myTNamedQuery.getResultList();
	}

}
