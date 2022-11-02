package master;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}
	public Rental(Movie movie) {
		super();
		this.movie = movie;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getDaysRented() {
		return this.daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
}
