package Main;

import java.awt.EventQueue;

import View.MainWindow;

/**
 * This program opens the MainWindow.
 * 
 * @author Trevor Nichols
 *
 */
public class Driver {
	
	/**
	 * A private constructor to inhibit external instantiation.
	 */
	private Driver() {
		throw new IllegalStateException();
	}
	
	/**
	 * The start point for a program that displays the MainWindow.
	 * 
	 * @param theArgs command line arguments - ignored in this program. 
	 */
	public static void main(final String[] theArgs) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow().run();
			}
		});
	}
		
}
