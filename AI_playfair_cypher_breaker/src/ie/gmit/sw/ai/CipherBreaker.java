package ie.gmit.sw.ai;

import java.util.Scanner;

import ie.gmit.sw.ai.Cipher.Key;
import ie.gmit.sw.ai.Cipher.PlayFairCipher;
import ie.gmit.sw.ai.Cipher.PlayFairKeyBuilder;
import ie.gmit.sw.ai.file.FileWriter;
import ie.gmit.sw.ai.file.NgramParser;
import ie.gmit.sw.ai.file.TextFileParser;
/***
 * 
 * The CipherBreaker program implements an application
 * that uses Simulated Anealing with heuristics to break
 * playfair ciphering.
 * 
 * @version 1.0
 * @author RnDMizeD
 *
 */
public class CipherBreaker {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// Parse hobbit file
		TextFileParser hobbit = new TextFileParser();
		NgramParser ngram = new NgramParser();

		
		/* Minimal user interface to demonstrate Simulateed Anealing working. */
		System.out.println("PlayFair Cipher Decryption Tool.");
		System.out.println("Enter file path (default: TheHobbit-Cypher(clean).txt):");
		String s = in.nextLine();
		if (s.length() == 0) {
			hobbit.parse("../TheHobbit-Cypher(clean).txt");
		} else {
			hobbit.parse(s);
		}

		System.out.println("Enter ngram file path (default: 4grams.txt):");
		s = in.nextLine();
		if (s.length() == 0) {
			ngram.parse("../4grams.txt");
		} else {
			ngram.parse(s);
		}


		// create a playfair cipher
		PlayFairCipher pfc = new PlayFairCipher();
		// Create and run simulated anealing
		SimulatedAnnealing sa = new SimulatedAnnealing(pfc, ngram);
		Key key = sa.breakPlayFairEncryption(hobbit.getTextSample(), PlayFairKeyBuilder.generateRandomKey());
		// Decrypt file
		System.out.println("Writing Output to file.");
		new FileWriter().writeFile(pfc.decrypt(hobbit.getText(), key));
		System.out.println("Done!");

	}

}
