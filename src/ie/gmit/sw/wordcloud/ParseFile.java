package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/*
 * The ParseFile class will be responsible for parsing 
 * words from a text file provided by the user
 */
public class ParseFile extends Parse {

	public ParseFile() {
		//super();
	}
	
	public void parseFile(String path) throws UnsupportedEncodingException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
            	
                String[] words = line.split(" ");
                
                for (int i = 0; i < words.length; i++) {
                    if (getWordFrequency().get(words[i]) == null) {
                    	getWordFrequency().put(words[i], 1);
                    } 
                    else {
                        int newValue = Integer.valueOf(String.valueOf(getWordFrequency().get(words[i])));
                        newValue++;
                        getWordFrequency().put(words[i], newValue);
                    }
                }
                
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            
            //System.out.println(getWordFrequency().keySet());
        }
	}
}