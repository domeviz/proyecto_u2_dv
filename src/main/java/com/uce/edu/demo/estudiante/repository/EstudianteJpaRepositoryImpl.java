package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.modelo.EstudianteSencillo;

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
		Estudiante estudiante = this.buscarPorId(id);
		this.entityManager.remove(estudiante);
	}

	@Override
	public Estudiante buscarPorIdTyped(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.id=: datoId", Estudiante.class);
		myTypedQuery.setParameter("datoId", id);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.nombre=: datoNombre ORDER BY e.nombre DESC", Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		return myTypedQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedula");
		myNamedQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myNamedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		Query myNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellido");
		myNamedQuery.setParameter("datoApellido", apellido);
		return (List<Estudiante>) myNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorCedulaApellidoTypedNamed(String cedula, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedulaApellido",
				Estudiante.class);
		myTNamedQuery.setParameter("datoCedula", cedula);
		myTNamedQuery.setParameter("datoApellido", apellido);
		return myTNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadTypedNamed(String edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdad",
				Estudiante.class);
		myTNamedQuery.setParameter("datoEdad", edad);
		return myTNamedQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNombreApellidoNative(String cedula, String nombre, String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE cedula = :datoCedula AND nombre= :datoNombre AND apellido= :datoApellido",
				Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorEdadNative(String edad) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE edad = :datoEdad",
				Estudiante.class);
		myQuery.setParameter("datoEdad", edad);
		return (List<Estudiante>) myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNativeNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedulaNativeNamed",
				Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorApellidoEdadNativeNamed(String apellido, String edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarPorApellidoEdadNativeNamed", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarDinamicamentePorApellidoCursoGeneroCriteriaAPI(String apellido, String curso,
			String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoCurso = myCriteria.equal(myTabla.get("curso"), curso);
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

		Predicate miPredicadoFinal = null;
		if (genero.equals("M")) {
			miPredicadoFinal = myCriteria.and(predicadoCurso, predicadoApellido);
		} else {
			miPredicadoFinal = myCriteria.or(predicadoCurso, predicadoApellido);
		}

		myQuery.select(myTabla).where(miPredicadoFinal);
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

	@Override
	public Estudiante buscarDinamicamentePorApellidoEdadGeneroCriteriaAPI(String apellido, String edad, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoEdad = myCriteria.equal(myTabla.get("edad"), edad);
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

		Predicate miPredicadoFinal = null;
		if (genero.equals("F")) {
			miPredicadoFinal = myCriteria.and(predicadoEdad, predicadoApellido);
		} else {
			miPredicadoFinal = myCriteria.or(predicadoEdad, predicadoApellido);
		}

		myQuery.select(myTabla).where(miPredicadoFinal);
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<EstudianteSencillo> buscarPorCursoSencillo(String curso) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.estudiante.modelo.EstudianteSencillo(e.nombre, e.apellido, e.cedula)FROM Estudiante e WHERE e.curso= :datoCurso",
				EstudianteSencillo.class);
		myQuery.setParameter("datoCurso", curso);
		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteContadorEdad> buscarCantidadPorEdad() {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteContadorEdad> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.estudiante.modelo.EstudianteContadorEdad(e.edad, COUNT(e.edad))FROM Estudiante e GROUP BY e.edad",
				EstudianteContadorEdad.class);
		return myQuery.getResultList();
	}

}
