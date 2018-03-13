package ie.gmi.sw.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ie.gmit.sw.PlayFair.PlayFairCipher;
import ie.gmit.sw.PlayFair.PlayFairKey;
import ie.gmit.sw.PlayFair.PlayFairKeyGenerator;

public class SimulatedAnnealing implements Runnable {

	private PlayFairKey key;
	private PlayFairKeyGenerator keyGen;
	private PlayFairCipher pfc;
	private Ngram ngram;
	private Hobbit hobbit = new Hobbit();

	public SimulatedAnnealing() {

		this.init();

	}

	public void init() {

		keyGen = new PlayFairKeyGenerator();
		this.key = keyGen.generateRandomKey();
		this.pfc = new PlayFairCipher(key);
		ngram = new Ngram("../4grams.txt");

	}

	@Override
	public void run() {

		PlayFairKey parent = keyGen.generateRandomKey();
		PlayFairKey backup = keyGen.generateKey(parent.getKey());
		double score = logProbability(parent);

		for (int temp = 10; temp > 0; temp--) {
			for (int transitions = 5000; transitions > 0; transitions--) {
				PlayFairKey child = shuffleKey(parent);
				double scoreChild = logProbability(child);
				double delta = scoreChild - score;
				System.out.println("Parent Score: " + score +". Child Score: " + scoreChild );
				if (delta > 0) {
					parent.setKey(child.getKey());
					score = scoreChild;
				} else if (delta < 0) {
					
				}
			}
		}
		System.out.println("Staring Point");
		backup.displayMatrix();
		System.out.println("Final");
		parent.displayMatrix();
		//System.out.println(pfc.decrypt(hobbit.getCodedText(), parent));
	}

	private double logProbability(PlayFairKey key) {

		String decodedText = pfc.decrypt(hobbit.getCodedText(), key);
		Map<String, Integer> map = ngram.getMap();
		List<String> tetragrams = new ArrayList<>();
		
		double score = 0.0;

		for (int i = 0; i < decodedText.length() - 3; i++) {
			tetragrams.add(decodedText.substring(i, i + 4));
		}
		
		for (String string : tetragrams) {
			try {
				score += Math.log(map.get(string));
			} catch (Exception e) {

			}
		}

		return score;
	}

	public PlayFairKey shuffleKey(PlayFairKey key) {

		int rnd = (int) (Math.random() * 100);
		Random random = new Random();

		int index1 = random.nextInt(5);
		int index2 = random.nextInt(5);
		

		char[][] charArr = key.toMatrix();
		char[] temp = new char[5];

		switch (rnd) {
		case 1:
		case 2:
		case 5:
		case 6:
		case 7:
		case 8:
			while(index1 == index2){
				index2 = random.nextInt(5);
			}
			for (int i = 0; i < 5; i++) {
				temp[i] = charArr[index1][i];
				charArr[index1][i] = charArr[index2][i];
				charArr[index2][i] = temp[i];
			}
			key.setKey(charArr);
			break;
		case 3:
		case 4:
			while(index1 == index2){
				index2 = random.nextInt(5);
			}
			for (int i = 0; i < 5; i++) {
				temp[i] = charArr[i][index1];
				charArr[i][index1] = charArr[i][index2];
				charArr[i][index2] = temp[i];
			}
			key.setKey(charArr);
			break;

		case 9:
		case 10:
			String keyString = key.getKey();
			key = new PlayFairKeyGenerator().generateKey(new StringBuilder(keyString).reverse().toString());
			break;
		default:
			char swap = ' ';
			int rx1 = random.nextInt(5);
			int ry1 = random.nextInt(5);
			int rx2 = random.nextInt(5);
			int ry2 = random.nextInt(5);
			swap = charArr[rx1][ry1];
			charArr[rx1][ry1] = charArr[rx2][ry2];
			charArr[rx2][ry2] = swap;
			key.setKey(charArr);
			break;
		}
	
		return key;
	}

}
