package ie.gmit.sw.ai.Cipher;
/***
 * PlayFair key used in playfair cipher.
 * 
 * @author RnDMizeD
 *
 */
public class PlayFairKey extends Key {
	
	private String key;
	
	/***
	 * Contructor.
	 */
	public PlayFairKey() {
		super();
	}
		
	/***
	 * Build this key using a provided key.
	 * 
	 * @param key The key to be set as the key.
	 */
	public PlayFairKey(String key) {
		super();
		this.key = key;
	}


	public String getKey() {
		return key;
	}
	

	public void setKey(String key) {
		this.key = key;
	}

	
	/***
	 * Transform string in 2D char array representing a playfair key
	 * @return
	 */
	private char[][] toMatrix(){
		char[][] charArray = new char[5][5];
        char[] keyArray = this.key.toCharArray();
        for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				charArray[i][j] = keyArray[(i*5) +j];
			}
		}
        return charArray;
		
	}

	/***
	 * Print this key in the console in playfair format.
	 */
	public void displayMatrix(){
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(this.toMatrix()[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	
}
