package ie.gmit.sw.ai;

import java.util.Map;
import java.util.Random;

import ie.gmit.sw.ai.Cipher.Cipher;
import ie.gmit.sw.ai.Cipher.Key;
import ie.gmit.sw.ai.Cipher.PlayFairCipher;
import ie.gmit.sw.ai.Cipher.PlayFairKey;
import ie.gmit.sw.ai.file.NgramParser;

/***
 * The Simulated Anealing makes use of heuristics to score the quality of the text
 * decrypted by using a key and creates permutations from such key either until it reaches
 * the best solution or a certain number of permutations elapsed.
 * 
 * 
 * @author RnDMizeD
 *
 */
public class SimulatedAnnealing {

	private Cipher pfc;
	private NgramParser ngram;
	private Map<String, Integer> map;

	/***
	 * Constructor. Creates instance of this class.
	 * 
	 * @param playFairCipher This is the cipher used to decrypt the text.
	 * @param ngram This is the ngram used to calculate the appropriate heuristic.
	 */
	public SimulatedAnnealing(Cipher playFairCipher,  NgramParser ngram) {

		this.pfc = playFairCipher;
		this.ngram = ngram;
		this.init();

	}
	
	/* Initialize map to the ngram map */
	private void init() {
		map = ngram.getMap();
	}

	/***
	 * Simulated Anealing algorithm.
	 * It makes use of heuristics to permutate a playfair key to drypt a message encripted 
	 * using playfair cipher for which we don't know the key.
	 * 
	 * @param text This is the text to decrypt.
	 * @param parent This is the initial key provided.
	 * @return
	 */
	public Key breakPlayFairEncryption(String text, Key parent) {
		System.out.println("Started Simmulated Annealing to break PlayFair Cipher.");
		/* Initialize the score to the score of the first parent */
		double maxScore = logProbability(text, parent);
		/* Loop the temperature */
		for (int temp = 10; temp >= 0; temp--) {
			/* For every Transition */
			for (int transitions = 50000; transitions > 0; transitions--) {
				/* Permutate the key */
				Key child = shuffleKey(parent);
				/* Calculate the heuristic value of the new key */
				double score = logProbability(text, child);
				/* Calculate the distance between both keys (new and old) */
				double delta = score - maxScore;
				/* If the new key is better */
				if (delta > 0) {
					/* Assing it to be the new parent and update the best score*/
					maxScore = score;
					parent.setKey(child.getKey());
				}
				/* Otherwise, as higher the temperature, add in some randomness to 
				 * avoid plateaus by ocassionally assigning a worse key to be the parent key. */
				if (delta < 0) {
					if (temp > 0) {
						double prob = Math.pow(Math.E, delta / temp);
						if (prob > 0.5) {
							maxScore = score;
							parent.setKey(child.getKey());
						}

					}
				}
			}
			/* Display some information after every iteration. */
			System.out.println("Temperature: " + temp);
			System.out.println("Highest score in this iteration: " + maxScore);
			System.out.println("Best candidate Key in this iteration: " + parent.getKey());
		}
		/* Return the best key found in this simulation. */
		return parent;
	}

	/***
	 * Calculate the score or heuristic value of a giving key.
	 * 
	 * @param encryptedText The text to test the key against.
	 * @param key The key to decryot the text. Also the key we want to obtain the score from.
	 * @return The score of a key for a given text.
	 */
	private double logProbability(String encryptedText, Key key) {

		/* Decrypt the text using a given key */
		char[] text = pfc.decrypt(encryptedText, key).toCharArray();
		double score = 0.0;
		/* Break the text in 4grams and score each of them by using ngrams to calculate the number of appearences
		 * of such 4gram in a given language. */
		for (int i = 0; i < text.length - 3; i++) {
			String s = "" + text[i] + text[i + 1] + text[i + 2] + text[i + 3];
			if (map.containsKey(s)) {
				score += (Math.log10(map.get(s)) / Math.log10(ngram.getTotal()));
			}
		}
		return score;
	}

	/***
	 * This function randomly permutates the key.
	 * 
	 * @param parent This is the key to change.
	 * @return The permutated key.
	 */
	private PlayFairKey shuffleKey(Key parent) {

		/* Create a new key out of the one provided */
		PlayFairKey key = new PlayFairKey(parent.getKey());
		/* Get a random number*/
		int rnd = (int) (Math.random() * 100);
		/* Depending on the random number change the key on some predetermined way. */
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
	
	/***
	 * This method swap two letters in the matrix.
	 * 
	 * @param key This is the key that will be changed.
	 * @return The key changed.
	 */
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

	/***
	 * This method swap two rows in the matrix.
	 * 
	 * @param key This is the key that will be changed.
	 * @return The key changed.
	 */
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

	/***
	 * This method swap two columns in the matrix.
	 * 
	 * @param key This is the key that will be changed.
	 * @return The key changed.
	 */
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

	/***
	 * This method flip all rows in the matrix.
	 * 
	 * @param key This is the key that will be changed.
	 * @return The key changed.
	 */
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
	
	/***
	 * This method flip all columns in the matrix.
	 * 
	 * @param key This is the key that will be changed.
	 * @return The key changed.
	 */
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

	/***
	 * This method reverses the key matrix.
	 * 
	 * @param key This is the key that will be changed.
	 * @return The key changed.
	 */
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
