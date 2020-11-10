import java.util.concurrent.*;

/**
 * Created by liang on 2020/11/8.
 */
public class CountDownLatchImpl {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> result = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = Homework03.getFibo(9);
                countDownLatch.countDown();
                return result;
            }
        });

        executorService.shutdown();

        try {
            countDownLatch.await();
            System.out.println("result: "+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
