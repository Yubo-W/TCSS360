package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import Model.ProjectVersion;

/**
 * A class that represents a MenuBar.
 * 
 * @author Trevor Nichols 
 *
 */
public class MenuBar extends JMenuBar {

	//ID for serialization.
	private static final long serialVersionUID = 2164507453671730079L;
	
	private ProjectVersion myVersion;
	
	
	/**
	 * Initializes the MenuBar.
	 */
	public MenuBar() {
		myVersion = new ProjectVersion();
		createBar();
	}
	
	/**
	 * A Method that creates an ABout section within the MenuBar. 
	 */
	private void createBar() {
		final JMenu help = new JMenu("Help");
		final JMenu file = new JMenu("File");
		file.add(importAction());
		file.add(exportAction());
		help.add(aboutAction());
		add(file);
		add(help);
	}
	
	/**
	 * 
	 * @return
	 */
	private JMenuItem importAction() {
		JMenuItem imp = new JMenuItem("Import");
		
		//code
		
		return imp;
	}
	
	/**
	 * 
	 * @return
	 */
	private JMenuItem exportAction() {
		JMenuItem exp = new JMenuItem("Export");
		
		//code
		
		return exp;
	}
	
	/**
	 * Creates an JMenuItem with an action linked to it.
	 * 
	 * @return JMenuItem for the About section.
	 */
	private JMenuItem aboutAction() {
		JMenuItem about = new JMenuItem("About");
		StringBuilder str = new StringBuilder();
		str.append("Version: ");
		str.append(myVersion.getVersion());
		str.append("\nDevelopers: Stas, Trent, Trevor, Yubo");
		
		about.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, str.toString());
			}
		});
		
		return about;
	}

}