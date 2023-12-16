package Project02ProgLang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProgLang {
    Map<String, Set<String>> langsMap;
    Map<String, Set<String>> progsMap;

    ProgLang(String fname){
        readFile(fname);
    }

    private void readFile(String fname) {
        langsMap = new LinkedHashMap<>();
        progsMap = new LinkedHashMap<>();
        try(BufferedReader reader = new BufferedReader(
                new FileReader("src/Project02ProgLang/Programmers.tsv")
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
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static <K,V> Map<K,V> sorted(Map<K,V> map, Comparator<K> comparator){
        TreeMap<K,V> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(map);
        return treeMap;
    } //Explain why you use <K,V> this way and not raw types for example

    private static <K,V> Map<K,V>  filtered(Map<K,V> map, Predicate<K> predicate){
        Map<K,V> mapCopy = Map.copyOf(map);
        mapCopy.keySet().removeIf(predicate);
        return mapCopy;
    }

    public Map<String, Set<String>> getLangsMap() {
        return langsMap;
    }

    public Map<String, Set<String>> getProgsMap() {
        return progsMap;
    }

    public Map<String, Set<String>> getLangsMapSortedByNumOfProgs() {
        return
    }


    public Map<String, Collection<String>> getProgsMapSortedByNumOfLangs() {
        return null;
    }

    public Map<String, Collection<String>> getProgsMapForNumOfLangsGreaterThan(int i) {
        return null;
    }
}
