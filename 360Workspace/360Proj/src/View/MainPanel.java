package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileSystemView;


public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931505285368286964L;

	public MainPanel() {
		setLayout(new BorderLayout());
		
		JPanel projectScroll = new JPanel(new BorderLayout());
		JPanel projectButtn = new JPanel(new FlowLayout());
		
		/*
		 * Need to add button listeners for adding and deleting
		 * keys from our map which means we will have to pop up
		 * a new window for add to gather information and a window to 
		 * confirm delete. the listener should also refresh the projectScroll
		 * panel, so that the updates are visible
		 */
		JButton add = new JButton("Add Project");
		JButton delete = new JButton("Delete Project");
		
		projectButtn.add(add);
		projectButtn.add(delete);
		
		projectScroll.add(projectButtn, BorderLayout.NORTH);
		
		String test[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		
		//add all the key values from our map to this JList.
		
		/*
		 * Need to add a listselectionlistener that populates
		 * another window with all the values for the selected key/keys
		 * should refresh the window containing all values.
		*/
		JList<String> names = new JList<String>(test);
		
		JScrollPane projects = new JScrollPane(names);
		projectScroll.add(projects, BorderLayout.CENTER);
		
		add(projectScroll, BorderLayout.WEST);
		//end of the project select window on left side of GUI.
		
		
		
		//Documents window is below this comment
		//attempting to get the documents window to display correctly.
		JPanel documents = new JPanel(new BorderLayout());
		JPanel icons = new JPanel(new GridLayout(0, 10, 6, 6));
		
		//Add and Delete buttons for files.
		//Still need Action listeners for adding and deleting documents from storage.
		JPanel documentButtn = new JPanel(new FlowLayout());
		JButton dAdd = new JButton("Add File");
		JButton dDelete = new JButton("Delete File");
		documentButtn.add(dAdd);
		documentButtn.add(dDelete);		
		documents.add(documentButtn, BorderLayout.NORTH);
		
		File testFile = new File("C:\\Users\\trevo\\Pictures\\Screenshots\\Screenshot (5).png");
		Icon ico = FileSystemView.getFileSystemView().getSystemIcon(testFile);
		
		icons.add(new JButton(ico));
		JScrollPane scrollIcon = new JScrollPane(icons);
		documents.add(scrollIcon, BorderLayout.CENTER);
		
		add(documents, BorderLayout.CENTER);
	}
}
