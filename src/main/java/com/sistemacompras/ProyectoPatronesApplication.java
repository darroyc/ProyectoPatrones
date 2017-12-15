package com.sistemacompras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemacompras.gestor.Gestor;

@SpringBootApplication
public class ProyectoPatronesApplication {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Gestor gestor = new Gestor();

	public static void main(String[] args) throws IOException {
		
	logging();

		
	}
	public static void logging() throws IOException {
		String contraseña;
		
		System.out.println("********************************");
		System.out.println("Por favor ingrese su contraseña");
		System.out.println("********************************");
		contraseña = br.readLine();
		gestor.comprobarUsuario(contraseña);
		
		
	
	}
	
	
}
