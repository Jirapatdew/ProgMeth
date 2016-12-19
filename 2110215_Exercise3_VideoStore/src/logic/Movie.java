package logic;

public class Movie extends Item implements Rentable, Comparable<Movie> {

	public static int idCount = 0;;
	
	private String renterName;
	private Boolean isRented;
	private int rentDate;
	
	public Movie(String name, double rating, double price) {
		super(name, rating, price);
		this.id = ++idCount;
		
		// TODO Fill Code Initialize fields
		this.renterName = "";
		this.isRented = false;
		this.rentDate = 0;
	}

	@Override
	public String toString() {
		String statusString = "";
		if (isRented)
		{
			String dayString = (Store.day - this.rentDate < 2) ? "day" : "days" ;
			statusString = "rented by \"" + this.renterName + "\"";
			statusString += String.format("\t$%.2f/day\tRented %d %s",this.price * 0.1,Store.day - this.rentDate,dayString);
		}
		
		if (this.name.length() < 8)
			return String.format("#%d\t%s\t\t%.1f\t$%.2f\t%s",this.id,this.name,this.rating,this.price,statusString);
		else
			return String.format("#%d\t%s\t%.1f\t$%.2f\t%s",this.id,this.name,this.rating,this.price,statusString);
	}
	
	public void rent(String renterName, int rentOption) {
		this.renterName = renterName;
		isInStock = false;
		isRented = true;
		rentDate = Store.day;
	}
	
	public double giveBack() {
		double total = (Store.day-rentDate)*(price*0.1);
		if(Store.day==rentDate) total=price*0.1;
		renterName = "";
		isInStock = true;
		isRented = false;
		rentDate = 0;
		return total;
	}
	
	public int compareTo(Movie movie) {
		 if(this.getRating() != movie.getRating()) 
	        	return Double.compare(this.getRating(), movie.getRating());
		 return movie.getName().compareTo(this.getName());

	}
	
	// TODO Implement Getter&Setter
	
	public String getRenterName() {
		return renterName;
	}

	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}

	public Boolean getIsRented() {
		return isRented;
	}

	public void setIsRented(Boolean isRented) {
		this.isRented = isRented;
	}

	public int getRentDate() {
		return rentDate;
	}

	public void setRentDate(int rentDate) {
		this.rentDate = rentDate;
	}
	
}
