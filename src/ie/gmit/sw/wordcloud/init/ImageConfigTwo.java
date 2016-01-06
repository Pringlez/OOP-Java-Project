package ie.gmit.sw.wordcloud.init;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageConfigTwo implements Configurable {

	private final int maxXPos = 1000;
	private final int maxYPos = 800;
	
	private Font font;
	private BufferedImage image;
	private Graphics2D graphics;
	
	public ImageConfigTwo(){
		setup();
	}
	
	public void setup() {
		this.image = new BufferedImage(maxXPos, maxYPos, BufferedImage.TYPE_4BYTE_ABGR);
		this.graphics = getImage().createGraphics();
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
	
	public Graphics2D getGraphics() {
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