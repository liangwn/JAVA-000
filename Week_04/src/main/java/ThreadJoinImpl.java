import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liang on 2020/11/11.
 */
public class ThreadJoinImpl {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread thread = new Thread(() -> {
            atomicInteger.set(Homework03.getFibo(9));
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("result: "+atomicInteger.get());
    }
}
