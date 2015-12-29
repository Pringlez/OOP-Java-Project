package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * The ParseURL class will be responsible for parsing 
 * words from a web site page
 */
public class ParseURL extends Parse {
	
	public ParseURL() {
		super("stopwords.txt");
	}
	
	public void parseWords(String url) {
		
		try {
			URL urlPath = new URL(url);
	        URLConnection connection = urlPath.openConnection();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
	        StringBuilder sb = new StringBuilder();
	        String inputLine = br.readLine();
	        
	        while (inputLine != null) {
	        	
	        	char[] chars = inputLine.toCharArray();
	        	
	        	boolean validCharsFound = false;
	        	String word = "";
	        	
	        	for(int i = 0; i < chars.length; i++){
	        		if(isValidChar(chars[i])){
	        			sb.append(chars[i]);
	        			if(!validCharsFound)
	        				validCharsFound = true;
	        		}
	        		else{
	        			if(validCharsFound){
	        				word = sb.toString();
	        				validCharsFound = false;
	        				addWord(word);
	    	        		sb.setLength(0);
	        			}
	        		}
	        	}
	        	
	        	inputLine = br.readLine();
	        }
	        
	        br.close();
            
            //System.out.println(getWordFrequency().keySet());
            System.out.println("URL Parse Task Complete!");
            
            genWordCloud(0);
		}
		catch(Exception e){
			System.out.println("Error URL - " + e);
		}
	}
	
	private boolean isValidChar(char testChar){
		try{
			if((testChar > 'A' && testChar < 'Z') || (testChar > 'a' && testChar < 'z')){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;	
		}
	}
}