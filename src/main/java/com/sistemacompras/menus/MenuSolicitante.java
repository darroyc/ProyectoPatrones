package com.sistemacompras.menus;

import java.sql.SQLException;

import com.sistemacompras.gestor.Gestor;

public class MenuSolicitante extends Login{
	
	Gestor gestor1 = new Gestor();

    public void init()throws java.sql.SQLException, Exception{
    	
    	boolean continuar = false;
    	int opc = 0;
    	String dato = "";
    	
    	do {
    		System.out.println("1. Crear Tramite");
    		System.out.println("2. Buscar tramite por id");
    		System.out.println("3. Buscar tramite por nombre");
    		System.out.println("4. Cambiar destino de tramite");
    		System.out.println("5. Opción ver estado del tramite");
    		System.out.println("6. Salir");
    		
    		dato = in.readLine();
    		opc = Integer.parseInt(dato);
    		
    		switch(opc) {

    		case 1:
    			crearTramite();
    			break;
    			
    		case 2:
    			buscarTramiteId();
    			break;
    		case 3:
    			buscarTramiteNombre();
    			break;
    		case 4:
    			cambiarDestino();
    			break;
    		case 5:
    			
    			break;
    		case 6:
    			continuar = false;
    			break;
    		default:
    			System.out.println("Opción invalida");
    			break;
    		}
    	}
    	while(continuar);

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
    
    public void cambiarDestino() throws SQLException, Exception {
    	int id;
    	String destino;
    	
    	System.out.println("Ingrese la identificación");
    	id = Integer.parseInt(in.readLine());
    	System.out.println("Ingrese el destino");
    	destino = in.readLine();
    	
    	gestor1.cambiarDestinoTramite(id, destino);
    }

}
