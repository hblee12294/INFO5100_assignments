
public class DessertShoppe {
	public final static String shopName = "M & M Dessert Shoppe";
	public final static int maxSize = 25;
	public final static int maxWidth = 30;
	public final static double taxRate = 0.065; 
	
	public static String cents2dollarsAndCents(int cents) {
		String dollar = Double.toString(((double)cents)/100);
		if (dollar.charAt(0) == '0')
			dollar = " " + dollar.substring(1);
		return dollar;
	}
}
