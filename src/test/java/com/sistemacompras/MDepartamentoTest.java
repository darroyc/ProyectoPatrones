package com.sistemacompras;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sistemacompras.multis.MDepartamento;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MDepartamentoTest {

	private static MDepartamento dep;
	
	@BeforeClass
	public static void init(){
		dep = new MDepartamento();
	}
	
	@Test
	public void testCrearDep() throws Exception{
		dep.crearDepartamento("Contaduria");
	}
	
}
