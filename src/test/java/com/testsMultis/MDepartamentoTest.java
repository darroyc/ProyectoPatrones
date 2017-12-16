package com.testsMultis;

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
		dep.crear("Contaduria");
	}
	
	@Test
	public void testBuscarDep() throws Exception{
		dep.buscarPorId(1);
	}
	
	@Test
	public void testBuscarDepPorNombre() throws Exception{
		dep.buscarPorNombre("IT");
	}
	
	@Test
	public void testBuscarDepS() throws Exception{
		dep.buscarLlavePublica(2);
	}
	
	@Test
	public void testBuscarEmpPorDep() throws Exception{
		dep.actualizarLlavePublica(2, "2");
	}
	
}
