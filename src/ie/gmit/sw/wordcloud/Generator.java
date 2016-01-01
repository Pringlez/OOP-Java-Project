package ie.gmit.sw.wordcloud;

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
	private List<StringConfig> wordConfig = new ArrayList<StringConfig>();

	public Generator(Configurable config, Map<String, Integer> wordFrequency) {
		setConfig(config);
		sortFrequencies(wordFrequency);
		generateImage(wordFrequency);
		generateImage2(wordFrequency);
	}
	
	/*
	 * Implementation number 1
	 */
	public void generateImage(Map<String, Integer> wordFrequency){
		
		int posX = 0;
		int posY = 0;
		
		try {
		    for (Entry<String, Integer> pair : wordFrequency.entrySet()) { 
		    	if(!pair.getKey().equals("")){
		        
			        getConfig().getGraphics().setColor(ColourFactory.getRandColor());
			        getConfig().getGraphics().setFont(new Font(Font.SANS_SERIF, Font.BOLD, pair.getValue()));
			        
			        posX = PositionFactory.getRandPos(getConfig().getMaxXPos());
			        posY = PositionFactory.getRandPos(getConfig().getMaxYPos());
			        
			        getConfig().getGraphics().drawString(pair.getKey(), posX, posY);
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
	public void generateImage2(Map<String, Integer> wordFrequency) {
		
		try {
			System.out.println("Max Size: " + getConfig().getMaxXPos() + " " + getConfig().getMaxYPos());
			
			BufferedImage image = new BufferedImage(getConfig().getMaxXPos(), getConfig().getMaxYPos(), BufferedImage.TYPE_INT_ARGB);
		    Graphics2D graphics = image.createGraphics();
		    StringConfig wordConfig = null;
		    
		    int count = 0;
			
		    for (Entry<String, Integer> pair : wordFrequency.entrySet()) {
		    	if(count < 35){
		    		if(!pair.getKey().equals("")){
			    		wordConfig = this.wordConfig.get(0);
			    		
			    		graphics.setColor(ColourFactory.getRandColor());
			    		graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, wordConfig.getFontSize()));
			    		
			    		GlyphVector vect = getConfig().getGraphics().getFont().createGlyphVector(graphics.getFontRenderContext(), pair.getKey());
				    	Shape shape = vect.getOutline(0f, (float) -vect.getVisualBounds().getY());
				        
				        //graphics.rotate(Math.toRadians(45));
				        graphics.fill(shape);
				        graphics.drawString(pair.getKey(), wordConfig.getPosX(), wordConfig.getPosY());
		    		}
		    	
		    		count++;
		    		this.wordConfig.remove(0);
		    	}
		    	else{
		    		break;
		    	}
		    }
		    
		    System.out.println("Count: " + count);
		    
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
		
		int posX = 0;
		int posY = 0;
		int count = 0;
		
		try {
			for (Entry<String, Integer> pair : wordFrequency.entrySet()) { 
				if(!pair.getKey().equals("")){
					if(count > 0){
						posX = PositionFactory.getRandPos(getConfig().getMaxXPos());
				        posY = PositionFactory.getRandPos(getConfig().getMaxYPos());
					}
			        
			    	this.wordConfig.add(new StringConfig(posX, posY, 50, pair.getValue()));
			    	
			    	count++;
				}
		    }
			
			Comparator<StringConfig> freqComparator = new Comparator<StringConfig>() {
				@Override
				public int compare(StringConfig obj1, StringConfig obj2) {
					return -Integer.valueOf(obj1.getWordFreq()).compareTo(obj2.getWordFreq());
				}
			};
			
			Collections.sort(this.wordConfig, freqComparator);
			
			count = 0;
			
			for(StringConfig wordList : this.wordConfig) {
				if(count == 0){
					wordList.setFontSize(120);
				}
				else if(count == 1){
		            wordList.setFontSize(90);
				}
				else if(count >= 1 && count <= 10){
					wordList.setFontSize(70);
				}
				else if(count >= 10 && count <= 25){
					wordList.setFontSize(40);
				}
				else{
					wordList.setFontSize(25);
				}
				
		        System.out.println("Test: " + wordList.getFontSize() + " Pos X: " + wordList.getPosX() + " Pos Y: " + wordList.getPosY());
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