package Controller;

import java.io.File;

import Model.SettingsParser;
import Model.UserProfile;
import Model.UserProfileExporter;

public class ImportExportBridge {

	
	
	
	/**
	 * @author Stas Katrechko
	 * Exports the settings of our current user to a text file into a folder called "exported_user_profiles" where all 
	 * users are going to be stored.
	 */
	public static void exportSettings() {
		UserProfileExporter.exportUserProfile(CurrentUserBridgeDisplay.myUserProfileInfo);
	}
	
	
	/**
	 * @author Stas Katrechko
	 * Creates a simple parser to read our format for settings, this will load all the data and tags, that the user had previously. 
	 * 
	 * @param theFileChoosen a file that the user specifies 
	 */
	public static void importSettings(final File theFileChoosen) {
		
		SettingsParser parse = new SettingsParser(theFileChoosen);
		parse.importUserSettings();

		//print to console whose account we improted. this is temporary to show the functionalituy of our program. 
		System.out.println("Account imported was :" + CurrentUserBridgeDisplay.printName());

		
		
	}
	
	
	//TODO Property change event to shoot off to the GUI to change display. 
}
