package ie.gmi.sw.ai;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Ngram implements Parser {
	
	private Map<String, Integer> map =  new HashMap<String, Integer>();
	
	public Ngram(String filePath){
		this.parse(filePath);
	}
	

	public Map<String, Integer> getMap() {
		return map;
	}

	
	public void setMap(Map<String, Integer> map) {
		this.map = map;
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
						map.put(words[0].toLowerCase(), Integer.parseInt(words[1]));
						}
					
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
	}

