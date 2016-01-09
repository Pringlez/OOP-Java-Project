package ie.gmit.sw;

import ie.gmit.sw.wordcloud.*;
import ie.gmit.sw.gui.*;

/**
 * Runner.java - A class that tests the word cloud API.
 * @author  John Walsh
 * @version 1.0.
 */
public class Runner {

	public static void main(String[] args) throws Exception {
		
		//new ParseFile().parseWords("WarAndPeace.txt", 0, 35);
		//new ParseURL().parseWords("http://example.com/", 0, 35);
		
		Parse app;
		
		app = new ParseFile("stopwords.txt", "fileparse");
		app.parseWords("WarAndPeace.txt", 0, 50);
		
		app = new ParseURL("stopwords.txt", "urlparse");
		app.parseWords("http://www.bbc.com/news", 0, 50);
		
		//new WordCloudGUI();
	}
}