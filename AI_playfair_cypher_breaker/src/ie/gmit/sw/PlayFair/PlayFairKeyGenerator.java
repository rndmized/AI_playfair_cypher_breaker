package ie.gmit.sw.PlayFair;

import java.util.List;
import java.util.Random;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


// ref: https://gist.github.com/emara-geek/473702df72163773d8393d93428c4b6b

public class PlayFairKeyGenerator {
	
	private static final String alphabet = "abcdefghiklmnopqrstuvwxyz";

    public PlayFairKey generateKey(String key){
    	
		StringBuilder stringBuilder = new StringBuilder();
        Set<Character> set = new LinkedHashSet<Character>();
        key += alphabet;
        //Eliminate duplicate letters
        for (char chr : key.toLowerCase().toCharArray()) {
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
	
	public PlayFairKey generateRandomKey(){
		StringBuilder stringBuilder = new StringBuilder();
        char [] keyArr = this.shuffle(alphabet.toCharArray());
        for (Object chr : keyArr) {
            stringBuilder.append(chr);
       }
        PlayFairKey pfKey = new PlayFairKey();
        pfKey.setKey(stringBuilder.toString());
       return pfKey;
	}
	
	private char[] shuffle(char[] key) {
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
