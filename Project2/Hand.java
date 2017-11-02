
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

        while (unsorted-- != 1) {
            int maxIndex = 0;
            for (int i = 0; i < unsorted; ++i) {
                Card tmpCard = getCard(i);
                Card maxCard = getCard(maxIndex);
                if (tmpCard.getSuit() * 13 + tmpCard.getNum() > maxCard.getSuit() * 13 + maxCard.getNum())
                    maxIndex = i;
            }
            addCard(removeCard(maxIndex));
        }
    }

    public void setShortest() {
        int numOfClubs = 0;
        int numOfDiamonds = 0;
        int numOfSpades = 0;

        for (int i = 0; i < getCurrentSize(); ++i) {
            Card tmpCard = getCard(i);
            if (tmpCard.getSuit() == 0) ++numOfClubs;
            if (tmpCard.getSuit() == 1) ++numOfDiamonds;
            if (tmpCard.getSuit() == 3) ++numOfSpades;
        }

        if (numOfDiamonds <= numOfClubs)
            shortest = 1;
        if (numOfSpades <= (numOfClubs < numOfDiamonds ? numOfClubs : numOfDiamonds) && find(12,3) == -1
            && find(13,3) == -1 && find(14,3) == -1)
            shortest = 3;
    }

    public int getShortest() {
        return shortest;
    }

    public Card playACard(Game game, Trick trick) {
        int index = 0;

        if (trick.getCurrentSize() == 0 && (index = findHighest(shortest)) > 0);
        else if (trick.getCurrentSize() == game.PLAYERS - 1 && !trick.getHearts() && !trick.getQueen()
                && (index = findLastHigh(trick.getWinningCard().getSuit())) >= 0);
        else if ((index = findHighestBelow(trick.getWinningCard())) >= 0);
        else if ((index = findMiddleHigh(game, trick.getWinningCard().getSuit())) >= 0);
        else if ((index = find(12, 3)) >= 0);
        else if ((index = find(14, 3)) >= 0);
        else if ((index = find(13, 3)) >= 0);
        else if ((index = findHighest(2)) >= 0);
        else
        {
            index = findHighest();
        }
        game.updateHeartsAndQueen(getCard(index));
        trick.update(NUM, getCard(index));
        setShortest();
        return removeCard(index);
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
        for (int i = 0; i < getCurrentSize(); ++i) {
            Card tmpCard = getCard(i);
            if (tmpCard.getNum() == num && tmpCard.getSuit() == suit)
                return i;
        }

        return -1;
    }

    private int findHighest(int suit) {
        for (int i = 0; i < getCurrentSize(); ++i)
            if (getCard(i).getSuit() == suit)
                return i;

        return -1;
    }

    private int findLowest(Game game) {
        if (game.getHearts() == false) {
            for (int i = 0; i < getCurrentSize(); ++i)
                if (getCard(i).getSuit() != 2)
                    return i;
            return -1;
        }
        return getCurrentSize() - 1;
    }

    private int findLastHigh(int suit) {
        int highIndex = findHighest(suit);

        if (suit == 3 && getCard(highIndex).getNum() == 12 && findCount(suit) > 1) {
            for (int i = 0; i < getCurrentSize(); ++i)
                if (getCard(i).getSuit() == 3 && getCard(i).getNum() < 13)
                    return i;
        }

        return highIndex;
    }

    private int findHighestBelow(Card winningCard) {
        for (int i = 0; i < getCurrentSize(); ++i) {
            Card tmpCard = getCard(i);
            if (tmpCard.getSuit() == winningCard.getSuit() && tmpCard.getNum() < winningCard.getNum()) {
                if (i != getCurrentSize() - 1 && getCard(i+1).getSuit() != tmpCard.getSuit())
                    break;
                return i;
            }
        }

        return -1;
    }

    private int findMiddleHigh(Game game, int suit) {
        if (suit == 3 && game.getQueenOfSpades() == false)
            for (int i = 0; i < getCurrentSize(); ++i) {
                Card tmpCard = getCard(i);
                if (tmpCard.getSuit() == 3 && tmpCard.getNum() < 13)
                    return i;
            }

        return findHighest(suit);
    }

    private int findHighest() {
        return 0;
    }
}
