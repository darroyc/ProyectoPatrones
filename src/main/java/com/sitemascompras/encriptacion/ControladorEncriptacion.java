package com.sitemascompras.encriptacion;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class ControladorEncriptacion {
	private final String KEY_EXTENSION = ".key";
	private final String PUBLIC = "public.key";
	private final String PRIVATE = "private.key";
	private final String MESSAGE_ENCRYPT_EXTENSION = ".encript";
	//private final String PATH = "C:/encrpitacion/";
	// Estas son las rutas donde se van a guardar las llaves esto es temporal porque tambien se 
	// se puden almacenar  en la base de datos.
	private final String PRIVATEKEYPATH = "C:/encrpitacion/llavesPrivadas";
	private final String PUBLICKEYPATH = "C:/encrpitacion/llavesPublicas";
	
	
	
	public void crearLlaves(String nombreLlave) throws InvalidKeySpecException, NoSuchAlgorithmException {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		KeyFactory fact = KeyFactory.getInstance("RSA");
		kpg.initialize(2048);
		KeyPair kp = kpg.genKeyPair();
		RSAPublicKeySpec pub = fact.getKeySpec(kp.getPublic(),
		  RSAPublicKeySpec.class);
		RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(),
		  RSAPrivateKeySpec.class);

		guardarLlave(PUBLICKEYPATH + nombreLlave+PUBLIC, pub.getModulus(),
		  pub.getPublicExponent());
		guardarLlave(PRIVATEKEYPATH + nombreLlave+PRIVATE, priv.getModulus(),
		  priv.getPrivateExponent());
		
	}
	
	
	public void guardarLlave(String string, BigInteger bigInteger, BigInteger bigInteger2) {
		
	}
	
	

}
