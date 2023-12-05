package Task0601_SortingData;
public class Main {

    public static void main(String[] args)  {
        CustomersPurchaseSortFind cpsf = new CustomersPurchaseSortFind();
        String fname = "src/Task0601_SortingData/customers_en.txt";
        cpsf.readFile(fname);
        cpsf.showSortedBy("names");
        cpsf.showSortedBy("costs");

        String[] custSearch = { "c00001", "c00002" };

        for (String id : custSearch) {
            cpsf.showPurchaseFor(id);
        }
    }
}