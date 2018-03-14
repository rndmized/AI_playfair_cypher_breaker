package ie.gmit.sw.PlayFair;

import ie.gmi.sw.ai.Hobbit;
import ie.gmi.sw.ai.Ngram;
import ie.gmi.sw.ai.SimulatedAnnealing;

public class PlayFairCipherRunner {

	public static void main(String[] args) {

		
		Hobbit h = new Hobbit();
		Ngram _4gram = new Ngram("../4grams.txt");
//		PlayFairCipher pfc = new PlayFairCipher();
//		String plaintext = pfc.decrypt(h.getCodedText(), new PlayFairKeyGenerator().generateKey(h.getKey().toLowerCase()));
//		System.out.println(plaintext);
		// ExecutorService ex = Executors.newFixedThreadPool(5);
		// SimulatedAnnealing sa = new SimulatedAnnealing();
		// ex.execute(sa);

		SimulatedAnnealing sa = new SimulatedAnnealing();
		sa.run();
		
		
		
//		PlayFairKey key = new PlayFairKey();
//		key = new PlayFairKeyGenerator().generateRandomKey();
//		key.displayMatrix();
//		System.out.println();
//		sa.shuffleKey(key);
//		key.displayMatrix();
		

 		//PlayFairKey key = new PlayFairKey(h.getKey().toLowerCase());
		//System.out.println(sa.logProbability(key));
		//Score of proper key: 202.28482935704432
		
	}

}
