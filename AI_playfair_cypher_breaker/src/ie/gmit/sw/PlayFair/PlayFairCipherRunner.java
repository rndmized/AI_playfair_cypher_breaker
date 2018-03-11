package ie.gmit.sw.PlayFair;

import ie.gmi.sw.ai.Hobbit;

public class PlayFairCipherRunner {

	public static Hobbit hobbit  = new Hobbit();
	public static PlayFairKeyGenerator keyGen;
	
	public static void main(String[] args) {
		
		keyGen =  new PlayFairKeyGenerator();
		PlayFairKey key = keyGen.generateKey(hobbit.getKey());
		key.displayMatrix();
		//key.displayMatrix();
		PlayFairCipher pfc = new PlayFairCipher(key);
		//String coded = pfc.encrypt("thisisanexampleofwhatcangowrong");
		//System.out.println(coded);
		
		System.out.println(pfc.decrypt(hobbit.getCodedText(),key));

	}

}
