
public class Candy extends DessertItem{
	private double weight;
	private int price;
	private int cost;
	
	public Candy(String name, double weight, int price) {
		super(name);
		this.weight = weight;
		this.price = price;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getCost() {
		cost = (int) Math.round(weight * price);
		return cost;
	}
	
	public String toString() {
		String output = "";
		
		output += getWeight() + " lbs. @ ";
		output += DessertShoppe.cents2dollarsAndCents(getPrice()) + " /lb.\n";
		if (getName().length() <= DessertShoppe.maxSize) {
			output += getName();
			for (int i = 0; i < DessertShoppe.maxWidth - getName().length() - DessertShoppe.cents2dollarsAndCents(getCost()).length(); ++i)
				output += " ";
		}
		else {
			output += getName().substring(0, DessertShoppe.maxSize-1) + "\n" + getName().substring(DessertShoppe.maxSize);
			for (int i = 0; i < DessertShoppe.maxWidth - getName().length() - DessertShoppe.cents2dollarsAndCents(getCost()).length(); ++i)
				output += " ";
		}
		output += DessertShoppe.cents2dollarsAndCents(getCost()) + "\n";
		
		return output;
	}
}
