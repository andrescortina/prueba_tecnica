package com.todosistema.apiempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todosistema.apiempresa.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
