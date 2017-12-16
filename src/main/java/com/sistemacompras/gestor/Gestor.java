 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemacompras.gestor;

import com.sistemacompras.multis.*;
import com.sistemacompras.objects.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Gestor {
	
    private static final MDepartamento DEPARTAMENTO  = new MDepartamento();
    private static final MTramite TRAMITE = new MTramite();
    private static final MEmpleado EMPLEADO = new MEmpleado();
    private static Empleado empleadoActivo;
    
    public Integer login(int id, String pass) throws Exception{
        empleadoActivo = EMPLEADO.buscarPorID(id);
        if(empleadoActivo.getConstrasenna().equals(pass)){
        	return empleadoActivo.getIdDepartamento();
        	}
       return null;
    }

    public void crearTramite(String nombreTramite, String descripcionTramite ,
    		String contenidoTramite, String firmaDigTramite, String origenTramite, String destinoTramite) throws Exception {
    	
    	TRAMITE.crearTramite(nombreTramite, descripcionTramite, contenidoTramite, firmaDigTramite, 
    			origenTramite, destinoTramite);
    }
    
    public void buscarTramite(int pIdTramite) throws SQLException, Exception {
    	TRAMITE.buscarTramite(pIdTramite);
    }
    
    public void buscarTramitePorNombre(String pnombre) throws Exception {
    	TRAMITE.buscarTramitePorNombre(pnombre);
    }
    
    public void cambiarDestinoTramite(int pid, String pdestino) throws SQLException, Exception {
    	TRAMITE.actualizarDestinoTramite(pid, pdestino);
    }
    
    public void crearDepartamento(String nombreDepartamento) throws Exception {
    	DEPARTAMENTO.crear("ElDepartament");
    }
}
