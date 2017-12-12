package Main;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sistemacompras.encriptacion.ControladorEncriptacion;
import com.sistemacompras.multis.MDepartamento;
import com.sistemacompras.multis.MTramite;
import com.sistemacompras.objects.Tramite;

public class Main {
	
	public static MTramite pruebaTramite;
	
	public static void main(String[] args) throws SQLException, Exception {
//		Tramite tramite;
//		
//		pruebaTramite = new MTramite();
//		
//		try {
//			pruebaTramite.crearTramite("firma digital from el main", "origen: Main", "Destino : Cualquiera", "Prueba desde el main");
//			System.out.println("Se logro la insercion de datos");
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//	
//	
	
		
		MDepartamento pruebaDepartamento = new MDepartamento();
		try {
			pruebaDepartamento.crearDepartamento("Logistica");
			System.out.println("Se logro la insercion de datos");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	
	}
	


}
