package knowledge.线程;

import l.demo.Demo;

import java.util.concurrent.TimeUnit;

/**
 * Runnable
 * https://jdk6.net/lang/Runnable.html
 * void	    run()       使用实现接口 Runnable 的对象创建一个线程时，启动该线程将导致在独立执行的线程中调用对象的 run 方法。
 * <p>
 * extends Thread 创建线程的不足：
 * 1：继承冲突，由于 java 是单继承的，这就导致一个类如果希望是线程，同时有需要扩展另一个类的功能时，由于不能同时继承这两个类，导致继承冲突
 * 2：继承线程需要重写 run 方法来定义线程任务，这就导致线程与任务定义在一起有一个强耦合关系，不利于线程重用
 * <p>
 * implements Runnable 比 extends Thread 的有优势：
 * 1：因为 java 只能单继承，实现 Runnable 接口可以避免单继承的局限性
 * 2：继承 Thread 类，多个线程不能处理或者共享同一个资源，但是实现 Runnable 接口可以处理同一个资源。
 */
public class RunnableDemo extends Demo {

    public static void main(String[] args) {
        TicketRunnable runnable = new TicketRunnable();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
    }

    static class TicketRunnable implements Runnable {

        private int ticket = 100;

        @Override
        public synchronized void run() {
            while (ticket > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p(Thread.currentThread().getName() + "正在卖票" + ticket--);
            }
        }
    }

}
