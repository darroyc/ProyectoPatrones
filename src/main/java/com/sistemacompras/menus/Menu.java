/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemacompras.menus;

import com.sistemacompras.enums.Departamentos;
import com.sistemacompras.gestor.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
    protected final Gestor GESTOR = new Gestor();
    protected int option;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public void login()throws java.sql.SQLException, Exception{
        String pass;
        int id;
        print("\nIngrese su id");
        id = Integer.parseInt(in.readLine());
        print("\nIngrese su contrasenia");
        pass = in.readLine();
        
        Integer opcion = GESTOR.login(id, pass);
        if(!opcion.equals(null)){
        	FabricaMenu.crearNuevoMenu(Departamentos.values()[opcion-1]);
        }else{
        	login();
        }
    }
    
    protected void print(String msg){
        System.out.println(msg);
    }
}
