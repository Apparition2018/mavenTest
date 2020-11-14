package jar.apache.commons.beanutils;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.LazyDynaBean;
import org.junit.Test;

/**
 * DynaProperty
 * BasicDynaClass
 * DynaBean
 * LazyDynaBean
 * <p>
 * http://commons.apache.org/proper/commons-beanutils/javadocs/v1.9.4/apidocs/org/apache/commons/beanutils/package-summary.html#package_description
 */
public class DynaDemo {

    /**
     * 案例：
     * 1.在运行期生成一个动态 Bean
     * 2.生成无固定格式的 Bean
     */
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        // 动态 Bean，首先定义 Bean 类
        DynaProperty[] props = new DynaProperty[]{
                new DynaProperty("name", String.class),
                new DynaProperty("age", int.class)
        };
        BasicDynaClass dynaClass = new BasicDynaClass("people", null, props);
        // 动态 Bean 对象
        DynaBean people = dynaClass.newInstance();
        /* people 的 get/set 操作 */


        // 自由 Bean
        DynaBean user = new LazyDynaBean();
        // 直接定义属性和值
        user.set("name", "张三");
        // 定义属性名，限定属性类型为 Map
        user.set("phoneNum", "tel", "021");
        user.set("phoneNum", "mobile", "138");
        // 属性类型为 ArrayList
        user.set("address", 0, "上海");
        user.set("address", 1, "背景");
    }
}
