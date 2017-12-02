package com.sistemacompras.multis;

import java.util.ArrayList;
import com.sistemacompras.objects.Tramite;
import static com.sistemacompras.gestorbd.Conector.getConector;;

public class MTramite {
    
    public void crearTramite(String firmaDigital, String origen, String destino, String descripcionTramite ) throws Exception{
        String sql;
        sql="INSERT INTO tTramite (DescripcionTramite, FirmaDigitalTramite, OrigenTramite, DestinoTramite) "+
        "VALUES ('"+descripcionTramite+"','"+firmaDigital+"','"+origen+"','"+destino+"');";
        
		try {
			getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El número de Tramite ya está en el sistema.");
		}

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
                rs.getString("FirmaDigitalTramite"),
                rs.getString("OrigenTramite"),
                rs.getString("DestinoTramite")
            );
        } else {
            throw new Exception ("Tramite no encontrado intentelo de nuevo.");
            }

        rs.close();
        return tramite;
    }
    
    public ArrayList<Tramite> buscarTramites() throws java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        Tramite tramite;
        ArrayList<Tramite> tramites = new ArrayList<Tramite>();
        sql="SELECT * "+
        "FROM tTramite; ";
        getConector().ejecutarSQL(sql);
        rs = getConector().ejecutarSQL(sql,true);
        
        if (rs.next()) {
            do {
            	tramite = new Tramite(
	                rs.getInt("idTramite"),
	                rs.getString("DescripcionTramite"),
	                rs.getString("FirmaDigitalTramite"),
	                rs.getString("OrigenTramite"),
	                rs.getString("DestinoTramite")
                );
		tramites.add(tramite);
		} while (rs.next());
	} else {
            throw new Exception ("No hay Tramites disponibles.");
        }

        rs.close();
        return tramites;
    }
    
    public void actualizarDestinoTramite(int idTramite, String destino) throws
        java.sql.SQLException,Exception{
        String sql;
        sql="UPDATE tTramite "+
        "SET DestinoTramite='"+destino+"'"+
        "WHERE idTramite='"+idTramite+"';";
        
            try {
                getConector().ejecutarSQL(sql); 	
            }
            catch (Exception e) {
                throw new Exception ("El Tramite no está registrado.");
            }
    }

    public void borrar(Tramite tramite) throws
        java.sql.SQLException,Exception{
        String sql;
        sql= "DELETE FROM tTramite "+
        "WHERE idTramite='"+tramite.getId()+"';";
        
            try {
                getConector().ejecutarSQL(sql);
            }
            catch (Exception e) {
                throw new Exception ("Tramite no registrado.");
            }
            
    }
}
