package ie.gmit.sw.test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import ie.gmit.sw.wordcloud.main.*;
import ie.gmit.sw.wordcloud.init.*;

public class TestImageGenerator {

	private ImageGenerator imageGenerator = null;
	
	@Before
	public void setup() throws Exception {
		imageGenerator = new ImageGenerator(new ImageConfigOne(), new HashMap<String, Integer>(), 35);
	}
	
	@After
	public void tearDown(){
		imageGenerator = null;
	}
	
	@Test
	public void validGenerateImage() throws Exception {
		assertNotNull(imageGenerator.generateImage(new ArrayList<WordConfig>(), 35));
	}
	
	@Test
	public void validSortFrequencies() throws Exception {
		assertNotNull(imageGenerator.sortFrequencies(new HashMap<String, Integer>()));
	}
	
	@Test(expected=Exception.class)
	public void nullConfiguration() throws Exception {
		imageGenerator.setConfig(null);
	}
}