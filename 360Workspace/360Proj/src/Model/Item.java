package Model;

import java.util.List;
import java.util.ArrayList;
/**
 * Class used to create the items.
 * 
 * @author Yubo Wang
 * @version 11/24/19
 */
public class Item {
	private List<Tag> tags;
	private String itemName;
	
	/**
	 * Constructor for item.
	 * 
	 * @param theName name of the item.
	 * @param theTag tag to be associated with the item.
	 */
	public Item(final String theName, final Tag theTag) {
		tags = new ArrayList<>();
		itemName = theName;
		tags.add(theTag);
	}
	
	/**
	 * COnstructor for item with tags to be associated with it.
	 * 
	 * @param theName name of the item.
	 * @param theTags tags to be added to the item.
	 */
	public Item(final String theName, final List<Tag> theTags) {
		String itemName = theName;
		tags = new ArrayList<>();
		for (Tag temp : theTags) {
			tags.add(temp);
		}
	}
	
	/**
	 * Gets the tags of the item.
	 * @return a List of the tags associated with the item.
	 */
	public List<Tag> getTags() {
		return tags;
	}
	
	/**
	 * Gets the name of the item.
	 * @return a String representing the name of the item.
	 */
	public String getName() {
		return itemName;
	}
	
	/**
	 * Gets the number of tags associated with the item.
	 * @return the number of tags associated with the item.
	 */
	public int getTagsCount() {
		return tags.size();
	}
	
	/**
	 * Adds a tag to the item.
	 * @param theTag the tag to be added to the item.
	 */
	public void addTag(Tag theTag) {
		tags.add(theTag);
	}
	
	/**
	 * removes a tag from the item.
	 * @param theTag the tag to be removed.
	 */
	public void removeTag(Tag theTag) {
		tags.remove(theTag);
	}
}
