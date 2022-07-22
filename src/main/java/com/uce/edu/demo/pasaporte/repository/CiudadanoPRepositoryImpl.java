package com.uce.edu.demo.pasaporte.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.pasaporte.modelo.CiudadanoP;
import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;

@Repository
@Transactional
public class CiudadanoPRepositoryImpl implements ICiudadanoPRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CiudadanoP ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public CiudadanoP buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CiudadanoP.class, id);
	}

	@Override
	public void actualizar(CiudadanoP ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}
	
}
