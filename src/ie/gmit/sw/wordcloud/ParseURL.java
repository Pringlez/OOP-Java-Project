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
	}
	
	public void parseWords(String url) {
		
		try {
			URL urlPath = new URL(url);
	        URLConnection connection = urlPath.openConnection();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
	        StringBuilder sb = new StringBuilder();
	        String inputLine = br.readLine();
	        
	        while (inputLine != null) {
	        	
	            String[] words = inputLine.split(" ");
	            
	            for (int i = 0; i < words.length; i++) {
	            	if(!getStopWords().contains(words[i])){
		                if (getWordFrequency().get(words[i]) == null) {
		                	getWordFrequency().put(words[i], 1);
		                } 
		                else {
		                    int newValue = Integer.valueOf(String.valueOf(getWordFrequency().get(words[i])));
		                    newValue++;
		                    getWordFrequency().put(words[i], newValue);
		                }
	            	}
	            	else{
	            		//System.out.println("ParseURL: Word - " + words[i] + " Ignored");
	            	}
	            }
	            
	            sb.append(System.lineSeparator());
	            inputLine = br.readLine();
	        }
	        
	        br.close();
            
            //System.out.println(getWordFrequency().keySet());
            System.out.println("URL Parse Task Complete!");
		}
		catch(Exception e){
			System.out.println("Error - " + e);
		}
	}
}