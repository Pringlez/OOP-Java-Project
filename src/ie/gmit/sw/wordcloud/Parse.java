package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.gmit.sw.wordcloud.main.WordCloud;

/**  
* Parse.java - a abstract class that contains variables and methods
* shared between different types of text parsers.
* @author John Walsh
* @version 1.0 
* @see Parsable
*/
public abstract class Parse implements Parsable {
	
	private List<String> stopWords;
	private Map<String, Integer> wordFrequencyMap;
	
	public Parse() {
	}

	public Parse(String stopWordsPath) throws Exception{
		setStopWords(new ArrayList<String>());
		setWordFrequencyMap(new HashMap<String, Integer>());
		setStopWords(stopWordsPath);
	}
	
	/**
	 * This method is used to configure / set the words to be ignored
	 * by the parsing application.
	 * @param path is the location to the file to be parsed
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
	
	/**
	 * This method checks if the word passed is not in the stop words
	 * list, if so it will be ignored by the application.
	 * @param word is the word to be stored and used in image generation
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
	
	/**
	 * This method initializes / creates the word cloud image.
	 * @param imageOption the option controlling image configuration - 0, 1 and 2 options available
	 * @param maxWords the maximum amount of words to be rendered on the generated image
	 * @param outputFileName the outputted file name for the generated image
     * @throws Exception is thrown when an unexpected error has occurred
	 */
	public void createWordCloud(int imageOption, int maxWords, String outputFileName) throws Exception {
		WordCloud wordC = new WordCloud(getWordFrequencyMap());
		wordC.configWordCloud(imageOption, maxWords, outputFileName);
	}

	/**
	 * This method gets the stop words list.
	 * @return List
	 */
	public List<String> getStopWords() {
		return stopWords;
	}

	/**
	 * This method sets the stop words list.
	 * @param stopWords is the list containing the words to be ignored when parsing files or URL
     * @throws Exception is thrown when an unexpected error has occurred
	 */
	public void setStopWords(List<String> stopWords) throws Exception {
		if(stopWords == null) throw new Exception("Error: Invalid Stop Words List");
		
		this.stopWords = stopWords;
	}
	
	/**
	 * This method gets the word frequency map.
	 * @return Map
	 */
	public Map<String, Integer> getWordFrequencyMap() {
		return wordFrequencyMap;
	}

	/**
	 * This method sets the word frequency map.
	 * @param wordFrequencyMap is the map containing word frequencies
	 * @throws Exception is thrown when an unexpected error has occurred
	 */
	public void setWordFrequencyMap(Map<String, Integer> wordFrequencyMap) throws Exception {
		if(wordFrequencyMap == null) throw new Exception("Error: Invalid Word Frequency Map");
		
		this.wordFrequencyMap = wordFrequencyMap;
	}
}