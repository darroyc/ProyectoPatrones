package Main;

import java.security.KeyPair;
import java.sql.SQLException;
import java.util.ArrayList;

import org.assertj.core.data.Percentage;

import com.sistemacompras.encriptacion.ControladorEncriptacion;
import com.sistemacompras.multis.MDepartamento;
import com.sistemacompras.multis.MTramite;
import com.sistemacompras.objects.Departamento;
import com.sistemacompras.objects.Tramite;

public class Main {
	
	private static KeyPair kp;
	
	public static void main(String[] args) throws SQLException, Exception {
		byte[] llavePublica;
		MDepartamento pruebaDepartamento =  new MDepartamento();
		Departamento departamento;
		departamento = pruebaDepartamento.buscarPorNombre("VoIP");
		
		llavePublica = departamento.getLlavePublica();
		MTramite pruebaTramite = new MTramite();
	try {
			pruebaTramite.crearTramite("Tramite vasos", "un tramite como cualquiera", "queremos mas vasos", "DVC", "VoIP", "QA");
			System.out.println("Se logro la insercion de datos");
	} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
		
		
		
	
//		
//		try {
//			pruebaTramite.crearTramite("Tramite de los vasos", "Este tramite se hizo hoy", " mas vasos para la fiesta de la alegria",
//					"DVC", "Ventas", "IT");
//			System.out.println("Se logro la insercion de datos");
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
	
	
	
		
//		
//		try {
//			pruebaDepartamento.crear("QA");
//			System.out.println("Se logro la insercion de datos");
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		
	
//		pruebaTramite = new MTramite();
//		pruebaTramite.crearTramite("Esto es un tramite de prueba", "contenido a encriptar", "Firma", "Logistica", "IT");
		
		
		
	
	}
}
