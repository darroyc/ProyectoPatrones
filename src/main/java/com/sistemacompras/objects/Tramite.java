package com.sistemacompras.objects;

public class Tramite {
	int id;
	String descripcion;
	String contenido;
	String firmaDigital;
	String origen;
	String destino;
	
	public Tramite(int id, String descripcion,String contenido, String firmaDigital, String origen, String destino) {
		this.id = id;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.firmaDigital = firmaDigital;
		this.origen = origen;
		this.destino = destino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFirmaDigital() {
		return firmaDigital;
	}

	public void setFirmaDigital(String firmaDigital) {
		this.firmaDigital = firmaDigital;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Tramite [id=" + id + ", descripcion=" + descripcion + ", firmaDigital=" + firmaDigital + ", origen="
				+ origen + ", destino=" + destino + "]";
	}
	
}
