package ie.gmit.sw.wordcloud.main;

public class WordConfig {

	private int posX;
	private int posY;
	private String word;
	private int fontSize;
	private int wordFreq;
	private int strLength;
	
	public int getStrLength() {
		return strLength;
	}

	public void setStrLength(int strLength) {
		this.strLength = strLength;
	}

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
}