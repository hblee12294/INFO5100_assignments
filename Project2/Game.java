
public class Game {

    public int PLAYERS;
    private Deck deck;
    private Hand[] players;
    private Trick[] tricks;
    private int numberOfTricks;
    private boolean hearts;
    private boolean queenOfSpades;

    public Game(int numberOfPlayers) {
        PLAYERS = numberOfPlayers;
        deck = new Deck();
        players = new Hand[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; ++i)
            players[i] = new Hand(i, Deck.TOTAL_CARDS / numberOfPlayers);
        tricks = new Trick[Deck.TOTAL_CARDS/PLAYERS];
        numberOfTricks = 0;
        hearts = false;
        queenOfSpades = false;
    }

    public int getNumberOfTricks() {
        return numberOfTricks;
    }

    public boolean getHearts() {
        return hearts;
    }

    public boolean getQueenOfSpades() {
        return queenOfSpades;
    }

    public void playAGame() {
        deck.shuffle();
        deck.shuffle();

        int cardsLeft = Deck.TOTAL_CARDS % PLAYERS;
        while (deck.getCurrentSize() >= PLAYERS) {
            for (Hand player: players)
                player.addCard(deck.dealCard());
        }
        if (deck.getCurrentSize() != cardsLeft)
            System.out.println("Cards deal fails.");

        System.out.println("Output – first part:\n");
        int playerNum = 0;
        Card minCard = new Card(14, 0);
        int minIndexOfClub = 0;
        for (Hand player: players) {
            player.sort();
            player.setShortest();
            System.out.println("\t\tplayer " + player.NUM + " shortest = " + player.getShortest());
            player.display();
            if ((minIndexOfClub = player.findLowest(0)) != -1 && player.getCard(minIndexOfClub).getNum() < minCard.getNum()) {
                minCard = player.getCard(minIndexOfClub);
                playerNum = player.NUM;
            }
        }

        System.out.println("\nOutput – second part:\n");
        int index = 0;
        Card card = new Card(2,0);
        for (int i = 0; i < tricks.length; ++i) {
            Trick tmpTrick = new Trick(PLAYERS);
            tricks[i] = tmpTrick;
            ++numberOfTricks;
            if (i == 0) {
                card = players[playerNum].getCard(players[playerNum].getCurrentSize() - 1);
                playerNum++;
            }
            else {
                card = players[playerNum].playACard(this, tricks[i]);
                System.out.print("player " + playerNum + "\t\t\t");
                card.display();
            }
            tricks[i].addCard(card);
            tricks[i].update(playerNum, card);
            ++playerNum;

            while (playerNum % PLAYERS != 0) {
                card = players[playerNum].playACard(this, tricks[i]);
                System.out.print("player\t" + playerNum);
                card.display();
                tricks[i].addCard(card);
                tricks[i].update(playerNum, card);
                playerNum++;
            }

            if (i== 0) {
                for (int j = 0 ; j < deck.getCurrentSize(); ++j) {
                    Card tmpCard = deck.dealCard();
                    System.out.print("undealt card\t");
                    tmpCard.display();
                    tricks[i].addCard(tmpCard);
                }
            }
        }

        for (int i = 0; i < PLAYERS; ++i) {
            System.out.println("Player " + i + " score= " + computePoints(i));
        }
        System.out.println("Play another game (y/n)? ");
    }

    public void updateHeartsAndQueen(Card card) {
        if (card.getSuit() == 2 && getHearts() == false) {
            System.out.println("Hearts is now broken");
            hearts = true;
        }

        if (card.getSuit() == 3 && card.getNum() == 12)
            queenOfSpades = true;
    }

    private int computePoints(int playerNum) {
        int points = 0;

        for (Trick trick : tricks) {
            if (trick.getWinner() == playerNum) {
                for (int i = 0; i < trick.getCurrentSize(); ++i) {
                    Card tmpCard = trick.getCard(i);
                    if (tmpCard.getSuit() == 2) ++points;
                    if (tmpCard.getNum() == 12 && tmpCard.getSuit() == 3) points += 13;
                }
            }
        }
        return points;
    }
}
