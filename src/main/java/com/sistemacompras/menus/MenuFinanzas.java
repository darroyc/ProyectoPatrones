package com.sistemacompras.menus;

import java.sql.SQLException;

public class MenuFinanzas extends iMenu{

	public MenuFinanzas() throws Exception {
		super("Finanzas");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void verListaTramites() throws Exception {
		print(""+GESTOR.buscarTramites("Finanzas"));
	}
	    
	@Override
	protected void aprobarTramite(int id) throws SQLException, Exception {
		print(GESTOR.cambiarDestinoTramite(id, "IT"));
	}
	
}
