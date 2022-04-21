package lock;

import java.util.LinkedList;

public class BreadContainer {


    LinkedList<String> list = new LinkedList<>();
    // 容器容量
    private final static int CAPACITY = 10;
    /**
     * 放入面包
     */
    public synchronized void put(String bread) {
        while (list.size() == CAPACITY) {
            try {
                // 如果容器已满，则阻塞生产者线程
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(bread);
        // 面包生产成功后通知消费者线程
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " 生产 a bread" + bread + " size = " + list.size());
    }

    /**
     * 取出面包
     */
    public synchronized void take() {
        while (list.isEmpty()) {
            try {
                // 如果容器为空，则阻塞消费者线程
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String bread = list.removeFirst();
        // 消费后通知生产者生产面包
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " 消费 a bread" + bread + " size = " + list.size());
    }
}