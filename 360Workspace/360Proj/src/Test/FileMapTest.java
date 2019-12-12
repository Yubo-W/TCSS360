package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import Model.FileMap;
import Model.Item;
import Model.Tag;

public class FileMapTest {

	private FileMap map;
	
	/**
	 * Sets up a new FileMap object before each test is run.
	 */
	@Before
	public void setup() {
		map = new FileMap();
	}
	
	/**
	 * Tests addFile.
	 */
	@Test
	public void testAddFile() {
		final String expectedFileName = "TestFileName";
		final String testTagName = "TestTagName";
		final Tag testTag = new Tag(testTagName);
		final Item testItem = new Item(expectedFileName, testTag);
		
		map.addFile(testItem, testTagName);
		final List<String> testItems = map.getItems(testTagName);
		
		assertEquals(testItems.get(0), expectedFileName);
	}
	
	/**
	 * Tests addCategory(), as well as getTagNames()
	 */
	@Test
	public void testGetTagNames() {
		String[] names = {"TagName1", "TagName2", "TagName3"};
		for (String name : names) {
			map.addCategory(new Tag(name));
		}
		List<String> convertedNames = Arrays.asList(map.getTagNames());
		
		assertTrue(convertedNames.contains(names[0]));
		assertTrue(convertedNames.contains(names[1]));
		assertTrue(convertedNames.contains(names[2]));
	}
	
	/**
	 * Tests the getItems method.
	 */
	@Test
	public void testGetItems() {
		Tag testTag = new Tag("TestTag");
		String[] testItemNames = {"TestItem1", "TestItem2", "TestItem3"};

		List<String> compareToNames = new ArrayList<String>();
		for (String itemName : testItemNames) {
			map.addFile(new Item(itemName, testTag), testTag.getName());
			compareToNames.add(itemName);
		}
		List<String> retrievedNames = map.getItems(testTag.getName());
		assertEquals(retrievedNames, compareToNames);
	}
}
