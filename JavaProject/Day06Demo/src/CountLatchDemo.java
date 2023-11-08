import java.util.concurrent.CountDownLatch;

public class CountLatchDemo {
    public static CountDownLatch c = new CountDownLatch(1);
    public static CountDownLatch c2 = new CountDownLatch(2);

    public static void main(String[] args) {

        new Progress("Progress-" + "A").start();
        new Progress("Progress-" + "B",c).start();
        new Progress("Progress-" + "C",c2).start();
    }
}

class Progress extends Thread{
    public CountDownLatch latch = new CountDownLatch(0);;
    Progress(String name) {
        super(name);
    }
    Progress(String name, CountDownLatch c){
        super(name);
        latch = c;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(currentThread().getName() + " is running");
        CountLatchDemo.c.countDown();
        CountLatchDemo.c2.countDown();
    }
}
