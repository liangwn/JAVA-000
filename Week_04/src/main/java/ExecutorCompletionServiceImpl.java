import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liang on 2020/11/11.
 */
public class ExecutorCompletionServiceImpl {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorCompletionService<Integer> executorCompletionService =
                new ExecutorCompletionService<>(executorService);
        executorCompletionService.submit(() -> Homework03.getFibo(9));
        try {
            System.out.println("result: "+executorCompletionService.take().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();


    }
}
