package ie.gmit.sw.ai.file;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/***
 * Parser that reads an Ngram file.
 * 
 * @author RnDMizeD
 *
 */
public class NgramParser implements Parser {
	
	private Map<String, Integer> map =  new HashMap<String, Integer>();
	private long total;
	
	/***
	 * Takes file in a filepath to parse.
	 * 
	 * @param filePath File and file path to parse. 
	 */
	public NgramParser(String filePath){
		this.parse(filePath);
	}
	
/***
 * Constructor
 */
	public NgramParser() {
	}

/***
 * Gets map built from ngram file containing an ngram string as key and the number of occurrences of such ngram as integer.
 * 
 * @return the map of ngrams and their occurrences.
 */
	public Map<String, Integer> getMap() {
		return map;
	}

/***
 * The total amount of occurences of the total of ngrams of an ngram file.
 * 
 * @return
 */
	public long getTotal() {
		return total;
	}


	@Override
	public void parse(String fileName) {

		// Create a buffer reader
				BufferedReader br;
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
					
					String line = null;
					// for every line in the InputStream
					while ((line = br.readLine()) != null) {
						// Split it eliminating symbols and spaces 
						String[] words = line.split("[\\s@&.,;:?$+-]+");// using regex
						//Add words up to shingle size to buffer list
						map.put(words[0], Integer.parseInt(words[1]));
						total += Integer.parseInt(words[1]);
						}
					
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
	}

