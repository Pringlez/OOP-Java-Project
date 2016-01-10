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
* ImageGenerator.java - A class that generates the image from the parsed words of a file or URL
* @author John Walsh
* @version 1.0.
*/
public class ImageGenerator {

	private Configurable config;
	private List<WordConfig> wordConfigList = new ArrayList<WordConfig>();
	private List<Shape> shapesList = new ArrayList<Shape>();
	
	private boolean clearToGenerate = false;
	
	/**
	 * A constructor that builds the ImageGenerator object.
	 * @param config The image configuration of type Configurable.
	 * @param wordFrequencyMap The map containing word frequencies.
	 * @throws Exception This is thrown when an unexpected error has occurred.
	 */
	public ImageGenerator(Configurable config, Map<String, Integer> wordFrequencyMap) throws Exception {
		setConfig(config);
		clearToGenerate = sortFrequencies(wordFrequencyMap);
	}
	
	/**
	 * This method takes a List of configured words, max amount of words
	 * and output file name to be used to generate the image.
	 * @param maxWords The maximum amount of words to be rendered on the generated image.
	 * @param outputFileName The outputted file name for the generated image.
	 * @return boolean
	 */
	public boolean generateImage(int maxWords, String outputFileName) {
		// If word frequencies have been sorted then continue 
		if(clearToGenerate){
			try {
			    ColourFactory colFactory = new ColourFactory();
			    PositionGenerator posGenerator = new PositionGenerator();
			    int wordCount = 0;
			    int wordCollisions = 0;
				
			    for(WordConfig wordConfig : this.wordConfigList) {
			    	if(wordCount < maxWords){
			    		if(!wordConfig.getWord().equals("")){
				    		
			    			// Generating a shape from the configuration, font type, font size and default shape position set
			    			getConfig().getGraphics().setColor(colFactory.getRandomColor());
			    			getConfig().getGraphics().setFont(new Font(Font.SANS_SERIF, Font.BOLD, wordConfig.getFontSize()));
			    			
				    		GlyphVector vect = getConfig().getGraphics().getFont().createGlyphVector(getConfig().getGraphics().getFontRenderContext(), wordConfig.getWord());
				    		
				    		Shape shape = vect.getOutline(wordConfig.getPosX(), wordConfig.getPosY());
				    		//getConfig().getGraphics().rotate(Math.toRadians(45));
					    	
				    		// Checking the shape against previous generated shapes and their positions
					    	for(int i = 0; i < 1; i++){
						    	if(!shapesList.isEmpty()){
							    	for(Shape shapeTest : shapesList){
							    		// If shape intersects with another shape then generate a new position until a good position is found
							    		if(checkShapeIntersect(shape, shapeTest)){
							    			wordConfig.setPosX(posGenerator.getRandomPos(getConfig().getMinPos(), getConfig().getMaxXPos()));
							    			wordConfig.setPosY(posGenerator.getRandomPos(getConfig().getMinPos(), getConfig().getMaxYPos()));
							    			shape = vect.getOutline(wordConfig.getPosX(), wordConfig.getPosY());
							    			wordCollisions++;
							    			i--;
							    		}
						    		}
						    	}
					    	}
					    	
					    	// Adding shape to list and applying shape to image
					    	shapesList.add(shape);
					    	getConfig().getGraphics().fill(shape);
			    		}
			    		
			    		wordCount++;
			    	}
			    	else{
			    		break;
			    	}
			    }
			    
			    getConfig().getGraphics().dispose();
			    
			    // Writing out the image to file with name specified from user
			    ImageIO.write(getConfig().getImage(), "png", new File(outputFileName + ".png"));
			    System.out.println("Image Generated! - Word Collisions Avoided: " + wordCollisions + " - Filename: " + outputFileName + ".png");
			    
			    return true;
			}
			catch(Exception e){
				System.out.println("Something went wrong! - " + e);
				e.printStackTrace();
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	/**
	 * This method takes a List of configured words, max amount of words
	 * and output file name to be used to generate the image.
	 * @param wordFrequencyMap The map containing word frequencies.
	 * @return boolean
	 */
	public boolean sortFrequencies(Map<String, Integer> wordFrequencyMap){
		
		int defaultFontSize = 50;
		clearToGenerate = false;
		PositionGenerator posGenerator = new PositionGenerator();
		
		// Add the words from the word frequency map to the word config list with generated positions and default font size
		try {
			for (Entry<String, Integer> pair : wordFrequencyMap.entrySet()) { 
				if(!pair.getKey().equals("")){
			    	this.wordConfigList.add(new WordConfig(posGenerator.getRandomPos(getConfig().getMinPos(), getConfig().getMaxXPos()), posGenerator.getRandomPos(getConfig().getMinPos(), getConfig().getMaxYPos()), pair.getKey(), defaultFontSize, pair.getValue(), pair.getKey().length()));
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
			
			// Sorting the coolection
			Collections.sort(this.wordConfigList, freqComparator);
			
			int count = 0;
			
			// Looping through the new list of words to set their correct font sizes
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
	
	/**
	 * This method takes two shapes and compare them to see if they intersect each other.
	 * @param shapeA The shape to compare against the other.
	 * @param shapeB The shape to compare against the other.
	 * @return boolean
	 */
	private boolean checkShapeIntersect(Shape shapeA, Shape shapeB) {
	   Area areaA = new Area(shapeA);
	   areaA.intersect(new Area(shapeB));
	   return !areaA.isEmpty();
	}

	/**
	 * This method gets the image configuration of type Configurable.
	 * @return Configurable
	 */
	public Configurable getConfig() {
		return config;
	}

	/**
	 * This method sets the image configuration of type Configurable.
	 * @param config The image configuration of type Configurable.
	 * @throws Exception This is thrown when an unexpected error has occurred.
	 */
	public void setConfig(Configurable config) throws Exception {
		if(config == null) throw new Exception("Error: Invalid Configuration");
		
		this.config = config;
	}
}