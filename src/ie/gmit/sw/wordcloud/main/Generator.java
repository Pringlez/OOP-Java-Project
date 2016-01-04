package ie.gmit.sw.wordcloud.main;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;

import ie.gmit.sw.wordcloud.init.Configurable;

public class Generator {

	private Configurable config;
	private List<WordConfig> wordConfigList = new ArrayList<WordConfig>();

	public Generator(Configurable config, Map<String, Integer> wordFrequencyMap, int maxWords) {
		setConfig(config);
		sortFrequencies(wordFrequencyMap);
		generateImage(wordConfigList, maxWords);
		generateImage2(wordConfigList, maxWords);
	}
	
	/*
	 * Implementation number 1
	 */
	public void generateImage(List<WordConfig> wordConfigList, int maxWords){
		try {
			int wordCount = 0;
			
			for(WordConfig wordConfig : this.wordConfigList) {
				if(wordCount < maxWords){
			    	if(!wordConfig.getWord().equals("")){
				        getConfig().getGraphics().setColor(ColourFactory.getRandColor());
				        getConfig().getGraphics().setFont(new Font(Font.SANS_SERIF, Font.BOLD, wordConfig.getFontSize()));
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
			System.out.println("Image Generated! - 1");
		}
		catch(Exception e){
			System.out.println("Something went wrong! - " + e);
			e.printStackTrace();
		}
	}
	
	/*
	 * Implementation number 2
	 */
	public void generateImage2(List<WordConfig> wordConfigList, int maxWords) {
		try {
			BufferedImage image = new BufferedImage(getConfig().getMaxXPos(), getConfig().getMaxYPos(), BufferedImage.TYPE_INT_ARGB);
		    Graphics2D graphics = image.createGraphics();
		    
		    int wordCount = 0;
			
		    for(WordConfig wordConfig : this.wordConfigList) {
		    	if(wordCount < maxWords){
		    		if(!wordConfig.getWord().equals("")){
			    		
			    		graphics.setColor(ColourFactory.getRandColor());
			    		graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, wordConfig.getFontSize()));
			    		
			    		GlyphVector vect = getConfig().getGraphics().getFont().createGlyphVector(graphics.getFontRenderContext(), wordConfig.getWord());
				    	Shape shape = vect.getOutline(0f, (float) -vect.getVisualBounds().getY());
				        
				        //graphics.rotate(Math.toRadians(45));
				        graphics.fill(shape);
				        graphics.drawString(wordConfig.getWord(), wordConfig.getPosX(), wordConfig.getPosY());
		    		}
		    		wordCount++;
		    	}
		    	else{
		    		break;
		    	}
		    }
		    
		    graphics.dispose();
		    
		    ImageIO.write(image, "png", new File("test.png"));
		    System.out.println("Image Generated! - 2");
		}
		catch(Exception e){
			System.out.println("Something went wrong! - " + e);
			e.printStackTrace();
		}
	}
	
	public void sortFrequencies(Map<String, Integer> wordFrequency){
		
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
			
			for(WordConfig wordConfig : this.wordConfigList) {
				
				posX = PositionFactory.getRandPos(getConfig().getMaxXPos());
		        posY = PositionFactory.getRandPos(getConfig().getMaxYPos());
				
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
		}
		catch(Exception e){
			System.out.println("Something went wrong! - " + e);
			e.printStackTrace();
		}
	}

	public Configurable getConfig() {
		return config;
	}

	public void setConfig(Configurable config) {
		this.config = config;
	}
}