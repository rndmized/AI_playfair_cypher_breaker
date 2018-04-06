package ie.gmit.sw.ai.Cipher;

/***
 * PlayFair Cipher Class to apply such cipher.
 * 
 * @author RnDMizeD
 *
 */
public class PlayFairCipher implements Cipher {


	/***
	 * Implementation of decryption by using playfair cipher.
	 * 
	 * @param encryptedText This is the text to be decrypted.
	 * @param matrix This is the key to decript the text.
	 * @return The decrypted text.
	 */
	private String playFairDecryption(String encryptedText, String matrix) {

		StringBuilder ciphertex = new StringBuilder();
		
		String pairs[] = new String[encryptedText.length() / 2];
        int j = 0;
        for (int i = 0; i < encryptedText.length(); i = i + 2) {
            pairs[j] = encryptedText.substring(i, i + 2);
            j++;
        }

		for (String pair : pairs) {// using zero index
			byte row1 = (byte) (matrix.indexOf(pair.charAt(0)) / 5);
			byte col1 = (byte) (matrix.indexOf(pair.charAt(0)) % 5);
			byte row2 = (byte) (matrix.indexOf(pair.charAt(1)) / 5);
			byte col2 = (byte) (matrix.indexOf(pair.charAt(1)) % 5);


			char chr1;
			char chr2;
			if (col1 == col2) {
				chr2 = matrix.charAt(((row2 + 4) % 5 * 5 + col2));
				chr1 = matrix.charAt(((row1 + 4) % 5 * 5 + col1));
			} else if (row1 == row2) {
				chr1 = matrix.charAt(row1 * 5 + ((col1 + 4) % 5));
				chr2 = matrix.charAt(row2 * 5 + ((col2 + 4) % 5));
			} else {
				chr1 = matrix.charAt(row1 * 5 + col2);
				chr2 = matrix.charAt(row2 * 5 + col1);
			}
			ciphertex.append(Character.toString(chr1) + Character.toString(chr2));
		}

		return ciphertex.toString();
	}



	@Override
	public String encrypt(String text, Key key) {
		/*
		 * Encryption has not been implemented since it is not required for this project.
		 * Added for design and future implementation.
		 * 
		 * */
		return null;
	}

	
	@Override
	public String decrypt(String text, Key key) {
		
		return this.playFairDecryption(text, key.getKey());
	}



}
