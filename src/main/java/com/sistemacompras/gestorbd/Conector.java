package com.sistemacompras.gestorbd;


public class Conector {
		private static AccesoBD conector = null;
		
		public static AccesoBD getConector() throws java.sql.SQLException,Exception{
			
			if(conector==null){
				conector = new AccesoBD("jdbc:mariadb://127.0.0.1/sistemacompras?user=root&password=root");
			}
			return conector;
		}
}
