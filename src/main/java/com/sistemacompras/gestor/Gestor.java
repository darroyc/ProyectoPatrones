 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemacompras.gestor;

import com.sistemacompras.multis.*;
import com.sistemacompras.objects.*;

import java.util.ArrayList;

public class Gestor {
    private static final MDepartamento DEPARTAMENTO  = new MDepartamento();
    private static final MTramite TRAMITE = new MTramite();
    private static final MEmpleado EMPLEADO = new MEmpleado();
    private static Empleado empleadoActivo;
    private static String cedula;
    
    public Integer login(int id, String pass) throws Exception{
        empleadoActivo = EMPLEADO.buscarPorID(id);
        if(empleadoActivo.getConstrasenna().equals(pass)){
        	return empleadoActivo.getIdDepartamento();
        	}

       return null;
    }

}
