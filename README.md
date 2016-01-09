# OOP-Java-Project
## John Walsh

Project Details
---------------
0. I've developed a GUI to demonstrate usage of the word cloud API, you can either parse a file or URL with this user interface. It will
generate the images in the same directory as the wordcloud.jar file.
0. For more details on the word cloud API, see the java docs if you need more information on specific classes or methods.

To Run the GUI
--------------
To run the java application, open a command prompt / terminal window. Navigate to the directory containing the 'wordcloud.jar' file and run the following command. Include the 'stopwords.txt' file in the same directory, you can also specific a different word ignore file in the GUI application.

```
java –cp ./wordcloud.jar ie.gmit.sw.Runner
```

API Usage
---------
You can also directly interact with the classes to generate a wordcloud image. 

### ParseFile / ParseURL Class Parameters
The first argument is the path to the word ignore file, I've included the 'stopwords.txt' as a sample file.
The second argument allows you to specify the output file name of the generated word cloud image.

### parseWords Method Parameters
The first argument takes input from either the text file or URL, depending on what class parser you instantiate. 
The second argument allows you to select the image option, 0 - for image size of 800 x 600, 1 - for 1000 x 800, 2 - for 1200 x 1000. 
The third argument allows you to specify the maximum amount of words to be used in the image generation.

### Code Snippets
Below is sample usage of the word cloud API.

```
new ParseFile("stopwords.txt", "fileparse").parseWords("WarAndPeace.txt", 0, 35);
new ParseURL("stopwords.txt", "urlparse").parseWords("http://www.bbc.com/news", 1, 75);
new ParseURL("stopwords.txt", "urlparse").parseWords("http://news.sky.com", 1, 75);
```

The following example is another way of using the word cloud API.
```
Parse app;
		
app = new ParseFile("stopwords.txt", "fileparse");
app.parseWords("WarAndPeace.txt", 0, 50);
		
app = new ParseURL("stopwords.txt", "urlparse");
app.parseWords("http://www.bbc.com/news", 0, 50);
```
