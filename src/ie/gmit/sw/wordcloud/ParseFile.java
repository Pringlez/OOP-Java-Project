package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * The ParseFile class will be responsible for parsing 
 * words from a text file provided by the user
 */
public class ParseFile extends Parse {

	public ParseFile(String stopWordsFile) throws Exception {
		super(stopWordsFile);
	}
	
	public void parseWords(String path, int imageOption, int maxWords) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
	        String inputLine = br.readLine();

            while (inputLine != null) {
            	
                String[] words = inputLine.split(" ");
                
                for (int i = 0; i < words.length; i++)
                	addWord(words[i].toLowerCase());
                
                inputLine = br.readLine();
            }
            
            br.close();
            
            //System.out.println(getWordFrequency().keySet());
            System.out.println("File Parse Task Complete!");
            
            createWordCloud(imageOption, maxWords);
        }
		catch(Exception e){
			System.out.println("Error File - " + e);
			e.printStackTrace();
		}
	}
}