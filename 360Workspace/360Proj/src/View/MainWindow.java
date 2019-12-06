package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * This class represents the main window of our program.
 * 
 * @author Trevor Nichols
 *
 */
public class MainWindow extends JFrame {

	//ID for serialization.
	private static final long serialVersionUID = 9040978770256604819L;
	
	//A Toolkit.
	static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	//The Dimensions of the screen.
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	

	/**
	 * Constructs a new MainWindow where the rest of the UI components will
	 * be placed.
	 */
	public MainWindow() {
		setSize(SCREEN_SIZE);
		setJMenuBar(new MenuBar());
		add(new MainPanel());
	}
	
	/**
	 * Displays the MainWindow.
	 */
	public void run() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}