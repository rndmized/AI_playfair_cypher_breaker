package ie.gmit.sw.ai.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/***
 * FileWriter outputs a string into a text file.
 * 
 * @author RnDMizeD
 * @version 1.01
 *
 */
public class FileWriter {

	/***
	 * Write string into a text file called output.txt
	 * 
	 * @param text The string to print into the file.
	 */
public void writeFile(String text, String fileName) {
	try (PrintWriter out = new PrintWriter(fileName + ".txt")) {
	    out.println(text);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
}
