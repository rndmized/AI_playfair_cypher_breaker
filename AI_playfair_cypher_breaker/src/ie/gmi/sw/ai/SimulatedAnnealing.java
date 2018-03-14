package ie.gmi.sw.ai;

import java.util.Map;
import java.util.Random;

import ie.gmit.sw.PlayFair.PlayFairCipher;
import ie.gmit.sw.PlayFair.PlayFairKey;
import ie.gmit.sw.PlayFair.PlayFairKeyGenerator;

public class SimulatedAnnealing {

	private PlayFairKeyGenerator keyGen;
	private PlayFairCipher pfc;
	private Ngram ngram;
	private Hobbit hobbit = new Hobbit();
	private Map<String, Integer> map;

	public SimulatedAnnealing() {

		this.init();

	}

	public void init() {

		keyGen = new PlayFairKeyGenerator();
		ngram = new Ngram("../4grams.txt");
		pfc = new PlayFairCipher();
		map = ngram.getMap();
	}

	public void run() {

		PlayFairKey parent = keyGen.generateRandomKey();
		PlayFairKey backup = keyGen.generateKey(parent.getKey());
		double maxScore = logProbability(parent);
		int counter = 0;
		for (int temp = 10; temp > 0; temp--) {
			for (int transitions = 50000; transitions > 0; transitions--) {
				PlayFairKey child = shuffleKey(parent);
				double score = logProbability(child);
				double delta = score - maxScore;
				if (delta > 0) {
					maxScore = score;
					parent.setKey(child.getKey());
				}
				if (delta < 0) {
					if (temp > 0) {
						double prob = Math.pow(Math.E, delta / temp);
						if (prob > 0.5) {
							counter++;
							maxScore = score;
							parent.setKey(child.getKey());
						}

					}
				}

			}
		}

		System.out.println("Starting Point");
		backup.displayMatrix();
		System.out.println("Final");
		parent.displayMatrix();
		System.out.println(pfc.decrypt(hobbit.getCodedText(), parent));
		System.out.println("Randomness: " + counter);
	}

	public double logProbability(PlayFairKey key) {

		char[] text = pfc.decrypt(hobbit.getCodedText(), key).toCharArray();
		double score = 0.0;
		for (int i = 0; i < text.length - 3; i++) {
			String s = "" + text[i] + text[i + 1] + text[i + 2] + text[i + 3];
			if (map.containsKey(s)) {
				score += (Math.log10(map.get(s)) / Math.log10(ngram.getTotal()));
			}
		}
		return score;
	}

	public PlayFairKey shuffleKey(PlayFairKey parent) {

		PlayFairKey key = new PlayFairKey(parent.getKey());
		int rnd = (int) (Math.random() * 100);

		switch (rnd) {
		case 1:
		case 2:
			key = this.swapRows(key);
			break;
		case 3:
		case 4:
			key = this.swapColumns(key);
			break;
		case 5:
		case 6:
			key = this.flipColumns(key);
			break;
		case 7:
		case 8:
			key = this.flipRows(key);
			break;

		case 9:
		case 10:
			key = this.ReverseKey(key);
			break;
		default:
			key = this.swapLetters(key);
			break;
		}

		return key;
	}

	private PlayFairKey swapLetters(PlayFairKey key) {
		Random random = new Random();
		char[] keyArr = key.getKey().toCharArray();
		int index1 = random.nextInt(25);
		int index2 = random.nextInt(25);
		char temp = keyArr[index1];
		keyArr[index1] = keyArr[index2];
		keyArr[index2] = temp;
		key.setKey(String.valueOf(keyArr));
		return key;
	}

	private PlayFairKey swapRows(PlayFairKey key) {
		Random random = new Random();
		char[] keyArr = key.getKey().toCharArray();
		int index1 = random.nextInt(5);
		int index2 = random.nextInt(5);
		char temp;
		for (int i = 0; i < 5; i++) {
			temp = keyArr[index1 * 5 + i];
			keyArr[index1 * 5 + i] = keyArr[index2 * 5 + i];
			keyArr[index2 * 5 + i] = temp;
		}
		key.setKey(String.valueOf(keyArr));
		return key;
	}

	private PlayFairKey swapColumns(PlayFairKey key) {
		Random random = new Random();
		char[] keyArr = key.getKey().toCharArray();
		int index1 = random.nextInt(5);
		int index2 = random.nextInt(5);
		char temp;
		for (int i = 0; i < 5; i++) {
			temp = keyArr[i * 5 + index1];
			keyArr[i * 5 + index1] = keyArr[i * 5 + index2];
			keyArr[i * 5 + index2] = temp;
		}
		key.setKey(String.valueOf(keyArr));
		return key;
	}

	private PlayFairKey flipRows(PlayFairKey key) {

		char[] keyArr = key.getKey().toCharArray();

		for (int i = 0; i < 2; ++i) {
			int k = 5 - 1 - i;
			for (int j = 0; j < 5; ++j) {
				char temp = keyArr[i * 5 + j];
				keyArr[i * 5 + j] = keyArr[k * 5 + j];
				keyArr[k * 5 + j] = temp;
			}
		}
		key.setKey(String.valueOf(keyArr));
		return key;
	}

	private PlayFairKey flipColumns(PlayFairKey key) {

		char[] keyArr = key.getKey().toCharArray();
		char[] newKeyArr = key.getKey().toCharArray();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				newKeyArr[i * 5 + j] = keyArr[(4 - i) * 5 + j]; // swap cols left-right
			}
		}
		key.setKey(String.valueOf(newKeyArr));
		return key;
	}

	private PlayFairKey ReverseKey(PlayFairKey key) {
		char[] keyArr = key.getKey().toCharArray();
		char[] newKeyArr = key.getKey().toCharArray();

		for (int k = 0; k < 25; k++) {
			newKeyArr[k] = keyArr[24 - k];
		}

		key.setKey(String.valueOf(newKeyArr));
		return key;
	}
}
