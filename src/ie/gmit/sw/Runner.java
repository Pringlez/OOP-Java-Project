package ie.gmit.sw;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import ie.gmit.sw.wordcloud.*;
import ie.gmit.sw.gui.*;

public class Runner {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		
		//new ParseFile().parseWords("WarAndPeace.txt");
		//new ParseURL().parseWords("http://example.com/");
		
		Parse app;
		
		//app = new ParseFile();
		//app.parseWords("WarAndPeace.txt");
		
		app = new ParseURL();
		app.parseWords("http://example.com/");
		
		//new WordCloudGUI();
	}
}