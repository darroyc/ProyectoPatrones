package com.sistemacompras.menus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistemacompras.gestor.Gestor;
import com.sistemacompras.objects.Tramite;

public abstract class iMenu {
	protected ArrayList<Integer> ids = new ArrayList<Integer>();
	protected final Gestor GESTOR = new Gestor();
	protected int opcion;
	protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public iMenu(String departamento) throws Exception {
		for(Tramite tramite: GESTOR.buscarTramites(departamento)) {
			this.ids.add(tramite.getId());
		}
	}

	protected void init()throws java.sql.SQLException, Exception{
    		System.out.println("1. Ver lista tramites");
    		System.out.println("2. Aprobar tramite");
    		System.out.println("3. Solictar Tramite");
    		System.out.println("4. Salir");
    		
    		opcion = Integer.parseInt(in.readLine());
    		
    		switch(opcion) {

    		case 1:
    			verListaTramites();
    			break;
    			
    		case 2:
    			System.out.println("Ingrese el id del tramite");
    			aprobarTramite(Integer.parseInt(in.readLine()));
    			break;
    		
    		case 3:
    			MenuSolicitante menuSolicitante = new MenuSolicitante();
    			menuSolicitante.init();
    			break;
    		
    		case 4:
    			System.exit(0);
    			break;
    		
    		default:
    			System.out.println("Opción invalida");
    			break;
    		}	
    }
	
	protected abstract void verListaTramites()throws Exception;
  
	protected abstract void aprobarTramite(int id) throws SQLException, Exception;
	
	protected void print(String msg){
        System.out.println(msg);
    }
}
