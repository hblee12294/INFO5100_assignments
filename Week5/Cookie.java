
public class Cookie extends DessertItem{
	int number;
	int price;
	int cost;
	
	public Cookie(String name, int number, int price) {
		super(name);
		this.number = number;
		this.price = price;
	} 
	
	public int getNumber() {
		return number;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getCost() {
		cost = (int) (Math.round(number * price / 12));
		return cost;
	}
	
	public String toString() {
		String output = "";
		
		output += Integer.toString(getNumber()) + " @ ";
		output += DessertShoppe.cents2dollarsAndCents(getPrice()) + " /dz.\n";
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
