package ie.gmit.sw.wordcloud;

import java.util.Map;
import ie.gmit.sw.wordcloud.init.*;

/*
 * The WordCloud class will be responsible for generating 
 * the word cloud image in png format
 */
public class WordCloud {
	
	private Map<String, Integer> wordFrequency;

	public WordCloud(Map<String, Integer> wordFrequency) {
		this.wordFrequency = wordFrequency;
	}
	
	public void genWordCloud(int option) {
		
		Configurable config;
		
		switch(option){
			case 0:
				config = new ImageConfigOne();
			break;
			case 1:
				config = new ImageConfigTwo();
			break;
			case 2:
				config = new ImageConfigThree();
			break;
			default:
				config = new ImageConfigOne();
			break;
		}
		
		new Generator(config, wordFrequency);
	}
}