package ie.gmit.sw.PlayFair;

public class PlayFairKey extends Key {
	
	private String key;
	
	public PlayFairKey() {
		super();
	}
		
	public PlayFairKey(String key) {
		super();
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setKey(char[][] key) {
		
		StringBuilder stringBuilder = new StringBuilder();
        
		for (int i = 0; i < 5; i++) {
        	for (int j = 0; j < 5; j++) {
        		stringBuilder.append(key[i][j]);
			}
		}

		this.key = stringBuilder.toString();
		
	}	
	
	
	public char[][] toMatrix(){
		
		char[][] charArray = new char[5][5];
        char[] keyArray = this.key.toCharArray();
        for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				charArray[i][j] = keyArray[(i*5) +j];
			}
		}
        return charArray;
		
	}

	public void displayMatrix(){
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(this.toMatrix()[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
