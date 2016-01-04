package ie.gmit.sw.wordcloud.main;

import java.util.Random;

public class PositionFactory {

	private PositionFactory() {
	}

	public static int getRandPos(int maxRange){
		Random gen = new Random(System.nanoTime());
	    int num = gen.nextInt(((maxRange - 100) - 100) + 1) + 100;
	    return num;
	}
}