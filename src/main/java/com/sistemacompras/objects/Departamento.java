package com.sistemacompras.objects;

import java.util.ArrayList;

public class Departamento {
	int id;
	String nombre;
	ArrayList<Empleado> listaEmpleados;
	
	public Departamento(int id, String nombre, ArrayList<Empleado> listaEmpleados) {
		this.id = id;
		this.nombre = nombre;
		this.listaEmpleados = listaEmpleados;
	}
	public Departamento(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", listaEmpleados=" + listaEmpleados + "]";
	}

	
}
