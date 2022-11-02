package master;


public class RegularPrice extends Price{

	@Override 
	// annotation informs the compiler that the element is meant to override
	// an element declared in a superclass. 
	//Overriding methods will be discussed in Interfaces and Inheritance. 
	// While it is not required to use this annotation when overriding a method,
	// it helps to prevent errors.
	// however, it provides a great deal of information about this method
	public int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override 
	// annotation informs the compiler that the element is meant to override
	// an element declared in a superclass. 
	//Overriding methods will be discussed in Interfaces and Inheritance. 
	// While it is not required to use this annotation when overriding a method,
	// it helps to prevent errors.
	// however, it provides a great deal of information about this method
	double getCharge(int daysInRent, boolean cash) {
		// TODO Auto-generated method stub
		double result = 2;
		if(daysInRent > 2){
			result += (daysInRent -2) * 1.5;
		}
		if (cash) {
			return result -= result * 0.05;
		} else {
			return result; 
		}
	}
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		// TODO Auto-generated method stub
		 return 1; // in line IF statement
	}
}
