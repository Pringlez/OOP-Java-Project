package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.gmit.sw.wordcloud.main.WordCloud;

/*
 * The Parse abstract class will contain variables & methods
 * shared between different types of parsers
 * 
 * It implements the parsable interface which must be implemented
 * by subclasses of this class 'Parse'
 */
public abstract class Parse implements Parsable {
	
	private List<String> stopWords;
	private Map<String, Integer> wordFrequencyMap;
	
	public Parse() {
	}

	public Parse(String stopWordsPath){
		setStopWords(new ArrayList<String>());
		setWordFrequencyMap(new HashMap<String, Integer>());
		setStopWords(stopWordsPath);
	}
	
	/*
	 * This method is used to configure / set the words to be ignored
	 * by the parsing application
	 */
	public void setStopWords(String path) {
		
		BufferedReader reader;
		String line;
		
		try {
			reader = new BufferedReader(new FileReader(path));
			
			while ((line = reader.readLine()) != null)
			    this.stopWords.add(line);
			
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Error - " + e);
		}
	}
	
	/*
	 * This method checks if the word passed is not in the stop words
	 * list, if so it will be ignored by the application.
	 * If the word is valid it will be added to the hash map or 
	 * increment the frequency value if it's already contained in the map.
	 */
	public void addWord(String word){
		if(!getStopWords().contains(word)){
            if (getWordFrequencyMap().get(word) == null) {
            	getWordFrequencyMap().put(word, 1);
            } 
            else {
                int newValue = Integer.valueOf(String.valueOf(getWordFrequencyMap().get(word)));
                newValue++;
                getWordFrequencyMap().put(word, newValue);
            }
    	}
	}
	
	/*
	 *  The option variable is used to configure the image
	 */
	public void createWordCloud(int imageOption, int maxWords){
		WordCloud wordC = new WordCloud(getWordFrequencyMap());
		wordC.configWordCloud(imageOption, maxWords);
	}

	public List<String> getStopWords() {
		return stopWords;
	}

	public void setStopWords(List<String> stopWords) {
		this.stopWords = stopWords;
	}
	
	public Map<String, Integer> getWordFrequencyMap() {
		return wordFrequencyMap;
	}

	public void setWordFrequencyMap(Map<String, Integer> wordFrequencyMap) {
		this.wordFrequencyMap = wordFrequencyMap;
	}
}