package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Model.UserProfile;

/**
 * 
 * @author staskatrechko
 *
 * This class will be the bridge between the backend Model.UserSettings and the display,
 * while also handling the View.UserLoginWindow when the user decides to set a user and email.
 */
public class CurrentUserBridgeDisplay implements PropertyChangeListener {

	//Creates an empty userProfile that can either be filled in for a new user, or exported. 
	private UserProfile myUserProfileInfo = new UserProfile();
	
	
	
	
	
	@Override
	public void propertyChange(final PropertyChangeEvent theEvent) {
		//Will grab userName 
		//Will Grab User Profile. 
		
		System.out.println("We got an event fired.");
		
		//if the event that was clicked was file chooser, load userprifle to be set with the values that was read. 
		
		
		
	}
	
}
