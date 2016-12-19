package logic;

public abstract class Item{

	protected int id;
	protected String name;
	protected Boolean isInStock;
	protected double rating;
	protected double price;
	
	public Item(String name, double rating, double price) {
		super();
		this.name = name;
		this.isInStock = true;
		this.rating = rating;
		this.price = price;
	}
	
	public abstract String toString();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsInStock() {
		return isInStock;
	}

	public void setIsInStock(Boolean isInStock) {
		this.isInStock = isInStock;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
