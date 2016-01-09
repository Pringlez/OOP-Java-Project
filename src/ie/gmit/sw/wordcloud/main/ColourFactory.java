package ie.gmit.sw.wordcloud.main;

import java.awt.Color;
import java.util.Random;

/**  
* ColourFactory.java - A class that generates and returns an object of type Colour
* @author John Walsh
* @version 1.0.
*/
public class ColourFactory {
	
	public ColourFactory() {
	}
	
	/**
	 * This method generates a new object of type Colour.
	 * @return Color
	 */
	public Color getRandomColor(){
		
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