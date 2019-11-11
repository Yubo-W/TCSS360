package Main;

import Controller.CurrentUserBridgeDisplay;
import Model.UserProfile;
import Model.UserProfileExporter;
import View.UserEmailAndNameWindow;

public class TestDriver {

	public static void main(String[] args) {
	
		
//		
//		UserProfile theUser = new UserProfile();
//		
//		
//		theUser.setEmailAddress("The@hotmail.com");
//		theUser.setUserName("stas");
//		
//		
//		UserProfileExporter exportObject = new UserProfileExporter();
//		
//		exportObject.exportUserProfile(theUser);
//		
		
		
		
		UserEmailAndNameWindow s = null;
		s.generateEmailandUserWindow();
		
		
		System.out.println(CurrentUserBridgeDisplay.printName());

	}

}
