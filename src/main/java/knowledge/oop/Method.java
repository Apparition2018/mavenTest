package knowledge.oop;

/**
 * 方法
 * 修饰符 返回值类型 方法名 参数类型 方法体
 *
 * @author ljh
 * created on 2019/8/8 19:39
 */
public class Method {

    private static int max;

    /**
     * 构造方法
     * <p>
     * 当一个对象被创建时，构造方法用来初始化对象
     * 构造方法和它所在类的名字相同
     * 构造方法没有返回值
     * Java 会提供一个默认的无参构造方法
     * 一旦定义了自定义构造方法，默认构造方法就会失效
     */
    public Method() {
        max = Integer.MAX_VALUE;
    }

    public int max(int num1, int num2) {
        return Math.max(num1, num2);
    }

    final int min(int num1, int num2) {
        return Math.min(num1, num2);
    }

    /**
     * 方法重载
     * 1.方法名相同，参数列表不同，返回值类型无关
     * 2."编译期绑定"，看引用类型（编译时多态）
     * 3.一个类的多态性表现
     * 4.可以声明新的或更广的检查异常
     */
    private int max(int num1, int num2, int num3) {
        return max(num1, max(num2, num3));
    }

    private static class ChildMethod extends Method {

        /**
         * 方法重写
         * 1.方法名相同，参数列表相同，返回值类型相同，访问权限>=父
         * 2."运行时绑定"，看对象类型（编译时多态）
         * 3.子类与父类的一种多态性表现
         * 4.不能抛出新的检测性异常，或比重写方法更广泛的检测性异常
         * <p>
         * 5.final 方法不能被子类重写和再次声明
         * 6.static 方法不能被子类重写，但可以再次声明
         * 7.构造方法不能被重写
         */
        public int max(int num1, int num2) {
            return num1 > num2 ? num1 : num2;
        }
    }

}
