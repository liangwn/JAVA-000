/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03 {
    
    public static void main(String[] args) {
        
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        
        int result = getFibo(36); //这是得到的返回值
        
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
         
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");



        // 然后退出main线程
    }

    /**
     * 获取第n个斐波那契数
     * @param n
     * @return
     */
    public static int getFibo(int n) {
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;

        int[] array = new int[n];
        array[0] = 1; // 第1个斐波那契数是1
        array[1] = 1; // 第2个斐波那契数也是1
        for(int i=2; i<array.length; i++) {
            array[i] = array[i-1] + array[i-2];
        }

        return array[n-1];
    }




}
