package ie.gmit.sw.PlayFair;

import java.util.List;
import java.util.Random;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


public class PlayFairKeyGenerator {
	
	private static final String alphabet = "abcdefghiklmnopqrstuvwxyz".toUpperCase();
	

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
