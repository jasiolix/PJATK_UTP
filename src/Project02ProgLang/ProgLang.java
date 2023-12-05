package Project02ProgLang;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Predicate;

public class ProgLang {
    ProgLang(String fname){
        readFile(fname);

    }

    private void readFile(String fname) {
    }

    private static <K,V> Map<K,V>  sorted(Map<K,V> map, Comparator<K> comparator){} //Explain why you use <K,V> this way and not raw types for example

    private static <K,V> Map<K,V>  filtered(Map<K,V> map, Predicate<K> predicate){}

    public Map<String, Collection<String>> getLangsMap() {
    }

    public Map<String, Collection<String>> getProgsMap() {
    }

    public Map<String, Collection<String>> getLangsMapSortedByNumOfProgs() {
    }


    public Map<String, Collection<String>> getProgsMapSortedByNumOfLangs() {
    }

    public Map<String, Collection<String>> getProgsMapForNumOfLangsGreaterThan(int i) {
    }
}
