package com.sistemacompras.menus;

import com.sistemacompras.enums.Departamentos;

public class FabricaMenu {
	
	public static Menu crearNuevoMenu(Departamentos type) throws Exception {

		switch(type){
			case Administracion:
				return new MenuAdministracion();
			case Finanzas:
				return new MenuFinanzas();
			case IT:
				return new MenuIT();
			case Otros:
				return new MenuSolicitante();
		}
		throw new Exception("Tipo de cuenta imposible");
	}
}
