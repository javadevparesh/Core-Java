package Multithreading;

public class VolatileExample {

    private static volatile boolean running = true;

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Thread started...");
            while (running) {
                // busy-wait loop
            }
            System.out.println("Thread ended.");
        });

        thread.start();

        try {
            Thread.sleep(2000); // Let the thread run for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stopping thread...");
        running = false; // this change is immediately visible to the thread
    }
}
