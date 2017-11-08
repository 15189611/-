package 生产者与消费者;



/**
 * Created by 666 on 2017/11/8.
 */
public class 生产者与消费者 {

    public static void main(String[] args){
        TraditionalBlockingQueue<String> queue = new TraditionalBlockingQueue<String>(2);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer1 = new Thread(new Consumer(queue));
        producer.start();
        consumer1.start();

    }

}
