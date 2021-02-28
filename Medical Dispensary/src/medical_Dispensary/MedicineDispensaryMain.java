package medical_Dispensary;

/**
 * Date: December 28, 2018
 * Author: Aryan Patel
 * Description: This class will create the main Graphical User Interface that will display all the aspects
 * 				of the program; all the information and the search option.
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MedicineDispensaryMain extends JFrame implements ActionListener {

	JButton btnCheckout, btnSearch, btnHelp, btnExit;  //declaring JButtons
	JLabel backGnd, crossPicTop, crossPicBot;  //pictures for the main interface

	//variables to call the different windows of the program
	Window checkOut, searchTheMed, help, endAnimation;

	//variable for the delay
	static int delay = 2800;
	
	//boolean for enabling and disabling the Search the Med button
	static boolean enable = false;

	public MedicineDispensaryMain() {
		super("Medicine Dispensary");

		//creates the buttons
		btnCheckout = new JButton("Checkout");
		btnSearch = new JButton("Search the Medicine");
		btnHelp = new JButton("Help");
		btnExit = new JButton("Exit");

		//creates the pictures
		backGnd = new JLabel(new ImageIcon("background.jpg"));
		crossPicTop = new JLabel(new ImageIcon("Top.png"));
		crossPicBot = new JLabel(new ImageIcon("Bottom.png"));

		//set the layout and the window's size
		setSize(500, 500);
		setLayout(null);

		//draws the images on the JFrame
		crossPicTop.setBounds(280, -5, 150, 150);
		add(crossPicTop);

		crossPicBot.setBounds(65, 315, 150, 150);
		add(crossPicBot);

		//sets the size, position and visibility of the buttons and the pictures
		btnCheckout.setBounds(175, 100, 150, 50);
		add(btnCheckout);

		btnSearch.setBounds(175, 170, 150, 50);
		add(btnSearch);
		btnSearch.setEnabled(enable);

		btnHelp.setBounds(175, 240, 150, 50);
		add(btnHelp);

		btnExit.setBounds(175, 310, 150, 50);
		add(btnExit);

		backGnd.setBounds(0, 0, 500, 500);
		add(backGnd);

		//listen to the buttons
		btnCheckout.addActionListener(this);
		btnSearch.addActionListener(this);
		btnHelp.addActionListener(this);
		btnExit.addActionListener(this);

		setVisible(true);
		setResizable(false);
	}


	public void actionPerformed(ActionEvent event){
		//checks which button is pressed
		if (event.getSource() == btnCheckout) {

			try {
				btnSearch.setEnabled(true);
				
				// calls the checkOut class
				checkOut = new CheckOut();

				//sets this window invisible
				setVisible(false);
			}
			catch (IOException error) {

			}
		}
		else if(event.getSource() == btnSearch) {
			// calls the searchTheMed class
			searchTheMed = new SearchTheMed();

			//sets this window invisible
			setVisible(false);
		}
		else if(event.getSource() == btnHelp) {
			try {
				// calls the help class
				help = new Help();

				//sets this window invisible
				setVisible(false);
			}
			catch (IOException error) {
			}
		}
		else if(event.getSource() == btnExit) {
			//displays a thank you message
			JOptionPane.showMessageDialog(null, "Thank you for using Medicine Dispensary."
					+ " Hope you enjoyed the program and learned something about medicines and "
					+ "their uses.");

			//closes the window
			dispose();

//			//calls the animation class again
//			new LoadingScreen();
//
//			//delay to end the program
//			try {
//				Thread.sleep(delay);
//			}
//			catch (Exception error) {
//			}

			//terminate the program
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		//calls the constructor method
		new MedicineDispensaryMain();
	}



}
