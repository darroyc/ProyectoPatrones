package com.testsMultis;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sistemacompras.multis.MTramite;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MTramiteTest {
	
	private static MTramite tramite;
	
	@BeforeClass
	public static void init(){
		tramite = new MTramite();
	}
	
	@Test
	public void testCrearTramite() throws Exception{
		tramite.crearTramite("Compra", "XY", "LL", "MM", "IT","");
	}
	
	@Test
	public void testBorrarTramite() throws Exception{
		tramite.buscarTramite(1);
	}
	
	@Test
	public void testBuscarTramites() throws Exception{
		tramite.buscarTramites();
	}
	
	@Test
	public void testActualizarDestino() throws Exception{
		tramite.actualizarDestinoTramite(1, "Administración");
	}
	
}
