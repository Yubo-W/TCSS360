package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Controller.ImportExportBridge;
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
		file.add(settingsAction());
		
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
		
		imp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				// import was clicked, we allow for file choosing. 
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    
				    //Calls the bridge to initilize our user. 
				    ImportExportBridge.importSettings(selectedFile);   
				}
			}
			
		});
		
		return imp;
	}
	
	/**
	 * 
	 * @return
	 */
	private JMenuItem exportAction() {
		JMenuItem exp = new JMenuItem("Export");
		
		exp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				ImportExportBridge.exportSettings();
				
			}
		});
		
		return exp;
	}
	
	/**
	 * Creates a setting menu function which allows the user to set a username and email. 
	 * @return Menu Item to be clicked.
	 */
	private JMenuItem settingsAction() {
		JMenuItem settings = new JMenuItem("Settings");
		
		settings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				UserEmailAndNameWindow window = new UserEmailAndNameWindow();
				window.generateEmailandUserWindow();
			}
		});

		return settings;
	}
	
	/**
	 * Creates an JMenuItem with an action linked to it.
	 * 
	 * @return JMenuItem for the About section.
	 */
	private JMenuItem aboutAction() {
		JMenuItem about = new JMenuItem("About");
		StringBuilder str = new StringBuilder();
		str.append("This program is designed to allow useres to store and organize\n");
		str.append("documents for different projects in one location in order to\n");
		str.append("make the retrival of documents easier.\n");
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