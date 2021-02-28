package medical_Dispensary;

/**
 * Date: Jan. 3, 2019
 * Author: Aryan Patel
 * Description: This class will display the main interface where all the medicine information, sorting in three different methods
 * 				and allowing the user to choose the medicine from the list and save it to an another file to access it later.
 * 
 * Methods:
 * 
 * search - This method will search for the medicine the user enters and display the information into the second text box, for 
 * 			checkout.
 * listBegin - This method makes the title of the list displaying the medicines.
 * readInfo - This method reads the information from the file and loads up to the main list and displays it to the main text area
 */

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener {
	//declare variables for buttons, text fields, labels and text area
	JLabel lblCheckout, lblSort, lblFileName;
	JButton btnCheckout, btnHome, btnEnter, btnClear;
	JButton btnNameAsc, btnIllnessAsc, btnPriceAsc, btnNameDes, btnIllnessDes, btnPriceDes;
	JTextField txtInput, txtFileInput;
	static JTextArea medList, checkOut;

	//variable for the back ground image
	JLabel backGnd;

	//variable for the main list
	static String mainList = "";

	//declares the arrays
	static String medName[];
	static String illnessName[];
	static double price[];

	//variable to store the previous med info in the list and display the check out list
	static String checkOutList = "";
	static String previousMedInfo = "";

	//variable to create a scroll bar
	JScrollPane scroller, checkOutScroller;

	//variable to change the windows
	Window home;

	//variable to store the information the user searched
	String checkOutMed = "", checkOutIllness = "";
	double checkOutPrice = 0;

	//variable to check if the checkout text area is empty or not
	Boolean check;
	
	static String checkOutListFile;  //variable to store the check out file name
	
	static int clickCounter = 0;  //variable to keep track how many times the medicine is searched

	public CheckOut() throws IOException {
		//sets the name
		super("Check Out");

		//initialize all the variables
		lblCheckout = new JLabel("Enter the medicine name:");
		btnCheckout = new JButton("Save");
		btnClear = new JButton("Clear");
		btnHome = new JButton("Return To Home Page");
		lblSort = new JLabel("Sort by:");
		btnNameAsc = new JButton("Name (Ascending)");
		btnIllnessAsc = new JButton("Illness (Ascending)");
		btnPriceAsc = new JButton("Price (Ascending)");
		btnNameDes = new JButton("Name (Descending)");
		btnIllnessDes = new JButton("Illness (Descending)");
		btnPriceDes = new JButton("Price (Descending)");
		txtInput = new JTextField();
		btnEnter = new JButton("Enter");
		medList = new JTextArea();
		checkOut = new JTextArea();
		lblFileName = new JLabel("Enter the file name:");
		txtFileInput = new JTextField("Checkout.txt");

		//initializes the background
		backGnd = new JLabel(new ImageIcon("background.jpg"));

		//creates a variable for the font and font size for all the texts
		Font lblFont = new Font("Times New Roman", Font.BOLD, 14);
		Font txtFont = new Font("Times New Roman", Font.PLAIN, 16);
		Font btnFont = new Font("Times New Roman", Font.BOLD, 12);
		Font checkOutFont = new Font("Times New Roman", Font.PLAIN, 12);


		//sets the size, visibility and resizable of the JFrame
		setSize(900, 600);
		setVisible(true);
		setResizable(false);

		setLayout(null);   //sets the layout of the window area

		//sets the bounds of the variables, sets their fonts and adds them on the JFrame
		lblSort.setBounds(10, 10, 100, 25);
		lblSort.setFont(lblFont);
		add(lblSort);

		btnNameAsc.setBounds(70, 25, 140, 50);
		btnNameAsc.setFont(btnFont);
		add(btnNameAsc);

		btnNameDes.setBounds(70, 85, 140, 50);
		btnNameDes.setFont(btnFont);
		add(btnNameDes);

		btnIllnessAsc.setBounds(240, 25, 150, 50);
		btnIllnessAsc.setFont(btnFont);
		add(btnIllnessAsc);

		btnIllnessDes.setBounds(240, 85, 150, 50);
		btnIllnessDes.setFont(btnFont);
		add(btnIllnessDes);

		btnPriceAsc.setBounds(420, 25, 140, 50);
		btnPriceAsc.setFont(btnFont);
		add(btnPriceAsc);

		btnPriceDes.setBounds(420, 85, 140, 50);
		btnPriceDes.setFont(btnFont);
		add(btnPriceDes);

		lblCheckout.setBounds(580, 170, 280, 25);
		lblCheckout.setFont(lblFont);
		add(lblCheckout);

		txtInput.setBounds(580, 200, 180, 25);
		add(txtInput);

		btnEnter.setBounds(770, 190, 75, 35);
		btnEnter.setFont(btnFont);
		add(btnEnter);

		lblFileName.setBounds(580, 430, 150, 50);
		lblFileName.setFont(lblFont);
		add(lblFileName);

		txtFileInput.setBounds(580, 465, 160, 25);
		add(txtFileInput);

		btnCheckout.setBounds(750, 430, 100, 40);
		btnCheckout.setFont(btnFont);
		add(btnCheckout);

		btnClear.setBounds(750, 480, 100, 40);
		btnClear.setFont(btnFont);
		add(btnClear);
		
		btnHome.setBounds(620, 530, 180, 40);
		btnHome.setFont(btnFont);
		add(btnHome);

		//adds the two text areas
		medList.setTabSize(10);
		medList.setFont(txtFont);
		medList.setEditable(false);

		//creates a scroller
		scroller = new JScrollPane(medList);
		scroller.setBounds(10, 150, 550, 400);
		add(scroller);
		
		checkOut.setTabSize(10);
		checkOut.setFont(checkOutFont);
		checkOut.setEditable(false);

		//creates a scroller
		checkOutScroller = new JScrollPane(checkOut);
		checkOutScroller.setBounds(580, 230, 270, 200);
		add(checkOutScroller);

		//calls the readInfo method
		readInfo();
		
		//sets the default name for the checkout text file
		checkOutListFile = "Checkout.txt";

		//listens to the buttons
		btnCheckout.addActionListener(this);
		btnEnter.addActionListener(this);
		btnHome.addActionListener(this);
		btnClear.addActionListener(this);
		btnNameAsc.addActionListener(this);
		btnIllnessAsc.addActionListener(this);
		btnPriceAsc.addActionListener(this);
		btnNameDes.addActionListener(this);
		btnIllnessDes.addActionListener(this);
		btnPriceDes.addActionListener(this);
	}


	public void actionPerformed(ActionEvent event) {
		//checks which button is pressed
		if (event.getSource() == btnNameAsc) {
			//call the name (ascending) sorting method from class SortingTheList
			mainList = SortingTheList.nameAsc(medName, illnessName, price);

			//display the list on the JTextArea
			medList.setText(mainList);
		}
		else if(event.getSource() == btnNameDes) {
			//call the name (descending) sorting method from class SortingTheList
			mainList = SortingTheList.nameDes(medName, illnessName, price);

			//display the list on the JTextArea
			medList.setText(mainList);
		}
		else if(event.getSource() == btnIllnessAsc) {
			//call the illness (ascending) sorting method from class SortingTheList
			mainList = SortingTheList.illnessAsc(medName, illnessName, price);

			//display the list on the JTextArea
			medList.setText(mainList);
		}
		else if(event.getSource() == btnIllnessDes) {
			//call the illness (descending) sorting method from class SortingTheList
			mainList = SortingTheList.illnessDes(medName, illnessName, price);

			//display the list on the JTextArea
			medList.setText(mainList);
		}
		else if (event.getSource() == btnPriceAsc) {
			//call the price (ascending) sorting method from class SortingTheList
			mainList = SortingTheList.priceAsc(medName, illnessName, price);

			//display the list on the JTextArea
			medList.setText(mainList);
		}
		else if(event.getSource() == btnPriceDes) {
			//call the price (descending) sorting method from class SortingTheList
			mainList = SortingTheList.priceDes(medName, illnessName, price);

			//display the list on the JTextArea
			medList.setText(mainList);
		}
		else if(event.getSource() == btnClear) {
			//clears the check out list
			checkOut.setText("");
			
			//resets all the variables which holds the check out information
			checkOutMed = "";
			checkOutIllness = "";
			checkOutPrice = 0;
			previousMedInfo = "";
		}
		else if(event.getSource() == btnEnter) {
			//checks if the check out list is empty or not
			if(checkOutMed.equals("")) {
				//sets the check to false
				check = false;
			}
			else {
				//sets the check to true
				check = true;
			}

			try {
				//get the entered information from the text field
				String answer = txtInput.getText();

				//variable to store the return value
				int location = 0;
				location = search(answer, medName);

				//checks if the return value is -1 or not
				if (location >= 0) {
					//calls the listBegin methods
					listBegin();
					
					//adds one to the click for every time the info is entered
					clickCounter = clickCounter + 1;

					//store the searched information into variables
					checkOutMed =  medName[location];
					checkOutIllness = illnessName[location];
					checkOutPrice = price[location];

					//variable to store the medicine info
					String medInfo = checkOutMed + "\t" + checkOutIllness + "\t" + "$" + checkOutPrice;

					//add the list info to the previousMedInfo variable
					previousMedInfo = previousMedInfo + medInfo + "\n";

					//add the entered med info to the list
					checkOutList = checkOutList + previousMedInfo + "\n";

					//display the list to the JTextArea for checkout
					checkOut.setText(checkOutList);	

					//write the check out list to a file
					FileWriter checkOutFile = new FileWriter(checkOutListFile, check);
					PrintWriter output = new PrintWriter(checkOutFile);

					//write the check out list to another file
					output.println(checkOutMed);
					output.println(checkOutIllness);
					output.println(checkOutPrice);

					//closes the file
					output.close();
				}
				else {
					//display the missing info message
					JOptionPane.showMessageDialog(null, "The medicine you are trying to find does not exist in our database.");
				}
			}
			catch (NullPointerException error) {
				JOptionPane.showMessageDialog(null, "The medicine name input box is empty. Please enter a medicine name to search for.");
			}
			catch (IOException e) {
				//display an error message
				JOptionPane.showMessageDialog(null, "The file name input box is empty. Please enter a file name to save the checkout list.");
			}

			//erases the info from the txtInput
			txtInput.setText("");
		}

		else if(event.getSource() == btnCheckout) {
			try {
				//variable to ask the user to enter the file name to store the check out list
				checkOutListFile = txtFileInput.getText();
				
				//prompt the user about the list being saved
				JOptionPane.showMessageDialog(null, "The file name has been saved.");
			} 
			catch (NullPointerException e) {
				//display an error message
				JOptionPane.showMessageDialog(null, "The file name input box is empty. Please enter a file name to save the checkout list.");
			}

		}
		else if(event.getSource() == btnHome) {
			//prompt the user about the list being saved
			JOptionPane.showMessageDialog(null, "Your check out list has been saved to the"
					+ " file named " + checkOutListFile);
			
			//closes this window
			dispose();
			
			//change the enable from false to true
			MedicineDispensaryMain.enable = true;

			//calls the main interface
			home = new MedicineDispensaryMain();
		}
	}


	public static int search (String medNameToFind, String medSearch[]) {
		//loop to search for the medicine name from the array
		for(int i = 0; i < medSearch.length; i = i + 1) {
			//checks if the med name is in the database or not
			if(medNameToFind.equalsIgnoreCase(medSearch[i])) {
				return i;  //returns the location
			}
		}
		return -1;  //returns -1 if the med name is not in database
	}

	public static void listBegin() {
		//creates the list containing medicines
		checkOutList = "Medicine Name\t" + "Illness\t" + "Price\n";
		checkOutList = checkOutList + "----------------\t" + "------------\t" + "------------\n";
	}

	public static void readInfo() throws IOException {
		//declares the array's element number
		int arrayNum = 0;

		//try...catch error trapping to trap errors
		try {
			//reads the information from the file
			FileReader medInfo = new FileReader("Medicines.txt");
			BufferedReader medInput = new BufferedReader(medInfo);

			//reads the first line from the file and stores it in a variable
			arrayNum = Integer.parseInt(medInput.readLine());

			//initializes the arrays
			medName = new String[arrayNum];
			illnessName = new String[arrayNum];
			price = new double[arrayNum];

			//loads the information into the arrays
			for(int i = 0; i < medName.length; i = i + 1) {
				medName[i] = medInput.readLine();
				illnessName[i] = medInput.readLine();
				price[i] = Double.parseDouble(medInput.readLine());
				
				
			}

			//close the file
			medInput.close();

			//creates the list containing medicines
			mainList = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
			mainList = mainList + "----------------\t\t" + "------------\t\t" + "------------\n";

			//adds all the information to the list
			for(int i = 0; i <medName.length; i = i + 1) {
				mainList = mainList + medName[i] + "\t\t" + illnessName[i] + "\t\t" + "$" + price[i] + "\n";
			}

			//display the list on the JTextArea
			medList.setText(mainList);
		}
		catch (IOException error) {
			JOptionPane.showMessageDialog(null, "The file name entered is not found. Please check the file name which has the " + 
					"medicine information.");
		}
	}

	public static void main(String[] args) throws IOException {
		//calls the constructor class
		new CheckOut();
	}

}
