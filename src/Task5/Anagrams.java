package Task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {
    private final List<String> list;

    public Anagrams(String allWords) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(allWords));
        list = new ArrayList<>();
        while (scan.hasNext()){
            list.add(scan.next());
        }
    }

    public List<List<String>> getSortedByAnQty() {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : list){
            String invariant = anagramInvariant(word);
            map.putIfAbsent(invariant, new ArrayList<>());
            map.get(invariant).add(word);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        res.sort(new myComparator());
        return res;
    }

    public String getAnagramsFor(String wtf) {
        String invariant = anagramInvariant(wtf);
        List<String> anagrams = list.stream()
                .filter(e -> anagramInvariant(e).equals(invariant))
                .filter(e -> !e.equals(wtf))
                .toList();
        return wtf + ": " + anagrams;
    }

    public String anagramInvariant(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
