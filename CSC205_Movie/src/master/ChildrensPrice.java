package master;

public class ChildrensPrice extends Price {

	@Override 
	// annotation informs the compiler that the element is meant to override
	// an element declared in a superclass. 
	//Overriding methods will be discussed in Interfaces and Inheritance. 
	// While it is not required to use this annotation when overriding a method,
	// it helps to prevent errors.
	// however, it provides a great deal of information about this method
	public int getPriceCode() {
		return Movie.CHILDREN;
	}

	@Override 
	// annotation informs the compiler that the element is meant to override
	// an element declared in a superclass. 
	//Overriding methods will be discussed in Interfaces and Inheritance. 
	// While it is not required to use this annotation when overriding a method,
	// it helps to prevent errors.
	// however, it provides a great deal of information about this method
	double getCharge(int daysInRent, boolean cash) {
		double result =  1.5;
		if(daysInRent >3){
			result += (daysInRent -3) * 1.5;
		}
		if (cash) {
		return result -= result * 0.02;
		} else {
			return result; 
		}
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		// TODO Auto-generated method stub
		return 1;
	}
}
