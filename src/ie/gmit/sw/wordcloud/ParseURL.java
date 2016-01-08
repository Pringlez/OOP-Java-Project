package ie.gmit.sw.wordcloud;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**  
* ParseURL.java - a class that is responsible for parsing 
* words from a URL
* @author John Walsh
* @version 1.0 
* @see ParseURL
*/
public class ParseURL extends Parse {
	
	private String outputFileName;
	
	public ParseURL(String stopWordsFile, String outputFileName) throws Exception {
		super(stopWordsFile);
		setOutputFileName(outputFileName);
	}

	/**
	 * This method is used to configure / set the words to be ignored
	 * by the parsing application.
	 * @param url is the URL the parser will attempt to parse
	 * @param imageOption is the image configuration option
	 * @param maxWords is the max words the parser will render in the image
	 */
	public void parseWords(String url, int imageOption, int maxWords) {
		try {
			Document doc = Jsoup.connect(url).get();
			String text = doc.body().text();
			
			String[] words = text.split(" ");
            
            for (int i = 0; i < words.length; i++)
            	addWord(words[i].toLowerCase());
        
	        //System.out.println(getWordFrequency().keySet());
	        System.out.println("URL Parse Task Complete!");
	        
	        createWordCloud(imageOption, maxWords, getOutputFileName());
		}
		catch(Exception e){
			System.out.println("Error URL - " + e);
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