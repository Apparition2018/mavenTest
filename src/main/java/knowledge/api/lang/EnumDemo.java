package knowledge.api.lang;

import l.demo.Company;
import l.demo.Demo;
import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * Enum
 * https://jdk6.net/lang/Enum.html
 * <p>
 * 优点：
 * 1.枚举有更多灵活的用法
 * 2.有效的提高代码的整洁性、可读性
 * 3.限制非法值的传入
 * <p>
 * switch:
 * 1) jdk1.5-: byte, short, char, int
 * 2) jdk1.5:  Byte, Short, Character, Integer, enum
 * 3) jdk1.7:  String
 * <p>
 * int	                            ordinal()               返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）
 * String	                        name()                  返回此枚举常量的名称，在其枚举声明中对其进行声明
 * Class<E>	                        getDeclaringClass()     返回与此枚举常量的枚举类型相对应的 Class 对象
 * static <T extends Enum<T>> T	    valueOf(Class<T> enumType, String name) 返回带指定名称的指定枚举类型的枚举常量
 * <p>
 * https://blog.csdn.net/cndmss/article/details/51441617
 */
public class EnumDemo extends Demo {

    @Test
    public void companyEnum() {
        p(Company.SF.getCode());                // 1001
        p(Company.SF.getCompany());             // 顺丰速运

        p(Company.getCodeByCompany("顺丰速运")); // 1001
        p(Company.getCompanyByCode(1001));      // 顺丰速运
    }

    /**
     * 一些其它用法
     */
    @Test
    public void companyEnum2() {
        // 返回此枚举常量的名称,继承自java.lang.Enum类,通常重写该方法以实现相关操作
        p(Company.SF.toString());               // Company{company='顺丰速运', code=1001}

        // 返回此枚举常量的名称
        p(Company.SF.name());                   // SF

        // 返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）
        p(Company.YTO.ordinal());               // 1

        // 获取枚举中的常量个数
        p(Company.values().length);             // 5

        // 返回带指定名称的指定枚举类型的枚举常量
        p(Company.valueOf(Company.class, "SF").getCompany()); // 顺丰速运

        // 比较此枚举与指定对象的顺序;SF位置是0,YTO位置是1,结果为 0-1=-1
        p(Company.SF.compareTo(Company.YTO));   // -1

        // 返回与此枚举常量的枚举类型相对应的 Class 对象
        p(Company.SF.getDeclaringClass());      // class l.demo.Company

        // equals()
        p(Company.SF.name().equals("SF"));      // true
        p(Company.SF.equals(Company.YTO));      // false

    }

    /**
     * EnumSet, EnumMap 的使用
     */
    @Test
    public void enumSetAndEnumMap() {
        // EnumSet
        EnumSet<Company> companySet = EnumSet.allOf(Company.class);
        for (Company company : companySet) {
            p(company.getCode() + ":" + company.getCompany());
        }

        // EnumMap
        EnumMap<Company, String> companyMap = new EnumMap<>(Company.class);
        companyMap.put(Company.SF, "顺丰map");
        companyMap.put(Company.YTO, "圆通map");
        for (Map.Entry<Company, String> entry : companyMap.entrySet()) {
            p(entry.getKey().name() + ":" + entry.getValue() + ":" + entry.getKey());
        }
    }

}
