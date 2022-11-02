package master;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCustomer {
	private List<Movie> movies = new ArrayList<>();
	private List<Rental> rentals = new ArrayList<>();
	private List<Customer> customers = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TestCustomer test = new TestCustomer();
		test.createMovies();
		test.createRentals();
		test.welcome();
		test.printMenu();
	}
	private void welcome() {
		System.out.println("What is your name?");
		String name = getNextLineFromUser();
		System.out.println("Welcome to the Movie place " + name);
		customers.add(new Customer(name));
	}
	private void printMenu(){

		System.out.println("Please select what you'd like to do");
		System.out.println("0: Exit");
		System.out.println("1: Add New Movie");
		System.out.println("2: Checkout");
		int userChoice = getNextIntFromUser();
		handleUserChoiceMainMenu(userChoice);
		}
		
	
	private void printRentalList() {
		int i = 1;
		for(Movie moviez: movies) {
			System.out.println("\t" + i + ": " + moviez.getTitle());
			i++;
		}
		System.out.print("Enter the ID of movie you'd like to rent:");
	}
	private void handleUserChoiceMainMenu(int userChoice) {
		switch(userChoice) {
		case 0:
			exit();
			break;
		case 1:
			handleUserChoiceForRentalAdding();
			break;
		case 2:
			checkout();
			exit();
			break;
		default:
			System.out.println("Not a good choice");
			printMenu();
			break;
		}
	}
	private void handleUserChoiceForRentalAdding() {
		System.out.println("Select the ID of the Movie you'd like to checkout.");
		System.out.println("\t0: Exit");
		printRentalList();
		int userChoice = getNextIntFromUser();
			if(userChoice < rentals.size() + 1) {
				Rental rentalToAdd = rentals.get(userChoice - 1);
				
				System.out.println("You've added " + rentalToAdd.getMovie().getTitle());
				System.out.println("How many days would you like to rent it for?");
				
				int daysToRent = getNextIntFromUser();
				
				System.out.println("Will you be paying cash? \n Please Enter Y for Yes or any other key for No");
				
				scanner.nextLine();
				String isCash = getNextLineFromUser();

				if (isCash.equals("Y")|| isCash.equals("y")){
					printPriceIfNotPayingCash(rentalToAdd, daysToRent);
					customers.get(0).addRental(rentalToAdd, daysToRent);;
				} else {
					printPriceIfPayingCash(rentalToAdd, daysToRent);
					customers.get(0).addRental(rentalToAdd, daysToRent);;
				}
			} else {
			System.out.println("Please Check your input.");
			printRentalList();
			userChoice = getNextIntFromUser();
		}
			
			System.out.println();
			printMenu();
			
	}

	private void printPriceIfNotPayingCash(Rental rentalToAdd, int daysToRent) {
		System.out.println(String.format("You chose %s for %d days. This comes to $%.2f.",
				rentalToAdd.getMovie().getTitle(),
				daysToRent,
				rentalToAdd.getMovie().getPrice().getCharge(daysToRent, true)));
		
	}
	private void printPriceIfPayingCash(Rental rentalToAdd, int daysToRent) {
		System.out.println(String.format("You chose %s for %d days. This comes to $%.2f.",
				rentalToAdd.getMovie().getTitle(),
				daysToRent,
				rentalToAdd.getMovie().getPrice().getCharge(daysToRent, false)));
		
	}
	public void createMovies() {
		movies.add(new Movie("Return of Snake", 1));
		movies.add(new Movie("Welcome to the Jingle", 2));
		movies.add(new Movie("Mouse Pad Attacks", 0));
		movies.add(new Movie("When the tomatoes shake", 1));

	}
	public void createRentals() {
		for(Movie moviez: movies) {
			rentals.add(new Rental(moviez));
		}
	}
	private void checkout() {
		customers.get(0).printStatement();
	}
	private int getNextIntFromUser() {
		return scanner.nextInt();
	}
	private String getNextLineFromUser() {
		return scanner.nextLine();
	}
	private void exit() {
		System.out.println("Exiting Now. Goodbye");
		scanner.close();
	}
}
