package ie.gmit.sw.gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtShiftHrs;
	private JTextField txtHrRate;
	private JTextField txtRegDate;
	private JTextField txtSearchBox;
	private JTextField txtAddress;
	private JTextField txtCleanerProd;
	
	JLabel txtPrivileges;
	JLabel txtStatus;
	
	JButton btnSearch;
	JButton btnUpdate;
	JButton btnAdd;
	JButton btnDelete;
	JButton btnLogout;
	
	Border bGreyLine = BorderFactory.createLineBorder(Color.GRAY, 1, true);
	
	Checkbox cbFeesPaid;
	Checkbox cbDisabled;
	Checkbox cbFullTime;
	Checkbox cbLabCoat;
	Checkbox cbTools;
	
	JComboBox workWithCombo;
	
	public MainPanel() {
		setLayout(null);
		setupLoginPanel();
		setupOpPanel();
		setupPanelA();
		setupPanelB();
		setupSearchByPanel();
		setupMisc();
		disableInfo();
	}
	
	private void setupPanelA(){
		
		JPanel infoPanelA = new JPanel();
		infoPanelA.setBounds(10, 87, 290, 203);
		add(infoPanelA);
		infoPanelA.setLayout(null);
		infoPanelA.setBorder(bGreyLine);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setBounds(20, 14, 73, 14);
		infoPanelA.add(lblFirstname);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(91, 11, 177, 20);
		infoPanelA.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setBounds(20, 42, 73, 14);
		infoPanelA.add(lblLastname);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(91, 39, 177, 20);
		infoPanelA.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 70, 63, 14);
		infoPanelA.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(91, 67, 177, 20);
		infoPanelA.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblShiftHrs = new JLabel("Shift Hrs:");
		lblShiftHrs.setBounds(30, 101, 63, 14);
		infoPanelA.add(lblShiftHrs);
		
		txtShiftHrs = new JTextField();
		txtShiftHrs.setBounds(91, 98, 46, 20);
		infoPanelA.add(txtShiftHrs);
		txtShiftHrs.setColumns(10);
		
		JLabel lblHrRate = new JLabel("Hr Rate:");
		lblHrRate.setBounds(157, 101, 51, 14);
		infoPanelA.add(lblHrRate);
		
		txtHrRate = new JTextField();
		txtHrRate.setBounds(208, 98, 60, 20);
		infoPanelA.add(txtHrRate);
		txtHrRate.setColumns(10);
		
		txtRegDate = new JTextField();
		txtRegDate.setBounds(91, 129, 177, 20);
		infoPanelA.add(txtRegDate);
		txtRegDate.setColumns(10);
		
		JLabel lblRegDate = new JLabel("Reg Date:");
		lblRegDate.setBounds(30, 132, 63, 14);
		infoPanelA.add(lblRegDate);
		
		JLabel lblCleanerProd = new JLabel("Cleaner Prod:");
		lblCleanerProd.setBounds(10, 163, 83, 14);
		infoPanelA.add(lblCleanerProd);
		
		txtCleanerProd = new JTextField();
		txtCleanerProd.setBounds(91, 160, 177, 20);
		infoPanelA.add(txtCleanerProd);
		txtCleanerProd.setColumns(10);
		
	}
	
	private void setupPanelB(){
		
		JPanel infoPanelB = new JPanel();
		infoPanelB.setBounds(310, 153, 180, 137);
		add(infoPanelB);
		infoPanelB.setLayout(null);
		infoPanelB.setBorder(bGreyLine);
		
		JLabel lblFeesPaid = new JLabel("Fees Paid:");
		lblFeesPaid.setBounds(43, 11, 59, 14);
		infoPanelB.add(lblFeesPaid);
		
		cbFeesPaid = new Checkbox();
		cbFeesPaid.setBounds(108, 11, 13, 14);
		infoPanelB.add(cbFeesPaid);
		
		JLabel lblDisabled = new JLabel("Disabled:");
		lblDisabled.setBounds(43, 36, 59, 14);
		infoPanelB.add(lblDisabled);
		
		cbDisabled = new Checkbox();
		cbDisabled.setBounds(108, 36, 13, 14);
		infoPanelB.add(cbDisabled);
		
		JLabel lblFullTime = new JLabel("Full-Time:");
		lblFullTime.setBounds(43, 61, 59, 14);
		infoPanelB.add(lblFullTime);
		
		cbFullTime = new Checkbox();
		cbFullTime.setBounds(108, 61, 13, 14);
		infoPanelB.add(cbFullTime);
		
		JLabel lblLabCoat = new JLabel("Lab Coat:");
		lblLabCoat.setBounds(43, 86, 59, 14);
		infoPanelB.add(lblLabCoat);
		
		cbLabCoat = new Checkbox();
		cbLabCoat.setBounds(108, 86, 13, 14);
		infoPanelB.add(cbLabCoat);
		
		JLabel lblTools = new JLabel("Tools:");
		lblTools.setBounds(43, 111, 46, 14);
		infoPanelB.add(lblTools);
		
		cbTools = new Checkbox();
		cbTools.setBounds(108, 111, 13, 14);
		infoPanelB.add(cbTools);
		
	}
	
	private void setupLoginPanel(){
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(10, 11, 187, 70);
		add(loginPanel);
		loginPanel.setLayout(null);
		loginPanel.setBorder(bGreyLine);
		
		txtUserName = new JTextField();
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()==java.awt.event.KeyEvent.VK_ENTER){
		            login();
		        }
			}
		});
		txtUserName.setBounds(80, 11, 97, 20);
		loginPanel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(10, 14, 71, 14);
		loginPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 42, 71, 14);
		loginPanel.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()==java.awt.event.KeyEvent.VK_ENTER){
					login();
		        }
			}
		});
		txtPassword.setBounds(80, 39, 97, 20);
		loginPanel.add(txtPassword);
		txtPassword.setColumns(10);
		
	}
	
	private void setupOpPanel(){
		
		JPanel opPanel = new JPanel();
		opPanel.setBounds(207, 11, 283, 70);
		add(opPanel);
		opPanel.setLayout(null);
		opPanel.setBorder(bGreyLine);
		
		JLabel lblSearchId = new JLabel("Search ID:");
		lblSearchId.setBounds(10, 14, 68, 14);
		opPanel.add(lblSearchId);
		
		txtSearchBox = new JTextField();
		txtSearchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()==java.awt.event.KeyEvent.VK_ENTER){
					searchData();
		        }
			}
		});
		txtSearchBox.setBounds(77, 11, 97, 20);
		opPanel.add(txtSearchBox);
		txtSearchBox.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchData();
			}
		});
		btnSearch.setBounds(184, 10, 89, 23);
		opPanel.add(btnSearch);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInfo();
				/*if(workWithCombo.getSelectedIndex() == 0)
					//SqlCode.updateStaff(Integer.parseInt(txtSearchBox.getText()));
				else
					//SqlCode.updateStudent(Integer.parseInt(txtSearchBox.getText()));*/
				txtStatus.setText("Record Updated!");
				txtSearchBox.requestFocus();
			}
		});
		btnUpdate.setBounds(76, 39, 97, 23);
		opPanel.add(btnUpdate);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setInfo();
				/*if(workWithCombo.getSelectedIndex() == 0)
					//SqlCode.addStaff();
				else
					//SqlCode.addStudent();*/
				resetVals();
				clearFields();
				txtStatus.setText("Record Added!");
				txtSearchBox.requestFocus();
			}
		});
		btnAdd.setBounds(10, 39, 56, 23);
		opPanel.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(workWithCombo.getSelectedIndex() == 0)
					//SqlCode.deleteStaff(Integer.parseInt(txtSearchBox.getText()));
				else
					//SqlCode.deleteStudent(Integer.parseInt(txtSearchBox.getText()));*/
				resetVals();
				clearFields();
				txtStatus.setText("Record Deleted!");
				txtSearchBox.requestFocus();
			}
		});
		btnDelete.setBounds(184, 39, 89, 23);
		opPanel.add(btnDelete);
		
	}
	
	private void setupMisc(){
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disableInfo();
				txtUserName.setText("");
				txtPassword.setText("");
				txtPrivileges.setText("None");
				txtStatus.setText("");
				clearFields();
				txtPrivileges.setText("");
			}
		});
		btnLogout.setBounds(401, 297, 89, 23);
		add(btnLogout);
		
		JLabel lblPrivileges = new JLabel("Privileges:");
		lblPrivileges.setBounds(10, 301, 62, 14);
		add(lblPrivileges);
		
		txtPrivileges = new JLabel("None");
		txtPrivileges.setBounds(71, 301, 57, 14);
		add(txtPrivileges);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(138, 301, 46, 14);
		add(lblStatus);
		
		txtStatus = new JLabel("");
		txtStatus.setBounds(183, 301, 107, 14);
		add(txtStatus);
		
	}
	
	private void setupSearchByPanel(){
		
		JPanel searchByPanel = new JPanel();
		searchByPanel.setBounds(310, 87, 180, 55);
		add(searchByPanel);
		searchByPanel.setLayout(null);
		searchByPanel.setBorder(bGreyLine);
		
		JLabel lblWorkWith = new JLabel("Data:");
		lblWorkWith.setBounds(32, 22, 46, 14);
		searchByPanel.add(lblWorkWith);
		
		String[] search = {"Staff","Student"};
		workWithCombo = new JComboBox(search);
		workWithCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				/*if(//SqlCode.isAdmin == 1){
					if(workWithCombo.getSelectedIndex() == 1)
					{
						txtCleanerProd.setEditable(false);
						txtShiftHrs.setEditable(false);
						txtHrRate.setEditable(false);
						txtRegDate.setEditable(true);
					}
					else
					{
						txtCleanerProd.setEditable(true);
						txtShiftHrs.setEditable(true);
						txtHrRate.setEditable(true);
						txtRegDate.setEditable(false);
					}
				}*/
				clearFields();
				resetVals();
				txtSearchBox.requestFocus();
			}
		});
		workWithCombo.setSelectedIndex(0);
		workWithCombo.setBounds(76, 18, 76, 20);
		searchByPanel.add(workWithCombo);
		
	}
	
	private void login(){
		
		//new SqlCode(txtUserName.getText(), txtPassword.getText());
        
		/*if(//SqlCode.loginGood){
        	txtSearchBox.requestFocus();
        	txtStatus.setText("Login Ok!");
        }
        else{
        	txtStatus.setText("Login Failed!");
        }
        
        if(//SqlCode.isAdmin == 1 && //SqlCode.loginGood){
        	txtPrivileges.setText("Admin");
        	enableInfo();
        }
        else if(//SqlCode.isAdmin == 0 && //SqlCode.loginGood){
        	txtPrivileges.setText("Basic");
        	txtUserName.setEnabled(false);
        	txtPassword.setEnabled(false);
        	txtSearchBox.setEditable(true);
        	workWithCombo.setEnabled(true);
        	btnLogout.setEnabled(true);
        	btnSearch.setEnabled(true);
        }*/
        
	}
	
	private void searchData(){
		resetVals();
        if(workWithCombo.getSelectedIndex() == 0){
        	if(!txtSearchBox.getText().isEmpty()){
        		try{
        			//SqlCode.searchStaff(Integer.parseInt(txtSearchBox.getText()));
        		}catch(Exception ex){
        			System.out.println("Error: " + ex);
        		}
        		getInfo();
        	}
        }
        else{
        	if(!txtSearchBox.getText().isEmpty()){
        		try{	
        			//SqlCode.searchStudent(Integer.parseInt(txtSearchBox.getText()));
	        	}catch(Exception ex){
	    			System.out.println("Error: " + ex);
	    		}
        		getInfo();
        	}
        } 
	}
	
	private void getInfo(){
		/*txtFirstName.setText(//SqlCode.firstName);
		txtLastName.setText(//SqlCode.lastName);
		txtAddress.setText(//SqlCode.address);
		txtShiftHrs.setText(Float.toString(//SqlCode.shiftHrs));
		txtHrRate.setText(Float.toString(//SqlCode.hrRate));
		txtCleanerProd.setText(//SqlCode.cleanerProduct);
		txtRegDate.setText(//SqlCode.regDate);*/
		
		/*if(//SqlCode.feesPaid == 1)
			cbFeesPaid.setState(true);
		else
			cbFeesPaid.setState(false);
		
		if(//SqlCode.isDisabled == 1)
			cbDisabled.setState(true);
		else
			cbDisabled.setState(false);
		
		if(//SqlCode.isFullTime == 1)
			cbFullTime.setState(true);
		else
			cbFullTime.setState(false);
		
		if(//SqlCode.labCoatReq == 1)
			cbLabCoat.setState(true);
		else
			cbLabCoat.setState(false);
		
		if(//SqlCode.toolsReq == 1)
			cbTools.setState(true);
		else
			cbTools.setState(false);*/
	}
	
	private void setInfo(){
		//SqlCode.firstName = txtFirstName.getText();
		//SqlCode.lastName = txtLastName.getText();
		//SqlCode.address = txtAddress.getText();
		//SqlCode.shiftHrs = Float.parseFloat(txtShiftHrs.getText());
		//SqlCode.hrRate = Float.parseFloat(txtHrRate.getText());
		//SqlCode.cleanerProduct = txtCleanerProd.getText();
		//SqlCode.regDate = txtRegDate.getText();
		
		/*if(cbFeesPaid.getState() == false)
			//SqlCode.feesPaid = 0;
		else
			//SqlCode.feesPaid = 1;
		
		if(cbDisabled.getState() == false)
			//SqlCode.isDisabled = 0;
		else
			//SqlCode.isDisabled = 1;
		
		if(cbFullTime.getState() == false)
			//SqlCode.isFullTime = 0;
		else
			//SqlCode.isFullTime = 1;
		
		if(cbLabCoat.getState() == false)
			//SqlCode.labCoatReq = 0;
		else
			//SqlCode.labCoatReq = 1;
		
		if(cbTools.getState() == false)
			//SqlCode.toolsReq = 0;
		else
			//SqlCode.toolsReq = 1;*/
	}
	
	private void disableInfo(){
		txtFirstName.setEditable(false);
		txtLastName.setEditable(false);
		txtAddress.setEditable(false);
		txtShiftHrs.setEditable(false);
		txtHrRate.setEditable(false);
		txtRegDate.setEditable(false);
		txtCleanerProd.setEditable(false);
		txtSearchBox.setEditable(false);
		txtUserName.setEnabled(true);
		txtPassword.setEnabled(true);
		workWithCombo.setEnabled(false);
		disableBtn();
		disableCb();
	}
	
	private void enableInfo(){
		txtFirstName.setEditable(true);
		txtLastName.setEditable(true);
		txtAddress.setEditable(true);
		txtShiftHrs.setEditable(true);
		txtHrRate.setEditable(true);
		txtCleanerProd.setEditable(true);
		txtSearchBox.setEditable(true);
		btnSearch.setEnabled(true);
		txtUserName.setEnabled(false);
		txtPassword.setEnabled(false);
		workWithCombo.setEnabled(true);
		enableBtn();
		enableCb();
	}
	
	private void clearFields(){
		txtFirstName.setText("");
		txtLastName.setText("");
		txtAddress.setText("");
		txtShiftHrs.setText("");
		txtHrRate.setText("");
		txtRegDate.setText("");
		txtCleanerProd.setText("");
		txtSearchBox.setText("");
		cbFeesPaid.setState(false);
		cbDisabled.setState(false);
		cbFullTime.setState(false);
		cbLabCoat.setState(false);
		cbTools.setState(false);
		txtUserName.requestFocus();
	}
	
	private void enableBtn(){
		btnSearch.setEnabled(true);
		btnAdd.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
		btnLogout.setEnabled(true);
	}
	
	private void disableBtn(){
		btnSearch.setEnabled(false);
		btnAdd.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		btnLogout.setEnabled(false);
	}
	
	private void enableCb(){
		cbFeesPaid.setEnabled(true);
		cbDisabled.setEnabled(true);
		cbFullTime.setEnabled(true);
		cbLabCoat.setEnabled(true);
		cbTools.setEnabled(true);
	}
	
	private void disableCb(){
		cbFeesPaid.setEnabled(false);
		cbDisabled.setEnabled(false);
		cbFullTime.setEnabled(false);
		cbLabCoat.setEnabled(false);
		cbTools.setEnabled(false);
	}
	
	private void resetVals(){
		//SqlCode.firstName = "";
		//SqlCode.lastName = "";
		//SqlCode.address = "";
		//SqlCode.shiftHrs = 0.0f;
		//SqlCode.hrRate = 0.0f;
		//SqlCode.cleanerProduct = "";
		//SqlCode.regDate = "";
		//SqlCode.feesPaid = 0;
		//SqlCode.isDisabled = 0;
		//SqlCode.isFullTime = 0;
		//SqlCode.labCoatReq = 0;
		//SqlCode.toolsReq = 0;
	}
}