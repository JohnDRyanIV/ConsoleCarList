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
				//editAnItem();
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
