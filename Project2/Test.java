
public class Test {

	public static void main(String[] args) {
		GroupOfCards gc= new GroupOfCards(3); 
		Card c1 = new Card(2, 2);
		c1.display();
		Card c2 = new Card(11, 3);
		c2.display();
		Card c3 = new Card(14, 0);
		c3.display();
		
		System.out.println("******");
		
		gc.addCard(c1);
		gc.addCard(c2);
		gc.addCard(c3);
		gc.display();
		
		System.out.println("******");
		
		gc.removeCard(1);
		gc.removeCard(1);
		gc.display();
		
		System.out.println("******");
/*		
		Deck dk = new Deck();
		dk.shuffle();
		dk.display();
		
		System.out.println("******");
		dk.dealCard();
		dk.dealCard();
		dk.display();
*/		
		System.out.println("******");
		
		Trick tk = new Trick(4);
		tk.update(2, new Card(3, 0));
		tk.update(3, new Card(10, 0));
		tk.getWinningCard().display();
		System.out.println(tk.getWinner());
		
		System.out.println("******");
	}

}
