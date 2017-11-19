package com.sistemacompras.multis;

import static com.sistemacompras.gestorbd.Conector.getConector;

public class MultiLlavePublica {
        
    public String buscar(String departamento) throws java.sql.SQLException,Exception{
        String llavePublica;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM tLlavePublica "+
        "WHERE Departamento='"+departamento+"';";
        rs = getConector().ejecutarSQL(sql,true);

        if (rs.next()){
        	llavePublica = rs.getString("LlavePublica");
        } else {
            throw new Exception ("Llave Publica no encontrada intentelo de nuevo.");
            }

        rs.close();
        return llavePublica;
    }
    
}
