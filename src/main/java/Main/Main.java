package Main;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sistemacompras.encriptacion.ControladorEncriptacion;
import com.sistemacompras.multis.MDepartamento;
import com.sistemacompras.multis.MTramite;
import com.sistemacompras.objects.Departamento;
import com.sistemacompras.objects.Tramite;

public class Main {
	
	
	
	public static void main(String[] args) throws SQLException, Exception {
		String privateKey, message;
		Departamento depa;
		Tramite tramite;
		MTramite pruebaTramite = new MTramite();
		MDepartamento pruebaDepartamento = new MDepartamento();
		ControladorEncriptacion encrypt = new ControladorEncriptacion();
		
		depa = pruebaDepartamento.buscarDepartamentoPorNombre("QA");	
		
		privateKey = depa.getLlavePrivada();
		tramite =  pruebaTramite.buscarTramite(16);
		message = tramite.getContenido();
		System.out.println(message = tramite.getContenido());
		
		encrypt.decryptMessage(message, privateKey);
		
		
		
		
		
		
		
		
		
		
		
		
	
//		
//		try {
//			pruebaTramite.crearTramite("Tramite de los vasos", "Este tramite se hizo hoy", " mas vasos para la fiesta de la alegria",
//					"DVC", "Ventas", "IT");
//			System.out.println("Se logro la insercion de datos");
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
	
	
	
		
		
//		try {
//			pruebaDepartamento.crearDepartamento("QA");
//			System.out.println("Se logro la insercion de datos");
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
		
	
//		pruebaTramite = new MTramite();
//		pruebaTramite.crearTramite("Esto es un tramite de prueba", "contenido a encriptar", "Firma", "Logistica", "IT");
		
		
		
	
	}
	


}
