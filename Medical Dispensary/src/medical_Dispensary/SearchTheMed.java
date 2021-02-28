package medical_Dispensary;

/**
 * Date: Jan. 2, 2019
 * Author: Aryan Patel
 * Description: This class will search the medicines related to the specified illness and display it. Also, it will display the 
 * 				previously selected medicines in the text area.
 * 
 * Methods:
 * searchTheArray: A method to search the entered illness name and retrieve all the information related to that illness name
 * searchNameCounter: A method to go through the illness array and count whenever it finds the entered illness name
 */

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class SearchTheMed extends JFrame implements ActionListener{
	//declares the buttons, labels, text areas and text fields
	JLabel fileInput, injectionPic;
	JButton btnEnter, btnClear, btnLoad, btnHome;
	JTextField txtInput;
	static JTextArea output;

	//varaibele to return to main interface
	Window home;

	//arrays to store the info from the check out file
	static String checkOutMedName[];
	static String checkOutIllness[];
	static double checkOutPrice[];

	//array to store the illness name info location and variable to store the element number
	static int illnessInfoLocation[];
	static int searchArrayNum;

	static int counter = 0;   //counter to count when the entered name comes in the array

	static String nameToSearch = "";   //variable to store the info from the text file

	//variable to create the list
	static String checkOutInfoList = "", searchIllnessList = "";

	public SearchTheMed() {
		super("Search The Medicine");

		//initializes the buttons, labels, text fields and text areas
		fileInput = new JLabel("Enter the Illness name: ");
		btnEnter = new JButton("Search");
		btnClear = new JButton("Clear the List");
		btnLoad = new JButton("Load previous selection");
		btnHome = new JButton("Return to Home Page");
		txtInput = new JTextField("");
		injectionPic = new JLabel(new ImageIcon("Injection.png"));
		output = new JTextArea();

		setSize(700, 550);  //sets the size of the frame
		setVisible(true);     //makes the window visible
		setResizable(false);  //makes the window non-resizable

		//sets the layout
		setLayout(null);

		//sets the bounds of all the components
		fileInput.setBounds(0, 30, 150, 25);
		add(fileInput);

		txtInput.setBounds(140, 30, 260, 25);
		add(txtInput);

		btnEnter.setBounds(410, 20, 75, 40);
		add(btnEnter);

		btnClear.setBounds(465, 170, 125, 50);
		add(btnClear);

		btnLoad.setBounds(430, 250, 200, 50);
		add(btnLoad);

		btnHome.setBounds(430, 420, 200, 50);
		add(btnHome);
		
		injectionPic.setBounds(500, 20, 150, 160);
		add(injectionPic);

		output.setBounds(0, 75, 400, 400);
		output.setEditable(false);
		add(output);

		//listen to the buttons
		btnEnter.addActionListener(this);
		btnClear.addActionListener(this);
		btnLoad.addActionListener(this);
		btnHome.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {

		//checks which button is pressed
		if (event.getSource() == btnEnter) {
			try {
				//get the info from the text file
				nameToSearch = txtInput.getText();

				//call the searchNameCounter method to get the element size of the array
				searchArrayNum = searchNameCounter(nameToSearch, CheckOut.illnessName);  

				//initializes the array
				illnessInfoLocation = new int[searchArrayNum];
				
				//calls the search location method
				searchTheArray(nameToSearch, CheckOut.illnessName);

				//creates the list containing medicines
				searchIllnessList = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
				searchIllnessList = searchIllnessList + "----------------\t\t" + "------------\t\t" + "------------\n";

				//adds all the information to the list
				for(int i = 0; i < illnessInfoLocation.length; i = i + 1) {
					searchIllnessList = searchIllnessList + CheckOut.medName[illnessInfoLocation[i]] + "\t\t" 
							+ CheckOut.illnessName[illnessInfoLocation[i]] + "\t\t" + "$" + CheckOut.price[illnessInfoLocation[i]] + "\n";
					
				}
				//reset the counter
				counter = 0;
				
				//sets the list as text
				output.setText(searchIllnessList);
				
				//erases the text field's text
				txtInput.setText("");
			}
			catch(NullPointerException error) {
				JOptionPane.showMessageDialog(null, "Hiii");
			}
		}

		else if(event.getSource() == btnLoad) {
			try {
				//load the info from the file
				FileReader checkOutInfo = new FileReader(CheckOut.checkOutListFile);
				BufferedReader input = new BufferedReader(checkOutInfo);

				//initializes the arrays
				checkOutMedName = new String[CheckOut.clickCounter];
				checkOutIllness = new String[CheckOut.clickCounter];
				checkOutPrice = new double[CheckOut.clickCounter];

				//loads the information into the arrays
				for(int i = 0; i < checkOutMedName.length; i = i + 1) {
					checkOutMedName[i] = input.readLine();
					checkOutIllness[i] = input.readLine();
					checkOutPrice[i] = Double.parseDouble(input.readLine());
				}

				//close the file
				input.close();

				//creates the list containing medicines
				checkOutInfoList = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
				checkOutInfoList = checkOutInfoList + "----------------\t\t" + "------------\t\t" + "------------\n";

				//adds all the information to the list
				for(int i = 0; i < checkOutIllness.length; i = i + 1) {
					checkOutInfoList = checkOutInfoList + checkOutMedName[i] + "\t\t" + checkOutIllness[i] + "\t\t" + "$" + checkOutPrice[i] + "\n";
				}

				//sets the list as text
				output.setText(checkOutInfoList);
			}
			catch(IOException error) {
				//display an error message
				JOptionPane.showMessageDialog(null, "The file name input box is empty. Please enter a file name to save the checkout list.");
			}
		}
		else if(event.getSource() == btnClear) {
			//clears the text area
			output.setText("");
		}
		else if(event.getSource() == btnHome) {
			//closes this window
			dispose();

			//switches back to home page
			home = new MedicineDispensaryMain();
		}
	}

	public static void searchTheArray(String searchName, String searchedLocation[]) {
		//variable for the element number counter
		int elementCounter = 0;
		
		//loop to find all the locations of the entered illness info
		for (int i = 0; i < searchedLocation.length; i = i + 1){
			//check if the illness name is in the array or not
			if (searchName.equalsIgnoreCase(searchedLocation[i])) {
				illnessInfoLocation[elementCounter] = i;   //adds the location to the int array
				
				//adds one to the counter
				elementCounter = elementCounter + 1;
			}
		}
	}

	public static int searchNameCounter(String searchName, String searchArray[]) {
		//loop to go through the array
		for(int i = 0; i < searchArray.length; i = i + 1) {
			//checks whether the name is found in the array or not and count if the name is equal to the array
			if(searchName.equalsIgnoreCase(searchArray[i])) {
				//adds one to the counter
				counter = counter + 1;
			}
		}

		//returns the counter
		return counter;
	}

	public static void main(String[] args){
		// calls the constructor class
		new SearchTheMed();

	}


}
