package ie.gmit.sw.wordcloud.main;

import java.awt.Font;
import java.awt.Shape;
import java.awt.font.GlyphVector;
import java.awt.geom.Area;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;

import ie.gmit.sw.wordcloud.init.Configurable;

/**  
* ImageGenerator.java - a class that generates the image from a file or URL.
* @author John Walsh
* @version 1.0.
*/
public class ImageGenerator {

	private Configurable config;
	private List<WordConfig> wordConfigList = new ArrayList<WordConfig>();
	private List<Shape> shapesList = new ArrayList<Shape>();

	public ImageGenerator(Configurable config, Map<String, Integer> wordFrequencyMap, int maxWords, String outputFileName) throws Exception {
		setConfig(config);
		sortFrequencies(wordFrequencyMap);
		generateImage(wordConfigList, maxWords, outputFileName);
	}
	
	/*
	 * Implementation generateImage, takes a List of configured words
	 * and max amount of words to be taken from that list to populate
	 * the image being created
	 */
	public boolean generateImage(List<WordConfig> wordConfigList, int maxWords, String outputFileName) {
		try {
		    ColourFactory colFactory = new ColourFactory();
		    PositionGenerator posGenerator = new PositionGenerator();
		    int wordCount = 0;
		    int wordCollisions = 0;
			
		    for(WordConfig wordConfig : this.wordConfigList) {
		    	if(wordCount < maxWords){
		    		if(!wordConfig.getWord().equals("")){
			    		
		    			getConfig().getGraphics().setColor(colFactory.getRandomColor());
		    			getConfig().getGraphics().setFont(new Font(Font.SANS_SERIF, Font.BOLD, wordConfig.getFontSize()));
		    			
			    		GlyphVector vect = getConfig().getGraphics().getFont().createGlyphVector(getConfig().getGraphics().getFontRenderContext(), wordConfig.getWord());
			    		
			    		Shape shape = vect.getOutline(wordConfig.getPosX(), wordConfig.getPosY());
			    		//getConfig().getGraphics().rotate(Math.toRadians(45));
				    	
				    	for(int i = 0; i < 1; i++){
					    	if(!shapesList.isEmpty()){
						    	for(Shape shapeTest : shapesList){
						    		if(checkShapeIntersect(shape, shapeTest)){
						    			wordConfig.setPosX(posGenerator.getRandomPos(getConfig().getMaxXPos()));
						    			wordConfig.setPosY(posGenerator.getRandomPos(getConfig().getMaxYPos()));
						    			shape = vect.getOutline(wordConfig.getPosX(), wordConfig.getPosY());
						    			wordCollisions++;
						    			i--;
						    		}
					    		}
					    	}
				    	}
				    	
				    	shapesList.add(shape);
				    	getConfig().getGraphics().fill(shape);
				    	
				    	//getConfig().getGraphics().drawString(wordConfig.getWord(), wordConfig.getPosX(), wordConfig.getPosY());
		    		}
		    		
		    		wordCount++;
		    	}
		    	else{
		    		break;
		    	}
		    }
		    
		    getConfig().getGraphics().dispose();
		    
		    ImageIO.write(getConfig().getImage(), "png", new File(outputFileName + ".png"));
		    System.out.println("Image Generated! - Word Collisions: " + wordCollisions);
		    
		    return true;
		}
		catch(Exception e){
			System.out.println("Something went wrong! - " + e);
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean sortFrequencies(Map<String, Integer> wordFrequency){
		
		int defaultFontSize = 50;
		PositionGenerator posGenerator = new PositionGenerator();
		
		try {
			for (Entry<String, Integer> pair : wordFrequency.entrySet()) { 
				if(!pair.getKey().equals("")){
			    	this.wordConfigList.add(new WordConfig(posGenerator.getRandomPos(getConfig().getMaxXPos()), posGenerator.getRandomPos(getConfig().getMaxYPos()), pair.getKey(), defaultFontSize, pair.getValue(), pair.getKey().length()));
				}
		    }
			
			/*
			 * Overriding the compare method to suit the implementation
			 * Comparing word frequencies to be sorted in descending order
			 */
			Comparator<WordConfig> freqComparator = new Comparator<WordConfig>() {
				@Override
				public int compare(WordConfig obj1, WordConfig obj2) {
					return -Integer.valueOf(obj1.getWordFreq()).compareTo(obj2.getWordFreq());
				}
			};
			
			Collections.sort(this.wordConfigList, freqComparator);
			
			int count = 0;
			
			for(WordConfig wordConfig : this.wordConfigList) {
				
				if(count == 0){
					wordConfig.setFontSize(90);
					wordConfig.setPosX((getConfig().getMaxXPos() / 2) - (wordConfig.getStrLength() * 25));
					wordConfig.setPosY(getConfig().getMaxYPos() / 2);
				}
				else if(count >= 1 && count <= 5){
		            wordConfig.setFontSize(50);
				}
				else if(count >= 6 && count <= 10){
					wordConfig.setFontSize(40);
				}
				else if(count >= 11 && count <= 25){
					wordConfig.setFontSize(22);
				}
				else{
					wordConfig.setFontSize(18);	
				}
				
		        count++;
	        }
			
			return true;
		}
		catch(Exception e){
			System.out.println("Something went wrong! - " + e);
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean checkShapeIntersect(Shape shapeA, Shape shapeB) {
	   Area areaA = new Area(shapeA);
	   areaA.intersect(new Area(shapeB));
	   return !areaA.isEmpty();
	}

	public Configurable getConfig() {
		return config;
	}

	public void setConfig(Configurable config) throws Exception {
		if(config == null) throw new Exception("Error: Invalid Configuration");
		
		this.config = config;
	}
}