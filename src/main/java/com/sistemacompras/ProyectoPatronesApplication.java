package com.sistemacompras;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.sistemacompras.menus.*;

@SpringBootApplication
public class ProyectoPatronesApplication {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws SQLException, Exception {
		new SpringApplicationBuilder()
	    .bannerMode(Banner.Mode.OFF)
	    .sources(ProyectoPatronesApplication.class)
	    .run(args);
		Menu menu = new Menu();
		menu.login();
		
	}	
}
