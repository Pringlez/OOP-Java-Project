package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * The Parse abstract class will contain variables & methods
 * shared between different types of parsers
 */
public abstract class Parse implements Parsable {
	
	private List<String> stopWords;
	private Map<String, Integer> wordFrequency;

	public Parse(){
		this.stopWords = new ArrayList<String>();
		this.wordFrequency = new HashMap<String, Integer>();
		setStopWords("stopwords.txt");
	}
	
	/*
	 * This method will parse the words from the word frequency
	 * hash map to the word cloud generator 
	 */
	/*public void parseWords() {
		new WordCloud(this.getWordFrequency());
	}*/
	
	public void setStopWords(String path) {
		
		BufferedReader reader;
		String line;
		
		try {
			reader = new BufferedReader(new FileReader(path));
			
			while ((line = reader.readLine()) != null)
			    this.stopWords.add(line);
			
			reader.close();
			
			/*for (String word : this.stopWords)
			    System.out.println("String: " + word);*/
			
		} 
		catch (IOException e) {
			System.out.println("Error - " + e);
		}
	}

	public List<String> getStopWords() {
		return stopWords;
	}

	public void setStopWords(List<String> stopWords) {
		this.stopWords = stopWords;
	}
	
	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}

	public void setWordFrequency(Map<String, Integer> wordFrequency) {
		this.wordFrequency = wordFrequency;
	}
}