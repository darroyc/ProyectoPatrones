package com.sistemacompras.menus;

import java.sql.SQLException;

public interface IEstado {
	public void aprobarEstado(int id) throws SQLException, Exception;
}
