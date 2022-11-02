package master;

public class Movie {
	public static final int CHILDREN =2;
	public static final int REGULAR =0;
	public static final int NEW_RELEASE =1;
	
	private String title;
	private Price price;
	
	public Movie(String title, int args) {
		this.title = title;
		switch(args) {
			case Movie.REGULAR:
				price = new RegularPrice();
				break;
			case Movie.NEW_RELEASE:
				price = new NewReleasePrice();
				break;
			case Movie.CHILDREN:
				price = new ChildrensPrice();
				break;
			default:
				break;
		}
	}
	
	public Price getPrice() {
		return price;
	}
	
	public String getTitle() {
		return title;
	}
	public double getCharge(int daysInRental, boolean cash) {
		return price.getCharge(daysInRental, cash);
	}
}
