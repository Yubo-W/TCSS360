package Model;

public class UserSettings {
	
	private String myUserName;
	
	private String myEmailAddress;
	
	//TODO categories of this user. what ever data type we choose.
	
	
	public void setUserName(final String theUserName) {
		this.myUserName = theUserName;
	}
	
	public void setEmailAddress(final String theUserName) {
		this.myEmailAddress = theUserName;
	}
	
	public String getUserName() {
		return this.myUserName;
	}
	
	public String getUserEmail() {
		return this.myEmailAddress;
	}
	
	//TODO create a get and set for the categories. 
	

}
