/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemacompras.menus;

import com.sistemacompras.gestor.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Login {
    protected final Gestor GESTOR = new Gestor();
    protected Integer opcion;
    protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public void init()throws java.sql.SQLException, Exception{
    	try {
	        String pass;
	        int id;
	        System.out.println("Ingrese su id");
	        id = Integer.parseInt(in.readLine());
	        System.out.println("Ingrese su contrasenia");
	        pass = in.readLine();
	        switch(GESTOR.login(id, pass)){
	        	case "Administracion":
	        		System.out.println("Bienvenido al departamento de administracion");
		        	MenuAdministracion menuAdministracion = new MenuAdministracion();
		        	menuAdministracion.init();
		        	
	        	case "Finanzas":
	        		System.out.println("Bienvenido al departamento de finanza");
		        	MenuFinanzas menuFinanzas = new MenuFinanzas();
		        	menuFinanzas.init();
		        	
		        case "IT":
		        	System.out.println("Bienvenido al departamento de IT");
		        	MenuIT menuIT = new MenuIT();
		        	menuIT.init();
		        
		        case "Otros":
		        	System.out.println("Proceda a solicitar u");
		        	MenuSolicitante menuSolicitante = new MenuSolicitante();
		        	menuSolicitante.init();
		        	
		        case "":
		        	System.out.println("Contrasenna errornea");
		        	TimeUnit.SECONDS.sleep(5);
		        	init();
	        }
    	}catch(Exception e){
            System.out.println("\nOpcion invalida, intente de nuevo");
            init();
        }    
    }
}
