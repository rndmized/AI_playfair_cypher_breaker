package ie.gmit.sw.ai;

public interface Cipher {
	
	public String encrypt(String text, Key key);
	
	public String decrypt(String text, Key key);

}
