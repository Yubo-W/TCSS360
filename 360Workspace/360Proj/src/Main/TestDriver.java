package Main;

import Controller.CurrentUserBridgeDisplay;
import Model.UserProfile;
import Model.UserProfileExporter;
import View.UserEmailAndNameWindow;
import Model.FileMap;
import Model.*;

/**
 * Test Driver to test functionality of our program. 
 * @author staskatrechko
 *
 */
public class TestDriver {

	public static void main(String[] args) {
	
		FileMap map = new FileMap();
		Tag theTag = new Tag("Tag");
		Item theItem = new Item("Test Item", theTag);
		map.addCategory(theTag);
		
		System.out.println(map.getTagNames()[0]);
		
		map.removeCategory("Tag");
		
		System.out.println(map.getTagNames()[0]);
		

	}

}
