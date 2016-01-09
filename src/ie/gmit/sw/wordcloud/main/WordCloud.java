package ie.gmit.sw.wordcloud.main;

import java.util.Map;
import ie.gmit.sw.wordcloud.init.*;

/**
 * WordCloud.java - A class thats responsible for configuring
 * the word cloud image before any words are rendered on the image
 * @author John Walsh
 * @version 1.0.
 */
public class WordCloud {
	
	private Map<String, Integer> wordFrequencyMap;

	/**
	 * A constructor that builds the WordCloud object.
	 * @param wordFrequencyMap The map containing word frequencies.
	 */
	public WordCloud(Map<String, Integer> wordFrequencyMap) {
		this.wordFrequencyMap = wordFrequencyMap;
	}
	
	/**
	 * This configures the word cloud before generation.
	 * @param imageOption The option controlling image configuration - 0, 1 and 2 options available.
	 * @param maxWords The maximum amount of words to be rendered on the generated image.
	 * @param outputFileName The outputted file name for the generated image.
	 * @throws Exception This is thrown when an unexpected error has occurred.
	 */
	public void configWordCloud(int imageOption, int maxWords, String outputFileName) throws Exception {
		
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
		
		new ImageGenerator(config, wordFrequencyMap, maxWords, outputFileName);
	}
}