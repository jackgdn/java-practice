package lab8;

public class _1 {
    public static void main(String[] args) {
        Thread rabbitThread = new Thread(new Rabbit(), "兔子");
        Thread turtleThread = new Thread(new Turtle(), "乌龟");

        rabbitThread.start();
        turtleThread.start();
    }
}

class GlobalVariables {
    public static int LENGTH = 50;
    public static Object LOCK = new Object();
    public static int rabbitPosition = 0;
    public static int turtlePosition = 0;
}

class Rabbit implements Runnable {

    @Override
    public void run() {
        while (GlobalVariables.rabbitPosition < GlobalVariables.LENGTH) {
            move();
            if (GlobalVariables.rabbitPosition > GlobalVariables.turtlePosition) {
                System.out.println("我跑得快，睡一觉");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            synchronized (GlobalVariables.LOCK) {
                System.out
                        .println(String.format("兔子距离终点%d，当前%s", GlobalVariables.LENGTH - GlobalVariables.rabbitPosition,
                                (GlobalVariables.rabbitPosition > GlobalVariables.turtlePosition) ? "领先" : "落后"));
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("兔子到达终点！");
    }

    public void move() {
        GlobalVariables.rabbitPosition += 10;
    }
}

class Turtle implements Runnable {

    @Override
    public void run() {
        while (GlobalVariables.turtlePosition < GlobalVariables.LENGTH) {
            move();

            synchronized (GlobalVariables.LOCK) {
                System.out
                        .println(String.format("乌龟距离终点%d，当前%s", GlobalVariables.LENGTH - GlobalVariables.turtlePosition,
                                (GlobalVariables.rabbitPosition <= GlobalVariables.turtlePosition) ? "领先" : "落后"));
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("乌龟到达终点!");
    }

    public void move() {
        GlobalVariables.turtlePosition += 1;
    }
}