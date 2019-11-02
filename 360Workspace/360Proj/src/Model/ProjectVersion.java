package Model;

/**
 * A Class that represent the current Version for a program.
 * 
 * @author Trevor Nichols
 *
 */
public class ProjectVersion {
	
	//The current version of the program.
	private String CURR_VERS = "1.0";
	
	//The working version of the Program.
	private String myWorkingVers;
	
	/**
	 * Initilizes a new ProjectVersion.
	 */
	public ProjectVersion() {
		myWorkingVers = CURR_VERS;
	}
	
	/**
	 * Sets the version of a project to a new version.
	 * 
	 * pre-condition: There must be an older version
	 * postCondition: The version is updated
	 * 
	 * @param version a string representing the new version.
	 */
	public void setVersion(final String version) {
		myWorkingVers = version;
	}
	
	/**
	 * Returns the current version of a program.
	 * 
	 * @return A String representing the current version.
	 */
	public String getVersion() {
		return myWorkingVers;
	}
}