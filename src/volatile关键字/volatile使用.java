package volatile关键字;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Created by 666 on 2017/11/6.
 */
public class volatile使用 {
    private static final int THREADS_COUNT =20;
/*
    public static volatile int racee = 0;   //不具备 原子性 所以自增会出现问题
    public static void increase(){
        racee ++ ;
    }
*/

    public static AtomicInteger racee = new AtomicInteger();
    public static void increase(){
        racee.incrementAndGet();
    }

    public static void main(String[] args){
        Thread [] threads = new Thread[20];
        for (int i = 0;i < threads.length; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0 ;i <10000; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1){
            Thread.yield();
            System.out.println(racee);
        }
    }

}
