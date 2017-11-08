package 生产者与消费者;

import java.util.LinkedList;

/**
 * Created by 666 on 2017/11/8.
 * 使用Object.wait()/notifyAll()实现的阻塞队列
 */
public class TraditionalBlockingQueue<T> implements IBlockingQueue<T> {
    private int queueSize;  //队列大小默认是生产10个元素
    private LinkedList<T> linkedList = new LinkedList<T>();
    private Object lock = new Object();

    public TraditionalBlockingQueue() {
        this(10);
    }

    public TraditionalBlockingQueue(int queueSize) {
        if(queueSize < 1){
            throw new IllegalArgumentException("queueSize must be positive number");
        }
        this.queueSize = queueSize;
    }

    @Override
    public void put(T data) throws InterruptedException {
        synchronized (lock){
            while (linkedList.size() >= queueSize){ //如果生产出来的数据超过 阻塞队列就 这时候就停止，等待消费者消费
                lock.wait();
            }
            linkedList.addLast(data);
            System.out.println("生产线程"+Thread.currentThread().getName()+" 生产数据="+data);
            lock.notifyAll();
        }
    }

    @Override
    public T take() throws InterruptedException {
        synchronized (lock){
            while (linkedList.size() <= 0){     //生产者还没生出来数据，等待
                lock.wait();
            }

            T t = linkedList.removeFirst();
            System.out.println("消费线程"+Thread.currentThread().getName()+" 消费数据================================="+t);
            lock.notifyAll();
            return t;
        }
    }


}
