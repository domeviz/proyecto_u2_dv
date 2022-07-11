package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.modelo.Propietario;

@Repository
@Transactional
public class PropietarioJpaRepositoryImpl implements IPropietarioJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(cedula));
	}
	
	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, cedula);
	}

}
