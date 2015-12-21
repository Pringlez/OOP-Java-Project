package ie.gmit.sw.wordcloud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

/*
 * The ParseURL class will be responsible for parsing 
 * words from a web site page
 */
public class ParseURL extends Parse {
	
	public ParseURL() {
		//super();
	}
	
	public void parseURL(String url) throws UnsupportedEncodingException, IOException {
		
		String inputLine;
		URL urlPath = new URL(url);
        URLConnection connection = urlPath.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder text = new StringBuilder();
        
        while ((inputLine = br.readLine()) != null)
        	text.append(inputLine);
        
        br.close();
        setText(text.toString());
        
        //System.out.println(text.toString());
	}
}