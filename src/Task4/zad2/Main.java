package Task4.zad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
You need to create a InputConverter class which should transform input data (determined in a constructor of the class) using functions given as arguments of method convertBy.

Eg. If we have defined operations (functions):
flines - returns a list of lines from a text file
join - combines a string list (returns a string of interconnected elements of the list)
collectInts - returns a list of integers contained in the string
sum - returns the sum of elements of a list of integers
so sum of integers from file fname can be obtained by:
Integer s = new InputConverter<String>(fname).convertBy(flines, join, collectInts, sum);
and list of integers from a txt file in this way:
List<Integer> n = new InputConverter<String>(txt).convertBy(collectInts);

The essence of the method converty is that it allows to combine in different ways different operations on different data and receive results easily.
 */


class Main {

    public static void main(String[] args) {
        //TODO definition of operations in the form of lambda expressions:
        // - flines - returns a list of lines from a text file
        // - join - combines a string list (returns a string of interconnected elements of the list)
        // - collectInts - returns a list of integers contained in the string
        // - sum - returns the sum of elements of a list of integers

        Function<String, List<String>> flines = str -> {
            List<String> res = null;
            try {
                res = Files.readAllLines(Path.of(str));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return res;
        };

        Function<List<String>, String> join = strList -> {
            StringBuilder stringBuilder= new StringBuilder();
            for(String el : strList)
                stringBuilder.append(el);
            return stringBuilder.toString();
        };

        Function<String, List<Integer>> collectInts = str -> {
            List<Integer> intList = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\d+").matcher(str);
            while (matcher.find()){
                intList.add(Integer.parseInt(matcher.group()));
            }
            return intList;
        };

        Function<List<Integer>, Integer> sum = intList -> {
            int n=0;
            for(int el : intList){
                n+=el;
            }
            return n;
        };
        //TODO change following line to point location of input file
        String fname = "src/Task4/zad2/LamComFile.txt";

        InputConverter<String> fileConv = new InputConverter<>(fname);
        List<String> lines = fileConv.convertBy(flines);
        String text = fileConv.convertBy(flines, join);
        List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
        Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

        System.out.println(lines);
        System.out.println(text);
        System.out.println(ints);
        System.out.println(sumints);

        List<String> arglist = Arrays.asList(args);
        InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
        sumints = slistConv.convertBy(join, collectInts, sum);
        System.out.println(sumints);

    }
}

/*
For the following data from a file:
Cars:
- Fiat: 15, Ford: 20
- Opel: 8, Mitsubishi: 10

and the following arguments of main method call:
Warszawa 100 Kielce 200 Szczecin 300
program should print to the console:
[Cars:, - Fiat: 15, Ford: 20, - Opel: 8, Mitsubishi: 10]
Cars:- Fiat: 15, Ford: 20- Opel: 8, Mitsubishi: 10
[15, 20, 8, 10]
53
600
Attention: in InputConverter class must be only one method called convertBy (in this task you should not overload method convertBy).​​
Reference materials
 */