
public class Trick extends GroupOfCards{

    private int winner;
    private Card winningCard;
    private boolean hearts;
    private boolean queen;

    public Trick(int players) {
        super(players * 2 - 1);
        winner = 0;
        hearts = false;
        queen = false;
    }

    public int getWinner( ) {
        return winner;
    }

    public Card getWinningCard() {
        return winningCard;
    }

    public boolean getHearts() {
        return hearts;
    }

    public boolean getQueen() {
        return queen;
    }

    public void update(int playerNum, Card card) {
        if (isWinner(card)) {
            winner = playerNum;
            winningCard = card;
        }
        if (card.getSuit() == 2)
            hearts = true;
        if (card.getNum() == 12 && card.getSuit() == 3)
            queen = true;
    }

    private boolean isWinner(Card card) {
        if (winningCard != null && card.getSuit() !=  winningCard.getSuit() && card.getNum() < winningCard.getNum())
            return false;

        return true;
    }
}