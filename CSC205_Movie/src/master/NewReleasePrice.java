package master;

public class NewReleasePrice extends Price {

	@Override 
	// annotation informs the compiler that the element is meant to override
	// an element declared in a superclass. 
	//Overriding methods will be discussed in Interfaces and Inheritance. 
	// While it is not required to use this annotation when overriding a method,
	// it helps to prevent errors.
	// however, it provides a great deal of information about this method
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	@Override 
	// annotation informs the compiler that the element is meant to override
	// an element declared in a superclass. 
	//Overriding methods will be discussed in Interfaces and Inheritance. 
	// While it is not required to use this annotation when overriding a method,
	// it helps to prevent errors.
	// however, it provides a great deal of information about this method
	double getCharge(int daysInRent,boolean cash) {
		// TODO Auto-generated method stub
		double result =  daysInRent * 3;	
		if (cash) {
			return result -= result * 0.01;
		} else {
			return result; 
		}
	}
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		// TODO Auto-generated method stub
		 return daysRented > 1  ? 2 : 1; // in line IF statement
	}
}
