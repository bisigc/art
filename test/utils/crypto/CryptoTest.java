package utils.crypto;
import static org.fest.assertions.Assertions.assertThat;

import java.security.GeneralSecurityException;

import models.user.Digest;

import org.junit.Test;


/**
 * Tests the functionality of the {@link Crypto} class as well
 * as the {@link Digest} data model.
 * 
 * @author cbi
 */
public class CryptoTest {

    @Test
    public void passwordValidationCheck() {
    	boolean test = false;
    	Digest digest = new Digest();
    	digest.generateDigest("test");
    	try {
			test = Crypto.isPasswordValid("test", digest);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
        assertThat(test).isTrue();
    }
}
