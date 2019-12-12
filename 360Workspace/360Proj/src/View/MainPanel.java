package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Model.FileMap;
import Model.Item;
import Model.Tag;

/**
 * This program acts as the main panel of our GUI layout.
 * 
 * @author Trevor Nichols
 *	Date: 12/05/19
 *
 * @author Yubo Wang
 * 	Date: 12/11/2019
 *	Update: Added the functionality for the GUI to be able to display files that are in the storge
 */
public class MainPanel extends JPanel {

	/**Id for serialization*/
	private static final long serialVersionUID = -1931505285368286964L;

	//A button for addign a tag.
	private JButton tagAdd;
	
	//A button for deleting a tag.
	private JButton tagDelete;
	
	//A button for adding an item.
	private JButton itemAdd;
	
	//A button for deleting an item.
	private JButton itemDelete;
	
	//A List of tags for the gui.
	private JList<String> tagList;
	
	//A list of files for gui.
	private JList<String> fileList;
	
	//A map or tags to items.
	private FileMap storage;
	
	//A Panel that holds a list and buttons.
	private JPanel tagScroll; // this can probably be deleted.
	
	//A model for holding Strings.
	private DefaultListModel<String> tagNames;
	
	//A model for holding files.
	private DefaultListModel<String> theFiles;


	/**
	 * A constructor for initilizaing the main panel.
	 * 
	 * @author Trevor Nichols
	 * Date: 12/05/19
	 */
	public MainPanel() {
		storage = new FileMap();
		tagNames = new DefaultListModel<String>();
		theFiles = new DefaultListModel<String>();
		setLayout(new BorderLayout());
		createTagWindow();
		createItemWindow();
	}
	
	/**
	 * Creates a Tag window for selecting tags
	 * 
	 * @author Trevor Nichols
	 * Date: 12/05/19
	 */
	private void createTagWindow() {
		
		tagScroll = new JPanel(new BorderLayout());
		JPanel projectButtn = new JPanel(new FlowLayout());
		tagAdd = new JButton("Add Tag");
		addTagListener();
		tagDelete= new JButton("Delete Tag");
		deleteTagListener();
		tagDelete.setEnabled(false);
		
		projectButtn.add(tagAdd);
		projectButtn.add(tagDelete);
		
		tagScroll.add(projectButtn, BorderLayout.NORTH);
	
		tagList = new JList<String>(storage.getTagNames());
		addTagListListener();
		
		JScrollPane projects = new JScrollPane(tagList);
		tagScroll.add(projects, BorderLayout.CENTER);
		
		add(tagScroll, BorderLayout.WEST);
	}
	
	/**
	 * Creates an item window for showing items of a selected tag.
	 * 
	 * @author Trevor Nichols
	 * Date: 12/05/19
	 */
	private void createItemWindow() {
		//This if the window that should appear when a project has been selected
		//and should update ad files are added.
		//Our third user story.
		
		//attempting to get the documents window to display correctly.
		JPanel documents = new JPanel(new BorderLayout());
		fileList = new JList<String>();
		JScrollPane files = new JScrollPane(fileList);
		
		//Add and Delete buttons for files.
		//Still need Action listeners for adding and deleting documents from storage.
		JPanel documentButtn = new JPanel(new FlowLayout());
		itemAdd = new JButton("Add File");
		itemDelete = new JButton("Delete File");
		itemAdd.setEnabled(false);
		itemDelete.setEnabled(false);
		
		
		itemAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				// import was clicked, we allow for file choosing. 
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    
				    /*
				     * author: Yubo Wang
				     * Adds the user ability to add a file and categorize it into the storage.
				     */
				    String fileName = selectedFile.getName();
				    String category = JOptionPane.showInputDialog("What category does this item belong in?");
				    
				    // converts category name into correct input format
				    final Tag newTag = new Tag(category);
				    storage.addFile(new Item(fileName, newTag), category);
				    
	    			String currTag = tagList.getSelectedValue();
	    			final List<String> tempFiles = storage.getItems(currTag);
	    			theFiles.clear();
	    			for (String name : tempFiles) {
	    				theFiles.addElement(name);
	    			}
	    			fileList.setModel(theFiles);
				}
			}
			
		});
		
		
		documentButtn.add(itemAdd);
		documentButtn.add(itemDelete);		
		documents.add(documentButtn, BorderLayout.NORTH);

		documents.add(files, BorderLayout.CENTER);
		
		add(documents, BorderLayout.CENTER);
	}
	
	/**
	 * Adds a Listener used when selecting from a list.
	 * 
	 * @author Trevor Nichols
	 * Date: 12/05/19
	 */
	private void addTagListListener() {
		tagList.addListSelectionListener((ListSelectionListener) new ListSelectionListener()
		{
		    @Override
		    public void valueChanged(ListSelectionEvent e)
		    {
		    	tagDelete.setEnabled(true);
		    	itemAdd.setEnabled(true);
		    	
    			// @author: Yubo Wang
    			// setting the fileList properly
    			String currTag = tagList.getSelectedValue();
    			final List<String> tempFiles = storage.getItems(currTag);
    			theFiles.clear();
    			for (String name : tempFiles) {
    				theFiles.addElement(name);
    			}
    			fileList.setModel(theFiles);
		    }
		});
	}
	
	/**
	 * Adds a listener for adding a tag.
	 * 
	 * @author Trevor Nichols
	 * Date: 12/05/19
	 */
	private void addTagListener() {
		tagAdd.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent theEvent) {
				JTextField tag = new JTextField(20);

	    		
	    		//creates a panel to grab user and email
	    		JPanel tagPanel = new JPanel();
	    		tagPanel.add(new JLabel("Tag: "));
	    		tagPanel.add(tag);
	    			
	    		//Creating the ok and cancel button. 
	    		int result = JOptionPane.showConfirmDialog(null, tagPanel, "Add Tag", JOptionPane.OK_CANCEL_OPTION);
	    		
	    		if (result == JOptionPane.OK_OPTION) {
	    			storage.addCategory(new Tag(tag.getText()));
	    			tagNames.addElement(tag.getText());
	    			tagList.setModel(tagNames);
	    			tagDelete.setEnabled(false);
	    			tagList.setSelectedIndex(tagNames.getSize() - 1);
	    		}
			}
		});
	}
	
	/**
	 * Adds a listener for deleting a tag.
	 * 
	 * @author Trevor Nichols
	 * Date: 12/05/19
	 */
	private void deleteTagListener() {
		tagDelete.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent theEvent) {

	    		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Add Tag", JOptionPane.OK_CANCEL_OPTION);
	    		
	    		if (result == JOptionPane.OK_OPTION) {
	    			storage.removeCategory(tagList.getSelectedValue());
	    			tagNames.removeElement(tagList.getSelectedValue());
	    			tagList.setModel(tagNames);
	    		}
			}
		});
	}
}
	
