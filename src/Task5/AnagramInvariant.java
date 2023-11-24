package Task5;

import java.util.Arrays;

public class AnagramInvariant {
    private char[] sortedCharArr;
    public AnagramInvariant(String word){
        this.sortedCharArr = word.toCharArray();
        Arrays.sort(sortedCharArr);
    }


    @Override
    public int hashCode() {
        return Arrays.hashCode(sortedCharArr);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        AnagramInvariant invariant = (AnagramInvariant) obj;
        return Arrays.equals(sortedCharArr, invariant.sortedCharArr);
    }
}
