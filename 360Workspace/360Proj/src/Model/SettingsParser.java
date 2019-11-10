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
	
	public SettingsParser(final File settingsFile) {
		this.userSettings = settingsFile;
		try {
			scanner = new Scanner(this.userSettings);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readUserSettings() {
		while(this.scanner.hasNext()) {
			System.out.println(this.scanner.next());
		}
		this.scanner.close();
	}

}
