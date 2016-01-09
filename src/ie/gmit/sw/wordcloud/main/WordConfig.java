package ie.gmit.sw.wordcloud.main;

/**
 * WordConfig.java - A class thats responsible for storing
 * the configuration of words that have been parsed
 * @author John Walsh
 * @version 1.0.
 */
public class WordConfig {

	private int posX;
	private int posY;
	private String word;
	private int fontSize;
	private int wordFreq;
	private int strLength;

	/**
	 * A constructor that builds the WordConfig object.
	 * @param posX The X position of the image.
	 * @param posY The Y position of the image.
	 * @param word The word to be generated in the image.
	 * @param fontSize The font size of the word.
	 * @param wordFreq The word frequency occurrence.
	 * @param strLength The string length of the word.
	 */
	public WordConfig(int posX, int posY, String word, int fontSize, int wordFreq, int strLength) {
		setPosX(posX);
		setPosY(posY);
		setWord(word);
		setFontSize(fontSize);
		setWordFreq(wordFreq);
		setStrLength(strLength);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getWordFreq() {
		return wordFreq;
	}

	public void setWordFreq(int wordFreq) {
		this.wordFreq = wordFreq;
	}
	
	public int getStrLength() {
		return strLength;
	}

	public void setStrLength(int strLength) {
		this.strLength = strLength;
	}
}