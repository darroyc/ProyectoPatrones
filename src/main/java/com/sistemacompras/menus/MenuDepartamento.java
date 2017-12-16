package com.sistemacompras.menus;

import com.sistemacompras.gestor.Gestor;
import com.sistemacompras.multis.*;
import com.sistemacompras.objects.Tramite;

public class MenuDepartamento extends Menu{
	
	Gestor gestor1 = new Gestor();
	
    public void init()throws java.sql.SQLException, Exception{
    	
    	boolean continuar = true;
    	int opc = 0;
    	String dato = "";
    	
    	try {
	    	do {
	    		System.out.println("1. Crear departamento");
	    		System.out.println("2. Encriptar tramite");
	    		System.out.println("3. Listar tramites");
	    		System.out.println("4.  ");
	    		
	    		dato = in.readLine();
	    		opc = Integer.parseInt(dato);
	    		
	    		switch(opc) {
	
	    		case 1:
	    	
	    			String nombreDepartamento = "";
	        		
	        		System.out.println("Cual sera el nombre de este departamento?");
	        		nombreDepartamento = in.readLine();
	        		
	
	        		gestor1.crearDepartamento(nombreDepartamento);
	
	    			break;
	    		
	    		case 2:
	    			break;
	    		case 3:
	    			break;
	    		
	    		case 4:
	    			break;
	    			
	    		default:
	    			break;
	    		}
	    	}
	    	while(continuar);
    	}catch(Exception e){
            System.out.println("\nOpcion invalida, intente de nuevo");
            init();
		}
//
//        print("\nIngrese su id");
//        id = Integer.parseInt(in.readLine());
//        print("\nIngrese su contrasenia");
//        pass = in.readLine();
        
//        opcion = GESTOR.login(id, pass);
//        if(!opcion.equals(null)){
//        	FabricaMenu.crearNuevoMenu(Departamentos.values()[opcion-1]);
//        }else{
//        	login();
//        }
    }
}
