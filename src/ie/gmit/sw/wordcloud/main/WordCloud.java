package ie.gmit.sw.wordcloud.main;

import java.util.Map;
import ie.gmit.sw.wordcloud.init.*;

/*
 * The WordCloud class will be responsible for configuring
 * the word cloud image before any words are drawn on the image
 */
public class WordCloud {
	
	private Map<String, Integer> wordFrequencyMap;

	public WordCloud(Map<String, Integer> wordFrequencyMap) {
		this.wordFrequencyMap = wordFrequencyMap;
	}
	
	public void configWordCloud(int imageOption, int maxWords) throws Exception {
		
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
		
		new ImageGenerator(config, wordFrequencyMap, maxWords);
	}
}