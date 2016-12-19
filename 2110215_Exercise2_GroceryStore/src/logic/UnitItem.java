package logic;

public class UnitItem extends Item {
	
	private int amount;
	
	public UnitItem(String name, double unitPrice, int amount) {
		super.name = name;
		super.unitPrice = unitPrice;
		this.amount = amount;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return amount * super.unitPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String toString() {
		return String.format("UnitItem   : %-7s%-7d $%-7.2f $%-7.2f",super.name,this.amount,super.unitPrice,cost());
	}
}
