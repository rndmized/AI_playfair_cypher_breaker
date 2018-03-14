package ie.gmit.sw.PlayFair;

public class PlayFairCipher {

	private PlayFairKey key;
	private int length = 0;

	public PlayFairCipher() {
	}


	public String decrypt(String text, PlayFairKey key) {
		this.key = key;
		String decodedText = this.decrypt(text.toLowerCase(), key.getKey());
		if (decodedText.endsWith("x"))
			decodedText = decodedText.substring(0, decodedText.length() - 1);
		return decodedText;
	}
	
	
	public String[] divideToPairs(String message) {

        String pairs[] = new String[message.length() / 2];
        int j = 0;

        for (int i = 0; i < message.length(); i = i + 2) {
            pairs[j] = message.substring(i, i + 2);
            j++;
        }

        return pairs;
    }


	private String decrypt(String encryptedText, String matrix) {

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

}
