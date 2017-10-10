import java.util.ArrayList;

public class Checkout {
	private ArrayList<DessertItem> items = new ArrayList<DessertItem>();
	
	public Checkout() {}
	
	public int numberOfItems() {
		return items.size();
	}
	
	public void enterItem(DessertItem item) {
		items.add(item);
	}
	
	public void clear() {
		items.clear();
	}
	
	public int totalCost() {
		int cost = 0;
		for (DessertItem item : items)
			cost += item.getCost();
		return cost; 
	}
	
	public int totalTax() {
		return (int) Math.round(this.totalCost() * DessertShoppe.taxRate);
	}
	
	public String toString() {
		String recipt = "";
		
		// Head part
		int edge = (DessertShoppe.maxWidth - DessertShoppe.shopName.length()) / 2;
		for (int i = 0; i < edge; ++i)
			recipt += " ";
		recipt += DessertShoppe.shopName;
		recipt += '\n';
		
		for (int i = 0; i < edge; ++i)
			recipt += " ";
		for (int i = 0; i < DessertShoppe.shopName.length(); ++i)
			recipt += "-";
		recipt += "\n\n";
		
		// Item part
		for (DessertItem item : items)
			recipt += item.toString();
		
		// Summary part
		recipt += "\nTax";
		for (int i = 0; i < DessertShoppe.maxWidth - 2 - DessertShoppe.cents2dollarsAndCents(totalCost()).length(); ++i)
			recipt += " ";
		recipt += DessertShoppe.cents2dollarsAndCents(totalTax()) + "\n" + "Total Cost";
		for (int i = 0; i < DessertShoppe.maxWidth - 10 - DessertShoppe.cents2dollarsAndCents(totalCost()).length(); ++i)
			recipt += " ";
		recipt += DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()) + "\n";

		return recipt;
	}
}
