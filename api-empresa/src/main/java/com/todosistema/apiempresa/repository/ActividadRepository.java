package com.todosistema.apiempresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.todosistema.apiempresa.entity.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
	
	@Query("SELECT a FROM Actividad a WHERE a.estado = 'PENDIENTE'")
	public List<Actividad> listarTodasPendientes();
	
	@Query(value = "select a.idactividad, a.nombre, a.fechaCreada,a.fechaEjecutada,a.estado, e.nombre as empleado from actividad a left join actividadempleado ae\r\n" + 
			"on(a.idactividad = ae.idactividad) left join empleado e on(ae.idempleado = e.idempleado)", nativeQuery = true)
	public List<Actividad> listarTodasActividadesNative();

}
