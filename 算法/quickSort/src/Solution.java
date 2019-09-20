import java.util.concurrent.*;

public class Solution {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for(int i=0;i<20;i++){
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

