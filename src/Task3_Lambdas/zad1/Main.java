/**
 *
 *  @author Musiał Jan S28977
 *
 */

package Task3_Lambdas.zad1;


import java.util.*;

 class Main {

  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when(
                               e -> e.split("\\s+")[0].equals("WAW")
                               /*<-- lambda expression
                                *   selecting flights from Warsaw (starting with WAW)
                                */
                        )
                       .mapEvery(
                               e -> "to " +
                                       e.split("\\s")[1] +
                                       " - price in PLN: " +
                                       String.format("%.0f",xrate*Double.parseDouble(e.split("\\s+")[2]))
                               /*<-- lambda expression
                                   *  calculating flight price in PLN
                                   *  and creating the result string
                                   */
                       );
  }

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
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
