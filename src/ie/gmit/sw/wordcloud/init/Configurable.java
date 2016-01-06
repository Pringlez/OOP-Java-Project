package ie.gmit.sw.wordcloud.init;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public interface Configurable {
	public void setup();
	public Font getFont();
	public void setFont(Font font);
	public Graphics2D getGraphics();
	public BufferedImage getImage();
	public int getMaxXPos();
	public int getMaxYPos();
}