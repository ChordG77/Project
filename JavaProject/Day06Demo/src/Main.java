import java.io.Serializable;
import java.net.InetAddress;


import java.net.UnknownHostException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import static java.net.InetAddress.*;

public class Main {
    public static  CyclicBarrier c = new CyclicBarrier(5, new Meeting());
    public static  int sum = 0;
    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            new Staffs("员工" + i).start();
        }

        InetAddress inet = null;
        try {
            inet = getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(inet.getHostAddress());
//        System.out.println(inet.);
    }
    Semaphore  semaphore = new Semaphore(5);



}

class Meeting implements Runnable, Serializable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开会"+ Main.sum);
    }
}

class Staffs extends Thread {
    public Staffs(String name) {
        super(name);
    }

    public void run() {
        System.out.println(currentThread().getName() + "已就位");
        Main.sum += 1;
        try {
            System.out.println(Main.c.getNumberWaiting());
            Main.c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}