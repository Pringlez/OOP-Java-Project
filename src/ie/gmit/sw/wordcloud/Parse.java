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
* Parse.java - An abstract class that contains variables and methods
* shared between different types of text parsers
* @author John Walsh
* @version 1.0 
* @see Parsable
*/
public abstract class Parse implements Parsable {
	
	private List<String> stopWords;
	private Map<String, Integer> wordFrequencyMap;
	
	public Parse() {
	}

	/**
	 * A constructor that builds the Parse object.
	 * @param stopWordsPath The location to the stop words file.
	 * @throws Exception This is thrown when an unexpected error has occurred.
	 */
	public Parse(String stopWordsPath) throws Exception{
		setStopWords(new ArrayList<String>());
		setWordFrequencyMap(new HashMap<String, Integer>());
		setStopWords(stopWordsPath);
	}
	
	/**
	 * This method is used to configure / set the words to be ignored
	 * by the parsing application.
	 * @param path The location to the file to be parsed.
	 */
	public void setStopWords(String path) {
		
		BufferedReader reader;
		String line;
		
		try {
			reader = new BufferedReader(new FileReader(path));
			
			// Reading file line by line, add the words to the list
			while ((line = reader.readLine()) != null)
			    this.stopWords.add(line);
			
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Error - " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * This method checks if the word passed is in the stop words.
	 * list, if so it will be ignored by the application.
	 * If the word is not in the stop words list it will be added to
	 * the image generator map.
	 * @param word The word to be stored and used in image generation.
	 */
	public void addWord(String word){
		// Checking if the word is contained in the stop words list
		if(!getStopWords().contains(word)){
			// If word is not found in the frequency map, create new key / value pair
            if (getWordFrequencyMap().get(word) == null) {
            	getWordFrequencyMap().put(word, 1);
            } 
            else {
            	// Else increment value of key already in map
                int newValue = Integer.valueOf(String.valueOf(getWordFrequencyMap().get(word)));
                newValue++;
                getWordFrequencyMap().put(word, newValue);
            }
    	}
	}
	
	/**
	 * This method initializes / creates the word cloud image.
	 * @param imageOption The option controlling image configuration - 0, 1 and 2 options available.
	 * @param maxWords The maximum amount of words to be rendered on the generated image.
	 * @param outputFileName The outputted file name for the generated image.
	 * @return boolean
     * @throws Exception This is thrown when an unexpected error has occurred.
	 */
	public boolean createWordCloud(int imageOption, int maxWords, String outputFileName) throws Exception {
		WordCloud wordC = new WordCloud(getWordFrequencyMap());
		return wordC.configWordCloud(imageOption, maxWords, outputFileName);
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
	 * @param stopWords The list containing the words to be ignored when parsing files or URL.
     * @throws Exception This is thrown when an unexpected error has occurred.
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
	 * @param wordFrequencyMap The map containing word frequencies.
	 * @throws Exception This is thrown when an unexpected error has occurred.
	 */
	public void setWordFrequencyMap(Map<String, Integer> wordFrequencyMap) throws Exception {
		if(wordFrequencyMap == null) throw new Exception("Error: Invalid Word Frequency Map");
		
		this.wordFrequencyMap = wordFrequencyMap;
	}
}