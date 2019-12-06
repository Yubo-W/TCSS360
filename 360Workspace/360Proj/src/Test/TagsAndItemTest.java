package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import Model.Tag;
import Model.Item;

/**
 * Class to test the Tags and Item classes created.
 * 
 * @author Yubo Wang
 * @version 11/24/19
 */
public class TagsAndItemTest {

	private List<Tag> myTags;
	private List<Tag> tempTags;
	/**
	 * Setting up the JUnit test.
	 * 
	 * @throws Exception if it cannot be set up.
	 */
	@Before
	public void setUp() throws Exception {
		myTags = new ArrayList<>();
		tempTags = new ArrayList<>();
	}

	/**
	 * Testing to see if Tag creates and to see if getName() function works.
	 */
	@Test
	public void createNewTagTest() {
		Tag temp = new Tag("PDF");
		assertEquals("PDF", temp.getName());
	}
	
	/**
	 * Testing to see if Item creates with one tag and seeing if getTags() method works.
	 */
	@Test
	public void createNewItemWithOneTag() {
		Tag temp = new Tag("PDF");
		Item tempItem = new Item("Manual", temp);
		myTags = tempItem.getTags();
		tempTags = new ArrayList<>();
		tempTags.add(temp);
		assertEquals(tempTags, myTags);
	}
	
	/**
	 * Testing to see if Item creates with multiple tags added at once.
	 */
	@Test
	public void createNewItemWithMultipleTags() {
		Tag temp1 = new Tag("PDF");
		Tag temp2 = new Tag("JPEG");
		tempTags.add(temp1);
		tempTags.add(temp2);
		
		Item tempItem = new Item("Instruction", tempTags);
		myTags = tempItem.getTags();
		assertEquals(tempTags, myTags);
	}

	/**
	 * Testing to see if name of item returns properly.
	 */
	@Test
	public void getNameOfItem() {
		Tag temp = new Tag("PDF");
		Item tempItem = new Item("Manual", temp);
		assertEquals("Manual", tempItem.getName());
	}
	
	/**
	 * Testing to see if the number of tags associated with an item is correct.
	 */
	@Test
	public void getNumberOfTagsOfItem() {
		Tag temp1 = new Tag("PDF");
		Tag temp2 = new Tag("JPEG");
		tempTags.add(temp1);
		tempTags.add(temp2);
		
		Item tempItem = new Item("Instruction", tempTags);
		assertEquals(2, tempItem.getTagsCount());
	}
	
	/**
	 * Testing to see if adding a tag for item works properly.
	 */
	@Test
	public void addTagToItem() {
		Tag temp1 = new Tag("PDF");
		Tag temp2 = new Tag("JPEG");
		tempTags.add(temp1);
		tempTags.add(temp2);
		
		Item tempItem = new Item("Instruction", tempTags);
		Tag temp3 = new Tag("Important");
		tempItem.addTag(temp3);
		tempTags.add(temp3);
		assertEquals(tempTags, tempItem.getTags());
	}
	
	/**
	 * Testing to see if removing a tag from an item works.
	 */
	@Test
	public void removeTagFromItem() {
		Tag temp1 = new Tag("PDF");
		Tag temp2 = new Tag("JPEG");
		tempTags.add(temp1);
		tempTags.add(temp2);
		
		Item tempItem = new Item("Instruction", tempTags);
		tempItem.removeTag(temp1);
		tempTags.remove(temp1);
		assertEquals(tempTags, tempItem.getTags());
	}
}

