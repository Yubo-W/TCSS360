package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Model.Tag;
import Model.UserProfile;
/**
 * Unit tests for user profile. 
 * @author staskatrechko
 * tests all methods to make sure they work.
 *
 */
public class UserProfileTest {
	
	
	UserProfile myProfile;
	
	@Before
	public void setUp() throws Exception {
	
		myProfile = new UserProfile();
		
	}
	
	
	@Test
	public void testNULLUserProfile() {
		UserProfile newUser = new UserProfile();
		assertEquals("Null", newUser.getUserName());
		
	}
	
	@Test
	public void testNULLEmail() {
		UserProfile newUser = new UserProfile();
		assertEquals("Null", newUser.getUserEmail());
	}
	
	@Test
	public void testNull() {
		
		assertEquals("Null", myProfile.getUserEmail());
		assertEquals("Null", myProfile.getUserName());
		
	}
	
	@Test
	public void testNameChange() {
		myProfile.setUserName("JohnB");
		assertEquals("JohnB", myProfile.getUserName());
	}
	
	@Test
	public void testEmailChange() {
		myProfile.setEmailAddress("stas@yahoo.com");
		assertEquals("stas@yahoo.com", myProfile.getUserEmail());
	}

	@Test
	public void testConstructor() {
		UserProfile conTest = new UserProfile("stas", "stas@email");
		
		assertEquals("stas", conTest.getUserName());
		assertEquals("stas@email", conTest.getUserEmail());

	}
	
	@Test
	public void testChangeNameAFterConstructor() {
		UserProfile conTest = new UserProfile("stas", "stas@email");
		conTest.setEmailAddress("flying@yahoo.com");
		assertEquals("flying@yahoo.com", conTest.getUserEmail());
	}
	
	@Test
	public void testChangeEmailAfterConstructor() {
		UserProfile conTest = new UserProfile("stas", "stas@email");
		conTest.setUserName("john");
		assertEquals("john", conTest.getUserName());
	}
	

}
