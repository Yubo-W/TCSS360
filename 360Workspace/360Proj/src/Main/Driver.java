package Main;

import java.awt.EventQueue;

import View.MainWindow;

/**
 * This program opens the MainWindow.
 * 
 * @author Trevor Nichols
 * Date:11/10/19
 */
public class Driver {
	
	/**
	 * A private constructor to inhibit external instantiation.
	 * 
	 * @author Trevor Nichols
	 * Date 11/10/19
	 */
	private Driver() {
		throw new IllegalStateException();
	}
	
	/**
	 * The start point for a program that displays the MainWindow.
	 * 
	 * @param theArgs command line arguments - ignored in this program.
	 * 
	 * @author Trevor Nichols
	 * Date 11/10/19 
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