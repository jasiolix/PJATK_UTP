package Task0701_LetterThreads;

public class Letters {
    volatile boolean isRunning;
    Thread[] threads;
    Letters(String letters){
        threads = letters
                .chars()
                .mapToObj(i -> new Thread(
                ()->{
                    while(isRunning){
                        System.out.print((char)i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, String.valueOf((char)i)))
                .toArray(Thread[]::new);
    }
    public Thread[] getThreads() {
        return threads;
    }

    public void start(){
        isRunning = true;
        for(Thread t : threads){
            t.start();
        }
    }

    public void stop(){
        isRunning=false;
    }
}
