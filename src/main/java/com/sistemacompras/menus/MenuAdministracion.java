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
		print(GESTOR.cambiarDestinoTramite(id, "Finanzas"));
	}

	
}
