package com.todosistema.apiempresa.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todosistema.apiempresa.entity.Actividadempleado;
import com.todosistema.apiempresa.entity.ActividadempleadoPK;

@Repository
public interface ActividadEmpleadoRepository extends JpaRepository<Actividadempleado, ActividadempleadoPK> {
	
	@Modifying
	@Transactional
	@Query(value="delete from Actividadempleado WHERE idactividad = ? ", nativeQuery = true)
	public void eliminar(Integer idactividad);

}
