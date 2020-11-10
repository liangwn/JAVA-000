import java.util.concurrent.*;

/**
 * Created by liang on 2020/11/8.
 * 使用Future实现
 */
public class FutureImpl {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> result = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return Homework03.getFibo(9);
            }
        });
        executorService.shutdown();
        try {
            System.out.println("result: "+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
