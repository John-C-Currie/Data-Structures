package Nov01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TestSet {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("mobydick.txt"));

        Map<String, Integer> wordCountMap = new TreeMap<>();
        Set<String> words = new HashSet<String>();
        int rareWordsCount = 0;

        while(in.hasNext()){
            String word = in.next();
            word = word.toLowerCase();
            if(word.startsWith("a") && word.length() == 3)
                words.add(word);
        }

        in = new Scanner(new File("mobydick.txt"));

        while(in.hasNext()){
            String word = in.next();
            word = word.toLowerCase();
            if(wordCountMap.containsKey(word)){
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            }else{
                wordCountMap.put(word, 1);
            }
        }

        for (String word : wordCountMap.keySet()) {
            int count = wordCountMap.get(word);
            if(count <= 10)
                rareWordsCount++;
            if(count > 2000)
                System.out.println(word + " " + count);
        }

        System.out.println("\nNumber of words: " + words.size());
        System.out.println(words + "\n");
        System.out.println("Number of words that show up 10 or less times:\n" + rareWordsCount);
    }
}
