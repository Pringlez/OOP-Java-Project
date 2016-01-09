package ie.gmit.sw.wordcloud.init;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**  
* Configurable.java - An interface of type configurable
* Contains common methods used between different types of configurations
* @author John Walsh
* @version 1.0 
*/
public interface Configurable {
	public void setup();
	public Font getFont();
	public void setFont(Font font);
	public Graphics2D getGraphics();
	public BufferedImage getImage();
	public int getMinPos();
	public void setMinPos(int px);
	public int getMaxXPos();
	public int getMaxYPos();
}