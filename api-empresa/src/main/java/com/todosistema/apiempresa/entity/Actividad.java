package com.todosistema.apiempresa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Actividad")
public class Actividad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idactividad;
	private String nombre;
	private Date fechaCreada;
	private Date fechaEjecutada;
	private String estado;
	
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
	
	
	@Override
	public String toString() {
		return "Actividad [idactividad=" + idactividad + ", nombre=" + nombre + ", fechaCreada=" + fechaCreada
				+ ", fechaEjecutada=" + fechaEjecutada + ", estado=" + estado + "]";
	}
	
	

}
