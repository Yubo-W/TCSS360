package Model;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * 
 * 
 * @author Trent Julich
 *
 */
public class FileMap {

	/**
	 * Map mapping a tag to a list of all items stored under the tags.
	 */
	private HashMap<Tag, ArrayList<Item>> files;
	
	/**
	 * Constructor for new FileMap.
	 */
	public FileMap() {
		this.files = new HashMap<Tag, ArrayList<Item>>();
	}
	
	/**
	 * Adds file to the file map.
	 * 
	 * @param theItem The item to add to the map.
	 * @param theTag The tag to map the item to.
	 */
	public void addFile(Item theItem, Tag theTag) {
		if (!files.containsKey(theTag)) {
			ArrayList<Item> items = new ArrayList<Item>();
			items.add(theItem);
			files.put(theTag, items);
		} else {
			ArrayList<Item> tempList = files.get(theTag);
			tempList.add(theItem);
			files.put(theTag, tempList);
		}
	}
	
	/**
	 * Adds the given item to the file map, mapping the item to 
	 * each of the tags in the tag list.
	 * 
	 * @param theItem Item to add to the map.
	 * @param theTags The list of tags to map the item to.
	 */
	public void addFile(Item theItem, ArrayList<Tag> theTags) {
		for (Tag tag : theTags) {
			addFile(theItem, tag);
		}
	}
	
	/**
	 * 
	 * @param theItem
	 * @param theTag
	 */
	public void removeFile(Item theItem, Tag theTag) {
		
	}
	
	/**
	 * 
	 * @return An array of tag names (Strings).
	 */
	public String[] getTagNames() {
		String[] tagNames = new String[files.size()];
		int index = 0;
		for (Tag tag : files.keySet()) {
			tagNames[index] = tag.getName();
			index++;
		}
		return tagNames;
	}
}
