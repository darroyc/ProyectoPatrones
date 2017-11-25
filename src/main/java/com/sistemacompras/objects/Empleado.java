package com.sistemacompras.objects;

public class Empleado {
	String nombre;
	String id;
	String rol;
	Departamento departamento;
	
	public Empleado(String nombre, String id, String rol, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.rol = rol;
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", id=" + id + ", rol=" + rol + ", departamento=" + departamento + "]";
	}
	
}
