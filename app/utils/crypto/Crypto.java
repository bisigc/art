package utils.crypto;

import java.security.GeneralSecurityException;
import java.util.Base64;

import models.Digest;

import com.lambdaworks.crypto.SCrypt;
import com.lambdaworks.crypto.SCryptUtil;

public class Crypto {
	
	private static final int SCRYPT_N = 16384;
	private static final int SCRYPT_R = 8;
	private static final int SCRYPT_P = 1;
	private static final int SCRYPT_LENGTH = 32;

	
	public static String createScryptHash(String password) {
		return SCryptUtil.scrypt(password, SCRYPT_N, SCRYPT_R, SCRYPT_P);
	}
	
	public static Digest generateDigest(String password) {
		Digest digest = new Digest();
		String scrypt = SCryptUtil.scrypt(password, SCRYPT_N, SCRYPT_R, SCRYPT_P);
		String [] parts = scrypt.split("\\$");
		digest.setSalt(parts[3]);
		digest.setScrypt(parts[4]);
		return digest;
	}
	
	public static String computeScryptHash(String password, String saltBase64) throws GeneralSecurityException {
		byte [] hash = SCrypt.scrypt(password.getBytes(), Base64.getDecoder().decode(saltBase64), SCRYPT_N, SCRYPT_R, SCRYPT_P, SCRYPT_LENGTH);
		return Base64.getEncoder().encodeToString(hash);
	}
	
	public static boolean isPasswordValid(String password, Digest digest) throws GeneralSecurityException {
		return computeScryptHash(password, digest.getSalt()).equals(digest.getScrypt());
	}
	
	public static void main(String [] args) throws Exception {
		String password = "What ever";
		Digest digest = generateDigest(password);
		System.out.println(digest.getSalt());
		System.out.println(digest.getScrypt());
		System.out.println(computeScryptHash(password, digest.getSalt()).equals(digest.getScrypt()));
	}

}
