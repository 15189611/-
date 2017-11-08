package 生产者与消费者;


import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.concurrent.TimeUnit;

/**
 * Created by 666 on 2017/11/8.
 */
public class 生产者与消费者 {
    public static final String ENDING_SYMBOL = "FIN";

    public static void main(String[] args){
        TraditionalBlockingQueue<String> queue = new TraditionalBlockingQueue<String>();
        Thread producer = new Thread(new Producer(queue, 2));
        producer.start();

        Thread consumer1 = new Thread(new Consumer(queue));
        consumer1.start();
        Thread consumer2 = new Thread(new Consumer(queue));
        consumer2.start();
    }

    //生产
    public static class Producer implements Runnable {
        private IBlockingQueue<String> queue;
        private int consumerNum;

        public Producer(IBlockingQueue<String> queue, int consumerNum) {
            this.queue = queue;
            this.consumerNum = consumerNum;
        }

        @Override
        public void run() {

            for(int i=0; i< 100; i++){
                try {
                    queue.put("data_"+i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            for(int i=0; i<consumerNum; i++){   //结束符
                try {
                    queue.put(ENDING_SYMBOL);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Producer over");
        }
    }

    //消费
    public static class Consumer implements Runnable {
        private IBlockingQueue<String> queue;

        public Consumer(IBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            while (true) {
                String data = null;
                try {
                    data = queue.take();
                    System.out.println("Consumer "+Thread.currentThread().getName()+" consume:"+data);
                    if (ENDING_SYMBOL.equals(data)) {
                        break;
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Consumer over");
        }
    }

}
