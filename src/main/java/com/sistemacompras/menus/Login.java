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
    private final Gestor GESTOR = new Gestor();
    private Integer opcion;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
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
		        	MenuAdministracion menuAdministracion = new MenuAdministracion();
		        	menuAdministracion.init();
		        	
	        	case "Finanzas":
		        	MenuFinanzas menuFinanzas = new MenuFinanzas();
		        	menuFinanzas.init();
		        	
		        case "IT":
		        	MenuIT menuIT = new MenuIT();
		        	menuIT.init();
		        
		        case "Otros":
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
