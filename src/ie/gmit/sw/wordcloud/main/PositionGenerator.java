package ie.gmit.sw.wordcloud.main;

import java.util.Random;

/**  
* PositionGenerator.java - a class that generates and returns a random
* number between 100 and user's max range requested
* @author John Walsh
* @version 1.0.
*/
public class PositionGenerator {
	
	public PositionGenerator() {
	}

	public int getRandomPos(int maxRange){
		Random gen = new Random(System.nanoTime());
	    int num = gen.nextInt(((maxRange - 100) - 100) + 1) + 100;
	    return num;
	}
}