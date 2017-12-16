package com.sistemacompras.multis;
import static com.sistemacompras.gestorbd.Conector.getConector;

import com.sistemacompras.objects.Empleado;

public class MEmpleado {
	
	public Empleado buscarPorID(int idEmpleado) throws java.sql.SQLException,Exception{
	       Empleado empleado;
	        java.sql.ResultSet rs;
	        String sql;
	        sql = "SELECT * "+
	        "FROM tEmpleado "+
	        "WHERE idEmpleado='"+idEmpleado+"';";
	        rs = getConector().ejecutarSQL(sql,true);

	        if (rs.next()){
	        	empleado = new Empleado(
		                rs.getInt("idEmpleado"),
		                rs.getString("nombreEmpleado"),
		                rs.getString("RolEmpleado"),
		                rs.getString("ContrasennaEmpleado"),
		                rs.getInt("idDepartamento")
	                );
	        } else {
	            throw new Exception ("Departamento no encontrado intentelo de nuevo.");
	            }

	        rs.close();
	        return empleado;
	    }

}
