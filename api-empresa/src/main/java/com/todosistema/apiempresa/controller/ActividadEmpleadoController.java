package com.todosistema.apiempresa.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todosistema.apiempresa.dto.ActividadDTO;
import com.todosistema.apiempresa.entity.Actividad;
import com.todosistema.apiempresa.entity.Actividadempleado;
import com.todosistema.apiempresa.service.IActividadEmpleado;
import com.todosistema.apiempresa.service.IActividadService;

@RestController
@RequestMapping("/api/actividades")
public class ActividadEmpleadoController {
	
	@Autowired
	private IActividadEmpleado serviceActividadEmpleado;
	
	@Autowired
	private IActividadService serviceActividad;
	
	@GetMapping("/listarTodas")
	public List<ActividadDTO>listarTodas() {
		
		List<Actividadempleado> lista =  serviceActividadEmpleado.listarTodas();
		List<ActividadDTO> listaDTO = new ArrayList<ActividadDTO>();
		ActividadDTO actividadDTO;
		
		for(Actividadempleado objeto:lista) {
			
			actividadDTO = new ActividadDTO();
			actividadDTO.setIdactividad(objeto.getActividad().getIdactividad());
			actividadDTO.setNombre(objeto.getActividad().getNombre());
			actividadDTO.setIdempleado(objeto.getEmpleado().getIdempleado());
			actividadDTO.setEstado(objeto.getActividad().getEstado());
			actividadDTO.setFechaCreada(objeto.getActividad().getFechaCreada());
			actividadDTO.setFechaEjecutada(objeto.getActividad().getFechaEjecutada());
			actividadDTO.setEmpleado(objeto.getEmpleado().getNombre());
			
			Date fechaActual = Calendar.getInstance().getTime();
			
			int dias = 0;
			if(objeto.getActividad().getFechaEjecutada() !=null) {
			 Long diferenciaFecha = fechaActual.getTime()-objeto.getActividad().getFechaEjecutada().getTime();
			 dias = (int) TimeUnit.MILLISECONDS.toDays(diferenciaFecha);
			}
			
			actividadDTO.setDias(dias);
			listaDTO.add(actividadDTO);
		}
		
		return listaDTO;
	}
	
	@DeleteMapping("/eliminar/{idActividad}")
	public void eliminar(@PathVariable Integer idActividad){
		Actividad actividad = new Actividad();
		actividad.setIdactividad(idActividad);
		serviceActividadEmpleado.eliminar(idActividad);
		serviceActividad.eliminar(actividad);
	}

}
