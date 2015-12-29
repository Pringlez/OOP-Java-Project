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
 * 
 * It implements the parsable interface which must be implemented
 * by subclasses of this class 'Parse'
 */
public abstract class Parse implements Parsable {
	
	private List<String> stopWords;
	private Map<String, Integer> wordFrequency;
	
	public Parse() {
	}

	public Parse(String stopWordsPath){
		setStopWords(new ArrayList<String>());
		setWordFrequency(new HashMap<String, Integer>());
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
            if (getWordFrequency().get(word) == null) {
            	getWordFrequency().put(word, 1);
            } 
            else {
                int newValue = Integer.valueOf(String.valueOf(getWordFrequency().get(word)));
                newValue++;
                getWordFrequency().put(word, newValue);
            }
    	}
	}
	
	public void genWordCloud(int option){
		WordCloud wordC = new WordCloud(getWordFrequency());
		wordC.genWordCloud(option);
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