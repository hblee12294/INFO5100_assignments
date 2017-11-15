package Q2;

import java.io.*;
import java.util.*;

public class LyricAnalyzer {

    private HashMap<String, ArrayList<Integer>> map;
    private int wordNum;

    public void read(File file) throws IOException {
        // re-initialize map and wordNum
        init();

        System.out.println("\n*** Reading " + file.getName() + " ***");
        FileReader reader = new FileReader(file);
        Scanner sc = new Scanner(reader);
        String[] words;
        int wordCount = 0;
        while (sc.hasNextLine()) {
            words = sc.nextLine().split(" ");
            for (int i = 0; i < words.length; ++i) {
                ++wordCount;
                if (i == words.length - 1)
                    add(words[i], -wordCount);
                else
                    add(words[i], wordCount);
            }
        }
        wordNum = wordCount;        // words accumulation
        reader.close();
        System.out.println("*** Read ends ***");
    }

    // clean map
    private void init() {
        map = new HashMap<>();
        wordNum = 0;
    }

    private void add(String lyricWord, int wordPosition) {
        if (map.containsKey(lyricWord)) {
            map.get(lyricWord).add(wordPosition);
        }
        else {
            ArrayList<Integer> positions = new ArrayList<>();
            positions.add(wordPosition);
            map.put(lyricWord, positions);
        }
    }

    public void displayWords() {
        System.out.println("Word\t\tWord Position(s)");
        System.out.println("===========================");

        Set lyricSet = map.keySet();
        List<String> lyricList = new ArrayList<String>(lyricSet);
        Collections.sort(lyricList);

        for (String word : lyricList) {
            System.out.printf("%-12s", word.toUpperCase());
            for (int i = 0; i < map.get(word).size(); ++i) {
                System.out.print(map.get(word).get(i));
                if (i != map.get(word).size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    public void writeLyrics(File file) throws IOException {
        String[] lyrics = new String[wordNum+1];

        // more effective way to iterate HashMap
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            for (int i : entry.getValue()) {
                if (i > 0)
                    lyrics[i] = entry.getKey() + " ";
                else
                    lyrics[-i] = entry.getKey() + "\n";
            }
        }

        System.out.println("*** Writing " + file.getName() + " ***");
        FileWriter writer = new FileWriter(file);
        for (int i = 1; i < lyrics.length; ++i)
            writer.write(lyrics[i]);
        writer.close();
        System.out.println("*** Write ends ***");
    }

    public int count() {
        int uniqueWordCount = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet())
            if (entry.getValue().size() == 1)
                ++uniqueWordCount;

        return uniqueWordCount;
    }

    public String mostFrequentWord() {
        String frequentWord = "";
        int frequency = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > frequency) {      // update if get larger frequency
                frequentWord = entry.getKey();
                frequency = entry.getValue().size();
            }
            // come first alphabetically
            else if (entry.getValue().size() == frequency && entry.getKey().compareTo(frequentWord) < 0)
                frequentWord = entry.getKey();
        }
        return frequentWord;
    }

    public static void main(String[] args) throws IOException{
        LyricAnalyzer la = new LyricAnalyzer();

        // test1
        File lyric = new File("test1.txt");
        la.read(lyric);
        la.displayWords();
        System.out.println("\nNumber of unique word = " + la.count());
        System.out.println("Most frequent word = \'" + la.mostFrequentWord() + "\'");
        File outputFile = new File("test1_output.txt");
        la.writeLyrics(outputFile);

        // test2
        lyric = new File("test2.txt");
        la.read(lyric);
        la.displayWords();
        System.out.println("\nNumber of unique word = " + la.count());
        System.out.println("Most frequent word = \'" + la.mostFrequentWord() + "\'");
        outputFile = new File("test2_output.txt");
        la.writeLyrics(outputFile);

        // test3
        lyric = new File("test3.txt");
        la.read(lyric);
        la.displayWords();
        System.out.println("\nNumber of unique word = " + la.count());
        System.out.println("Most frequent word = \'" + la.mostFrequentWord() + "\'");
        outputFile = new File("test3_output.txt");
        la.writeLyrics(outputFile);

        // test4
        lyric = new File("test4.txt");
        la.read(lyric);
        la.displayWords();
        System.out.println("\nNumber of unique word = " + la.count());
        System.out.println("Most frequent word = \'" + la.mostFrequentWord() + "\'");
        outputFile = new File("test4_output.txt");
        la.writeLyrics(outputFile);
    }
}
