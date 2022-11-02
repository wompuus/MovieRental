package master;

public abstract class Price {
	
		// there is no implementation of the code just the stub methods
		abstract int getPriceCode();
		// NOTE: 1. no curly {] braces in the code no return statement 
		// 2. and it is immediately terminated by ";"
		abstract double getCharge(int daysInRent, boolean cash);
		abstract int getFrequentRenterPoints(int daysRented);

	}

