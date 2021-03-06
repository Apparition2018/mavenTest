package knowledge.api.lang;

import org.junit.jupiter.api.Test;

/**
 * Object
 * https://www.runoob.com/manual/jdk1.6/java/lang/Object.html
 *
 * @author ljh
 * created on 2019/8/8 19:39
 */
public class ObjectDemo {

    /**
     * protected  Object	clone()
     * 创建并返回此对象的一个副本
     * <p>
     * https://www.zhihu.com/question/52490586
     */
    @Test
    public void clone_() {

    }

    /**
     * boolean	equals(Object obj)
     * 指示其他某个对象是否与此对象"相等"
     * <p>
     * 对于基本类型，比较的是基本类型的值
     * 对于引用类型，比较的是对象的内存地址
     */
    @Test
    public void equals_() {
        Object x = 1;
        Object y = 2;
        System.out.println(x.equals(y)); // false

        Object z = x;
        System.out.println(x.equals(z)); // true
    }

    /**
     * protected  void	finalize()
     * 当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法
     * <p>
     * https://blog.csdn.net/maoyeqiu/article/details/49562093
     */
    @Test
    public void finalize_() {
    }

    /**
     * Class<?>	getClass()
     * 返回此 Object 的运行时类
     * <p>
     * https://www.cnblogs.com/wsw-bk/p/8026266.html
     */
    @Test
    public void getClass_() {
        // Object.class 和 object.getClass() 的区别：

        Number n = 2;
        // object.getClass()
        System.out.println(n.getClass().getName()); // java.lang.Integer

        // Object.class
        System.out.println(Number.class.getName()); // java.lang.Number
    }

    /**
     * int	hashCode()
     * 返回该对象的哈希码值
     * <p>
     * hashCode() 的主要作用是配合基于散列的集合一起正常运行，如 HashMap, HashSet, HashTable
     * <p>
     * 如果两个对象相等，他们的 hashCode 值一定相等
     * 如果两个对象的 hashCode 值相等，他们不一定相等
     * <p>
     * https://zhuanlan.zhihu.com/p/26814793
     */
    @Test
    public void hashCode_() {

    }

    /**
     * void	notify()
     * 唤醒在此对象监视器上等待的单个线程
     * <p>
     * void	notifyAll()
     * 唤醒在此对象监视器上等待的所有线程
     * <p>
     * 此方法只应由作为此对象监视器的所有者的线程来调用，否则抛出 IllegalMonitorStateException 异常
     * 通过以下三种方法之一，线程可以成为此对象监视器的所有者：
     * 1.通过执行此对象的同步实例方法；
     * 2.通过执行在此对象上进行同步的 synchronized 语句的正文；
     * 3.对于 Class 类型的对象，可以通过执行该类的同步静态方法；
     */
    @Test
    public void notify_() {
    }

    /**
     * void	wait([long timeout])
     * 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量前，导致当前线程等待
     * <p>
     * void	wait(long timeout, int nanos)
     * 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量前，导致当前线程等待
     * <p>
     * 当前线程必须拥有此对象监视器，请参阅 notify()
     * <p>
     * https://blog.csdn.net/jianiuqi/article/details/53448849
     */
    @Test
    public void wait_() {

    }

}
