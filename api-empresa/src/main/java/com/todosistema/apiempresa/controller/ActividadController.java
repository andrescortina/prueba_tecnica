package com.todosistema.apiempresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todosistema.apiempresa.dto.ActividadDTO;
import com.todosistema.apiempresa.dto.EstadosDTO;
import com.todosistema.apiempresa.entity.Actividad;
import com.todosistema.apiempresa.service.IActividadEmpleado;
import com.todosistema.apiempresa.service.IActividadService;

@RestController
@RequestMapping("/api/actividad")
public class ActividadController {
	
	@Autowired
	private IActividadService serviceActividad;
	
	@Autowired
	private IActividadEmpleado serviceActividadEmpleado;
	
	@GetMapping("/listarTodas")
	public List<Actividad> listarTodas(){
		return serviceActividad.listarTodasActividadesNative();
	}
	
	@GetMapping("/listarPendientes")
	public List<Actividad> listarTodasPendientes(){
		return serviceActividad.listarTodasPendientes();
		
	}
	
	@GetMapping("/buscar/{idActividad}")
	public Optional<Actividad> buscar(@PathVariable Integer idActividad){
		return serviceActividad.buscar(idActividad);
		
	}
	
	@PostMapping("/crear")
	public void guardar(@RequestBody ActividadDTO actividadDTO){
		try {
			serviceActividad.guardar(actividadDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@PutMapping("/editar/{idActividad}/{estado}")
	public void editar(@PathVariable Integer idActividad, @PathVariable String estado){
		try {
			Actividad actividad = new Actividad();
			actividad.setIdactividad(idActividad);
			actividad.setEstado(estado);
			
			serviceActividad.editar(actividad);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*@DeleteMapping("/eliminar/{idActividad}")
	public void eliminar(@PathVariable Integer idActividad){
		Actividad actividad = new Actividad();
		serviceActividad.eliminar(actividad);
	}*/
	
	@GetMapping("/estados")
	public List<EstadosDTO> obtenerEstados(){
		return serviceActividad.obtenerEstados();
	}
	

}
