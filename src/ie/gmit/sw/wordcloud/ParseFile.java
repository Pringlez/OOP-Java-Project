package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * The ParseFile class will be responsible for parsing 
 * words from a text file provided by the user
 */
public class ParseFile extends Parse {

	public ParseFile() {
	}
	
	public void parseWords(String path) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
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
	            		//System.out.println("ParseFile: Word - " + words[i] + " Ignored");
	            	}
                }
                
                sb.append(System.lineSeparator());
                inputLine = br.readLine();
            }
            
            br.close();
            
            //System.out.println(getWordFrequency().keySet());
            System.out.println("File Parse Task Complete!");
        }
		catch(Exception e){
			System.out.println("Error - " + e);
		}
	}
}