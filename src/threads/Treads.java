package threads;

import java.util.concurrent.*;

public class Treads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println("Finished");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
        Thread.sleep(5000);
        semaphore.release(1);
    }
}
