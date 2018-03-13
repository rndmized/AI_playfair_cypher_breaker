package ie.gmit.sw.PlayFair;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ie.gmi.sw.ai.SimulatedAnnealing;

public class PlayFairCipherRunner {

	
	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(5);
		SimulatedAnnealing sa = new SimulatedAnnealing();
		ex.execute(sa);
		
//		Test1 t = new Test1();
//		PlayFairKey key = new PlayFairKeyGenerator().generateRandomKey();
//		key.displayMatrix();
//		key = t.shuffleKey(key);
//		key.displayMatrix();
		
	}

}
