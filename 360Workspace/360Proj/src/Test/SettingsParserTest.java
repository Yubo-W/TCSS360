package Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Model.UserProfile;
import Controller.CurrentUserBridgeDisplay;
import Model.SettingsParser;
import java.io.File;

public class SettingsParserTest {
	
	private CurrentUserBridgeDisplay bridge;
	private UserProfile profile;
	private SettingsParser parser;
	
	@Before
	public void setup() {
		bridge = new CurrentUserBridgeDisplay();
		profile = new UserProfile();
		bridge.myUserProfileInfo = profile;
		parser = new SettingsParser(new File("./src/Test/TestExportedProfile.txt"));
	}
	
	@Test
	public void testParseUserName() {
		final String expectedUsername = "TestUserName";
		parser.importUserSettings();
		assertEquals(expectedUsername, profile.getUserName());
	}
	
	@Test
	public void testParseUserEmail() {
		final String expectedEmail = "TestEmail";
		parser.importUserSettings();
		assertEquals(expectedEmail, profile.getUserEmail());
	}
	
	
	
}