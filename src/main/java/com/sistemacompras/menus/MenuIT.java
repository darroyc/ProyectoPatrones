package com.sistemacompras.menus;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sistemacompras.multis.MTramite;

public class MenuIT extends iMenu{	
	
	public MenuIT() throws Exception {
		super("IT");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void verListaTramites() throws Exception {
		print(""+GESTOR.buscarTramites("IT"));
	}   

	@Override
	protected void aprobarTramite(int id) throws SQLException, Exception {
		print(GESTOR.cambiarDestinoTramite(id, "Pendiente de entrega"));
	}

	
}
