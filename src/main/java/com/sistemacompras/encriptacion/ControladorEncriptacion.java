package com.sistemacompras.encriptacion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ControladorEncriptacion {
		private final String MESSAGE_ENCRYPT_EXTENSION = ".encript";
		private final String PATH = "C:/encrypt/asymetric/";
		private static KeyPair kp;
		private static String rutaArchivFirmar;
		private static ArrayList<String> listaLlaves = new ArrayList<String>();
		
	public ArrayList<String> crearLlaves() throws Exception {
		String llavePrivada;
		String llavePublica;
		
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");

		keyGen.initialize(1024,random);
		KeyPair pair = keyGen.generateKeyPair();
		byte[]	 priv = pair.getPrivate().getEncoded();
		byte[]	 pub = pair.getPublic().getEncoded();

		llavePrivada = convertirLlavesString(priv);
		llavePublica = convertirLlavesString(pub);
		listaLlaves.add(llavePrivada);
		listaLlaves.add(llavePublica);
		
		return listaLlaves;		
		
	}
	public String convertirLlavesString(byte[] llave) {
		

		 String keyAsString = Base64.getEncoder().encodeToString(llave);
		
		return keyAsString;
	}
	public Key decodeKeyFromString(String keyString) throws GeneralSecurityException, IOException {
		 byte[] data = Base64.getDecoder().decode((keyString.getBytes()));
		 X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
		 KeyFactory fact = KeyFactory.getInstance("RSA");
		 return fact.generatePublic(spec);
	}
	public Key decodePrivateKeyFromString(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
			
			byte[] data = Base64.getDecoder().decode((privateKey.getBytes()));
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(data);
			 KeyFactory fact = KeyFactory.getInstance("RSA");
			 return fact.generatePrivate(spec);
			
		}
	public String decryptMessage(String messageName, String keyName) throws Exception {
		PrivateKey privKey = (PrivateKey) decodePrivateKeyFromString(keyName);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privKey);
		byte[] encryptedMessage = readMessageFile(messageName);
		byte[] decryptedData = cipher.doFinal(encryptedMessage);
	    String messagedescode = new String(decryptedData,StandardCharsets.UTF_8);
		
		return "El mensaje es :"+"\n"+messagedescode;

	}
	


	public String encryptMessage(String nombreTramite,String message, String publickey) throws Exception {
		
		PublicKey pubKey = (PublicKey) decodeKeyFromString(publickey);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] encryptedData = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
	    Encoder oneEncoder = Base64.getEncoder();
	    encryptedData = oneEncoder.encode(encryptedData);
	    String mensajeString = new String(encryptedData,StandardCharsets.UTF_8);
	    writeBytesFile(nombreTramite,encryptedData,MESSAGE_ENCRYPT_EXTENSION);
	    return mensajeString;
	    
	}
	
	

	private void writeBytesFile(String name, byte[] content, String type) throws FileNotFoundException, IOException{	
		FileOutputStream fos = new FileOutputStream(PATH + name + type);
		fos.write(content);
		fos.close();
		
	}
	
	
	private byte[] readMessageFile(String messageName) throws Exception{
		File file = new File(PATH + messageName + MESSAGE_ENCRYPT_EXTENSION);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        Decoder oneDecoder = Base64.getDecoder();
		return oneDecoder.decode(bytes);
			
		
	}
		
	
	
	public void firmarTramite()  throws Exception {
		
		PrivateKey priv =kp.getPrivate();
			
			byte[] data = leerArchivo(rutaArchivFirmar);
			Signature dsa = Signature.getInstance("SHA1withRSA"); 
			dsa.initSign(priv);
			dsa.update(data);
			byte[] firma = dsa.sign();
			
			guardarFirma(PATH, firma);
		}
	
	public byte[] leerArchivo(String ruta) throws Exception {
		
		return Files.readAllBytes(Paths.get(ruta));
	}
	
	public void guardarFirma(String rutafirma, byte[] firma) throws Exception {
		

		FileOutputStream fos = new FileOutputStream(rutafirma+".digitalSignature");
		fos.write(firma);
		fos.close();
		
	}
	
	
	


}// llave de la clase





