package ie.gmit.sw;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import ie.gmit.sw.wordcloud.*;
import ie.gmit.sw.gui.*;

public class Runner {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		new ParseURL().parseURL("http://example.com/");
		new ParseFile().parseFile("stopwords.txt");
		new WordCloudGUI();
	}
}