import java.util.concurrent.*;

/**
 * Created by liang on 2020/11/8.
 */
public class FutureTask2Impl {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            public Integer call() throws Exception {
                return Homework03.getFibo(9);
            }
        });
        executorService.submit(futureTask);
        executorService.shutdown();
        try {
            System.out.println("result: "+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
