package ie.gmit.sw;

import ie.gmit.sw.wordcloud.*;
import ie.gmit.sw.gui.*;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		//new ParseFile().parseWords("WarAndPeace.txt", 0, 35);
		//new ParseURL().parseWords("http://example.com/", 0, 35);
		
		Parse app;
		
		app = new ParseFile("stopwords.txt");
		app.parseWords("WarAndPeace.txt", 0, 35);
		
		app = new ParseURL("stopwords.txt");
		app.parseWords("http://example.com/", 0, 35);
		
		//new WordCloudGUI();
	}
}