package ie.gmit.sw.ai.Cipher;

import java.util.Random;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/***
 * Factory to build Playfair keys.
 * 
 * @author RnDMizeD
 *
 */
public class PlayFairKeyBuilder {
	
	private static final String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
	

	/***
	 * Generates a playfair key based on a given string.
	 * 
	 * @param key The string used to build the new key from.
	 * @return
	 */
    public static PlayFairKey generateKey(String key){
    	
		StringBuilder stringBuilder = new StringBuilder();
        Set<Character> set = new LinkedHashSet<Character>();
        key += alphabet;
        //Eliminate duplicate letters
        //Change j for i
        for (char chr : key.toUpperCase().toCharArray()) {
        	if (chr == 'j') chr = 'i';
            set.add(chr);
        }
        for (Object chr : set) {
            stringBuilder.append(chr);
       }
        PlayFairKey pfKey = new PlayFairKey();
        pfKey.setKey(stringBuilder.toString());
       return pfKey;
	}
	
    /***
     * Generate a random playfair key.
     * 
     * @return PlayFair key.
     */
	public static PlayFairKey generateRandomKey(){
		StringBuilder stringBuilder = new StringBuilder();
        char [] keyArr = shuffle(alphabet.toCharArray());
        for (Object chr : keyArr) {
            stringBuilder.append(chr);
       }
        PlayFairKey pfKey = new PlayFairKey();
        pfKey.setKey(stringBuilder.toString());
       return pfKey;
	}
	
	/***
	 * Shuffle characters in a key to randomized it.
	 * 
	 * @param key This is the key to be randomized.
	 * @return The randomized key.
	 */
	private static char[] shuffle(char[] key) {
		int index;
		Random random = ThreadLocalRandom.current();
		for (int i = key.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			if (index != i) {
				key[index] ^= key[i];
				key[i] ^= key[index];
				key[index] ^= key[i];
			}
		}		
		return key;
	}
	

}
