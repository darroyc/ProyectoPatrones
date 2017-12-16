package com.sistemacompras.menus;

import java.sql.SQLException;
import com.sistemacompras.multis.MTramite;

public class MenuAdministracion implements IEstado{

	MTramite tramite = new MTramite();
	
	@Override
	public void aprobarEstado(int id) throws SQLException, Exception {
		tramite.actualizarDestinoTramite(id, "Finanzas");
	}

	
}
