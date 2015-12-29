package ie.gmit.sw.wordcloud;

import java.util.Random;

public class PositionFactory {

	private PositionFactory() {
	}

	public static int getRandPos(int maxRange){
		Random gen = new Random(System.nanoTime());
	    int num = gen.nextInt();
	    return num;
	}
}