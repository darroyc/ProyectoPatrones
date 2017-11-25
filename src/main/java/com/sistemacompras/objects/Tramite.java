package com.sistemacompras.objects;

import java.util.ArrayList;

public class Tramite {
	String firmaDigital;
	String origen;
	String destino;
	String id;
	ArrayList<String> listaTramites = new ArrayList<String>();
	
	public Tramite(String firmaDigital, String origen, String destino, String id, ArrayList<String> listaTramites) {
		super();
		this.firmaDigital = firmaDigital;
		this.origen = origen;
		this.destino = destino;
		this.id = id;
		this.listaTramites = listaTramites;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getListaTramites() {
		return listaTramites;
	}

	public void setListaTramites(ArrayList<String> listaTramites) {
		this.listaTramites = listaTramites;
	}

	@Override
	public String toString() {
		return "Tramite [firmaDigital=" + firmaDigital + ", origen=" + origen + ", destino=" + destino + ", id=" + id
				+ ", listaTramites=" + listaTramites + "]";
	}
	
}
