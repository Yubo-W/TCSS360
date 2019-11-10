package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class used to export a given UserProfile into a .txt file. 
 * 
 * @author Trent Julich
 * @version 11/10/19
 */
public class UserProfileExporter {
	
	public UserProfileExporter() {
		
	}
	
	public void exportUserProfile(final UserProfile profile) {
		final String exportedFileName = profile.getUserName()+"_settings.txt";
		final String exportedFilePath = "./exported_user_profiles/" + exportedFileName;
		final File newFile = new File(exportedFilePath);
		final String settingsFileContents = "ttys\nusername=" + profile.getUserName() + "\nemail=" + profile.getUserEmail();
		
		try {
			final BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
			writer.write(settingsFileContents);
			newFile.createNewFile();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}