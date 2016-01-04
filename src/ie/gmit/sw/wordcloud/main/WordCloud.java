package ie.gmit.sw.wordcloud.main;

import java.util.Map;
import ie.gmit.sw.wordcloud.init.*;

/*
 * The WordCloud class will be responsible for generating 
 * the word cloud image in png format
 */
public class WordCloud {
	
	private Map<String, Integer> wordFrequencyMap;

	public WordCloud(Map<String, Integer> wordFrequencyMap) {
		this.wordFrequencyMap = wordFrequencyMap;
	}
	
	public void configWordCloud(int imageOption, int maxWords) {
		
		Configurable config;
		
		switch(imageOption){
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
		
		new Generator(config, wordFrequencyMap, maxWords);
	}
}