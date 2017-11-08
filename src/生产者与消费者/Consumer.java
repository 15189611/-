package 生产者与消费者;

/**
 * Created by 666 on 2017/11/8.\
 * 消费类
 */
public class Consumer implements Runnable {
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
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}