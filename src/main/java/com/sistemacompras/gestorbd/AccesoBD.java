package com.sistemacompras.gestorbd;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBD{
	private Connection conn=null;
	private Statement st;
	
	public AccesoBD(String conexion) throws SQLException,Exception{
		try {
        conn = DriverManager.getConnection(conexion);
		st = conn.createStatement();
                } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
	}
	
	public void ejecutarSQL(String sentencia) throws SQLException,Exception{	
		st.execute(sentencia);		
	}
	
	public ResultSet ejecutarSQL(String sentencia, boolean retorno) throws SQLException,Exception{
		ResultSet rs;
		rs = st.executeQuery(sentencia);
		return rs;
	}
	
	public void iniciarTransaccion() throws java.sql.SQLException{
		conn.setAutoCommit(false);	
	}

		
	public void terminarTransaccion() throws java.sql.SQLException{
		conn.setAutoCommit(true);
	}
	
	public void aceptarTransaccion() throws java.sql.SQLException{
		conn.commit();
	}
	
	public void deshacerTransaccion() throws java.sql.SQLException{
		conn.rollback();	
	}
	
	@Override
	protected void finalize(){
		try {
			conn.close();	
		}
		catch(Exception e){
					
		}
	}				
}
