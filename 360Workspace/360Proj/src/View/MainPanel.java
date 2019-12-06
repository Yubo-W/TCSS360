package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import Controller.CurrentUserBridgeDisplay;
import Model.FileMap;
import Model.Item;
import Model.Tag;


public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931505285368286964L;
	
	private JButton tagAdd;
	private JButton tagDelete;
	private JButton itemAdd;
	private JButton itemDelete;
	private JList<String> tagList;
	private FileMap storage;
	private JPanel tagScroll;
	private DefaultListModel<String> tagNames;


	public MainPanel() {
		storage = new FileMap();
		tagNames = new DefaultListModel<String>();
		setLayout(new BorderLayout());
		createTagWindow();
		createItemWindow();
	}
	
	private void createTagWindow() {
		
		tagScroll = new JPanel(new BorderLayout());
		JPanel projectButtn = new JPanel(new FlowLayout());
		
		/*
		 * Need to add button listeners for adding and deleting
		 * keys from our map which means we will have to pop up
		 * a new window for add to gather information and a window to 
		 * confirm delete. the listener should also refresh the projectScroll
		 * panel, so that the updates are visible
		 */
		tagAdd = new JButton("Add Tag");
		addTagListener();
		tagDelete= new JButton("Delete Project");
		tagDelete.setEnabled(false);
		
		projectButtn.add(tagAdd);
		projectButtn.add(tagDelete);
		
		tagScroll.add(projectButtn, BorderLayout.NORTH);
	
		
		//add all the key values from our map to this JList.
		
		/*
		 * Need to add a listselectionlistener that populates
		 * another window with all the values for the selected key/keys
		 * should refresh the window containing all values.
		*/
		tagList = new JList<String>(storage.getTagNames());
		
		JScrollPane projects = new JScrollPane(tagList);
		tagScroll.add(projects, BorderLayout.CENTER);
		
		add(tagScroll, BorderLayout.WEST);
	}
	
	private void createItemWindow() {

		//attempting to get the documents window to display correctly.
		JPanel documents = new JPanel(new BorderLayout());
		JPanel icons = new JPanel(new GridLayout(0, 10, 6, 6));
		
		//Add and Delete buttons for files.
		//Still need Action listeners for adding and deleting documents from storage.
		JPanel documentButtn = new JPanel(new FlowLayout());
		itemAdd = new JButton("Add File");
		itemDelete = new JButton("Delete File");
		itemAdd.setEnabled(false);
		itemDelete.setEnabled(false);
		documentButtn.add(itemAdd);
		documentButtn.add(itemDelete);		
		documents.add(documentButtn, BorderLayout.NORTH);
		
		
		JScrollPane scrollIcon = new JScrollPane(icons);
		documents.add(scrollIcon, BorderLayout.CENTER);
		
		add(documents, BorderLayout.CENTER);
	}
	
	private void addTagListListener() {
		
	}
	
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
	    			repaint();
	    		}
			}
		});
	}
}
	
