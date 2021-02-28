package medical_Dispensary;


/**
 * Date: Jan. 1, 2019
 * Author: Aryan Patel
 * Description: This class will display the instructions for the user on how to navigate through the program and use it correctly.
 *
 */

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Help extends JFrame implements ActionListener{
	//declares the JTextArea and JButton
	static JTextArea output = new JTextArea();
	JButton btnExit = new JButton("Return to Home Page");
	
	//variable to add back ground
	JLabel backGnd = new JLabel(new ImageIcon("background.jpg"));

	//variable to return to the main interface
	Window home;

	public Help() throws IOException {
		super("Help");
		setSize(900, 550);  //sets the size of the window frame
		setVisible(true);  //makes it visible
		setResizable(false);  //disables the resize of the window

		//sets the layout
		setLayout(null);

		//sets the size of the text area and the button
		output.setBounds(0, 0, 900, 440);
		add(output);

		btnExit.setBounds(330, 445, 200, 70);
		add(btnExit);
		
		//adds the background image
		backGnd.setBounds(0, 0, 900, 550);
		add(backGnd);

		//calls the readInfo method
		readInfo();
		
		//listen to the button click
		btnExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		//checks which button is pressed
		if (e.getSource() == btnExit) {
			//disposes the window
			dispose();

			//go back to the home page
			home = new MedicineDispensaryMain();
		}
	}

	public static String helpInfo() throws IOException {
		//variable to store the instructions
		String info = "";

		//loads the information from a file
		FileReader fileInfo = new FileReader("README.txt");
		BufferedReader input = new BufferedReader(fileInfo);

		//loop to store the information in the variable
		for (int i = 0; i < 28; i = i + 1) {
			info = info + input.readLine() + "\n";
		}

		//closes the file
		input.close();

		//returns the information
		return info;
	}

	public static void readInfo() throws IOException{
		//variable to store the return value
		String helpInfo = helpInfo();

		output.setEditable(false);  //disables the interactions with the text in the text area
		output.setText(helpInfo);  //displays the help information

	}

	public static void main(String[] args) throws IOException {
		//calls the constructor class
		new Help();
	}	
}
