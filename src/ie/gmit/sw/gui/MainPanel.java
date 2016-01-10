package ie.gmit.sw.gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ie.gmit.sw.wordcloud.Parse;
import ie.gmit.sw.wordcloud.ParseFile;
import ie.gmit.sw.wordcloud.ParseURL;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int fileCount = 0;
	private String fileName = ""; 
	
	private JLabel txtStatus;
	
	private JPanel parseFilePanel;
	private JPanel parseUrlPanel;
	
	private Border bGreyLine = BorderFactory.createLineBorder(Color.GRAY, 1, true);
	private TitledBorder panelOptionsTitle = BorderFactory.createTitledBorder(bGreyLine, "Options", 2, 2);
	private TitledBorder panelFileTitle = BorderFactory.createTitledBorder(bGreyLine, "Parse File", 2, 2);
	private TitledBorder panelUrlTitle = BorderFactory.createTitledBorder(bGreyLine, "Parse URL", 2, 2);
	private TitledBorder panelSettingsTitle = BorderFactory.createTitledBorder(bGreyLine, "Settings", 2, 2);
	private TitledBorder panelResultsTitle = BorderFactory.createTitledBorder(bGreyLine, "Result", 2, 2);
	
	private JTextField textFieldFile;
	private JTextField textFieldURL;
	private JTextField maxWords;
	private JTextField outputFileName;
	private JTextField stopWordsFile;
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	
	private ImageIcon resultImage;
	private JLabel resultImageLabel;
	
	private JRadioButton rdbtnImgOption1;
	private JRadioButton rdbtnImgOption2;
	private JRadioButton rdbtnImgOption3;
	
	private JPanel parseResultPanel;
	
	private Parse app;
	
	public MainPanel() {
		setLayout(null);
		setupOptionPanel();
		setupFilePanel();
		setupUrlPanel();
		setupFileSettingsPanel();
		setupUrlSettingsPanel();
		setupResultPanel();
		setupMiscObjects();
	}
	
	private void setupOptionPanel(){
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBounds(10, 11, 680, 40);
		add(optionsPanel);
		optionsPanel.setLayout(null);
		optionsPanel.setBorder(panelOptionsTitle);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(485, 15, 60, 14);
		optionsPanel.add(lblStatus);
		
		txtStatus = new JLabel("N/A");
		txtStatus.setBounds(550, 15, 120, 14);
		optionsPanel.add(txtStatus);
		
		JLabel lblParseType = new JLabel("Parse Type:");
		lblParseType.setBounds(10, 15, 90, 14);
		optionsPanel.add(lblParseType);
		
		final JRadioButton rdbtnFile = new JRadioButton("File");
		rdbtnFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(rdbtnFile.isSelected()){
					parseFilePanel.setVisible(true);
					parseUrlPanel.setVisible(false);
				}
			}
		});
		buttonGroup1.add(rdbtnFile);
		rdbtnFile.setBounds(100, 12, 52, 23);
		optionsPanel.add(rdbtnFile);
		
		final JRadioButton rdbtnUrl = new JRadioButton("URL");
		rdbtnUrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				parseFilePanel.setVisible(false);
				parseUrlPanel.setVisible(true);
			}
		});
		buttonGroup1.add(rdbtnUrl);
		rdbtnUrl.setBounds(150, 12, 52, 23);
		optionsPanel.add(rdbtnUrl);
		
		rdbtnFile.setSelected(true);
	}
	
	private void setupFilePanel(){
		parseFilePanel = new JPanel();
		parseFilePanel.setBounds(10, 60, 680, 50);
		add(parseFilePanel);
		parseFilePanel.setLayout(null);
		parseFilePanel.setBorder(panelFileTitle);
		
		textFieldFile = new JTextField();
		textFieldFile.setBounds(57, 18, 480, 21);
		textFieldFile.setColumns(10);
		parseFilePanel.add(textFieldFile);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(10, 20, 37, 14);
		parseFilePanel.add(lblFile);
		
		JButton btnFile = new JButton("Select File");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(MainPanel.this);
				 
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                textFieldFile.setText(fc.getSelectedFile().getAbsolutePath());
	            }
			}
		});
		btnFile.setBounds(547, 18, 123, 21);
		parseFilePanel.add(btnFile);
	}
	
	private void setupUrlPanel(){
		parseUrlPanel = new JPanel();
		parseUrlPanel.setBounds(10, 60, 680, 50);
		add(parseUrlPanel);
		parseUrlPanel.setLayout(null);
		parseUrlPanel.setBorder(panelUrlTitle);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(57, 18, 610, 21);
		textFieldURL.setColumns(10);
		parseUrlPanel.add(textFieldURL);
		
		JLabel lblURL = new JLabel("URL:");
		lblURL.setBounds(10, 20, 37, 14);
		parseUrlPanel.add(lblURL);
	}
	
	private void setupFileSettingsPanel(){
		JPanel parseFileOptionPanel = new JPanel();
		parseFileOptionPanel.setBounds(10, 121, 275, 218);
		add(parseFileOptionPanel);
		parseFileOptionPanel.setLayout(null);
		parseFileOptionPanel.setBorder(panelSettingsTitle);
		
		rdbtnImgOption1 = new JRadioButton("Image: 800 x 600");
		buttonGroup2.add(rdbtnImgOption1);
		rdbtnImgOption1.setBounds(8, 20, 150, 20);
		parseFileOptionPanel.add(rdbtnImgOption1);
		
		rdbtnImgOption2 = new JRadioButton("Image: 1000 x 800");
		buttonGroup2.add(rdbtnImgOption2);
		rdbtnImgOption2.setBounds(8, 40, 150, 20);
		parseFileOptionPanel.add(rdbtnImgOption2);
		
		rdbtnImgOption3 = new JRadioButton("Image: 1200 x 1000");
		buttonGroup2.add(rdbtnImgOption3);
		rdbtnImgOption3.setBounds(8, 60, 170, 20);
		parseFileOptionPanel.add(rdbtnImgOption3);
		
		rdbtnImgOption1.setSelected(true);
		
		JLabel lblMaxWords = new JLabel("Max Words:");
		lblMaxWords.setBounds(12, 100, 100, 15);
		parseFileOptionPanel.add(lblMaxWords);
		
		maxWords = new JTextField();
		maxWords.setBounds(110, 98, 60, 19);
		parseFileOptionPanel.add(maxWords);
		maxWords.setColumns(10);
		maxWords.setText("50");
		
		JLabel lblOutputFileName = new JLabel("File Output Name:");
		lblOutputFileName.setBounds(12, 138, 140, 15);
		parseFileOptionPanel.add(lblOutputFileName);
		
		outputFileName = new JTextField();
		outputFileName.setBounds(150, 136, 110, 19);
		parseFileOptionPanel.add(outputFileName);
		outputFileName.setColumns(10);
		outputFileName.setText("parsedImage");
		
		JLabel lblStopWordsFile = new JLabel("Stop Words File:");
		lblStopWordsFile.setBounds(12, 178, 130, 15);
		parseFileOptionPanel.add(lblStopWordsFile);
		
		stopWordsFile = new JTextField();
		stopWordsFile.setBounds(140, 176, 120, 19);
		parseFileOptionPanel.add(stopWordsFile);
		stopWordsFile.setColumns(10);
		stopWordsFile.setText("stopwords.txt");
	}
	
	private void setupUrlSettingsPanel(){
		JPanel parseUrlOptionPanel = new JPanel();
		parseUrlOptionPanel.setBounds(10, 121, 275, 218);
		add(parseUrlOptionPanel);
		parseUrlOptionPanel.setLayout(null);
		parseUrlOptionPanel.setBorder(panelSettingsTitle);
	}
	
	private void setupResultPanel(){
		parseResultPanel = new JPanel();
		parseResultPanel.setBounds(295, 121, 395, 218);
		add(parseResultPanel);
		parseResultPanel.setLayout(null);
		parseResultPanel.setBorder(panelResultsTitle);
		
		resultImage = new ImageIcon();
		resultImageLabel = new JLabel(resultImage);

		resultImageLabel.setBounds(20, 14, 360, 350);
		resultImageLabel.setVisible(true);
        parseResultPanel.add(resultImageLabel);
	}
	
	private void setupMiscObjects(){
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String textField;
				int imageOption = 0;
				
				if(rdbtnImgOption1.isSelected()){
					imageOption = 0;
				}
				else if(rdbtnImgOption2.isSelected()){
					imageOption = 1;
				}
				else{
					imageOption = 2;
				}
				
				try{
					fileName = outputFileName.getText();
					File file = new File(fileName + ".png");
					if(file.exists()){
						fileName = (outputFileName.getText() + "_" + ++fileCount);
					}
				} catch(Exception e){
					e.printStackTrace();
					txtStatus.setText("File Error!");
				}
				
				if(parseFilePanel.isVisible()){
					textField = textFieldFile.getText();
					if(!textField.isEmpty() && textField != null){
						try {
							app = new ParseFile(stopWordsFile.getText(), fileName);
							if(app.parseWords(textField, imageOption, Integer.parseInt(maxWords.getText()))){
								makeNewResultPanel();
								txtStatus.setText("Task Complete!");
							}
						} catch (Exception e) {
							e.printStackTrace();
							txtStatus.setText("File Error!");
						}
					}
					else{
						txtStatus.setText("File Error!");
					}
				}
				else{
					textField = textFieldURL.getText();
					if(!textField.isEmpty() && textField != null){
						try {
							if(textField.substring(0, 8).equals("https://")){
								textField = "http://" + textField.substring(8, textField.length());
							}
							else if(!textField.substring(0, 7).equals("http://")){
								textField = "http://" + textField;
							}
							app = new ParseURL(stopWordsFile.getText(), fileName);
							if(app.parseWords(textField, imageOption, Integer.parseInt(maxWords.getText()))){
								makeNewResultPanel();
								txtStatus.setText("Task Complete!");
							}
						} catch (Exception e) {
							e.printStackTrace();
							txtStatus.setText("URL Error!");
						}
					}
					else{
						txtStatus.setText("URL Error!");
					}
				}
			}
		});
		btnGenerate.setBounds(558, 345, 130, 23);
		add(btnGenerate);
	}
	
	private void makeNewResultPanel(){
		remove(parseResultPanel);
		parseResultPanel = new JPanel();
		parseResultPanel.setBounds(295, 121, 395, 218);
		add(parseResultPanel);
		parseResultPanel.setLayout(null);
		parseResultPanel.setBorder(panelResultsTitle);
		resultImage = null;
		resultImageLabel = null;
		resultImage = new ImageIcon(fileName + ".png");
		resultImageLabel = new JLabel(resultImage);
		resultImageLabel.setBounds(20, 14, 360, 360);
		resultImageLabel.setVisible(true);
        parseResultPanel.add(resultImageLabel);
	}
}