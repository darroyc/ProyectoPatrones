package com.sistemacompras.objects;

public class Tramite {
	int id;
	String firmaDigital;
	String origen;
	String destino;

	
	public Tramite(int id, String firmaDigital, String origen, String destino) {
		super();
		this.firmaDigital = firmaDigital;
		this.origen = origen;
		this.destino = destino;
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Tramite [firmaDigital=" + firmaDigital + ", origen=" + origen + ", destino=" + destino + ", id=" + id
				+ "]";
	}
	
}
