
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        MyCallable mc = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t = new Thread(ft,"Thread01");
        Thread t1 = new Thread(ft,"Thread02");
        t.start();
        t1.start();
        try {
            System.out.println(ft.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExecutorService exe2 = new ThreadPoolExecutor(3,3,0, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        ExecutorService exe = Executors.newFixedThreadPool(3);
        Future<String> fu =  exe.submit(new MyCallable());
        try {
            System.out.println(fu.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        exe.shutdown();


    }
}

class MyCallable implements  Callable<String>{
    @Override
	public String call() {
        int i = 0;
        for(; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
		return "Hello" + i + Thread.currentThread().getName();
    }
}