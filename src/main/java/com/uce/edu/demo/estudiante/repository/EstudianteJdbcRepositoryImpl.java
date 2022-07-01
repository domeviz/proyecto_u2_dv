package com.uce.edu.demo.estudiante.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EstudianteTo buscarPorId(int id) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?", new Object[] { id },
				new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
	}

	@Override
	public void insertar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante (id, cedula, nombre, apellido, edad) values (?, ?, ?, ?, ?)",
				new Object[] { estudiante.getId(), estudiante.getCedula(), estudiante.getNombre(),
						estudiante.getApellido(), estudiante.getEdad() });
	}

	@Override
	public void actualizar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set cedula=?, nombre=?, apellido=?, edad=? where id=?",
				new Object[] { estudiante.getCedula(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getEdad(), estudiante.getId() });
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from estudiante where id=?", new Object[] { id });
	}

}
