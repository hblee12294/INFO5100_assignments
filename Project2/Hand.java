
public class Hand extends GroupOfCards{

	public final int NUM;
	private int shortest;
	
	public Hand(int playerNum, int numberOfCards) {
		super(numberOfCards);
		NUM = playerNum;
		shortest = 0;
	}
	
	public void sort() {
		int unsorted = getCurrentSize();
		int maxIndex = 0;
		Card maxCard = new Card(0, 2);
		
		while (unsorted-- != 1) {
			for (int n = 0; n < unsorted; ++n) {
				Card tmpCard = getCard(n);
				if (tmpCard.getSuit() * 13 + tmpCard.getNum() > maxCard.getSuit() * 13 + maxCard.getNum())
					maxIndex = n;
			}
			addCard(removeCard(maxIndex));
		}
	}
	
	public void setShortest() {

	}
	
	public int getShortest() {
		return shortest;
	}
	
	public Card playACard(Game game, Trick trick) {
		
	}
	
	public int findLowest(int suit) {
		for (int i = 0; i < getCurrentSize(); ++i)
			if (getCard(i).getSuit() == suit) return i;
		
		return -1;
	}
	
	private int findCount(int suit) {
		int count = 0;
		for (int i = 0; i < getCurrentSize(); ++i)
			if (getCard(i).getSuit() == suit)
				++count;
		
		return count;
	}
	
	private int find(int num, int suit) {
		for (int i = 0; i < getCurrentSize(); ++i)
			if (getCard(i).getNum() == num && getCard(i).getSuit() == suit)
				return i;
		
		return -1;
	}
	
	private int findHighest(int suit) {
		for (int i = getCurrentSize() - 1; i >= 0; ++i)
			if (getCard(i).getSuit() == suit)
				return i;
		
		return -1;
	}
	
	private int findLowest(Game game) {
		
	}
	
	private int findLastHigh(int suit) {
		
	}
	
	private int findHighestBelow(Card winningCard) {
		
	}
	
	private int findMiddleHigh(Game game, int suit) {
		
	}
	
	private int findHighest() {
		
	}
}
