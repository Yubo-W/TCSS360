package Controller;

import java.beans.PropertyChangeSupport;

import Model.UserProfile;

/**
 * 
 * @author staskatrechko
 *
 * This class will be the bridge between the backend Model.UserSettings and the display,
 * while also handling the View.userEmailAndWindow when the user decides to set a user and email.
 */
public class CurrentUserBridgeDisplay  {

	/*
	 * @author Stas Katrechko
	 * We want one instance of UserProfile, since one user at a time will be using this program, which will store email, name and other information.
	 */
    static UserProfile myUserProfileInfo = new UserProfile();
	
	/*
	 * @author Stas Katrechko
	 * property change support to allow firing change events from this. class.
	 */
	private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
	
	/**
	 * @author Stas Katrechko
	 * a bridge between our model and GUI, this will handle data being passed and forth. 
	 * 
	 * @param theName the User name the person has specified.
	 */
	public static void setName(final String theName) {
		
		myUserProfileInfo.setUserName(theName);
	}
	
	/**
	 * @author Stas Katrechko
	 * A bridge between Model and GUI that will initialize our Email value in our single instance of UserProfile.
	 * 
	 * @param theUserEmail the user Email that the user has specified.
	 */
	public static void setEmail(final String theUserEmail) {
		
		myUserProfileInfo.setEmailAddress(theUserEmail);
	}
	
	//TOO Fire Property change to the GUI to display user that the program is set for/.
	
	/**
	 * @author Stas Katrechko
	 * Print format for our program. 
	 * 
	 * @return String formatted for which user is currently on.
	 */
	public static String printName() {
		return myUserProfileInfo.toString();
	}
}
