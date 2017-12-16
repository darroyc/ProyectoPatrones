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

public class Menu {
    protected final Gestor GESTOR = new Gestor();
    protected Integer opcion;
    protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public void login()throws java.sql.SQLException, Exception{
    	try {
	        String pass;
	        int id;
	        print("\nIngrese su id");
	        id = Integer.parseInt(in.readLine());
	        print("\nIngrese su contrasenia");
	        pass = in.readLine();
	        switch(GESTOR.login(id, pass)){
	        	case "Administracion":
		        	MenuAdministracion menuAdministracion = new MenuAdministracion();
		        	//menuAdministracion.init();
		        	
	        	case "Finanzas":
		        	MenuFinanzas menuFinanzas = new MenuFinanzas();
		        	//menuFinanzas.init();
		        	
		        case "IT":
		        	MenuIT menuIT = new MenuIT();
		        	menuIT.init();
		        
		        case "Otros":
		        	MenuSolicitante menuSolicitante = new MenuSolicitante();
		        	//menuSolicitante.init();
		        case "":
		        	print("Contrasenna errornea");
		        	TimeUnit.SECONDS.sleep(5);
		        	login();
	        }
	    }catch(Exception e){
	        System.out.println("\nOpcion invalida, intente de nuevo");
	        login();
		}
    }
    
    protected void print(String msg){
        System.out.println(msg);
    }
}
