# OOP-Java-Project
## John Walsh

Project Details
---------------
0. Current version of the project is nearly completion, only a few image generation problems still to fix
0. I've developed a GUI for the user to interact with the application API

To Run the App
--------------
To run the java application, open a command prompt / terminal window. Navigate to the directory containing the 'wordcloud.jar' file and run the following command. Also make sure to include the 'stopwords.txt' file.

```
java –cp ./wordcloud.jar ie.gmit.sw.Runner
```

API Usage
---------
You can also directly interact with the classes to generate a wordcloud image. The first argument
takes input from either the text file or URL, depending on what you instantiate. The second argument allows
you to select the image option, 0 - for image size of 800 x 600, 1 - for 1000 x 800, 2 - for 1200 x 1000. The
third argument allows you to specify the max words to be used in the image generation.

```
new ParseFile().parseWords("WarAndPeace.txt", 0, 35);
new ParseURL().parseWords("http://example.com/", 0, 35);
```

The can also use this method of instantiating the parsing classes.
```
Parse app;
		
app = new ParseFile("stopwords.txt");
app.parseWords("WarAndPeace.txt", 0, 35);

app = new ParseURL("stopwords.txt");
app.parseWords("http://example.com/", 0, 35);
```

Test Case
---------
ToDo