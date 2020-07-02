package design;

import java.util.concurrent.atomic.AtomicReference;

public class 自旋锁锁 {

    private AtomicReference<Thread> lock = new AtomicReference<>();

    public void getLock(){
        Thread current = Thread.currentThread();
        System.out.println(current.getName()+"尝试获取锁");
        while (!lock.compareAndSet(null,current));
        System.out.println(current+"获取锁成功");
    }

    public void unLock(){
        Thread current = Thread.currentThread();
        while (!lock.compareAndSet(current,null));
    }
}
