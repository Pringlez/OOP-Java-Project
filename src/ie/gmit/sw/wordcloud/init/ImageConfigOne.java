package ie.gmit.sw.wordcloud.init;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageConfigOne implements Configurable {

	private final int maxXPos = 800;
	private final int maxYPos = 600;
	
	private Font font;
	private BufferedImage image;
	private Graphics graphics;
	
	public ImageConfigOne(){
		setup();
	}
	
	public void setup() {
		this.image = new BufferedImage(maxXPos, maxYPos, BufferedImage.TYPE_4BYTE_ABGR);
		this.graphics = image.getGraphics();
	}

	public Font getFont() {
		return font;
	}

	/*
	 * (non-Javadoc)
	 * @see ie.gmit.sw.wordcloud.init.Configurable#setFont(java.awt.Font)
	 * Useful for overriding font configuration
	 */
	public void setFont(Font font) {
		this.font = font;
	}
	
	public Graphics getGraphics() {
		return graphics;
	}
	
	public BufferedImage getImage(){
		return this.image;
	}

	public int getMaxXPos() {
		return maxXPos;
	}

	public int getMaxYPos() {
		return maxYPos;
	}
}