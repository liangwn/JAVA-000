import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by liang on 2020/11/8.
 */
public class CompletableFutureImpl {

    public static void main(String[] args) {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程名称："+Thread.currentThread().getName());
            return Homework03.getFibo(9);
        });
        try {
            System.out.println("result: "+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
