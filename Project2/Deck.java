
public class Deck extends GroupOfCards{
	
	public static int TOTAL_CARDS = 52;
	
	public Deck() {
		super(TOTAL_CARDS);
		for (int suit = 0; suit < 4; ++suit)
			for (int num = 2; num < 15; ++num) {
				Card tmpCard = new Card(num, suit);
				addCard(tmpCard);
			} 
	}
	
	public void shuffle() {
		int unshuffled = getCurrentSize();
		while (unshuffled-- > 0) {
			addCard(removeCard((int)(Math.random() * 52)));
		}
	}
	
	public Card dealCard() {
		return removeCard(0);
	}
}
