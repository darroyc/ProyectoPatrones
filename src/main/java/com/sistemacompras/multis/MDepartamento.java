package com.sistemacompras.multis;

import static com.sistemacompras.gestorbd.Conector.getConector;
import java.util.ArrayList;

import com.sistemacompras.encriptacion.ControladorEncriptacion;
import com.sistemacompras.objects.Departamento;
import com.sistemacompras.objects.Empleado;

public class MDepartamento {
	ArrayList<String> listaLlaves = new ArrayList<String>();
	
	public void crearDepartamento(String nombreDepartamento) throws Exception {
		String sql;
		ControladorEncriptacion encrytar = new ControladorEncriptacion();
		listaLlaves =  encrytar.crearLlaves();
			sql ="insert into tdepartamento (NombreDepartamento,LlavePublica,LlavePrivada)"+
					"values('"+nombreDepartamento+"','"+listaLlaves.get(1)+"','"+listaLlaves.get(0)+"');";
			try {
				getConector().ejecutarSQL(sql);
			} catch (Exception e) {
				throw new Exception ("El departamento ya existe en el sistema.");
					
			}	
		
	}
    
    public Departamento buscarDepartamentoPorId(int idDepartamento) throws java.sql.SQLException,Exception{
       Departamento departamento;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM tDepartamento "+
        "WHERE idDepartamento='"+idDepartamento+"';";
        rs = getConector().ejecutarSQL(sql,true);

        if (rs.next()){
        	departamento = new Departamento(
                rs.getInt("idDepartamento"),
                rs.getString("NombreDepartamento"),
                buscarEmpleadosPorDepartamento(idDepartamento)
            );
        } else {
            throw new Exception ("Departamento no encontrado intentelo de nuevo.");
            }

        rs.close();
        return departamento;
    }
    public Departamento buscarDepartamentoPorNombre(String nombreDepartamento) throws java.sql.SQLException,Exception{
        Departamento departamento;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM tDepartamento "+
        "WHERE NombreDepartamento='"+nombreDepartamento+"';";
        rs = getConector().ejecutarSQL(sql,true);

        if (rs.next()){
        	departamento = new Departamento(
                rs.getInt("idDepartamento"),
                rs.getString("NombreDepartamento"),
                rs.getString("LlavePublica"),
                rs.getString("LlavePrivada")
                
            );
        } else {
            throw new Exception ("Departamento no encontrado intentelo de nuevo.");
            }

        rs.close();
        return departamento;
    }
    
    public ArrayList<Departamento> buscarDepartamentos() throws java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        Departamento departamento;
        ArrayList<Departamento> Departamentos = new ArrayList<Departamento>();
        sql="SELECT * "+
        "FROM tDepartamento; ";
        getConector().ejecutarSQL(sql);
        rs = getConector().ejecutarSQL(sql,true);
        
        if (rs.next()) {
            do {
            	departamento = new Departamento(
                        rs.getInt("idDepartamento"),
                        rs.getString("NombreDepartamento"),
                        buscarEmpleadosPorDepartamento(rs.getInt("idDepartamento"))
                    );
		Departamentos.add(departamento);
		} while (rs.next());
	} else {
            throw new Exception ("No hay Departamentos disponibles.");
        }

        rs.close();
        return Departamentos;
    }
    
    public ArrayList<Empleado> buscarEmpleadosPorDepartamento(int idDepartamento)
    		throws java.sql.SQLException,Exception{
        java.sql.ResultSet rs;
        String sql;
        Empleado empleado;
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        sql="SELECT * "+
        "FROM tEmpleado" + 
        "WHERE idDepartamento='"+idDepartamento+"';";
        getConector().ejecutarSQL(sql);
        rs = getConector().ejecutarSQL(sql,true);
        
        if (rs.next()) {
            do {
            	empleado = new Empleado(
	                rs.getInt("idEmpleado"),
	                rs.getString("nombreEmpleado"),
	                rs.getString("RolEmpleado"),
	                rs.getString("ContrasennaEmpleado")
                );
		empleados.add(empleado);
		} while (rs.next());
	} else {
            throw new Exception ("No hay Departamentos disponibles.");
        }

        rs.close();
        return empleados;
    }

    public void borrar(Departamento departamento) throws
        java.sql.SQLException,Exception{
        String sql;
        sql= "DELETE FROM tDepartamento "+
        "WHERE idDepartamento='"+departamento.getId()+"';";
        
            try {
                getConector().ejecutarSQL(sql);
            }
            catch (Exception e) {
                throw new Exception ("Departamento no registrado.");
            }
            
    }
    
    public void actualizarLlavePublica(int idDepartamento, String llavePublica) throws
    java.sql.SQLException,Exception{
    String sql;
    sql="UPDATE tDepartamento "+
    "SET LlavePublica='"+llavePublica+"'"+
    "WHERE idDepartamento='"+idDepartamento+"';";
    
        try {
            getConector().ejecutarSQL(sql); 	
        }
        catch (Exception e) {
            throw new Exception ("El Departamento no está registrado.");
        }
}
	
    public String buscarLlavePublica(int idDepartamento) throws java.sql.SQLException,Exception{
        String llavePublica;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM tDepartamento "+
        "WHERE Departamento='"+idDepartamento+"';";
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
