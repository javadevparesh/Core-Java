 package Multithreading;

import java.util.ArrayList;
import java.util.List;

public class NotifyAllExample {

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Producer
        Thread producer = new Thread(() -> {
            int value = 0;
            try {
                while (true) {
                    buffer.produce(value++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer
        Thread consumer1 = new Thread(() -> {
            try {
                while (true) {
                    buffer.consume();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while (true) {
                    buffer.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}

class SharedBuffer {
    private final List<Integer> buffer = new ArrayList<>();
    private final int MAX_SIZE = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == MAX_SIZE) {
            System.out.println("Buffer full. Producer is waiting...");
            wait(); // Wait until there's space
        }

        buffer.add(value);
        System.out.println("Produced: " + value);
        notifyAll(); // Notify all waiting threads (producers/consumers)
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty. Consumer is waiting...");
            wait(); // Wait until there is something to consume
        }

        int value = buffer.remove(0);
        System.out.println("Consumed: " + value);
        notifyAll(); // Notify all waiting threads (producers/consumers)
    }
}

