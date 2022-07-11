package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Vehiculo;

public interface IVehiculoJpaRepository {

	public void insertar(Vehiculo vehiculo);

	public Vehiculo buscar(String placa);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);
}
