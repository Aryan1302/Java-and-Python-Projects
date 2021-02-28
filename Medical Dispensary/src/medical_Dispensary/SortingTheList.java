package medical_Dispensary;

/**
 * Date: Jan. 5, 2019
 * Author: Aryan Patel
 * Description: This class will sort the list of the medicines according to the name, illness and price in either ascending
 * 				or descending order
 * 
 * Methods:
 * 
 * nameAsc: This method will sort the list according to the medicine name in ascending order
 * nameDes: This method will sort the list according to the medicine name in descending order
 * illnessAsc: This method will sort the list according to the illness name in ascending order
 * illnessDes: This method will sort the list according to the illness name in descending order
 * priceAsc: This method will sort the list according to the price in ascending order
 * priceDes: This method will sort the list according to the price in descending order
 */


public class SortingTheList {
	static String list = "";
	
	public static String nameAsc(String name[], String illness[], double price[]) {
		
		//loop through the whole array to sort the list according to name in ascending order
		for (int i = 0; i < name.length; i = i + 1) {
			//loop to compare one element to next
			for(int j = 0; j < name.length - 1; j = j + 1) {
				//compare the two elements
				if(name[j].compareToIgnoreCase(name[j + 1]) > 0) {
					//swap the names if they are not in ascending order
					String tempName = name[j];
					name[j] = name[j + 1];
					name[j + 1] = tempName;
					
					//swap the illness associated with the med Names
					String tempIllness = illness[j];
					illness[j] = illness[j + 1];
					illness[j + 1] = tempIllness;
					
					//swap the price associated with the med Names
					double tempPrice = price[j];
					price[j] = price[j + 1];
					price[j + 1] = tempPrice;
				}
			}
		}  //ends for loop with 'i'
		
		//makes the list of the information

		//creates the list containing medicines
		list = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
		list = list + "----------------\t\t" + "------------\t\t" + "------------\n";
		
		//adds all the information to the list
		for(int i = 0; i < name.length; i = i + 1) {
			list = list + name[i] + "\t\t" + illness[i] + "\t\t" + "$" + price[i] + "\n";
		}
		
		//return the list
		return list;
	}

	public static String nameDes(String name[], String illness[], double price[]) {
		
		//loop through the whole array to sort the list according to name in ascending order
		for (int i = 0; i < name.length; i = i + 1) {
			//loop to compare one element to next
			for(int j = 0; j < name.length - 1; j = j + 1) {
				//compare the two elements
				if(name[j].compareToIgnoreCase(name[j + 1]) < 0) {
					//swap the names if they are not in ascending order
					String tempName = name[j];
					name[j] = name[j + 1];
					name[j + 1] = tempName;
					
					//swap the illness associated with the med Names
					String tempIllness = illness[j];
					illness[j] = illness[j + 1];
					illness[j + 1] = tempIllness;
					
					//swap the price associated with the med Names
					double tempPrice = price[j];
					price[j] = price[j + 1];
					price[j + 1] = tempPrice;
				}
			}
		}  //ends for loop with 'i'
		
		//makes the list of the information

		//creates the list containing medicines
		list = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
		list = list + "----------------\t\t" + "------------\t\t" + "------------\n";
		
		//adds all the information to the list
		for(int i = 0; i < name.length; i = i + 1) {
			list = list + name[i] + "\t\t" + illness[i] + "\t\t" + "$" + price[i] + "\n";
		}
		
		//return the list
		return list;
	}
	
	public static String illnessAsc(String name[], String illness[], double price[]) {
		
		//loop through the whole array to sort the list according to illness in ascending order
		for (int i = 0; i < illness.length; i = i + 1) {
			//loop to compare one element to next
			for(int j = 0; j < illness.length - 1; j = j + 1) {
				//compare the two elements
				if(illness[j].compareToIgnoreCase(illness[j + 1]) > 0) {
					//swap the illness if they are not in ascending order
					String tempIllness = illness[j];
					illness[j] = illness[j + 1];
					illness[j + 1] = tempIllness;
					
					//swap the name associated with the illness
					String tempName = name[j];
					name[j] = name[j + 1];
					name[j + 1] = tempName;
					
					//swap the price associated with the illness
					double tempPrice = price[j];
					price[j] = price[j + 1];
					price[j + 1] = tempPrice;
				}
			}
		}  //ends for loop with 'i'
		
		//makes the list of the information

		//creates the list containing medicines
		list = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
		list = list + "----------------\t\t" + "------------\t\t" + "------------\n";
		
		//adds all the information to the list
		for(int i = 0; i < illness.length; i = i + 1) {
			list = list + name[i] + "\t\t" + illness[i] + "\t\t" + "$" + price[i] + "\n";
		}
		
		//return the list
		return list;
	}

	public static String illnessDes(String name[], String illness[], double price[]) {
		
		//loop through the whole array to sort the list according to illness in ascending order
		for (int i = 0; i < illness.length; i = i + 1) {
			//loop to compare one element to next
			for(int j = 0; j < illness.length - 1; j = j + 1) {
				//compare the two elements
				if(illness[j].compareToIgnoreCase(illness[j + 1]) < 0) {
					//swap the illness if they are not in ascending order
					String tempIllness = illness[j];
					illness[j] = illness[j + 1];
					illness[j + 1] = tempIllness;
					
					//swap the name associated with the illness
					String tempName = name[j];
					name[j] = name[j + 1];
					name[j + 1] = tempName;
					
					//swap the price associated with the illness
					double tempPrice = price[j];
					price[j] = price[j + 1];
					price[j + 1] = tempPrice;
				}
			}
		}  //ends for loop with 'i'
		
		//makes the list of the information

		//creates the list containing medicines
		list = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
		list = list + "----------------\t\t" + "------------\t\t" + "------------\n";
		
		//adds all the information to the list
		for(int i = 0; i < illness.length; i = i + 1) {
			list = list + name[i] + "\t\t" + illness[i] + "\t\t" + "$" + price[i] + "\n";
		}
		
		//return the list
		return list;
	}
	
	public static String priceAsc(String name[], String illness[], double price[]) {
		
		//loop through the whole array to sort the list according to illness in ascending order
		for (int i = 0; i < price.length; i = i + 1) {
			//loop to compare one element to next
			for(int j = 0; j < price.length - 1; j = j + 1) {
				//compare the two elements
				if(price[j] > price[j + 1]) {
					//swap the price if they are not in ascending order
					double tempPrice = price[j];
					price[j] = price[j + 1];
					price[j + 1] = tempPrice;
					
					//swap the name associated with the price
					String tempName = name[j];
					name[j] = name[j + 1];
					name[j + 1] = tempName;
					
					//swap the illness associated with the price
					String tempIllness = illness[j];
					illness[j] = illness[j + 1];
					illness[j + 1] = tempIllness;
				}
			}
		}  //ends for loop with 'i'
		
		//makes the list of the information

		//creates the list containing medicines
		list = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
		list = list + "----------------\t\t" + "------------\t\t" + "------------\n";
		
		//adds all the information to the list
		for(int i = 0; i < illness.length; i = i + 1) {
			list = list + name[i] + "\t\t" + illness[i] + "\t\t" + "$" + price[i] + "\n";
		}
		
		//return the list
		return list;
	}

	public static String priceDes(String name[], String illness[], double price[]) {
	
		//loop through the whole array to sort the list according to illness in ascending order
		for (int i = 0; i < price.length; i = i + 1) {
			//loop to compare one element to next
			for(int j = 0; j < price.length - 1; j = j + 1) {
				//compare the two elements
				if(price[j] < price[j + 1]) {
				//swap the price if they are not in ascending order
				double tempPrice = price[j];
				price[j] = price[j + 1];
				price[j + 1] = tempPrice;
				
				//swap the name associated with the price
				String tempName = name[j];
				name[j] = name[j + 1];
				name[j + 1] = tempName;
				
				//swap the illness associated with the price
				String tempIllness = illness[j];
				illness[j] = illness[j + 1];
				illness[j + 1] = tempIllness;
				}
			}
		}  //ends for loop with 'i'
	
		//makes the list of the information

		//creates the list containing medicines
		list = "Medicine Name\t\t" + "Illness\t\t" + "Price\n";
		list = list + "----------------\t\t" + "------------\t\t" + "------------\n";
	
		//adds all the information to the list
		for(int i = 0; i < illness.length; i = i + 1) {
			list = list + name[i] + "\t\t" + illness[i] + "\t\t" + "$" + price[i] + "\n";
		}
	
		//return the list
		return list;
	}

	
	public static void main(String[] args) {

	}

}
