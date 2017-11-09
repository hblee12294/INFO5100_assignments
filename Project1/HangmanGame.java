import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {
	private String word;          // secret word
	private String tmpWord;       // current word
	private String misses;        // missed letters
	private String hits;          // hit letters
	private int missNumber;       // number of missed
	private ArrayList<String> img = new ArrayList<String>();           // whole image
	private ArrayList<String> man = new ArrayList<String>();           // man image
	private ArrayList<String> wordDict = new ArrayList<String>();      // dictionary of candidate words
	

	public HangmanGame() {
		init();
	}
	

	public void reset() {
		init();
	}
	

	public void init(){

		// Initiate word dictionary
		wordDict.add("doughnut"); 
		wordDict.add("waffle"); 
		wordDict.add("cookie"); 
		wordDict.add("macaroon");
		wordDict.add("opera");
		wordDict.add("baguette"); 
		wordDict.add("bronie"); 
		wordDict.add("toast"); 
		wordDict.add("mousse");
		wordDict.add("tiramisu");
		
		// Choose a random word from dictionary
		word = wordDict.get((int)(Math.random() * 10));
		
		// Initiate other fields
		tmpWord = "";
		misses = "";
		hits = "";
		missNumber = 0;
		for (int i = 0; i < word.length(); ++i) {
			tmpWord += "-";
		}
		
		// Initiate scaffold
		img.add(" ------------");
		img.add("|           |");
		img.add("|           ");
		img.add("|           ");
		img.add("|        ");
		img.add("|          ");
		img.add("|         ");
		img.add("|       ");
		img.add("|           ");
		img.add(" -----------------");
		
		// Initiate man
		man.add("O");
		man.add("|");
		man.add("---");
		man.add(" ---");
		man.add("/");
		man.add("/");
		man.add(" \\");
		man.add("   \\");
		man.add("--");
		man.add("     --");
	}
	

	public void printImg() {
		for (String row : img)
			System.out.println(row);
	}
	

	public char guess() {
		char letter = ' ';
		
		while (true) {
			System.out.println("Please enter a letter:");
			
			// Input a char
			Scanner input = new Scanner(System.in);
			letter = input.next().charAt(0);
			
			// Check if it's a legal letter
			if (letter >= 'A' && letter <= 'Z') {
				letter += 32;
			}
			if (letter < 'a' || letter > 'z') {
				System.out.println("Input must be a letter! Try again.");
				continue;
			}
			
			// Check if it's been entered
			if (hits.indexOf(letter) != -1 || misses.indexOf(letter) != -1) {
				System.out.println("You have enter this letter before. Try again.");
				continue;
			}
			else {
				break;
			}
		}
		
		return letter;
	}
 

	public void hit(char letter) {
		hits += letter;
		
		// Replace '-' with letter
		for (int i = 0; i < word.length(); ++i) {
			if (word.charAt(i) == letter)
				tmpWord = tmpWord.substring(0, i) + letter + tmpWord.substring(i+1);
		}
	}
	

	public void miss(char letter) {
		misses += letter;
		
		// Draw man step by step
		switch(missNumber) {
			default:
				System.out.println("Undefined action ...");
				break;
			case 0:
				img.set(2, img.get(2) + man.get(missNumber));    // add head
				break;
			case 1:
				img.set(3, img.get(3) + man.get(missNumber));    // add body
				break;
			case 2:
				img.set(4, img.get(4) + man.get(missNumber));    // add left arm
				break;
			case 3:
				img.set(4, img.get(4) + man.get(missNumber));    // add right arm
				break;
			case 4:
				img.set(5, img.get(5) + man.get(missNumber));    // add left leg
				img.set(6, img.get(6) + man.get(missNumber+1));
				break;
			case 5:
				img.set(5, img.get(5) + man.get(missNumber+1));  // add right leg
				img.set(6, img.get(6) + man.get(missNumber+2));
				break;
			case 6:
				img.set(7, img.get(7) + man.get(missNumber+2));  // add left foot
				break;
			case 7:
				img.set(7, img.get(7) + man.get(missNumber+2));  // add right foot
				break;
		}
		
		++missNumber;
	}
	

	public void printWordAndMisses() {
		System.out.println("Word: " + tmpWord);
		System.out.println("Misses: " + misses);
	}
	

	public boolean judge(char letter) {
		boolean result = true;
		
		if (word.indexOf(letter) == -1) {
			result = false;
		}
		
		return result;
	}
	
	
	public void start() {
		char guessLetter = ' ';
		
		while (true) {
			guessLetter = guess();
			
			if (judge(guessLetter)) {
				hit(guessLetter);
				printWordAndMisses();
				printImg();
			}
			else {
				miss(guessLetter);
				printWordAndMisses();
				printImg();
			}
			
			if (tmpWord.equals(word)) {
				System.out.println("Congratulations! You win the game.");
				break;
			}
			if (missNumber == 8) {
				// Typo out
				System.out.println("Oops, you are running our of chances. ---- Game over.");
				break;
			}
		}
	}
	
}
