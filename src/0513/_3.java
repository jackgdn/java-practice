public class _3 {
    public static void main(String[] args) {
        Station station1 = new Station(Station.names.哈尔滨站);
        Station station2 = new Station(Station.names.哈尔滨东站);
        Station station3 = new Station(Station.names.哈尔滨西站);

        Thread t1 = new Thread(station1);
        Thread t2 = new Thread(station2);
        Thread t3 = new Thread(station3);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Station implements Runnable {

    public static enum names {
        哈尔滨站, 哈尔滨东站, 哈尔滨西站
    }

    private names name;
    private static Object lock = new Object();
    private static int total = 200;

    public Station(names name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (total > 0) {
            synchronized (lock) {
                total--;
                System.out.println(String.format("%s: 剩余 %d 张票", name, total));
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}