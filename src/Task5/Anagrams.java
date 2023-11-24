package Task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Anagrams {
    private List<String> list;

    public Anagrams(String allWords) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(allWords));
        list = new ArrayList<>();
        while (scan.hasNext()){
            list.add(scan.next());
        }
    }

    public List<List<String>> getSortedByAnQty() {
        Map<AnagramInvariant, List<String>> map = new HashMap<>();
        for(String word : list){
            AnagramInvariant invariant = new AnagramInvariant(word);
            map.putIfAbsent(invariant, new ArrayList<>());
            map.get(invariant).add(word);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        res.sort(new myComparator());
        return res;
    }

    public String getAnagramsFor(String wtf) {
        AnagramInvariant invariant = new AnagramInvariant(wtf);
        List<String> anagrams = list.stream()
                .filter(e -> new AnagramInvariant(e).equals(invariant))
                .filter(e -> !e.equals(wtf))
                .collect(Collectors.toList());
        return wtf + ": " + anagrams;
    }
}
