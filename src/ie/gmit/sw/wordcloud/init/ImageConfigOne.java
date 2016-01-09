package ie.gmit.sw.wordcloud.init;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**  
* ImageConfigOne.java - A class that contains a configuration for an image
* The dimensions for this image configuration is 1200 x 1000
* @author John Walsh
* @version 1.0 
* @see Configurable
*/
public class ImageConfigOne implements Configurable {

	private int minPos;
	private final int maxXPos = 800;
	private final int maxYPos = 600;
	
	private Font font;
	private BufferedImage image;
	private Graphics2D graphics;
	
	/**
	 * A constructor that builds the ImageConfigOne object.
	 */
	public ImageConfigOne(){
		setup();
		setMinPos(100);
	}
	
	public void setup() {
		this.image = new BufferedImage(maxXPos, maxYPos, BufferedImage.TYPE_4BYTE_ABGR);
		this.graphics = getImage().createGraphics();
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
	public Graphics2D getGraphics() {
		return graphics;
	}
	
	public BufferedImage getImage(){
		return this.image;
	}
	
	public int getMinPos() {
		return this.minPos;
	}
	
	public void setMinPos(int px) {
		this.minPos = px;
	}

	public int getMaxXPos() {
		return maxXPos;
	}

	public int getMaxYPos() {
		return maxYPos;
	}
}