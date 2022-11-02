package master;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private boolean cash = false;
	private List<Rental> rentals = new ArrayList<>();
		/********Constructor for the customers***********/
		Customer(String name){
			this.name = name;
		}
		Customer(String name, List<Rental> rental){
			this.name = name;
			for(Rental rentalz: rental) {
					rentals.add(rentalz);
			}
		}
		/********Adding a rental to the customer rentals array*****/
		public void addRental(Rental rental) {
			rentals.add(rental);
		}
		public void addRental(Rental rental, int days) {
			rental.setDaysRented(days);
			rentals.add(rental);
		}
		/*******Setting whether or not the customer paid in cash***********/
		public void paidInCash(boolean arg) {
			cash = arg;
		}
		/********Printing the statement for customer in $$ amount***********/
		public void printStatement() {
			var totalAmount = 0.00;
			var frequentRenterPoints = 0;
			var discountTotal = 0.00;
			printCustNameRentalRecord();
			for (Rental rental : rentals) {
				var daysInRental = rental.getDaysRented();
				var currentMoviePrice = rental.getMovie().getCharge(daysInRental,cash);
				totalAmount += currentMoviePrice;
				discountTotal = calculateIfPaidInCash(discountTotal, rental, daysInRental, currentMoviePrice);
				// show detail rentals figures
				printEachMovieCost(rental, currentMoviePrice);
				frequentRenterPoints += rental.getMovie().getPrice().getFrequentRenterPoints(daysInRental);
			}
			printTotalAndPoints(totalAmount, frequentRenterPoints);
			printIfPaidInCash(discountTotal);
		}
		/********Calculating the discount amount if cust paid in cash***********/
		private double calculateIfPaidInCash(double discountTotal, Rental rental, int daysInRental,
				double currentMoviePrice) {
			if (cash) {
				discountTotal += rental.getMovie().getCharge(daysInRental,false) - currentMoviePrice;
			}
			return discountTotal;
		}
		/********Printing the total amount discounted if they paid in cash***********/
		private void printIfPaidInCash(double discountTotal) {
			if (cash) {
				System.out.println(String.format("Thank you for paying cash. You saved a total of: $%.2f",discountTotal));
			}
		}
		/********Printing top line for Statement method***********/
		private void printCustNameRentalRecord() {
			String str = String.format("Rental Records for %s:", this.name );
			System.out.println(str);
		}
		/********Printing movie list for statement method***********/
		private void printEachMovieCost(Rental rental, double currentMoviePrice) {
			String printEachMovieAndCost = String.format("\t%-25s$%,.2f", rental.getMovie().getTitle(),currentMoviePrice);
			System.out.println(printEachMovieAndCost);
		}
		/********Printing total amount and points for statement method***********/
		private void printTotalAndPoints(double totalAmount, int frequentRenterPoints) {
			String printTotalAmount = String.format("\tTotal Amount Owed is:%-4s$%.2f","", totalAmount);
			System.out.println(printTotalAmount);
			String printFrequentRenterPoints = String.format("\tYou earned : %d frequent renter points", frequentRenterPoints);
			System.out.println(printFrequentRenterPoints);
		}
		public void setName(String name) {
			this.name = name;
		}
		/********Returning name of customer***********/
		public String getName() {
			return name;
		}
}
