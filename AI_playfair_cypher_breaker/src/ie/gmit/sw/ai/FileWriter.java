package ie.gmit.sw.ai;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {

	
public void writeFile(String text) {
	try (PrintWriter out = new PrintWriter("../output.txt")) {
	    out.println(text);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
