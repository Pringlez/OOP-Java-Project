package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;

/**  
* ParseFile.java - A class that is responsible for parsing words from a text file
* @author John Walsh
* @version 1.0 
* @see ParseFile
*/
public class ParseFile extends Parse {

	private String outputFileName;
	
	/**
	 * A constructor that builds the ParseFile object.
	 * @param stopWordsFile The location to the stop words file.
	 * @param outputFileName The outputted file name for the generated image.
	 * @throws Exception This is thrown when an unexpected error has occurred.
	 */
	public ParseFile(String stopWordsFile, String outputFileName) throws Exception {
		super(stopWordsFile);
		setOutputFileName(outputFileName);
	}
	
	/**
	 * This method is used to parse the words from a file found locally on the system.
	 * @param path The location to the file to be parsed.
	 * @param imageOption The option controlling image configuration - 0, 1 and 2 options available.
	 * @param maxWords The maximum amount of words to be rendered on the generated image.
	 * @return boolean
	 */
	public boolean parseWords(String path, int imageOption, int maxWords) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
	        String inputLine = br.readLine();

	        // Loop while input has another line to process
            while (inputLine != null) {
            	
                String[] words = inputLine.split(" ");
                
                // Add word, setting to lowercase
                for (int i = 0; i < words.length; i++)
                	addWord(words[i].toLowerCase());
                
                inputLine = br.readLine();
            }
            
            br.close();
            
            System.out.println("File Parsing Complete!");
            
            return createWordCloud(imageOption, maxWords, getOutputFileName());
        }
		catch(Exception e){
			System.out.println("Error File - " + e);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method gets the output file name.
	 * @return String
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * This method sets the output file name.
	 * @param outputFileName The name of the file that will be generated.
	 */
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
}