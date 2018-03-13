package ie.gmit.sw.PlayFair;

import java.util.Random;

public class Test1 {
	
	
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
			System.out.println("Swapping rows!");
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
			System.out.println("Swapping columns!");
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
			System.out.println("Reversing the key!");
			key = new PlayFairKeyGenerator().generateKey(new StringBuilder(keyString).reverse().toString());
			break;
		default:
			System.out.println("Swapping one letter!");
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
