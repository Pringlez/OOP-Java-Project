package ie.gmit.sw.wordcloud;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import ie.gmit.sw.wordcloud.init.Configurable;

public class Generator {

	private Configurable config;
	
	public Generator(Configurable config, Map<String, Integer> wordFrequency) {
		setConfig(config);
		generate(wordFrequency);
	}
	
	public void generate(Map<String, Integer> wordFrequency){
	    
	    for (Entry<String, Integer> pair : wordFrequency.entrySet()) { 
	    	
	    	if(!pair.getKey().equals("")){
	        
		        //getConfig().getGraphics().setColor(ColourFactory.getRandColor());
	    		getConfig().getGraphics().setColor(Color.red);
		        
		        // TODO - Need to set font size of the word according to the frequency in the map
		        //getConfig().getGraphics().setFont(new Font(Font.SANS_SERIF, Font.BOLD, pair.getValue()));
		        getConfig().getGraphics().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		        getConfig().getGraphics().drawString(pair.getKey(), PositionFactory.getRandPos(getConfig().getMaxXPos()), PositionFactory.getRandPos(getConfig().getMaxYPos()));
	    	}
	    }
		
		try {
			ImageIO.write(getConfig().getImage(), "png", new File("image.png"));
			System.out.println("Image Generated!");
		} catch (IOException e) {
			System.out.println("Something went wrong!");
			//e.printStackTrace();
		}
	}

	public Configurable getConfig() {
		return config;
	}

	public void setConfig(Configurable config) {
		this.config = config;
	}
}