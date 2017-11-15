package Q1;

import java.util.Scanner;
import java.io.IOException;

public class FileCounter {

    private int characterCount, wordCount, lineCount;

    public FileCounter() {
        characterCount = 0;
        wordCount = 0;
        lineCount = 0;
    }

    public void read(Scanner in) throws IOException {
        String line;
        String[] words;
        while (in.hasNextLine()) {
            line = in.nextLine();
            words = line.split(" ");

            // count characters and words
            for (String word : words) {
                characterCount += word.length();
                ++wordCount;
            }

            // count lines
            ++lineCount;
        }
    }

    public int getCharacterCount() { return characterCount; }
    public int getWordCount() { return wordCount; }
    public int getLineCount() { return lineCount; }
}
