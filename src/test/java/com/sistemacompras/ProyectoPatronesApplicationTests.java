package com.sistemacompras;

import org.junit.runner.RunWith;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProyectoPatronesApplicationTests implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplicationTests.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
