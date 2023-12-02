package cryptoCypher;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestPublic {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("JAVA"));
		assertTrue(CryptoManager.isStringInBounds("\"JAVA IS FUN\""));
		assertFalse(CryptoManager.isStringInBounds("java"));
		assertFalse(CryptoManager.isStringInBounds("{JAVA"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.CaeserEncryption("bye", 3));
		assertEquals("DEF", CryptoManager.CaeserEncryption("ABC", 3));
		assertEquals("!\"#", CryptoManager.CaeserEncryption("ABC", 96));
		assertEquals("1.558", CryptoManager.CaeserEncryption("HELLO", 105));
		assertEquals("UFTUJOH", CryptoManager.CaeserEncryption("TESTING", 1));
		assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.CaeserEncryption("THIS IS ANOTHER TEST", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("TESTING", CryptoManager.CaeserDecryption("UFTUJOH", 1));
		assertEquals("TESTING ANOTHER STRING", CryptoManager.CaeserDecryption(";,:;05.G(56;/,9G:;905.", 999));
		assertEquals("HELLO WORLD", CryptoManager.CaeserDecryption("4188;LC;>80", 300));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.CaeserDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WN#\\N &", CryptoManager.BellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.BellasoEncryption("MERRY CHRISTMAS", "HELLO"));
		assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.BellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager.BellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.BellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.BellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));

	}

}
