package exception;

import java.util.concurrent.locks.ReentrantLock;

//try块中引起异常，异常代码之后的语句不再执行，直接执行finally语句
// try块没有引发异常，则执行完try块就执行finally语句

/**
 * finally在以下情况不会被执行
 * 1.在前面的代码中用了System.exit()退出程序
 * 2.finally语句块中发生了异常
 * 3.程序所在的线程死亡
 * 4.关闭CPU
 */
public class TryFinally {
    public static void main(String[] args) {
        //以Lock加锁为例，演示try-finall
        ReentrantLock lock=new ReentrantLock();
        try{
            //需要加锁的代码
            Thread thread1=new Thread("t1");
            Thread thread2=new Thread("t2");
            Thread thread3=new Thread("t3");
            for(int i=0;i<=20;i++)
            {
                System.out.println(thread1.getName()+"正在运行中");
                Thread.sleep(10);
                System.out.println(thread2.getName()+"正在运行中");
                Thread.sleep(10);
                System.out.println(thread3.getName()+"正在运行中");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            lock.unlock();//保证锁一定被释放
        }

    }
}
