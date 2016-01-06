package ie.gmit.sw.wordcloud.main;

import java.awt.Font;
import java.awt.Shape;
import java.awt.font.GlyphVector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;

import ie.gmit.sw.wordcloud.init.Configurable;

public class ImageGenerator {

	private Configurable config;
	private List<WordConfig> wordConfigList = new ArrayList<WordConfig>();

	public ImageGenerator(Configurable config, Map<String, Integer> wordFrequencyMap, int maxWords) throws Exception {
		setConfig(config);
		sortFrequencies(wordFrequencyMap);
		generateImage(wordConfigList, maxWords);
	}
	
	/*
	 * Implementation generateImage, takes a List of configured words
	 * and max amount of words to be taken from that list to populate
	 * the image being created
	 */
	public boolean generateImage(List<WordConfig> wordConfigList, int maxWords) {
		try {
		    ColourFactory colFactory = new ColourFactory();
		    int wordCount = 0;
			
		    for(WordConfig wordConfig : this.wordConfigList) {
		    	if(wordCount < maxWords){
		    		if(!wordConfig.getWord().equals("")){
			    		
		    			getConfig().getGraphics().setColor(colFactory.getRandomColor());
		    			getConfig().getGraphics().setFont(new Font(Font.SANS_SERIF, Font.BOLD, wordConfig.getFontSize()));
			    		
			    		GlyphVector vect = getConfig().getGraphics().getFont().createGlyphVector(getConfig().getGraphics().getFontRenderContext(), wordConfig.getWord());
				    	Shape shape = vect.getOutline(0f, (float) -vect.getVisualBounds().getY());
				        
				        //graphics.rotate(Math.toRadians(45));
				    	getConfig().getGraphics().fill(shape);
				    	getConfig().getGraphics().drawString(wordConfig.getWord(), wordConfig.getPosX(), wordConfig.getPosY());
		    		}
		    		wordCount++;
		    	}
		    	else{
		    		break;
		    	}
		    }
		    
		    getConfig().getGraphics().dispose();
		    
		    ImageIO.write(getConfig().getImage(), "png", new File("image.png"));
		    System.out.println("Image Generated! - 2");
		    
		    return true;
		}
		catch(Exception e){
			System.out.println("Something went wrong! - " + e);
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean sortFrequencies(Map<String, Integer> wordFrequency){
		
		int defaultPosX = 0;
		int defaultPosY = 0;
		int defaultFontSize = 50;
		
		try {
			for (Entry<String, Integer> pair : wordFrequency.entrySet()) { 
				if(!pair.getKey().equals("")){
			    	this.wordConfigList.add(new WordConfig(defaultPosX, defaultPosY, pair.getKey(), defaultFontSize, pair.getValue(), pair.getKey().length()));
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
			
			int posX = 0;
			int posY = 0;
			int count = 0;
			
			PositionGenerator posGenerator = new PositionGenerator();
			
			for(WordConfig wordConfig : this.wordConfigList) {
				
				posX = posGenerator.getRandomPos(getConfig().getMaxXPos());
		        posY = posGenerator.getRandomPos(getConfig().getMaxYPos());
				
				if(count == 0){
					wordConfig.setFontSize(90);
					wordConfig.setPosX((getConfig().getMaxXPos() / 2) - (wordConfig.getStrLength() * 25));
					wordConfig.setPosY(getConfig().getMaxYPos() / 2);
				}
				else if(count >= 1 && count <= 5){
		            wordConfig.setFontSize(60);
		            wordConfig.setPosX(posX);
					wordConfig.setPosY(posY);
				}
				else if(count >= 6 && count <= 10){
					wordConfig.setFontSize(30);
					wordConfig.setPosX(posX);
					wordConfig.setPosY(posY);
				}
				else if(count >= 11 && count <= 25){
					wordConfig.setFontSize(16);
					wordConfig.setPosX(posX);
					wordConfig.setPosY(posY);
				}
				else{
					wordConfig.setFontSize(10);
					wordConfig.setPosX(posX);
					wordConfig.setPosY(posY);
				}
				
		        System.out.println("Test - Font Size: " + wordConfig.getFontSize() + " Pos X: " + wordConfig.getPosX() + " Pos Y: " + wordConfig.getPosY());
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

	public Configurable getConfig() {
		return config;
	}

	public void setConfig(Configurable config) throws Exception {
		if(config == null) throw new Exception("Error: Invalid Configuration");
		
		this.config = config;
	}
}