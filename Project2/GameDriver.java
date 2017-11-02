import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        Game game = new Game(4);
        game.playAGame();
        Scanner sc = new Scanner(System.in);

        String anwser = "";
        while (sc.hasNext()) {
            anwser = sc.next();
            if (anwser  == "y")
                game.playAGame();
            else if (anwser == "n")
                break;
            else
                System.out.println("Please enter 'y' or 'n' !");
        }

        System.out.println("Thanks, bye~");
    }
}
