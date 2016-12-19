package logic;

import java.util.Random;

public class WeightItem extends Item {
	
	private double weight;
	public WeightItem(String name, double unitPrice) {
		super.name = name;
		super.unitPrice = unitPrice;
		this.weight = scale();
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return weight * super.unitPrice;
	}
	
	public double scale() {
		Random r = new Random();		
		return (r.nextInt(400) + 1) / 100.0;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return String.format("WeightItem : %-7s%-7.2f $%-7.2f $%-7.2f",super.name,this.weight,super.unitPrice,cost());
	}
}
