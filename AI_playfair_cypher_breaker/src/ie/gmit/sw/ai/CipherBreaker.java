package ie.gmit.sw.ai;


public class CipherBreaker {

	public static void main(String[] args) {

		//Parse hobbit file
		PlayFairEncryptedTextFileParser hobbit = new PlayFairEncryptedTextFileParser("../TheHobbit-Cypher(clean).txt");
		//Parse ngram
		NgramParser ngram = new NgramParser("../4grams.txt");
		//create a playfair cipher
		PlayFairCipher pfc = new PlayFairCipher();
		//Create a key
		new PlayFairKeyBuilder();
		//Create simulated annealing
		SimulatedAnnealing sa = new SimulatedAnnealing(pfc, ngram);
		Key key = sa.breakPlayFairEncryption(hobbit.getTextSample(), PlayFairKeyBuilder.generateRandomKey());
		//Decrypt file
		System.out.println("Writing Output to file.");
		new FileWriter().writeFile(pfc.decrypt(hobbit.getText(), key));
		System.out.println("Done!");
		
	}

}
