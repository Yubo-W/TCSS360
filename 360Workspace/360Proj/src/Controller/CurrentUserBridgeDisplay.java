package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import Model.UserProfile;
import View.UserEmailAndNameWindow;

/**
 * 
 * @author staskatrechko
 *
 * This class will be the bridge between the backend Model.UserSettings and the display,
 * while also handling the View.userEmailAndWindow when the user decides to set a user and email.
 */
public class CurrentUserBridgeDisplay  {

	//Creates an empty userProfile that can either be filled in for a new user, or exported. 
    static UserProfile myUserProfileInfo = new UserProfile();
	
	/*
	 * property change support to allow firing change events from this. class.
	 */
	private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
	
	
	public static void setName(final String theName) {
		
		myUserProfileInfo.setUserName(theName);
	}
	
	public static void setEmail(final String theUserEmail) {
		
		myUserProfileInfo.setEmailAddress(theUserEmail);
	}
	
	//TOO Fire Property change to the GUI to display user that the program is set for/.
	
	
	public static String printName() {
		return myUserProfileInfo.toString();
	}
}
