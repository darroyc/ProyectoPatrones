package com.sistemacompras.multis;

import java.util.ArrayList;

import static com.sistemacompras.gestorbd.Conector.getConector;;

public class MultiTramite {
    
    public Tramite crearTramite(String descripcion, String cedulaQ) throws Exception{
        Tramite tramite=null;
        String sql;
        String cedulaJ = persona.getRandomJudgeID();
        sql="INSERT INTO tTramite (DescripcionTramite, CedulaQ, CedulaJ) "+
        "VALUES ('"+descripcion+"','"+cedulaQ+"','"+cedulaJ+"');";
        
		try {
			getConector().ejecutarSQL(sql);
			tramite = new Tramite(descripcion, persona.buscarJuezPorCedula(cedulaJ), persona.buscarQuerellante(cedulaQ));
		}
		catch (Exception e) {
			throw new Exception ("El número de Tramite ya está en el sistema.");
		}
                
        return tramite;
    }
    
    public Tramite buscarTramite(int idTramite) throws java.sql.SQLException,Exception{
        Tramite tramite = null;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM tTramite "+
        "WHERE idTramite='"+idTramite+"';";
        rs = getConector().ejecutarSQL(sql,true);

        if (rs.next()){
        	tramite = new Tramite(
                rs.getInt("idTramite"),
                rs.getString("DescripcionTramite"),
                rs.getString("EstadoTramite"),
                rs.getDate("FechaCreacion").toLocalDate()
            );
        } else {
            throw new Exception ("Tramite no encontrado intentelo de nuevo.");
            }

        rs.close();
        return tramite;
    }
    
    public ArrayList<Tramite> buscarTramitesPorJuez(String cedula) throws java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        Tramite Tramite;
        ArrayList<Tramite> tramites = new ArrayList();
        sql="SELECT * "+
        "FROM tTramite "+
        "WHERE CedulaJ='"+cedula+"';";
        getConector().ejecutarSQL(sql);
        rs = getConector().ejecutarSQL(sql,true);
        
        if (rs.next()) {
            do {
                Tramite = new Tramite(
                rs.getInt("idTramite"),
                rs.getString("DescripcionTramite"),
                rs.getString("EstadoTramite"),
                rs.getDate("FechaCreacion").toLocalDate()
                );
		tramites.add(tramite);
		} while (rs.next());
	} else {
            throw new Exception ("No hay Tramites para este juez.");
        }

        rs.close();
        return tramites;
    }
    
    public String conseguirCedulaQuerellante(int idTramite) throws java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        sql="SELECT * "+
        "FROM tTramite "+
        "WHERE idTramite='"+idTramite+"';";
        getConector().ejecutarSQL(sql);
        rs = getConector().ejecutarSQL(sql,true);
        
        if (rs.next()){
                sql = rs.getString("CedulaQ");
        } else {
            throw new Exception ("Tramite no encontrado intentelo de nuevo.");
        }

        rs.close();
        return sql;
    }
    
    public ArrayList<Tramite> buscarTramitesPorDepartamento(String cedula) throws java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        Tramite Tramite;
        ArrayList<Tramite> Tramites = new ArrayList();
        sql="SELECT * "+
        "FROM tTramite "+
        "WHERE CedulaQ='"+cedula+"';";
        getConector().ejecutarSQL(sql);
        rs = getConector().ejecutarSQL(sql,true);
        
        while (rs.next()){
            
            if (rs.next()) {
                do {
                    Tramite = new Tramite(
                    rs.getInt("idTramite"),
                    rs.getString("DescripcionTramite"),
                    rs.getString("EstadoTramite"),
                    rs.getDate("FechaCreacion").toLocalDate()
                    );
                    Tramites.add(Tramite);
                    } while (rs.next());
            } else {
                throw new Exception ("No hay Tramites para este Querellante.");
            }
        }
        rs.close();
        return Tramites;
    }
    
    public ArrayList<Historial> buscarHistorial(int idTramite) throws java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        Historial historial;
        ArrayList<Historial> historialC = new ArrayList();
        sql="SELECT * "+
        "FROM thistorial "+
        "WHERE idTramite='"+idTramite+"';";
        getConector().ejecutarSQL(sql);
        rs = getConector().ejecutarSQL(sql,true);
        
        do{
            historial = new Historial(
                rs.getDate("FechaModificacion").toLocalDate(),
                rs.getString("EstadoTramiteH")
                );
            historialC.add(historial);
        }while (rs.next());
 
        rs.close();
        return historialC;
    }

    public void actualizarEstadoTramite(int idTramite, String estado) throws java.sql.SQLException,Exception{
        String sql;
        sql="UPDATE tTramite "+
        "SET EstadoTramite='"+estado+"' "+
        "WHERE idTramite='"+idTramite+"';";

            try {
                getConector().ejecutarSQL(sql); 	
            }
            catch (Exception e) {
                throw new Exception ("El Tramite no está registrado.");
            }
    }
    
    public void actualizarResolucionTramite(int idTramite, String resolucion) throws
        java.sql.SQLException,Exception{
        String sql;
        sql="UPDATE tTramite "+
        "SET Resolucion='"+resolucion+"', EstadoTramite='Resuelto' "+
        "WHERE idTramite='"+idTramite+"';";
        
            try {
                getConector().ejecutarSQL(sql); 	
            }
            catch (Exception e) {
                throw new Exception ("El Tramite no está registrado.");
            }
    }
    
    public String consultarResolucionTramite(int idTramite) throws java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        String estado;
        sql = "SELECT EstadoTramite, Resolucion "+
        "FROM tTramite "+
        "WHERE idTramite='"+idTramite+"';";
        rs = getConector().ejecutarSQL(sql,true);

        if (rs.next()){
            sql = rs.getString("Resolucion");
            estado = rs.getString("EstadoTramite");
            
        } else {
            throw new Exception ("Tramite no encontrado intentelo de nuevo.");
            }
        
        if (!"Resuelto".equals(estado)){
            return "Pendiente de resolucion";
        }
        
        rs.close();
        return sql;
    }

    public void borrar(Tramite tramite) throws
        java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        sql= "DELETE FROM tTramite "+
        "WHERE Cedula='"+tramite.idTramite()+"';";
        
            try {
                getConector().ejecutarSQL(sql);
            }
            catch (Exception e) {
                throw new Exception ("Tramite no registrado.");
            }
            
    }
}
