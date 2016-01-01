package ie.gmit.sw.wordcloud;

public class StringConfig {

	private int posX;
	private int posY;
	private int fontSize;
	private int wordFreq;
	
	public StringConfig(int posX, int posY, int fontSize, int wordFreq) {
		setPosX(posX);
		setPosY(posY);
		setFontSize(fontSize);
		setWordFreq(wordFreq);
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