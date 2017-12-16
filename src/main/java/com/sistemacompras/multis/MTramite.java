package com.sistemacompras.multis;

import java.util.ArrayList;

import com.sistemacompras.encriptacion.ControladorEncriptacion;
import com.sistemacompras.objects.Departamento;
import com.sistemacompras.objects.Tramite;
import static com.sistemacompras.gestorbd.Conector.getConector;


public class MTramite {
	ControladorEncriptacion encriptarMensaje = new ControladorEncriptacion();
	Tramite tramite;
	 MDepartamento buscardepartamento = new MDepartamento();
	 Departamento departamento;
<<<<<<< HEAD
    public void crearTramite(String nombreTramite,String descripcionTramite,String contenidoTramite,String firmaDigital,String origen,String destino) throws Exception{
=======
    public void crearTramite(String descripcionTramite,String contenidoTramite,
    		String firmaDigital,String origen,String destino) throws Exception{
>>>>>>> cadb47d991f56d3bc25a39c2318822685bf85eff
        String sql;
        String llavePublica;
        String mensajeEncriptado;
        
        departamento = buscardepartamento.buscarPorNombre(origen);
        llavePublica= departamento.getLlavePublica();
        mensajeEncriptado= encriptarMensaje.encryptMessage(contenidoTramite, llavePublica);
        
        sql="INSERT INTO tTramite (NombreTramite,DescripcionTramite,ContenidoTramite, FirmaDigitalTramite, OrigenTramite, DestinoTramite) "+
        "VALUES ('"+nombreTramite+"','"+descripcionTramite+"','"+mensajeEncriptado+"','"+firmaDigital+"','"+origen+"','"+destino+"');";
        
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
                rs.getString("NombreTramite"),
                rs.getString("DescripcionTramite"),
                rs.getString("ContenidoTramite"),
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
    public Tramite buscarTramitePorNombre(String nombreTramite) throws SQLException, Exception {
    	 Tramite tramite;
         java.sql.ResultSet rs;
         String sql;
         sql = "SELECT * "+
         "FROM tTramite "+
         "WHERE NombreTramite='"+nombreTramite+"';";
         rs = getConector().ejecutarSQL(sql,true);

         if (rs.next()){
         	tramite = new Tramite(
                 rs.getInt("idTramite"),
                 rs.getString("NombreTramite"),
                 rs.getString("DescripcionTramite"),
                 rs.getString("ContenidoTramite"),
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
	                rs.getString("nombreTramite"),
	                rs.getString("DescripcionTramite"),
	                rs.getString("ContenidoTramite"),
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
