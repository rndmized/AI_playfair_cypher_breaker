package ie.gmit.sw.ai.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/***
 * Parser that reads a text file.
 * 
 * @author RnDMizeD
 *
 */
public class TextFileParser implements Parser {
	
	private String text = "";
	
	/***
	 * Constructor
	 */
	public TextFileParser() {	}
	
	
	/***
	 * Parse the provided file.
	 * 
	 * @param filepath The file to parse along its path.
	 */
	public TextFileParser(String filepath) {
		this.parse(filepath);
	}

	@Override
	public void parse(String fileName) {
		System.out.println("Starting to parse file....");

		 try {
			 File file = new File(fileName);
			 
	            // Use this for reading the data.
	            byte[] buffer = new byte[(int) file.length()];

	            FileInputStream inputStream = 
	                new FileInputStream(fileName);

	            // read fills buffer with data and returns
	            // the number of bytes read (which of course
	            // may be less than the buffer size, but
	            // it will never be more).

	            while((inputStream.read(buffer)) != -1) {
	                // Convert to String so we can concat it to the text.
	                text += new String(buffer).toString();
	
	            }   

	            // Close the file.
	            inputStream.close();  
	            System.out.println("File parsed!");

	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	        }

}

	/***
	 * Return the parsed text as string.
	 * @return parsed text.
	 */
	public String getText() {
		return text;
	}
	

	/***
	 * Return sample of the parsed text.
	 * 
	 * @return sample of parsed text.
	 */
	public String getTextSample() {
		return text.substring(0, 400);
	}


	}

