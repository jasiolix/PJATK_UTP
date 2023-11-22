/*
Create a class XList, providing additional functionalities to create lists, and operating on them.
In the class should be appropriate constructors and static methodsof, allows creating XList objects from another collections, arrays, and arguments separated by commas.

In addition, auxiliary methods to create a list of strings:

ofChars(string) - returns x-list of given string characters,
ofTokens(string, [ sep ]) - returns x-list of string symbols, separated by sep separators (if lack of sep - use white chars instead).

In addition you should provide methods:

union(any_collection)  -  returns  a new x-list containing elements from both old x-list and collection from the method argument,
diff(any_collection) - returns a x-list containing only those elements of that lists, which are not present in the collection from method argument,
unique() - returns a new x-list, which  contains all unique elements of the list
combine() - returns a x-list that contains combination of elements of x-list
collect(Function) - returns a new x-list which elements are results of function applied to elements of the x-list
join([sep]) - returns a string which is concatenation of elements of the list, optionally with the interposition of a given separator
forEachWithIndex(consumer_with_two_arguments: element, index) - for iterating over list with access to elements and it's indexes

For the implementation of each of the above-mentioned properties you will obtain distinct points, so that you can perform only part of the job.
But you should be careful that the file Main.java in your solution should not have any errors at compile time.

A Main class included in the project should explain how to implement the task.

This program should write to the console:

[1, 3, 9, 11]
[5, 6, 9]
[100, 200, 300]
[100, 200, 300]
[3, 4, 5]
[3, 4, 5]
[a, l, a,  , m, a,  , k, o, t, a]
[ala, ma, kota]
[A, B, C]
[1, 3, 9, 11, 5, 6, 9]
[1, 3, 9, 11, 5, 6, 9, 11]
[1, 3, 9, 11, 5, 6, 9, 11]
[1, 3, 9, 11, 5, 6, 9, 11, 100, 200, 300, 4, 4]
[1, 3, 9, 11, 5, 6, 9, 11, 100, 200, 300, 4, 4, 3, 4, 5]
[1, 9, 11, 6, 9, 11, 100, 200, 300]
[]
[1, 3, 9, 11, 5, 6, 100, 200, 300, 4]
[[a, b], [X, Y, Z], [1, 2]]
[[a,X, 1], [b, X, 1], [a, Y, 1], [b, Y, 1], [a, Z, 1], [b, Z, 1], [a, X, 2], [b, X, 2], [a, Y, 2], [b, Y, 2], [a, Z, 2], [b, Z, 2]]
aX1 bX1 aY1 bY1 aZ1 bZ1 aX2 bX2 aY2 bY2 aZ2 bZ2
a-X-1 b-X-1 a-Y-1 b-Y-1 a-Z-1 b-Z-1 a-X-2 b-X-2 a-Y-2 b-Y-2 a-Z-2 b-Z-2
[2, 4, 16, 20, 22, 60, 6, 8]
[4, 16, 22, 60, 8]
[16, 22, 60, 8]

 */
package Project01AdditionaloOperationsOnLists;


import java.util.*;

// The Main.java file can be modified freely,
// but you will obtain points for proper implementation of each XList class methods.

// If you don't implement all methods, you should remove those fragments from Main class,
// which causes compilation errors - otherwise you will not get any points.

public
    class Main {

    public static void main(String[] args) {
        // Some additional data sets
        Integer[] ints = { 100, 200, 300 };
        Set<Integer> set = new HashSet<>(Arrays.asList(3, 4, 5));

        // Ways of creating XList
        XList<Integer> list1 = new XList<>(1, 3, 9, 11);
        XList<Integer> list2 = XList.of(5, 6, 9);
        XList<Integer> list3 = new XList(ints);
        XList<Integer> list4 = XList.of(ints);
        XList<Integer> list5 = new XList(set);
        XList<Integer> list6 = XList.of(set);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list5);
        System.out.println(list6);

        // --- and auxiliary methods for creating from strings
        XList<String> slist1 = XList.charsOf("ala ma kota"); //Q: why not XList<Character>
        XList<String> slist2 = XList.tokensOf("ala ma kota");
        XList<String> slist3 = XList.tokensOf("A-B-C", "-");

        System.out.println(slist1);
        System.out.println(slist2);
        System.out.println(slist3);

        // union method - sum of elements
        List<Integer> m1 = list1.union(list2);  // of course, you can assign result to List
        System.out.println(m1);
        // You can perform all the operations of the List interface, for example:
        m1.add(11);
        System.out.println(m1);
        XList<Integer> m2 = (XList<Integer>) m1;
        XList<Integer> m3 = m2.union(ints).union(XList.of(4, 4));
        System.out.println(m2); // m2 doesn't change
        System.out.println(m3); // result is in m3
        m3 = m3.union(set);
        System.out.println(m3);

        // We saw union method
        // Now diff method (with any collection as an argument)
        System.out.println(m3.diff(set));  // all from m3, which is not in set
        System.out.println(XList.of(set).diff(m3)); // all what is in set, but not in m3

        // Unique method - returns a new XList without duplicates
        XList<Integer> uniq = m3.unique(); // a list, not a Set
        System.out.println(uniq);

        //Q: Can we use any classes implementing Collection interface

        // combinations (order of elements does matter)
        List<String> sa = Arrays.asList( "a", "b");
        List<String> sb = Arrays.asList( "X", "Y", "Z" );
        XList<String> sc = XList.charsOf( "12" );
        XList toCombine = XList.of(sa, sb, sc);  // can we avoid of usage of raw type?
        System.out.println(toCombine);
        XList<XList<String>> cres = toCombine.combine();
        System.out.println(cres);

        // collect and join
        XList<String> j1 = cres.collect( list -> list.join());
        System.out.println(j1.join(" "));
        XList<String> j2 =cres.collect( list -> list.join("-"));
        System.out.println(j2.join(" "));

        // forEachWithIndex
        XList<Integer> lmod = XList.of(1,2,8, 10, 11, 30, 3, 4);
        lmod.forEachWithIndex( (e, i) -> lmod.set(i, e*2));
        System.out.println(lmod);
        lmod.forEachWithIndex( (e, i) -> { if (i % 2 == 0) lmod.remove(e); } );
        System.out.println(lmod);
        lmod.forEachWithIndex( (e, i) -> { if (i % 2 == 0) lmod.remove(i); } );
        System.out.println(lmod); // Question: why do we have such a effect?
    }
}