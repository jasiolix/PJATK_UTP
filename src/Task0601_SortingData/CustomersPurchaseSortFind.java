package Task0601_SortingData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
public class CustomersPurchaseSortFind {
    private final List<Purchase> purchaseArr = new ArrayList<>();
    private  final Map<Customer,Customer> customerMap = new HashMap<>();
    public void readFile(String fname) {
        try (Scanner scanner = getScanner(fname)) {
            while (scanner.hasNext())
                addPurchase(scanner.next(), scanner.next(), scanner.next(), scanner.nextDouble(), scanner.nextDouble());
        } catch (IOException exception) {
            System.err.println("Couldn't read the file.");
            System.exit(1);
        }
    }

    private Scanner getScanner(String fname) throws IOException {
        Scanner scanner = new Scanner(new File(fname));
        scanner.useLocale(Locale.US);
        scanner.useDelimiter(";|\\R");
        return scanner;
    }

    private void addPurchase(String id, String customerName, String commodityName, double price, double quantity) {
        Customer customer = new Customer(id, customerName);
        if(customerMap.containsKey(customer))
            customer = customerMap.get(customer);
        else
            customerMap.put(customer,customer);
        purchaseArr.add(new Purchase(customer, commodityName, price, quantity));
    }

    public void showSortedBy(String attribute) {
        System.out.println();
        Comparator<Purchase> comparator = toComparator(attribute);
        purchaseArr.sort(comparator);
        System.out.println(attribute);
        if(attribute.equals("costs"))
            for(Purchase purchase : purchaseArr){
                System.out.println(purchase + " (cost: "
                        + purchase.getPrice()*purchase.getQuantity()
                        + ")");
            }
        else
            for(Purchase purchase : purchaseArr){
                System.out.println(purchase);
            }
        System.out.println();
    }

    private Comparator<Purchase> toComparator(String attribute) {
        return switch (attribute){
            case "names" -> (p1, p2) -> {
                int res = p1.getCustomer().getName().compareTo(p2.getCustomer().getName());
                if(res == 0)
                    res = p1.getCustomer().getId().compareTo(p2.getCustomer().getId());
                return res;
            };
            // why such expression: case "names" -> Comparator.comparing(p -> p.getCustomer().getName()).thenComparing(p -> p.getCustomer().getId()); doesnt work??????
            case "costs" -> (p1, p2) -> {
                int res = Double.compare(p2.getPrice()*p2.getQuantity(), p1.getPrice()*p1.getQuantity());
                if(res == 0)
                    res = p1.getCustomer().getId().compareTo(p2.getCustomer().getId());
                return res;
            };
            default -> throw new IllegalStateException("Unexpected value: " + attribute);
        };
    }

    public void showPurchaseFor(String id) {
        System.out.println();
        System.out.println("Customer " + id);
        purchaseArr.stream().filter(p -> p.getCustomer().getId().equals(id)).forEach(System.out::println);
        System.out.println();
    }
}
