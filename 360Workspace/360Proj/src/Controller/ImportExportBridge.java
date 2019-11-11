package Controller;

import java.io.File;

import Model.UserProfile;
import Model.UserProfileExporter;

public class ImportExportBridge {

	
	
	
	
	public static void exportSettings() {
		UserProfileExporter.exportUserProfile(CurrentUserBridgeDisplay.myUserProfileInfo);
	}
	
	
	public static void importSettings(final File theFileChoosen) {
		
		
		
	}
	
	
	//TODO Property change event to shoot off to the GUI to change display. 
}
