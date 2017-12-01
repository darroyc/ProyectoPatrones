package com.sitemascompras.encriptacion;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.Signature;

public class Firma {
	
	//	Este metodo recibe la ruta del archivo a firmar,la clave privada,y la ruta donde se va a guardar la firma
	
	public void firmarTramite(String rutaTramite,PrivateKey clavePrivada,String ruta )  throws Exception {
		
	public void firmarTramite(String rutaTramite,PrivateKey clavePrivada,String rutafirma )  throws Exception {
		
		byte[] data = leerArchivo(rutaTramite);
		Signature dsa = Signature.getInstance("SHA1withRSA"); 
		dsa.initSign(clavePrivada);
		dsa.update(data);
		byte[] firma = dsa.sign();
		
		guardarFirma(rutafirma, firma);
	}
	
	public byte[] leerArchivo(String ruta) throws Exception {
		
		return Files.readAllBytes(Paths.get(ruta));
	}
	
	
	
	public void guardarFirma(String rutafirma, byte[] firma) throws Exception {
		

		FileOutputStream fos = new FileOutputStream(rutafirma);
		fos.write(firma);
		fos.close();
		
	}
}
