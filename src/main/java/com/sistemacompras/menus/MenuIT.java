package com.sistemacompras.menus;

import com.sistemacompras.enums.Departamentos;
import com.sistemacompras.gestor.Gestor;
import com.sistemacompras.multis.*;
import com.sistemacompras.objects.Tramite;

public class MenuIT extends Menu{
	
	Gestor gestor1 = new Gestor();

    public void init()throws java.sql.SQLException, Exception{
    	
    	boolean continuar = true;
    	int opc = 0;
    	String dato = "";
    	
    	do {
    		System.out.println("1. Crear Tramite");
    		System.out.println("2. Encriptar tramite");
    		System.out.println("3. Listar tramites");
    		System.out.println("4.  ");
    		
    		dato = in.readLine();
    		opc = Integer.parseInt(dato);
    		
    		switch(opc) {

    		case 1:
    			String nombreTramite = "";
    			String descripcionTramite = "";
    			String contenidoTramite = "";
    			String firmaDigTramite = "";
    			String origenTramite = "";
    			String destinoTramite = "";
        		
        		System.out.println("Deme el nombre de su tramite");
        		nombreTramite = in.readLine();
        		
        		System.out.println("Describa al tramite.");
        		descripcionTramite = in.readLine();
        		
        		System.out.println("Ingrese textualmente el contenido del traminte.");
        		contenidoTramite = in.readLine();
        		
        		System.out.println("Ingrese su firma Digital");
        		firmaDigTramite = in.readLine();
        		
        		System.out.println("Digite el origen del tramite.");
        		origenTramite = in.readLine();
        		
        		System.out.println("Digite el destino del traminte");
        		destinoTramite = in.readLine();
        		

        		
        		gestor1.crearTramite(nombreTramite, descripcionTramite, contenidoTramite, firmaDigTramite, origenTramite, destinoTramite);

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
        
//        opcion = GESTOR.login(id, pass);
//        if(!opcion.equals(null)){
//        	FabricaMenu.crearNuevoMenu(Departamentos.values()[opcion-1]);
//        }else{
//        	login();
//        }
    }
}
