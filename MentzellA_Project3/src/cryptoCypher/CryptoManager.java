package cryptoCypher;

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	
	
	public static boolean isStringInBound(String input) {
		for (int i = 0; i<input.length();i++) {
			if (!((input.charAt(i)> LOWER_RANGE) && (input.charAt(i) < UPPER_RANGE))) {
				return false;
			}
		}
		return true;
		
	}
	
	public static String CaeserEncryption(String input, int key) {
		String encryptedStr = "";
		for (int i=0; i<input.length();i++) {
			if ((input.charAt(i) == ' ')) {	
				encryptedStr += ' ';
			}
			else {
				int charMath = (int) input.charAt(i) + key;
				char encryptChar = (char) charMath;
				encryptedStr += encryptChar;
			}
		}
		return encryptedStr;
	}
	
	public static String CaeserDecryption(String input, int key) {
		String decryptedStr = "";
		for (int i=0; i<input.length();i++) {
			if ((input.charAt(i) == ' ')) {	
				decryptedStr += ' ';
			}
			else {
				int charMath = (int) input.charAt(i) - key;
				char encryptChar = (char) charMath;
			
			decryptedStr += encryptChar;
		}
		}
		return decryptedStr;
		
	}
	
	public static String BellasoEncryption(String input, String cypher) {
		String encrypted = "";
		char indexChar, encryptedChar, cypherChar;
		for (int i = 0; i<(input.length()); i++) {
			indexChar = input.charAt(i);
			cypherChar = cypher.charAt(i%cypher.length());
			int charMath = (int)(indexChar + cypherChar - RANGE);
			encryptedChar = (char)charMath;
			encrypted += encryptedChar;
		}
		return encrypted;
	}
	
	public static String BellasoDecryption(String input, String cypher) {
		String decrypted = "";
		char indexChar, decryptedChar, cypherChar;
		for (int i = 0; i<(input.length()); i++) {
			indexChar = input.charAt(i);
			cypherChar = cypher.charAt(i%cypher.length());
			int charMath = (int)(RANGE + indexChar - cypherChar);
			decryptedChar = (char)charMath;
			decrypted += decryptedChar;
		}
		return decrypted;
	}
}
