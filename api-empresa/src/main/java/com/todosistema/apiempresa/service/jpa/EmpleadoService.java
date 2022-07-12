package com.todosistema.apiempresa.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todosistema.apiempresa.entity.Empleado;
import com.todosistema.apiempresa.repository.EmpleadoRepository;
import com.todosistema.apiempresa.service.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService{
	
	@Autowired
	private EmpleadoRepository repoEmpleado;

	@Override
	public List<Empleado> listarTodos() {
		return repoEmpleado.findAll();
	}

}
