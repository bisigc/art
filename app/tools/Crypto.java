package tools;

import java.security.GeneralSecurityException;
import java.util.Base64;
import com.lambdaworks.crypto.SCryptUtil;
import com.lambdaworks.crypto.SCrypt;

public class Crypto {
	
	private static final int SCRYPT_N = 16384;
	private static final int SCRYPT_R = 8;
	private static final int SCRYPT_P = 1;
	private static final int SCRYPT_LENGTH = 32;

	public static String createScryptHash(String password) {
		return SCryptUtil.scrypt(password, SCRYPT_N, SCRYPT_R, SCRYPT_P);
	}
	
	public static String computeScryptHash(String password, String saltBase64) throws GeneralSecurityException {
		byte [] hash = SCrypt.scrypt(password.getBytes(), Base64.getDecoder().decode(saltBase64), SCRYPT_N, SCRYPT_R, SCRYPT_P, SCRYPT_LENGTH);
		return Base64.getEncoder().encodeToString(hash);
	}
	
}
