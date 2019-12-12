package Model;

/**
 * Class representing a user profile, storing the email and user name.
 * 
 * @author Stas Katrechko 
 * @date 12/01/19
 */
public class UserProfile {
	
	private String myUserName;
	
	private String myEmailAddress;
	
	/**
	 * Method to set the profiles user name.
	 * @author Stas Katrechko
	 * @param theUserName The new user name to set.
	 */
	public void setUserName(final String theUserName) {
		this.myUserName = theUserName;
	}
	
	/**
	 * Method to set the profiles email address.
	 * @author Stas Katrechko
	 * @param newEmailAddress The new email address. 
	 */
	public void setEmailAddress(final String newEmailAddress) {
		this.myEmailAddress = newEmailAddress;
	}
	
	/**
	 * Method used to get the profiles user name.
	 * @author Stas Katrechko
	 * @return String - the user name attached to the profile.
	 */
	public String getUserName() {
		return this.myUserName;
	}
	
	/**
	 * Method used to get the profiles email address.
	 * @author Stas Katrechko
	 * @return String - The profiles email address.
	 */
	public String getUserEmail() {
		return this.myEmailAddress;
	}
	
	/**
	 * Method used to convert the profile to a String representation.
	 * @author Stas Katrechko
	 * @returns String - A string representation of the user profile.
	 */
	public String toString() {
		return "User: " + myUserName + "    " + " Email: " + myEmailAddress; 
	}
	
}
