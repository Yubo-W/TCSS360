package Model;

import java.util.HashMap;
import java.util.List;
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
	 * 
	 * @author Trent Julich
	 * @version 12/11/19
	 */
	public FileMap() {
		this.files = new HashMap<Tag, ArrayList<Item>>();
	}
	
	/**
	 * Adds file to the file map.
	 * 
	 * @param theItem The item to add to the map.
	 * @param theTag The tag to map the item to.
	 * 
	 * Author: Yubo Wang
	 * Author: Trent Julich
	 * Update: Client is now able to add items names of tags.
	 * Date: 12/11/2019
	 */
	public void addFile(Item theItem, String theTagName) {
		boolean found = false;
		for (Tag tag : files.keySet()) {
			if(tag.getName().equals(theTagName)) {
				found = true;
				break;
			}
		}
		if(found) {
			for (Tag tag : files.keySet()) {
				if(tag.getName().equals(theTagName)) {
					files.get(tag).add(theItem);
				}
			}
		} else {
			Tag newTag = new Tag(theTagName);
			files.put(newTag, new ArrayList<Item>());
			files.get(newTag).add(theItem);
		}

		
		
//		  if (!files.containsKey(theTag)) { 
//			  ArrayList<Item> items = new ArrayList<Item>(); 
//			  items.add(theItem); files.put(theTag, items); 
//		  } else {
//			  ArrayList<Item> tempList = files.get(theTag); 
//			  tempList.add(theItem);
//			  files.put(theTag, tempList); 
//		  }
			 
	}
	
	/**
	 * Adds the given item to the file map, mapping the item to 
	 * each of the tags in the tag list.
	 * 
	 * @param theItem Item to add to the map.
	 * @param theTags The list of tags to map the item to.
	 */
//	public void addFile(Item theItem, ArrayList<Tag> theTags) {
//		for (Tag tag : theTags) {
//			addFile(theItem, tag);
//		}
//	}
	
	/**
	 * Adds a category to the map. Maps the tag to an empty item list.
	 * 
	 * @param theCategory The tag to be added to the file map.
	 * @author Trent Julich
	 */
	public void addCategory(Tag theCategory) {
		ArrayList<Item> emptyList= new ArrayList<>();
		files.put(theCategory, emptyList);
	}
	
	
	/**
	 * Removes the specified category from the filemap.
	 * 
	 * @param theTagName Name of the tag to remove.
	 *
	 * @author Trent Julich
	 * @date 12/11/19
	 */
	public void removeCategory(String theTagName) {
		for (Tag tag : files.keySet()) {
			if (tag.getName().equals(theTagName)) {
				files.remove(tag);
				break;
			}
		}
	}
	
	/**
	 * Returns an array of strings representing the names of
	 * all of the keys in the map.
	 * 
	 * @return An array of tag names (Strings).
	 *
	 * @author Trent Julich
	 * @date 12/11/19
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
	
	/**
	 * Get Items for a specific tag.
	 * @return ArrayList of Items belonging to this Tag.
	 * 
	 * @author Yubo Wang
	 * @author Trent Julich
	 */
	public List<String> getItems(final String theTag) {
		ArrayList<Item> temp = new ArrayList<Item>();
		ArrayList<String> result = new ArrayList<String>();
		for (Tag tag : files.keySet()) {
			if(tag.getName().equals(theTag)) {
				temp = files.get(tag);
			}
		}
		for (Item item : temp) {
			result.add(item.getName());
		}
		return result;
	}
}
