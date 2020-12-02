package knowledge.design.behavioral.observer.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：定义了对象间的一种一对多依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新
 * <p>
 * 抽象主题角色 Subject
 * 具体主题角色 ConcreteSubject
 * 抽象观察者角色 Observer
 * 具体观察者角色 ConcreteObserver
 * <p>
 * https://www.runoob.com/design-pattern/observer-pattern.html
 * http://www.cnblogs.com/java-my-life/archive/2012/05/16/2502279.html
 * https://zhuanlan.zhihu.com/p/85975439
 * https://zhuanlan.zhihu.com/p/51357583
 * https://www.zhihu.com/question/23486749
 *
 * @author ljh
 * created on 2020/9/26 2:51
 */
public class ObserverDemo {
    public static void main(String[] args) {
        // 创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        // 创建观察者对象
        Observer observer = new ConcreteObserver();
        // 将观察者对象登记到主题对象上
        subject.attach(observer);
        // 改变主题对象的状态
        subject.change("new state");
    }

    /**
     * 抽象主题角色类
     */
    private static abstract class Subject {

        /**
         * 用来保存注册的观察者对象
         */
        private List<Observer> list = new ArrayList<>();

        /**
         * 注册观察者对象
         */
        public void attach(Observer observer) {
            list.add(observer);
            System.out.println("Attached an observer");
        }

        /**
         * 删除观察者对象
         */
        public void detach(Observer observer) {
            list.remove(observer);
        }

        /**
         * 通知所有注册的观察者对象
         */
        void notifyObservers(String newState) {
            for (Observer observer : list) {
                observer.update(newState);
            }
        }

    }

    /**
     * 具体主题角色类
     */
    private static class ConcreteSubject extends Subject {
        private String state;

        public String getState() {
            return state;
        }

        public void change(String newState) {
            state = newState;
            System.out.println("主题状态为：" + state);
            // 状态发生改变，通知各个观察者
            this.notifyObservers(state);
        }
    }

    /**
     * 抽象观察者角色类
     */
    interface Observer {
        /**
         * 更新接口
         */
        void update(String state);
    }

    /**
     * 具体观察者角色类
     */
    private static class ConcreteObserver implements Observer {
        /**
         * 观察者的状态
         */
        private String observerState;

        @Override
        public void update(String state) {
            // 更新观察者的状态，使其与目标的状态保持一致
            observerState = state;
            System.out.println("状态为：" + observerState);
        }
    }
}
