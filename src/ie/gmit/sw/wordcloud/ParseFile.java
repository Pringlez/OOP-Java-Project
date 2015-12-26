package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * The ParseFile class will be responsible for parsing 
 * words from a text file provided by the user
 */
public class ParseFile extends Parse {

	public ParseFile() {
		super("stopwords.txt");
	}
	
	public void parseWords(String path) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
	        StringBuilder sb = new StringBuilder();
	        String inputLine = br.readLine();

            while (inputLine != null) {
            	
                String[] words = inputLine.split(" ");
                
                for (int i = 0; i < words.length; i++) {
                	addWord(words[i]);
                }
                
                sb.append(System.lineSeparator());
                inputLine = br.readLine();
            }
            
            br.close();
            
            System.out.println(getWordFrequency().keySet());
            System.out.println("File Parse Task Complete!");
        }
		catch(Exception e){
			System.out.println("Error File - " + e);
		}
	}
}