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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
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
		lblStatus.setBounds(525, 15, 46, 14);
		optionsPanel.add(lblStatus);
		
		txtStatus = new JLabel("N/A");
		txtStatus.setBounds(570, 15, 107, 14);
		optionsPanel.add(txtStatus);
		
		JLabel lblParseType = new JLabel("Parse Type:");
		lblParseType.setBounds(10, 15, 70, 14);
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
		buttonGroup.add(rdbtnFile);
		rdbtnFile.setBounds(80, 12, 52, 23);
		optionsPanel.add(rdbtnFile);
		
		final JRadioButton rdbtnUrl = new JRadioButton("URL");
		rdbtnUrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				parseFilePanel.setVisible(false);
				parseUrlPanel.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnUrl);
		rdbtnUrl.setBounds(130, 12, 52, 23);
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
	                System.out.println("Opening: " + fc.getSelectedFile().getAbsolutePath() + ".");
	                textFieldFile.setText(fc.getSelectedFile().getAbsolutePath());
	            } 
	            else {
	            	System.out.println("Opening Cancelled");
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
		textFieldURL.setBounds(57, 18, 480, 21);
		textFieldURL.setColumns(10);
		parseUrlPanel.add(textFieldURL);
		
		JLabel lblURL = new JLabel("URL:");
		lblURL.setBounds(10, 20, 37, 14);
		parseUrlPanel.add(lblURL);
		
		JButton btnURL = new JButton("Parse URL");
		btnURL.setBounds(547, 18, 123, 21);
		parseUrlPanel.add(btnURL);
		
		parseUrlPanel.setVisible(false);
	}
	
	private void setupFileSettingsPanel(){
		JPanel parseFileOptionPanel = new JPanel();
		parseFileOptionPanel.setBounds(10, 121, 275, 218);
		add(parseFileOptionPanel);
		parseFileOptionPanel.setLayout(null);
		parseFileOptionPanel.setBorder(panelSettingsTitle);
	}
	
	private void setupUrlSettingsPanel(){
		JPanel parseUrlOptionPanel = new JPanel();
		parseUrlOptionPanel.setBounds(10, 121, 275, 218);
		add(parseUrlOptionPanel);
		parseUrlOptionPanel.setLayout(null);
		parseUrlOptionPanel.setBorder(panelSettingsTitle);
	}
	
	private void setupResultPanel(){
		JPanel parseResultPanel = new JPanel();
		parseResultPanel.setBounds(295, 121, 395, 218);
		add(parseResultPanel);
		parseResultPanel.setLayout(null);
		parseResultPanel.setBorder(panelResultsTitle);
	}
	
	private void setupMiscObjects(){
		JButton btnGenerate = new JButton("Re-Generate");
		btnGenerate.setBounds(578, 347, 112, 23);
		add(btnGenerate);
	}
}