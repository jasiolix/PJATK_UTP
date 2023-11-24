package Task5;


// remember to add package before turinging in !
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //TODO: change to folder location
        String home = "src/Task5";
        String allWords = home + "/allwords.txt";
        Anagrams an = new Anagrams(allWords);
        for(List<String> wlist : an.getSortedByAnQty()) {
            System.out.println(wlist);
        }
        
        System.out.println("************************");
        Scanner scan = new Scanner(new File(home, "wordsToFind.txt"));
        while(scan.hasNext()) {
            System.out.println(an.getAnagramsFor(scan.next()));
        }
        scan.close();
    }

}

/*
In a file allwords.txt, located in the directory {user.home} are written words (separated by white chars).
Find all anagrams that can be created with these words and write out them as a list of words on the console in the order of the number of anagrams.
With the same number of anagrams lists are printed in alphabetical order of the first word in the list.

To accomplish this task in class Anagrams create a method getSortedByAnQty(), which returns a list of lists of words that are anagrams, ordered according to the above criteria.
In this class provide a method String getAnagramsFor(String word), which returns a string, showing a list of anagrams for the word given in the form of:

word: [ anagram1, anagram2, ... , anagramN]

If the word has no anagrams, the list is empty (after the colon we have []). If the specified word is not in the file allwords.txt after colon should be a word null.

The words for which we will look for anagrams, are loaded from a file called {user.home}/wordsToFind.txt.

The solution will facilitate the class Main (attached into task), created by the projects generator (you are not allowed change it).

If the file allwords.txt contains the following words:

andes danes deans evil gals lags levi live sedan
slag streets testers uprising veil vile

and wordsToFind.txt file contains words:
evil streets uprising

- and the program (starting execution of a mandatory Main class) should output the following information on the console:

[evil, levi, live, veil, vile]
[andes, danes, deans, sedan]
[gals, lags, slag]
[streets, testers]
[uprising]
************************
evil: [levi, live, veil, vile]
streets: [testers]
uprising: []

The Main class created by projects generator contains a fragment helpful to obtain the required file name.

You have to manually create test files and place them in a directory where txt files are located.
 */