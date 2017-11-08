package 生产者与消费者;

/**
 * Created by 666 on 2017/11/8.
 */
public class Producer implements Runnable {
    private IBlockingQueue<String> queue;

    public Producer(IBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i< 100; i++){
            try {
                queue.put("data_"+i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}