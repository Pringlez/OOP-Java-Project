package ie.gmit.sw.wordcloud;

import java.awt.Color;
import java.util.Random;

public class ColourFactory {
	
	private ColourFactory() {
	}
	
	/*public static Color getRandColor(){
		Random gen = new Random(System.nanoTime());
	    float r = gen.nextFloat();
	    float g = gen.nextFloat();
	    float b = gen.nextFloat();
	    Color randomColor = new Color(r, g, b);
	    return randomColor;
	}*/
	
	public static Color getRandColor(){
		
		Random gen = new Random(System.nanoTime());
		int num = gen.nextInt((6 - 0) + 1) + 0;
	    Color randomColor;
	    
	    switch(num){
	    	case 0:
	    		randomColor = Color.red;
	    	break;
	    	case 1:
	    		randomColor = Color.green;
		    break;
	    	case 2:
	    		randomColor = Color.blue;
		    break;
	    	case 3:
	    		randomColor = Color.orange;
		    break;
	    	case 4:
	    		randomColor = Color.pink;
		    break;
	    	case 5:
	    		randomColor = Color.yellow;
		    break;
	    	case 6:
	    		randomColor = Color.magenta;
		    break;
		    default:
		    	randomColor = Color.red;
		    break;
	    }
	    
	    return randomColor;
	}
}