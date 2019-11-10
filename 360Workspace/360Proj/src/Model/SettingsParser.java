package Model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class used to parse a users setting file.
 * 
 * @author Trent Julich
 * @version 11/10/19
 */
public class SettingsParser {

	private Scanner scanner;
	private File userSettings;
	
	/**
	 * Constructor used to create a new SettingsParser. Takes the settings file 
	 * to be read as a parameter.
	 * 
	 * @param settingsFile The file in which to read the users settings from.
	 */
	public SettingsParser(final File settingsFile) {
		this.userSettings = settingsFile;
		try {
			scanner = new Scanner(this.userSettings);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads user settings from the file used to initialize the SettingsParser.
	 * Users these settings to initialize a new UserProfile object, which is
	 * then returned.
	 * 
	 * @return a new UserProfile object initialized with values found in the
	 * settings file given to the SettingsParser.
	 */
	public UserProfile importUserSettings() {
		final UserProfile profile = new UserProfile();
		if (this.scanner.hasNext()) {
			String testKey = scanner.next();
			if (testKey.compareTo("ttys") != 0) {
				System.out.println("Invalid user setting file.");
			} else {
				while(this.scanner.hasNext()) {
					final String nextSetting = this.scanner.next();
					if (nextSetting.contains("username")) {
						profile.setUserName(nextSetting.split("=")[1]);
					}
					if (nextSetting.contains("email")) {
						profile.setEmailAddress(nextSetting.split("=")[1]);
					}
				}
			}
		}
		this.scanner.close();
		return profile;
	}

}
