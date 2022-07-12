package com.todosistema.apiempresa.service;

import java.util.List;
import java.util.Optional;

import com.todosistema.apiempresa.dto.ActividadDTO;
import com.todosistema.apiempresa.dto.EstadosDTO;
import com.todosistema.apiempresa.entity.Actividad;

public interface IActividadService {
	
	public List<Actividad> listarTodas();
	
	public List<Actividad> listarTodasPendientes();
	
	public List<Actividad> listarTodasActividadesNative();
	
	public void guardar(ActividadDTO actividadDTO) throws Exception;
	
	public void editar(Actividad actividad) throws Exception;
	
	public Optional<Actividad> buscar(Integer idActividad);
	
	public void eliminar(Actividad actividad);
	
	public List<EstadosDTO> obtenerEstados();

}
