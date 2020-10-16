package knowledge.建议;

import l.demo.Demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 建议108：反射结合模板方法模式
 */
// 抽象模板角色类
abstract class Initializer extends Demo {

    // 模板方法
    public final void dataInitialing() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            if (isInitDataMethod(m)) {
                m.invoke(this);
            }
        }
        doSomething();
    }

    // 判断是否为数据初始化方法
    private boolean isInitDataMethod(Method m) {
        return m.getName().startsWith("init")
                && Modifier.isPublic(m.getModifiers())
                && m.getReturnType().equals(Void.TYPE)
                && !m.isVarArgs();
    }

    // 基本方法-具体方法
    private void doSomething() {
        p("do something ...");
    }

}

// 具体模板角色类
class UserInitializer extends Initializer {
    public void initUser() {
        p("init user");
    }

    public void initPassword() {
        p("init password");
    }

    public void initJobs() {
        p("init jobs");
    }
}