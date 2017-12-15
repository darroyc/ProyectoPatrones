package com.sistemacompras.objects;

public class Empleado {
	int id;
	String nombre;
	String rol;
	String constrasenna;
	
	public Empleado(int id, String nombre, String rol,String constrasenna) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.rol = rol;
		this.constrasenna = constrasenna;
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

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", id=" + id + ", rol=" + rol + "]";
	}
	
}
