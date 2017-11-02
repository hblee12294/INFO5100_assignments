
public class Card {

    private int num;
    private int suit;

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }

    public void display() {
        String rep = "";

        switch(num) {
            default:
                System.out.println("Undefined num!");
                break;
            case 2:
                rep += 2 + " ";
                break;
            case 3:
                rep += 3 + " ";
                break;
            case 4:
                rep += 4 + " ";
                break;
            case 5:
                rep += 5 + " ";
                break;
            case 6:
                rep += 6 + " ";
                break;
            case 7:
                rep += 7 + " ";
                break;
            case 8:
                rep += 8 + " ";
                break;
            case 9:
                rep += 9 + " ";
                break;
            case 10:
                rep += 10 + " ";
                break;
            case 11:
                rep += "Jack ";
                break;
            case 12:
                rep += "Queen ";
                break;
            case 13:
                rep += "King ";
                break;
            case 14:
                rep += "Ace ";
                break;
        }

        switch(suit) {
            default:
                System.out.println("Undefined suit!");
                break;
            case 0:
                rep += "of clubs";
                break;
            case 1:
                rep += "of diamonds";
                break;
            case 2:
                rep += "of hearts";
                break;
            case 3:
                rep += "of spades";
                break;
        }

        System.out.println(rep);
    }
}
