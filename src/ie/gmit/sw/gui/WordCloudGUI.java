package ie.gmit.sw.gui;

import javax.swing.JFrame;

public class WordCloudGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MainPanel currentPanel;
	
	public WordCloudGUI(){
		currentPanel = new MainPanel();
		setupFrame();
	}
	
	private void setupFrame(){
		setContentPane(currentPanel);
		setTitle("Word Cloud Generator");
		setSize(702, 415);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WordCloudGUI().setVisible(true);
	}
}