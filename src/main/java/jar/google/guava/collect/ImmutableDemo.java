package jar.google.guava.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * 不可变集合
 * 效率高，占内存少
 * <p>
 * ImmutableList
 * ImmutableMap
 * ImmutableSet
 * ImmutableSortedMap
 * ImmutableSortedSet
 *
 * @author ljh
 * created on 2019/8/8 19:39
 */
public class ImmutableDemo {

    public static void main(String[] args) {
        // 不可变 List
        ImmutableList<String> list = ImmutableList.of("A", "B", "C");

        // 不可变 Map
        ImmutableMap<Integer, String> map = ImmutableMap.of(1, "壹", 2, "贰", 3, "叁");
    }

}
