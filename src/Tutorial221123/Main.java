package Tutorial221123;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.add("Ala");
        al.add("ma");
        al.add("kota");

        for(String str : al){
            System.out.println(str);
            //al.remove(str);
        }

        MyDataStructure<String> mds = new MyDataStructure();
        mds.add("Ala");
        mds.add("ma");
        mds.add("kota");

        for(String str : mds) {
            System.out.println(str);
            mds.add("smt");
        }
    }
}