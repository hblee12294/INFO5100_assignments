
public class IceCream extends DessertItem{
	private int cost;
	
	public IceCream(String name, int cost) {
		super(name);
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String toString() {
		String output = "";
		
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
