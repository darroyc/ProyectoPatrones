package com.sistemacompras.menus;

import java.sql.SQLException;

import com.sistemacompras.gestor.Gestor;

public class MenuSolicitante extends Login{
	
	Gestor gestor1 = new Gestor();

    public void init()throws java.sql.SQLException, Exception{
    	
    	int opc = 0;
    	String dato = "";
    	
		System.out.println("1. Crear Tramite");
		System.out.println("2. Salir");
		
		dato = in.readLine();
		opc = Integer.parseInt(dato);
		
		switch(opc) {

		case 1:
			crearTramite();
			break;
			
		case 4:
			System.exit(0);
		
		default:
			System.out.println("Opción invalida");
			init();
			break;
		}

    }
    
    public void crearTramite() throws Exception {
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
		
		System.out.println("Digite la firma digital.");
		firmaDigTramite = in.readLine();
		
		gestor1.crearTramite(nombreTramite, descripcionTramite, contenidoTramite, firmaDigTramite);
    }
    
    public void buscarTramiteId() throws SQLException, Exception {
    	int idTramite;
    	
    	System.out.println("Ingrese la identificación del tramite que desea buscar");
    	idTramite = Integer.parseInt(in.readLine());
    	
    	gestor1.buscarTramite(idTramite);
    	
    }
    
    public void buscarTramiteNombre() throws Exception {
    	String nombre = "";
    	
    	System.out.println("Ingrese el nombre del tramite que desea buscar");
    	nombre = in.readLine();
    	
    	gestor1.buscarTramitePorNombre(nombre);
    }
    

}
