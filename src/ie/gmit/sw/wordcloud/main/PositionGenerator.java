package ie.gmit.sw.wordcloud.main;

import java.util.Random;

/**  
* PositionGenerator.java - A class that generates and returns a random
* number between min and max range requested
* @author John Walsh
* @version 1.0.
*/
public class PositionGenerator {
	
	public PositionGenerator() {
	}

	/**
	 * This method generates and returns a random
	 * number between min and the max range requested.
	 * @param minRange The minimum range of area in px.
	 * @param maxRange The maximum range of area in px.
	 * @return int
	 */
	public int getRandomPos(int minRange, int maxRange){
		Random gen = new Random(System.nanoTime());
	    int num = gen.nextInt(((maxRange - minRange) - minRange) + 1) + minRange;
	    return num;
	}
}