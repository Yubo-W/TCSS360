package View;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.CurrentUserBridgeDisplay;
/**
 * 
 * @author staskatrechko
 * 
 */
public class UserEmailAndNameWindow {

	/**
	 * @author Stas Katrechko
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
		int result = JOptionPane.showConfirmDialog(null, emailUserPanel, "Settings", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
			
			//using the design pattern singleton where theres a single instance of the class.
			CurrentUserBridgeDisplay.setName(username.getText());
			CurrentUserBridgeDisplay.setEmail(email.getText());
			
		}
	}
	
	
	
	
	

	
	
	
}
