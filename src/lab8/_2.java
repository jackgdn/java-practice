package lab8;

import java.util.Random;

public class _2 {
    public static void main(String[] args) {
        Random rand = new Random();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Walker walker = new Walker(Walker.names.values()[rand.nextInt(10)]);
            threads[i] = new Thread(walker);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class Walker implements Runnable {

    public enum names {
        Alice, Bob, Charlie, David, Eve, Frank, George, Hannah, Ivan, Jane
    };

    private names name;
    private static Object object = new Object();

    public Walker(names name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(String.format("%s正在过桥", name));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}