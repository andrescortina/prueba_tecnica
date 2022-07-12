package com.todosistema.apiempresa.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todosistema.apiempresa.entity.Actividadempleado;
import com.todosistema.apiempresa.repository.ActividadEmpleadoRepository;
import com.todosistema.apiempresa.service.IActividadEmpleado;

@Service
public class ActividadEmpleadoService implements IActividadEmpleado {
	
	@Autowired
	private ActividadEmpleadoRepository repoActividadEmpleado;

	@Override
	public List<Actividadempleado> listarTodas() {
		return repoActividadEmpleado.findAll();
	}
	
	public void guardar(Actividadempleado actividadEmpleado){
		repoActividadEmpleado.save(actividadEmpleado);
	}

	@Override
	public void eliminar(Integer idActividad) {
		repoActividadEmpleado.eliminar(idActividad);
		
	}
	

}
