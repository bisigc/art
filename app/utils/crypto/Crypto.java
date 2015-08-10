package utils.crypto;

import java.security.GeneralSecurityException;

import models.user.Digest;

import com.lambdaworks.codec.Base64;
import com.lambdaworks.crypto.SCrypt;
import com.lambdaworks.crypto.SCryptUtil;

/**
 * Class contains static methods to generate and validate salt and digest values for
 * a given password using the lambdaworks crypto library {@link com.lambdaworks.crypto.SCrypt}
 * Since it contains only static methods, the class does not need to be instantiated and is
 * therefore abstract.
 * 
 * @author cbi
 */
public abstract class Crypto {
	
	private static final int SCRYPT_N = 16384;
	private static final int SCRYPT_R = 8;
	private static final int SCRYPT_P = 1;
	private static final int SCRYPT_LENGTH = 32;

	
	/**
	 * Creates an scrypt hash (containing salt and scrypt and check values) based 
	 * on the provided password.
	 * 
	 * @param password password String to scrypt
	 * @return encrypted password string
	 */
	public static String createScryptHash(String password) {
		return SCryptUtil.scrypt(password, SCRYPT_N, SCRYPT_R, SCRYPT_P);
	}
	
	/**
	 * Generates a {@link Digest} object with salt and scrypt values based
	 * on the provided password.
	 * 
	 * @param password password string
	 * @return Digest object
	 */
	public static Digest generateDigest(String password) {
		Digest digest = new Digest();
		String scrypt = createScryptHash(password);
		String [] parts = scrypt.split("\\$");
		digest.setSalt(parts[3]);
		digest.setScrypt(parts[4]);
		return digest;
	}
	
	/**
	 * Computes the scrypt hash based on the provided password and salt values.
	 * 
	 * @param password password string
	 * @param saltBase64 Base64 encoded Salt value string
	 * @return Scrypt Hash
	 * @throws GeneralSecurityException if decoding has failed
	 */
	public static String computeScryptHash(String password, String saltBase64) throws GeneralSecurityException {
		byte [] hash = SCrypt.scrypt(password.getBytes(), Base64.decode(saltBase64.toCharArray()), SCRYPT_N, SCRYPT_R, SCRYPT_P, SCRYPT_LENGTH);
		return String.copyValueOf(Base64.encode(hash));
	}
	
	/**
	 * Computes the scrypt hash with the provided password and the salt value comming
	 * from the provided {@link Digest} object and compares it with the scrypt hash comming
	 * from the same {@link Digest} object.
	 * 
	 * @param password password string
	 * @param digest Digest object
	 * @return password valid or not
	 * @throws GeneralSecurityException if decoding or encoding has failed
	 */
	public static boolean isPasswordValid(String password, Digest digest) throws GeneralSecurityException {
		return computeScryptHash(password, digest.getSalt()).equals(digest.getScrypt());
	}
	
	/**
	 * Main method accepts password from commandline, generates salt and scrypt hashes out of
	 * it and prints them to the sysout.
	 * 
	 * @param args commandline inputs
	 * @throws Exception all exceptions to the console
	 */
	public static void main(String [] args) throws Exception {
		String password = args[0];
		Digest digest = generateDigest(password);
		System.out.println(digest.getSalt());
		System.out.println(digest.getScrypt());
		System.out.println(computeScryptHash(password, digest.getSalt()).equals(digest.getScrypt()));
	}

}
