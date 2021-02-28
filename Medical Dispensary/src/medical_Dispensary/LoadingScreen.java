package medical_Dispensary;

/**
 * Date: December 28, 2018
 * Author: Aryan Patel
 * Description: Medical Dispensary is an application which displays different medicines for 
 * 				different illness and also displays their price. The user can also search specific
 * 				illness and get a list of all the medicines related to that illness.
 * 				
 * 				This class will display an animation as a loading indicator and then will display the main 
 * 				user interface.
 */

import javax.swing.*;
import java.awt.*;


public class LoadingScreen extends JFrame{
	//variables to store background image and the animation related images
	ImageIcon background = new ImageIcon("background.jpg");
	ImageIcon medicalCross[] = {new ImageIcon("Cross1.png"), new ImageIcon("Cross2.png"), new ImageIcon("Cross3.png"), 
			new ImageIcon("Cross4.png"), new ImageIcon("Cross5.png"), new ImageIcon("Cross6.png"), new ImageIcon("Cross7.png"), 
			new ImageIcon("Cross8.png"), new ImageIcon("Cross9.png")};
	
	static int delay = 350, windowDelay = 2800;  //variable for the delay of the animation

	//variable to call the main user interface window
	static Window mainUserInterface;
	
	public LoadingScreen() {
		//sets the title of the window
		super("Medical Dispensary");
		
		setSize(500, 500);    //sets the size of the window and makes it visible
		setVisible(true);

		setResizable(false);   //sets the window resize feature to false
	}
	
	public void paint(Graphics g) {
		//variable to play the animation
		int animationCounter = 0;
		
		//loop to play the animation
		while (animationCounter < medicalCross.length)  {
			//displays the background and the medical cross images
			background.paintIcon(this, g, 0, 0);
			medicalCross[animationCounter].paintIcon(this, g, 100, 100);
			
			//sets the delay
			try {
				Thread.sleep(delay);
			}
			catch (Exception error) {
			}
			
			animationCounter = animationCounter + 1;  //adds one to the counter
		}
		//closes the window
		dispose();
	}


	public static void main(String[] args) {
		//calls the constructor class
		new LoadingScreen();
		
		//sets the delay to call the main interface window
		try {
			Thread.sleep(windowDelay);
		}
		catch (Exception error) {
		}
		
		//calls the MedicineDispensarymain class
		mainUserInterface = new MedicineDispensaryMain();
	}

}
