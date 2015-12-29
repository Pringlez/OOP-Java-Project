package ie.gmit.sw.wordcloud;

import java.awt.Color;
import java.util.Random;

public class ColourFactory {
	
	private ColourFactory() {
	}
	
	public static Color getRandColor(){
		Random gen = new Random(System.nanoTime());
	    float r = gen.nextFloat();
	    float g = gen.nextFloat();
	    float b = gen.nextFloat();
	    Color randomColor = new Color(r, g, b);
	    return randomColor;
	}
}