package ie.gmit.sw.PlayFair;

import java.awt.Point;

public class PlayFairCipher {

	private PlayFairKey key;
	private int length = 0;

	public PlayFairCipher(PlayFairKey key) {
		this.key = key;

	}

	public String encrypt(String text) {
		text = text.toLowerCase();
		if(text.length()%2 != 0) text+='x';
		String cipheredText = cipher(text);
		return cipheredText;

	}

	public String decrypt(String text, PlayFairKey key) {
		String decodedText = this.decode(text.toLowerCase(), key);
		if(decodedText.endsWith("x")) decodedText = decodedText.substring(0, decodedText.length()-1);
		return decodedText;

	}

	
	private String cipher(String in) {
		length = (int) in.length() / 2 + in.length() % 2;

		// insert x between double-letter digraphs & redefines "length"
		for (int i = 0; i < (length - 1); i++) {
			if (in.charAt(2 * i) == in.charAt(2 * i + 1)) {
				in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
				length = (int) in.length() / 2 + in.length() % 2;
			}
		}

		// adds an x to the last digraph, if necessary
		String[] digraph = new String[length];
		for (int j = 0; j < length; j++) {
			if (j == (length - 1) && in.length() / 2 == (length - 1))
				in = in + "X";
			digraph[j] = in.charAt(2 * j) + "" + in.charAt(2 * j + 1);
		}

		// encodes the digraphs and returns the output
		String out = "";
		String[] encDigraphs = new String[length];
		encDigraphs = encodeDigraph(digraph);
		for (int k = 0; k < length; k++)
			out = out + encDigraphs[k];
		return out;
	}

	// encodes the digraph input with the cipher's specifications
	private String[] encodeDigraph(String di[]) {
		String[] enc = new String[length];
		for (int i = 0; i < length; i++) {
			char a = di[i].charAt(0);
			char b = di[i].charAt(1);
			int r1 = (int) getPoint(a).getX();
			int r2 = (int) getPoint(b).getX();
			int c1 = (int) getPoint(a).getY();
			int c2 = (int) getPoint(b).getY();

			// case 1: letters in digraph are of same row, shift columns to
			// right
			if (r1 == r2) {
				c1 = (c1 + 1) % 5;
				c2 = (c2 + 1) % 5;

				// case 2: letters in digraph are of same column, shift rows
				// down
			} else if (c1 == c2) {
				r1 = (r1 + 1) % 5;
				r2 = (r2 + 1) % 5;

				// case 3: letters in digraph form rectangle, swap first column
				// # with second column #
			} else {
				int temp = c1;
				c1 = c2;
				c2 = temp;
			}

			// performs the table look-up and puts those values into the encoded
			// array
			enc[i] = key.toMatrix()[r1][c1] + "" + key.toMatrix()[r2][c2];
		}
		return enc;
	}

	// decodes the output given from the cipher and decode methods (opp. of
	// encoding process)
	private String decode(String out, PlayFairKey newKey) {
		String decoded = "";
		this.key = newKey;
		for (int i = 0; i < out.length() / 2; i++) {
			char a = out.charAt(2 * i);
			char b = out.charAt(2 * i + 1);
			int r1 = (int) getPoint(a).getX();
			int r2 = (int) getPoint(b).getX();
			int c1 = (int) getPoint(a).getY();
			int c2 = (int) getPoint(b).getY();
			if (r1 == r2) {
				c1 = (c1 + 4) % 5;
				c2 = (c2 + 4) % 5;
			} else if (c1 == c2) {
				r1 = (r1 + 4) % 5;
				r2 = (r2 + 4) % 5;
			} else {
				int temp = c1;
				c1 = c2;
				c2 = temp;
			}
			decoded = decoded + key.toMatrix()[r1][c1] + key.toMatrix()[r2][c2];
		}
		return decoded;
	}

	// returns a point containing the row and column of the letter
	private Point getPoint(char c) {
		Point pt = new Point(0, 0);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				if (c == key.toMatrix()[i][j])
					pt = new Point(i, j);
		return pt;
	}

}
