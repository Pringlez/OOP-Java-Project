package ie.gmit.sw.wordcloud.main;

import java.util.Random;

public class PositionGenerator {

	public PositionGenerator() {
	}

	public int getRandomPos(int maxRange){
		Random gen = new Random(System.nanoTime());
	    int num = gen.nextInt(((maxRange - 100) - 100) + 1) + 100;
	    return num;
	}
}