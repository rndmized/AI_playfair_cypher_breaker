package ie.gmit.sw.ai.Cipher;

/***
 * Interface to define the behavior of a Cipher.
 * 
 * @author RnDMizeD
 *
 */
public interface Cipher {
	/***
	 * This method encrypts a text using a key.
	 * 
	 * @param text This is the text to encrypt.
	 * @param key This is the key to encrypt the text.
	 * @return The encrypted text.
	 */
	public String encrypt(String text, Key key);
	
	/***
	 * This method decrypts an encryted text using a key.
	 * 
	 * @param text This is the encrypted text to decrypt.
	 * @param key This is the key to decrypt the text.
	 * @return The decrypted text using the key.
	 */
	public String decrypt(String text, Key key);

}
