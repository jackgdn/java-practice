package lab7;

import java.util.Scanner;

public class _4 {
    public static void main(String[] args) {
        Cargoship c = new Cargoship();
        int weight;
        Scanner in = new Scanner(System.in);

        try {
            while (true) {
                weight = in.nextInt();
                c.loading(weight);
                System.out.println(String.format("目前装载了%d吨货物", c.getLoad()));
            }
        } catch (OverloadingException oe) {
            System.out.println(oe.getMessage());
        } finally {
            in.close();
            System.out.println("货船将整点启航");
        }
    }
}

class Cargoship {

    private int load;

    public Cargoship() {
        load = 0;
    }

    public void loading(int weight) throws OverloadingException {
        if (load + weight > 2000) {
            throw new OverloadingException("超重，拒绝装载集装箱");
        }
        load += weight;
    }

    public int getLoad() {
        return load;
    }
}

class OverloadingException extends Exception {
    public OverloadingException(String message) {
        super(message);
    }
}