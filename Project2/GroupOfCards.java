
public class GroupOfCards {

    private Card[] cards;
    private int currentSize;

    public GroupOfCards(int num) {
        cards = new Card[num];
        currentSize = 0;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Card getCard(int i) {
        return cards[i];
    }

    public void addCard(Card card) {
        cards[currentSize++] = card;
    }

    public Card removeCard(int index) {
        Card tmpCard = cards[index];

        for (int i = index; i < currentSize - 1; ++i) {
            cards[i] = cards[i+1];
        }
        --currentSize;

        return tmpCard;
    }

    public void display() {
        for (int i = 0; i < currentSize; ++i)
            cards[i].display();
    }
}

