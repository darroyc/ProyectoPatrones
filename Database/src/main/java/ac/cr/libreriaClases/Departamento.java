package ac.cr.libreriaClases;

import java.util.Arrays;

public class Departamento {
	String nombre;
	String id;
	Empleado listaEmpleados[] = new Empleado[10];
	
	public Departamento(String nombre, String id, Empleado[] listaEmpleados) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.listaEmpleados = listaEmpleados;
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
	public Empleado[] getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(Empleado[] listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	@Override
	public String toString() {
		return "Departamento [nombre= \n" + nombre + ", id=" + id + ", listaEmpleados=" + Arrays.toString(listaEmpleados)
				+ "]";
	}
	
}
