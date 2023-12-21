package Project02ProgLang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
public class ProgLang {
    Map<String, Set<String>> langsMap;
    Map<String, Set<String>> progsMap;

    ProgLang(String fname) throws IOException{
        langsMap = new LinkedHashMap<>();
        progsMap = new LinkedHashMap<>();
        try(BufferedReader reader = new BufferedReader(
                new FileReader(fname)
        )){
            String line;
            String[] words;
            while((line = reader.readLine())!= null){
                words = line.split("\t");
                Set<String> progSet = new LinkedHashSet<>();
                Set<String> langSet;
                for(int i=1; i<words.length; i++) {
                    progSet.add(words[i]);
                    if ((langSet = progsMap.get(words[i]))!= null){
                        langSet.add(words[0]);
                    }
                    else {
                        progsMap.put(
                                words[i],
                                new LinkedHashSet<>(Collections.singletonList(words[0]))
                        );
                    }
                }
                langsMap.putIfAbsent(words[0], progSet);
            }
        }
    }


    private static <K,V> Map<K,V> sorted(Map<K,V> map, Comparator<Map.Entry<K,V>> comparator){
        LinkedHashMap<K,V> linkedHashMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(comparator)
                .forEach(kvEntry -> linkedHashMap.put(kvEntry.getKey(), kvEntry.getValue()));
        return linkedHashMap;
    } //Explain why you use <K,V> this way and not raw types for example

    private static <K,V> Map<K,V>  filtered(Map<K,V> map, Predicate<Map.Entry<K,V>> predicate){
        LinkedHashMap<K,V> linkedHashMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .filter(predicate)
                .forEach(kvEntry -> linkedHashMap.put(kvEntry.getKey(), kvEntry.getValue()));
        return linkedHashMap;
    }

    public Map<String, Set<String>> getLangsMap() {
        return langsMap;
    }

    public Map<String, Set<String>> getProgsMap() {
        return progsMap;
    }

    public Map<String, Set<String>> getLangsMapSortedByNumOfProgs() {
        return sorted(langsMap, compareBySizeThenName);
    }


    public Map<String, Set<String>> getProgsMapSortedByNumOfLangs() {
        return sorted(progsMap, compareBySizeThenName);
    }

    public Map<String, Set<String>> getProgsMapForNumOfLangsGreaterThan(int n) {
        return filtered(progsMap, progsMapEntry -> progsMapEntry.getValue().size() > n);
    }

    private static final Comparator<Map.Entry<String,Set<String>>> compareBySizeThenName = (entry1, entry2) -> {
        int k = entry2.getValue().size() - entry1.getValue().size();
        if(k==0)
            k = entry1.getKey().compareTo(entry2.getKey());
        return k;
    };
}
