import java.util.concurrent.*;

/**
 * Created by liang on 2020/11/8.
 */
public class SemaphoreImpl {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new SemaphoreImpl.SemaphoreFibo(9, semaphore));
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

    static class SemaphoreFibo implements Callable<Integer> {

        private int num;
        private Semaphore semaphore;

        public SemaphoreFibo(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public Integer call() throws Exception {
            semaphore.acquire();
            int result = Homework03.getFibo(num);
            System.out.println("当前线程名称: "+Thread.currentThread().getName());
            semaphore.release();
            return result;
        }
    }
}
