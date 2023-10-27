/**
 *
 *  @author Musiał Jan S28977
 *
 */

package Task3_Lambdas.zad2;


/*<-- necessary imports */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Main {

  public static void main(String[] args) {
    // List of destination: departure_airport destination_airport price_EUR
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = dest.stream().filter(
            e -> e.split("\\s+")[0].equals("WAW")
    ).map(
            e -> "to " +
                    e.split("\\s")[1] +
                    " - price in PLN: " +
                    String.format("%.0f",ratePLNvsEUR*Double.parseDouble(e.split("\\s+")[2]))
    ).collect(Collectors.toList());
    /*<-- here you should add fragment of code
     * but you are not allowed to use any own classes like eg ListCreator
     * or any own interfaces either 
     * Hint: you should use streams 
     */

    for (String r : result) System.out.println(r);
  }
}
