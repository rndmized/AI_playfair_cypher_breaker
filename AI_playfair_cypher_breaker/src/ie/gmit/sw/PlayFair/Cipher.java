package ie.gmit.sw.PlayFair;

public interface Cipher {
	
	public String encrypt(String text);
	
	public String decrypt(Key key);

}
