package ie.gmit.sw.wordcloud;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * The ParseURL class will be responsible for parsing 
 * words from a web site page
 */
public class ParseURL extends Parse {
	
	public ParseURL(String stopWordsFile) {
		super(stopWordsFile);
	}

	public void parseWords(String url, int imageOption, int maxWords) {
		try {
			Document doc = Jsoup.connect(url).get();
			String text = doc.body().text();
			
			String[] words = text.split(" ");
            
            for (int i = 0; i < words.length; i++)
            	addWord(words[i].toLowerCase());
        
	        //System.out.println(getWordFrequency().keySet());
	        System.out.println("URL Parse Task Complete!");
	        
	        createWordCloud(imageOption, maxWords);
		}
		catch(Exception e){
			System.out.println("Error URL - " + e);
		}
	}
}