package com.todosistema.apiempresa.service.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todosistema.apiempresa.dto.ActividadDTO;
import com.todosistema.apiempresa.dto.EstadosDTO;
import com.todosistema.apiempresa.entity.Actividad;
import com.todosistema.apiempresa.entity.Actividadempleado;
import com.todosistema.apiempresa.entity.ActividadempleadoPK;
import com.todosistema.apiempresa.entity.Empleado;
import com.todosistema.apiempresa.repository.ActividadRepository;
import com.todosistema.apiempresa.service.IActividadService;

@Service
public class ActividadService implements IActividadService {
	
	@Autowired
	private ActividadRepository repoActividad;
	
	@Autowired
	private ActividadEmpleadoService serviceActividadEmpleado;

	@Override
	public List<Actividad> listarTodas() {
		return repoActividad.findAll();
	}

	@Override
	public List<Actividad> listarTodasPendientes() {
		return repoActividad.listarTodasPendientes();
	}

	@Override
	public void guardar(ActividadDTO actividadDTO) throws Exception {
		try {
			
			Actividad objeto = new Actividad();
			objeto.setNombre(actividadDTO.getNombre());
			objeto.setFechaCreada(new Date());
			objeto.setEstado("PENDIENTE");
			
			objeto = repoActividad.save(objeto);
		
			Empleado empleado = new Empleado();
			empleado.setIdempleado(actividadDTO.getIdempleado());
			
			ActividadempleadoPK actividadempleadoPK = new ActividadempleadoPK();
			actividadempleadoPK.setIdactividad(objeto.getIdactividad());
			actividadempleadoPK.setIdempleado(actividadDTO.getIdempleado());
			
			Actividadempleado actividadEmpleado = new Actividadempleado();
			actividadEmpleado.setActividad(objeto);
			actividadEmpleado.setEmpleado(empleado);
			actividadEmpleado.setActividadempleadoPK(actividadempleadoPK);
			
			serviceActividadEmpleado.guardar(actividadEmpleado);
			
		
		}catch(Exception e) {
			String mensajeError = "Error presentado al guardar actividad";
			throw new Exception(mensajeError, e);
		}
	}

	@Override
	public List<Actividad> listarTodasActividadesNative(){
		 return repoActividad.listarTodasActividadesNative();
	}
	
	@Override
	public void editar(Actividad actividad) throws Exception {
		Optional<Actividad> optional = repoActividad.findById(actividad.getIdactividad());
		try {
			
			if(optional.isPresent()) {
				Actividad a = optional.get();
				a.setEstado(actividad.getEstado());
				repoActividad.save(a);
			}else {
				System.out.println("Actividad no encontrada");
			}
			
		}catch (Exception e) {
			String mensajeError = "Error presentado al editar la actividad";
			throw new Exception(mensajeError, e);
		}
		
	}

	@Override
	public Optional<Actividad> buscar(Integer idActividad) {
		return repoActividad.findById(idActividad);
	}

	@Override
	public void eliminar(Actividad actividad) {
		repoActividad.delete(actividad);
	}
	
	public List<EstadosDTO> obtenerEstados(){
		
		List<EstadosDTO> lista = new ArrayList<EstadosDTO>();
		
		EstadosDTO EstadosDTO = new EstadosDTO();
		EstadosDTO.setCodigo("PENDIENTE");
		EstadosDTO.setValor("PENDIENTE");
		lista.add(EstadosDTO);
		
		EstadosDTO = new EstadosDTO();
		EstadosDTO.setCodigo("REALIZADA");
		EstadosDTO.setValor("REALIZADA");
		lista.add(EstadosDTO);
		
		return lista;
		
	}

}
