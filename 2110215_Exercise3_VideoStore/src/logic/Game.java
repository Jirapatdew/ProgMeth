package logic;

public class Game extends Item implements Rentable, Saleable, Comparable<Game> {

	public static int idCount = 0;
	
	public static final double[] RENTAL_RATES = {0.10,0.18,0.25,0.30};  
	
	private Boolean isRented;
	private String renterName;
	private int chosenRentOption;
	private int giveBackDate;
	private double lateFeePerDay;
	
	private String buyerName;
	private Boolean isBought;
	private Boolean isBuyable;
	
	public Game(String name, double rating, double price) {
		super(name,rating,price);
		this.id = ++idCount;
		
		// TODO Fill Code Initialize fields
		this.isRented = false;
		this.renterName = "";
		this.chosenRentOption = 0;
		this.giveBackDate = 0;
		this.lateFeePerDay = price*0.10;
		this.buyerName = "";
		this.isBought = false;
		this.isBuyable = true;
	}

	@Override
	public String toString() {
		String statusString = "";
		String buyableString = (isBuyable) ? "Buyable\t" : "NOT Buyable";
		
		if (isRented)
		{
			statusString = "rented by \"" + this.renterName +"\"";
			statusString += String.format("\t$%.2f (Option %d)\t(MUST BE RETURNED within Day %d)", RENTAL_RATES[this.chosenRentOption - 1] * this.price,this.chosenRentOption,this.giveBackDate);
		}
		else if (isBought)
		{
			statusString = "bought by \"" + this.buyerName + "\"";
		}
		
		if (this.name.length() < 8)
			return String.format("#%d\t%s\t\t%.1f\t$%.2f\t%s\t%s",this.id,this.name,this.rating,this.price,buyableString,statusString);
		else
			return String.format("#%d\t%s\t%.1f\t$%.2f\t%s\t%s",this.id,this.name,this.rating,this.price,buyableString,statusString);
	}
	
	public void rent(String renterName, int rentOption) {
		this.renterName = renterName;
		this.chosenRentOption = rentOption;
		isInStock = false;
		isRented = true;
		giveBackDate = Store.day + (rentOption*7);
		isBuyable = false;
	}
	public double giveBack() {
		double total = RENTAL_RATES[chosenRentOption-1]*price;
		if(Store.day - giveBackDate > 0) total+= (Store.day - giveBackDate)*lateFeePerDay;
		renterName = "";
		chosenRentOption = 0;
		isInStock = true;
		isRented = false;
		giveBackDate = 0;
		return total;
	}
	public double buy(String buyerName) {
		this.buyerName = buyerName;
		isInStock = false;
		isBought = true;
		isBuyable = false;
		return price;
	}
	public int compareTo(Game game) {
		 if(this.getRating() != game.getRating()) 
	        	return Double.compare(this.getRating(),game.getRating());
		 return game.getName().compareTo(this.getName());

	}
	
	// TODO Implement Getter&Setter
	public Boolean getIsRented() {
		return isRented;
	}

	public void setIsRented(Boolean isRented) {
		this.isRented = isRented;
	}

	public String getRenterName() {
		return renterName;
	}

	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}

	public int getChosenRentOption() {
		return chosenRentOption;
	}

	public void setChosenRentOption(int chosenRentOption) {
		this.chosenRentOption = chosenRentOption;
	}

	public int getGiveBackDate() {
		return giveBackDate;
	}

	public void setGiveBackDate(int giveBackDate) {
		this.giveBackDate = giveBackDate;
	}

	public double getLateFeePerDay() {
		return lateFeePerDay;
	}

	public void setLateFeePerDay(double lateFeePerDay) {
		this.lateFeePerDay = lateFeePerDay;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Boolean getIsBought() {
		return isBought;
	}

	public void setIsBought(Boolean isBought) {
		this.isBought = isBought;
	}

	public Boolean getIsBuyable() {
		return isBuyable;
	}

	public void setIsBuyable(Boolean isBuyable) {
		this.isBuyable = isBuyable;
	}
	

}
