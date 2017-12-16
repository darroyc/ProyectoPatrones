package com.sistemacompras.menus;

import com.sistemacompras.enums.Departamentos;

public class MenuIT extends Menu{

    public void menuIt()throws java.sql.SQLException, Exception{
    	
    	boolean continuar = true;
    	int opc = 0;
    	String dato = "";
    	
    	do {
    		System.out.println("Opcion1");
    		System.out.println("Opcion1");
    		System.out.println("Opcion1");
    		System.out.println("Opcion1");
    		
    		dato = in.readLine();
    		opc = Integer.parseInt(dato);
    		
    		switch(opc) {
    		
    		case 1:
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
//
//        print("\nIngrese su id");
//        id = Integer.parseInt(in.readLine());
//        print("\nIngrese su contrasenia");
//        pass = in.readLine();
        
        opcion = GESTOR.login(id, pass);
        if(!opcion.equals(null)){
        	FabricaMenu.crearNuevoMenu(Departamentos.values()[opcion-1]);
        }else{
        	login();
        }
    }
}
