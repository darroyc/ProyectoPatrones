package com.sistemacompras.menus;

import java.sql.SQLException;

public class MenuAdministracion extends iMenu{
	
	public MenuAdministracion() throws Exception {
		super("Adminisitracion");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void verListaTramites() throws Exception {
		print(""+GESTOR.buscarTramites("Administracion"));
	}
	    
	@Override
	protected void aprobarTramite(int id) throws SQLException, Exception {
		for(int idListaTramites: ids) {
			if(idListaTramites==id){
				print(GESTOR.cambiarDestinoTramite(id, "Finanzas"));
			}else {
				print("El tramite no pertenece a este departamento");
			}
		}
	}
}
