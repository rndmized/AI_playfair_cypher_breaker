package ie.gmit.sw.ai.file;

/***
 * Interface defining the behavior of a parser.
 * 
 * @author RnDMizeD
 *
 */
public interface Parser {

	/***
	 * Parse a file.
	 * 
	 * @param fileName file name and its path.
	 */
	public void parse(String fileName);
	
}
