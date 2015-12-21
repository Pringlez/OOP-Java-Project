package ie.gmit.sw.wordcloud;

import java.util.Map;

/*
 * The WordCloud class will be responsible for generating 
 * the word cloud image in png format
 */
public class WordCloud {
	
	protected Map<String, Integer> wordFrequency;

	public WordCloud(Map<String, Integer> wordFrequency) {
		this.wordFrequency = wordFrequency;
	}
	
	public void generateWordCloud(){
		
	}
}