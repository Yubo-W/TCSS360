package Model;

/**
 * Class used to create tags items are associated with.
 * 
 * @author Yubo Wang
 * @version 11/24/29
 */
public class Tag {
	private String name;
	
	public Tag(final String theName) {
		name = theName;
	}
	
	public String getName() {
		return name;
	}
}
