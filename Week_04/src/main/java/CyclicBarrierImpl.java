import java.util.concurrent.*;

/**
 * Created by liang on 2020/11/8.
 */
public class CyclicBarrierImpl {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                // 线程执行完毕后打印输出结果
                System.out.println("线程执行结束");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<Integer> future = new FutureTask<Integer>(new CalcFibo(9, cyclicBarrier));
        executorService.submit(future);
        executorService.shutdown();

        try {
            System.out.println("result: "+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    static class CalcFibo implements Callable<Integer> {

        private int num;
        private CyclicBarrier cyclicBarrier;

        public CalcFibo(int num, CyclicBarrier cyclicBarrier) {
            this.num = num;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public Integer call() throws Exception {
            int result = Homework03.getFibo(num);
            System.out.println("当前线程名称: "+Thread.currentThread().getName());
            cyclicBarrier.await();
            return result;
        }
    }

}
