package logic;

import java.util.ArrayList;
import java.util.Random;

public class ShoppingCart {
	private int requiredUnitItems;
	private int requiredWeightItems;
	private int discount; // in percentage 1 - 100;
	
	private ArrayList<Item> items;
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
		Random random = new Random();
		requiredUnitItems = 1 + random.nextInt(3);
		requiredWeightItems = 1 + random.nextInt(3);
		discount = 20;
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item)
	{
		//fill code
		if(item.getUnitPrice() <= 0) 
			System.out.println("Unable to add. Price should be more than $0");
		else if(item instanceof UnitItem && ((UnitItem)item).getAmount() < 1) 
			System.out.println("Unable to add. Amount should be more than 0");
		else 
			items.add(item);
		
	}
	
	public double checkOut(){
		//fill code
		double total = 0;
		for(int i = 0; i < items.size(); i++) {
			total += items.get(i).cost();
		}
		return total;
	}
	
	public boolean isDiscounted(){
		//fill code
		int ru = requiredUnitItems;
		int rw = requiredWeightItems;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i) instanceof UnitItem) ru--;
			if(items.get(i) instanceof WeightItem) rw--;
		}
		return (rw <= 0) && (ru <= 0);
	}

	public int getRequiredUnitItems() {
		return requiredUnitItems;
	}

	public void setRequiredUnitItems(int requiredUnitItems) {
		this.requiredUnitItems = requiredUnitItems;
	}

	public int getRequiredWeightItems() {
		return requiredWeightItems;
	}

	public void setRequiredWeightItems(int requiredWeightItems) {
		this.requiredWeightItems = requiredWeightItems;
	}

	//Create Getter&Setter method for all private fields
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
}
