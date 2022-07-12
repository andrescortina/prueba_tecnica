package com.todosistema.apiempresa.dto;

import java.util.Date;

public class ActividadDTO {
	
	private Integer idactividad;
	private String nombre;
	private Date fechaCreada;
	private Date fechaEjecutada;
	private String estado;
	private String empleado;
    private Integer idempleado;
    private Integer dias;
	public Integer getIdactividad() {
		return idactividad;
	}
	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaCreada() {
		return fechaCreada;
	}
	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}
	public Date getFechaEjecutada() {
		return fechaEjecutada;
	}
	public void setFechaEjecutada(Date fechaEjecutada) {
		this.fechaEjecutada = fechaEjecutada;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	public Integer getIdempleado() {
		return idempleado;
	}
	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	
	

}
