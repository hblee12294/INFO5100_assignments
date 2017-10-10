
public class Sundae extends IceCream{
	private String toppingName;
	private int toppingCost;
	private int cost;

	public Sundae(String name, int iceCost, String toppingName, int toppingCost) {
		super(name, iceCost);
		this.toppingName = toppingName;
		this.toppingCost = toppingCost;
	}
	
	public String getToppingName() {
		return toppingName;
	}
	
	public int toppingCost() {
		return toppingCost;
	}
	
	public int getCost() {
		cost = (int) (toppingCost + super.getCost());
		return cost;
	}
	
	public String toString() {
		String output = "";
		
		output += getToppingName() + " with\n";
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
