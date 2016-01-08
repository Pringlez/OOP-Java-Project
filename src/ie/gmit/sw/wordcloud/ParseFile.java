package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;

/**  
* ParseFile.java - a class that is responsible for parsing 
* words from a text file
* @author John Walsh
* @version 1.0 
* @see ParseFile
*/
public class ParseFile extends Parse {

	private String outputFileName;
	
	public ParseFile(String stopWordsFile, String outputFileName) throws Exception {
		super(stopWordsFile);
		setOutputFileName(outputFileName);
	}
	
	/**
	 * This method is used to parse the words from a file found locally on the system.
	 */
	public void parseWords(String path, int imageOption, int maxWords) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
	        String inputLine = br.readLine();

            while (inputLine != null) {
            	
                String[] words = inputLine.split(" ");
                
                for (int i = 0; i < words.length; i++)
                	addWord(words[i].toLowerCase());
                
                inputLine = br.readLine();
            }
            
            br.close();
            
            System.out.println("File Parse Task Complete!");
            
            createWordCloud(imageOption, maxWords, getOutputFileName());
        }
		catch(Exception e){
			System.out.println("Error File - " + e);
			e.printStackTrace();
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
	 * @param outputFileName is the name of the file that will be generated
	 */
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
}