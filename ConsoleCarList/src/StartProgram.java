import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static ListItemHelper lih = new ListItemHelper();
	
	private static void addAnItem() {
		System.out.print("Enter a make: ");
		String make = in.nextLine();
		System.out.print("Enter a model: ");
		String model = in.nextLine();
		System.out.print("Enter a year: ");
		String year = in.nextLine();
		ListItem toAdd = new ListItem(make, model, year);
		lih.insertItem(toAdd);
	}
	
	private static void deleteAnItem() {
		System.out.print("Enter the make to delete: ");
		String make = in.nextLine();
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
		System.out.print("Enter the year to delete: ");
		String year = in.nextLine();
		ListItem toDelete = new ListItem(make, model, year);
		lih.deleteItem(toDelete);
	}
	
	private static void editAnItem() {
		boolean validInput = true;
		System.out.println("How would you like to search? ");
		System.out.println("1 - Search by Make");
		System.out.println("2 - Search by Model");
		System.out.println("3 - Search by Year");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListItem> foundItems = null;
		switch(searchBy) {
		case 1: 
			System.out.print("Enter the make: ");
			String makeName = in.nextLine();
			foundItems = lih.searchForItemByMake(makeName);
			break;
		case 2:
			System.out.print("Enter the model: ");
			String modelName = in.nextLine();
			foundItems = lih.searchForItemByModel(modelName);
			break;
		case 3:
			System.out.print("Enter the year: ");
			String yearName = in.nextLine();
			foundItems = lih.searchForItemByYear(yearName);
			break;
		default:
			validInput = false;
			System.out.print("Invalid input.\n");
			break;
		}
		
		if(validInput) {
			
			if(!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();
				
				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getMake() + " " + toEdit.getModel() + ", year " + toEdit.getYear());
				System.out.println("1 - Update Make");
				System.out.println("2 - Update Model");
				System.out.println("3 - Update Year");
				int update = in.nextInt();
				in.nextLine();
				
				switch (update) {
				case 1:
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
					break;
				case 2:
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
					break;
				case 3:
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
					break;
				default:
					validInput = false;
					System.out.println("Invalid input.\n");
					break;
				}
				
				if(validInput) {
					lih.updateItem(toEdit);
				}
			} else {
				System.out.println("---- No results found");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our epic car dealership! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the epic program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<ListItem> allItems = lih.showAllItems();
		for(ListItem singleItem : allItems) {
			System.out.println(singleItem.returnItemDetails());
		}
		

	}
	
}
