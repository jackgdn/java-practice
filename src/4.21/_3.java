interface USB {
    void turnOn();

    void turnOff();
}

class Mouse implements USB {
    public void turnOn() {
        System.out.println("鼠标启动了");
    }

    public void turnOff() {
        System.out.println("鼠标关闭了");
    }
}

class Keyboard implements USB {
    public void turnOn() {
        System.out.println("键盘启动了");
    }

    public void turnOff() {
        System.out.println("键盘关闭了");
    }
}

class Microphone implements USB {
    public void turnOn() {
        System.out.println("麦克启动了");
    }

    public void turnOff() {
        System.out.println("麦克关闭了");
    }
}

class Computer {
    private USB[] devices;

    public Computer() {
        devices = new USB[3];
    }

    private void add(USB device, int i) {
        devices[i] = device;
        devices[i].turnOn();
    }

    private void remove(int i) {
        devices[i].turnOff();
        devices[i] = null;
    }

    public void powerOn() {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] == null) {
                switch (i) {
                    case 0:
                        add(new Mouse(), i);
                        break;
                    case 1:
                        add(new Keyboard(), i);
                        break;
                    case 2:
                        add(new Microphone(), i);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("计算机开机成功");
    }

    public void powerOff() {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] != null) {
                remove(i);
            }
        }
        System.out.println("计算机关机成功");
    }
}

public class _3 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();
        computer.powerOff();
    }
}