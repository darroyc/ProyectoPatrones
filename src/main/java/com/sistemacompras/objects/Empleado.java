package com.sistemacompras.objects;

public class Empleado {
	int id;
	String nombre;
	String rol;
	String constrasenna;
	int idDepartamento;
	
	public Empleado(int id, String nombre, String rol, String constrasenna, int idDepartamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rol = rol;
		this.constrasenna = constrasenna;
		this.idDepartamento = idDepartamento;
	}

	public String getConstrasenna() {
		return constrasenna;
	}

	public void setConstrasenna(String constrasenna) {
		this.constrasenna = constrasenna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@Override
	public String toString() {
		return "\nID: " + id + " Nombre: " + nombre;
	}
	
}
