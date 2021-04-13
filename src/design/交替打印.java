package design;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 交替打印 {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionNum = lock.newCondition();
    private static Condition conditionLet = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread num = new Thread(()->{
            try{
                int i=1;
                lock.lock();
                System.out.println("进入锁1");
                while (true){
                    System.out.println(Thread.currentThread().getName()+"conditionLet.signal-before");
                    conditionLet.signal();
                    System.out.println(Thread.currentThread().getName()+"conditionLet.signal-1");
                    System.out.println(i++);
                    System.out.println(i++);
                    System.out.println(Thread.currentThread().getName()+"conditionNum.await-1");
                    if(i>27){
                        break;
                    }
                    conditionNum.await();
                    System.out.println(Thread.currentThread().getName()+"conditionNum.await-finish");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("释放锁1");
                lock.unlock();
            }
        });

        Thread let = new Thread(()->{
            try{
                char i='A';
                lock.lock();
                System.out.println("进入锁a");
                while (true){
                    System.out.println(Thread.currentThread().getName()+"conditionNum.signal-before");
                    conditionNum.signal();
                    Thread.sleep(1100);
                    System.out.println(Thread.currentThread().getName()+"conditionNum.signal-a");
                    System.out.println(i++);
                    System.out.println(i++);
                    System.out.println(Thread.currentThread().getName()+"conditionLet.await-a");
                    if(i>'Z'){
                        break;
                    }
                    conditionLet.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("释放锁a");
                lock.unlock();
            }
        });

        num.start();
        Thread.sleep(10);
        let.start();
    }
}
