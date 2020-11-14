package jar.apache.commons.lang3;

import org.apache.commons.lang3.Validate;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Validate
 * https://blog.csdn.net/yaomingyang/article/details/80876009
 * http://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/Validate.html
 */
public class ValidateDemo {

    /**
     * 验证指定值是否在规定范围内
     * 不包括边界值
     */
    @Test
    public void exclusiveBetween() {
        Validate.exclusiveBetween(1, 10, 9);
        Validate.exclusiveBetween(1, 10, 10); // IllegalArgumentException: The value 10 is not in the specified exclusive range of 1 to 10
    }

    /**
     * 验证指定值是否在规定范围内
     * 包括边界值
     */
    @Test
    public void inclusiveBetween() {
        Validate.inclusiveBetween(1, 10, 9);
        Validate.inclusiveBetween(1, 10, 10);
    }

    /**
     * 验证指定值是否不是无穷大 或 NaN
     */
    @Test
    public void finite() {
        Validate.finite(Double.POSITIVE_INFINITY); // IllegalArgumentException: The value is invalid: Infinity
        Validate.finite(Double.POSITIVE_INFINITY, "无穷大"); // IllegalArgumentException: 无穷大
    }

    /**
     * 验证 superType 是否为 type 的父类或父接口
     */
    @Test
    public void isAssignableFrom() {
        Validate.isAssignableFrom(Map.class, HashMap.class);
        Validate.isAssignableFrom(HashMap.class, Map.class); // IllegalArgumentException: Cannot assign a java.util.Map to a java.util.HashMap
    }

    /**
     * 验证指定的参数字符序列是否与指定的正则表达式匹配
     */
    @Test
    public void matchesPattern() {
        Validate.matchesPattern("abc", ".*");
    }

    /**
     * 验证数组或迭代是否没有一个元素为 null
     */
    @Test
    public void noNullElements() {
        Validate.noNullElements(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Validate.noNullElements(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, null)); // IllegalArgumentException: The validated collection contains null element at index: 8
    }

    /**
     * 验证 blank
     * " ", "", null
     */
    @Test
    public void notBlank() {
        Validate.notBlank(" "); // IllegalArgumentException: The validated character sequence is blank
    }

    /**
     * 验证 empty
     * "", null
     */
    @Test
    public void notEmpty() {
        Validate.notEmpty(" ");
        Validate.notEmpty(""); // IllegalArgumentException: The validated character sequence is empty
    }

    /**
     * 验证 null
     */
    @Test
    public void notNull() {
        Validate.notNull(null); // NullPointerException: The validated object is null
    }

    /**
     * 验证 index
     */
    @Test
    public void validIndex() {
        Validate.validIndex("abc", 2);
        Validate.validIndex(Arrays.asList(1, 2, 3, 4), 4); // IndexOutOfBoundsException: The validated collection index is invalid: 4
    }

}
