package Task5;

import java.util.List;

public class myComparator implements java.util.Comparator<List<String>> {
    @Override
    public int compare(List<String> o1, List<String> o2) {
        if(o1.size()!=o2.size()){
            return o2.size()-o1.size();
        }
        else{
            return o1.get(0).compareTo(o2.get(0));
        }
    }
}
