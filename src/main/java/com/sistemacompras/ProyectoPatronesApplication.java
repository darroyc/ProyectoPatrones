package com.sistemacompras;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.sistemacompras.menus.*;


@SpringBootApplication
@Configuration
@PropertySource("classpath:application.properties")
public class ProyectoPatronesApplication {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	@Autowired
	public static Environment env;
	
	public static void main(String[] args) throws SQLException, Exception {
		new SpringApplicationBuilder()
	    .bannerMode(Banner.Mode.OFF)
	    .sources(ProyectoPatronesApplication.class)
	    .run(args);
		Menu menu = new Menu();
		menu.login();
		
			
	}	
}
