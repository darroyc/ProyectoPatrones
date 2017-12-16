package com.sistemacompras;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemacompras.menus.*;

@SpringBootApplication
public class ProyectoPatronesApplication {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws SQLException, Exception {
		SpringApplication.run(Menu.class, args);
	}	
}
