package com.todosistema.apiempresa.service;

import java.util.List;

import com.todosistema.apiempresa.entity.Actividadempleado;

public interface IActividadEmpleado {
	
	public List<Actividadempleado> listarTodas();
	
	public void guardar(Actividadempleado actividadEmpleado);
	
	public void eliminar(Integer idActividad);

}
