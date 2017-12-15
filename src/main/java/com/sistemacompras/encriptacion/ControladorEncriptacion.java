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
	private final String KEY_EXTENSION = ".key";
	private final String PUBLIC = "public";
	private final String PRIVATE = "private";
	private final String MESSAGE_ENCRYPT_EXTENSION = ".encript";
	private final String MESSAGE_ENCRYPT_PATH = "C:/encriptacion/mensajesEncriptados";
	private final String PRIVATE_KEY_PATH = "C:/encrpitacion/llavesPrivadas";
	private final String PUBLIC_KEY_PATH = "C:/encrpitacion/llavesPublicas";
	private final String PATH = "C:/encrypt/asymetric/";//esta ruta es para probar si se esta guardando la firma digital
	private static KeyPair kp;
	private static String rutaArchivFirmar;
	public static ArrayList<String> listaLlaves = new ArrayList<String>();
	
	public ArrayList<String> crearLlaves() throws Exception {
		String llavePrivada;
		String llavePublica;
		
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

		keyGen.initialize(512);
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
	
	
	public void saveToFile(String fileName,BigInteger mod, BigInteger exp) throws IOException {	
			ObjectOutputStream oout = new ObjectOutputStream(
				    new BufferedOutputStream(new FileOutputStream(fileName)));
			try {
				oout.writeObject(mod);
				oout.writeObject(exp);
			} catch (Exception e) {
				throw new IOException("Unexpected error", e);
			} finally {
			    oout.close();
			}
	}

	public String encryptMessage(String message, String publickey) throws Exception {
		PublicKey pubKey = (PublicKey) decodeKeyFromString(publickey);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] encryptedData = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
	    Encoder oneEncoder = Base64.getEncoder();
	    encryptedData = oneEncoder.encode(encryptedData);
	    String mensajeString = new String(encryptedData,StandardCharsets.UTF_8);
		//writeBytesFile(messageName,encryptedData,MESSAGE_ENCRYPT_EXTENSION);
	    return mensajeString;
	}

	private void writeBytesFile(String name, byte[] content, String type) throws FileNotFoundException, IOException{	
		FileOutputStream fos = new FileOutputStream(MESSAGE_ENCRYPT_PATH + name + type);
		fos.write(content);
		fos.close();
		
	}
	
	Key readKeyFromFile(String keyFileName, String type) throws IOException {
		
		 InputStream in = new FileInputStream (PUBLIC_KEY_PATH + keyFileName+ type + KEY_EXTENSION);
		  ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(in));
		  try {
		    BigInteger m = (BigInteger) oin.readObject();
		    BigInteger e = (BigInteger) oin.readObject();
		    if (type.equals("public")) {
			    RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
			    KeyFactory fact = KeyFactory.getInstance("RSA");
			    PublicKey pubKey = fact.generatePublic(keySpec);
			    return pubKey;		    	
		    } else {
		    	RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
			    KeyFactory fact = KeyFactory.getInstance("RSA");
			    PrivateKey pubKey = fact.generatePrivate(keySpec);
			    return pubKey;		    	
		    }
		  } catch (Exception e) {
		    throw new RuntimeException("Spurious serialisation error", e);
		  } finally {
		    oin.close();
		  }
		  
		  
	}
	
	private byte[] readMessageFile(String messageName) throws Exception{
		File file = new File(MESSAGE_ENCRYPT_PATH + messageName + MESSAGE_ENCRYPT_EXTENSION);
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





