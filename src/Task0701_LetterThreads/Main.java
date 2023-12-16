package Task0701_LetterThreads;

public
class Main {

    public static void main (String [] args) throws InterruptedException {
        Letters letters = new Letters("ABCD");
        for (Thread t: letters.getThreads()) System.out.println(t.getName());
        letters.start();
        Thread.sleep (5000);
        letters.stop();
        System.out.println("\nProgram finished working");
    }
}