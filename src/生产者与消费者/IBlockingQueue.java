package 生产者与消费者;

/**
 * Created by 666 on 2017/11/8.
 */
public interface IBlockingQueue<T> {
    void put(T data) throws InterruptedException; //生产
    T take() throws InterruptedException;         //消费
}
