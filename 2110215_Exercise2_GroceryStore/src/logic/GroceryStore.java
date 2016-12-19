package logic;

import java.util.Scanner;

public class GroceryStore {

	public static Scanner in;
	public static ShoppingCart cart;

	public static void main(String[] args) {
		String command;
		in = new Scanner(System.in);
		cart = new ShoppingCart();

		viewPromotion();
		
		while (true) {
			showMenu();
			command = in.nextLine();

			switch (command) {
			case "U":
				addUnitItemMenu();
				break;
			case "W":
				addWeightItemMenu();
				break;
			case "V":
				viewAllItemMenu();
				break;
			case "":
				checkOutMenu();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid command.");
				break;
			}
		}
	}

	public static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------");
		System.out.println("Grocery Store Menu");
		System.out.println("----------------------------------------");
		System.out.println("U)\tAdd Unit item to shopping cart");
		System.out.println("W)\tAdd Weight item to shopping cart");
		System.out.println("V)\tView all items in shopping cart");
		System.out.println("Enter)\tCheck out your shopping cart");
		System.out.println("----------------------------------------");
		System.out.print("Enter input command : ");
	}

	public static void addWeightItemMenu() {
		// TODO Auto-generated method stub
		String name;
		double unitPrice;

		System.out.println("----------------------------------------");
		System.out.println("Add Weight item to shopping cart");
		System.out.println("----------------------------------------");

		//fill code
		System.out.print("Enter name : ");
		name = in.nextLine();
		
		int size = cart.getItems().size();
		for(int i = 0; i < size; i++) {
			
			Item itemA = cart.getItems().get(i);
			
			if(itemA instanceof WeightItem && itemA.name.equals(name)) {
				
				WeightItem wItemA = (WeightItem) itemA;
				double preWeight = wItemA.getWeight();
				double scale = wItemA.scale();
				
				wItemA.setWeight(preWeight + scale);
				System.out.printf("Weight is %.2f\n",scale);
				System.out.printf("Total weight of %s is %.2f (Previous is %.2f)\n",name,wItemA.getWeight(),preWeight);
				System.out.printf("Cost is $%.2f (Price per kilogram is $%.2f)\n",wItemA.cost(),wItemA.getUnitPrice());
				
				return;
			}
		}
		
		System.out.print("Enter price per kilogram : ");
		unitPrice = in.nextDouble();
		Item itemA = new WeightItem(name, unitPrice);
		cart.addItem(itemA);
		if(size < cart.getItems().size()) {
			System.out.printf("Weight is %.2f\n",((WeightItem)itemA).getWeight());
			System.out.printf("Cost is $%.2f\n",itemA.cost());
		}
		
		in.nextLine();
	}

	public static void addUnitItemMenu() {
		// TODO Auto-generated method stub
		String name;
		int amount;
		double unitPrice;

		System.out.println("----------------------------------------");
		System.out.println("Add Unit item to shopping cart");
		System.out.println("----------------------------------------");

		//fill code
		System.out.print("Enter name : ");
		name = in.nextLine();
		System.out.print("Number of Units : ");
		amount = in.nextInt();
		
		int size = cart.getItems().size();
		for(int i = 0; i < size; i++) {
			
			Item itemA = cart.getItems().get(i);
			
			if(itemA instanceof UnitItem && itemA.name.equals(name)) {
				
				UnitItem uItemA = (UnitItem) itemA;
				int preAmount = uItemA.getAmount();
				
				uItemA.setAmount(preAmount + amount);
				System.out.printf("Total number of %s is %d (Previous is %d)\n",name,uItemA.getAmount(),preAmount);
				System.out.printf("Cost is $%.2f (Price per unit is $%.2f)\n",uItemA.cost(),uItemA.getUnitPrice());
				
				in.nextLine();
				return;
			}
		}
		
		System.out.print("Enter price per unit : ");
		unitPrice = in.nextDouble();
		Item itemA = new UnitItem(name, unitPrice, amount);
		cart.addItem(itemA);
		if(size < cart.getItems().size()) {
			System.out.printf("Cost is $%.2f\n",itemA.cost());
		}
		
		in.nextLine();
	}

	public static void viewAllItemMenu() {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------");
		System.out.println("View all items in shopping cart");
		System.out.println("----------------------------------------");

		//fill code
		if(cart.getItems().size() == 0) {
			System.out.println("There isn't any item in shopping cart!!!");
			return;
		}
		for(int i = 0; i < cart.getItems().size(); i++) {
			
			Item itemA = cart.getItems().get(i);
			System.out.printf("#%-5d ",i+1);
			if(itemA instanceof UnitItem) {
				System.out.println(itemA.toString());
			}
			else if(itemA instanceof WeightItem){
				System.out.println(itemA.toString());
			}
		}
	}
	
	public static void checkOutMenu(){
		System.out.println("----------------------------------------");
		System.out.println("Check out your shopping cart");
		System.out.println("----------------------------------------");
		
		//fill code
		boolean isDiscounted = cart.isDiscounted();
		double cost = cart.checkOut();
		double save = (cost*cart.getDiscount())/100.0;
		if(isDiscounted) {
			System.out.printf("Congratulation! You got a %d%% discount\n",cart.getDiscount());
			System.out.printf("Grand total cost : $%.2f (Save $%.2f)\n",cost-save,save);
		}		
		else System.out.printf("Grand total cost : $%.2f\n",cost);
			
	}
	
	public static void viewPromotion(){
		System.out.println("**************************************************");
		System.out.println("Today Promotion");
		System.out.println("Buy at least " + cart.getRequiredUnitItems() +  " UnitItem(s) & " + cart.getRequiredWeightItems() + " WeightItem(s),Get " + cart.getDiscount() + "% off");
		System.out.println("**************************************************");
	}
	
}
