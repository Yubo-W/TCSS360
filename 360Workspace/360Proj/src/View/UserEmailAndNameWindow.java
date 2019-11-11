package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.CurrentUserBridgeDisplay;

public class UserEmailAndNameWindow {




	/**
	 * creates a window and prompts for user and email, and when clicked ok, will fireproperty change event to currentUserBridge
	 * to provide less coupling.  
	 */
	public void generateEmailandUserWindow() {
		
		JTextField username = new JTextField(20);
		JTextField email = new JTextField(30);
		
		//creates a panel to grab user and email
		JPanel emailUserPanel = new JPanel();
		emailUserPanel.add(new JLabel("Username :"));
		emailUserPanel.add(username);
		emailUserPanel.add(Box.createHorizontalStrut(20));
		emailUserPanel.add(new JLabel("Email :"));
		emailUserPanel.add(email);
		
		
		//Creating the ok and cancel button. 
		int result = JOptionPane.showConfirmDialog(null, emailUserPanel, "Provide Username and Email.", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
			
			//using the design pattern singleton where theres a single instance of the class.
			CurrentUserBridgeDisplay.setName(username.getText());
			CurrentUserBridgeDisplay.setEmail(email.getText());
			
//			//TODO figure out how to property change event this 
//			myPCS.firePropertyChange("user", "", username.getText());
//			myPCS.firePropertyChange("email", "", email.getText());
		}
	}
	
	
	
	
	

	
	
	
}
