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
import java.nio.charset.Charset;
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
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ControladorEncriptacion {

	private final String PATH = "C:/encrypt/asymetric/";//esta ruta es para probar si se esta guardando la firma digital
	private static KeyPair kp;
	private static String rutaArchivFirmar;
	
	
	public KeyPair crearLlaves() throws Exception {
		
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		KeyPair pair = keyGen.generateKeyPair();
		
		return pair;		
		
	}
	public String convertirLlavesString(byte[] llave) {
		

		 String keyAsString = Base64.getEncoder().encodeToString(llave);
		
		return keyAsString;
	}
	public Key decodePublicKey(byte[] llavePublica) throws GeneralSecurityException, IOException {
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(llavePublica));
		return publicKey;
		
			
		
	}
	public Key decodePrivateKeyFromString(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		byte[] data = Base64.getDecoder().decode((privateKey.getBytes()));
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(data);
		 KeyFactory fact = KeyFactory.getInstance("RSA");
		 return fact.generatePrivate(spec);
		
	}
	
	


	public byte[] encryptMessage(String message, byte[] publickey) throws Exception {
		PublicKey pubKey = (PublicKey) decodePublicKey(publickey);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] encryptedData = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
	    Encoder oneEncoder = Base64.getEncoder().withoutPadding();
	    encryptedData = oneEncoder.encode(encryptedData);
	   return encryptedData;
	}
	public String decryptMessage(String message, String privatekey) throws Exception {
		PrivateKey privKey = (PrivateKey) decodePrivateKeyFromString(privatekey);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privKey);
		byte[] encryptedMessage = readMessageFile(message);
		byte[] decryptedData = cipher.doFinal(encryptedMessage);
		String descryMessage = new String(decryptedData,StandardCharsets.UTF_8);
		return descryMessage;	
  	}
	
	private byte[] readMessageFile(String message) throws Exception{
        int length = message.length();
        byte[] bytes = new byte[length];
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





