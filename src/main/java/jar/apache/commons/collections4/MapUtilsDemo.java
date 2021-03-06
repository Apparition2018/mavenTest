package jar.apache.commons.collections4;

import l.demo.Demo;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * MapUtils
 * http://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/MapUtils.html
 * <p>
 * static <K,V> IterableMap<K,V>	fixedSizeMap(Map<K,V> map)                          固定长度
 * static <K,V> SortedMap<K,V>	    fixedSizeSortedMap(SortedMap<K,V> map)              固定长度排序
 * static <K,V> IterableMap<K,V>	iterableMap(Map<K,V> map)                           可迭代
 * static <K,V> IterableSortedMap<K,V>iterableSortedMap(SortedMap<K,V> sortedMap)       可迭代排序
 * static <K,V> IterableMap<K,V>	lazyMap(map, factory)                               Lazy
 * static <K,V> SortedMap<K,V>	    lazySortedMap(map, factory)                         Lazy排序
 * static <K,V> OrderedMap<K,V> 	orderedMap(Map<K,V> map)                            有序 ?
 * static <K,V> IterableMap<K,V>	predicatedMap(map, keyPred, valuePred)              追加限制
 * static <K,V> SortedMap<K,V>	    predicatedSortedMap(map, keyPred, valuePred)        追加限制排序
 * static <K,V> Map<K,V>	        synchronizedMap(Map<K,V> map)                       同步
 * static <K,V> SortedMap<K,V>	    synchronizedSortedMap(SortedMap<K,V> map)           同步排序
 * static <K,V> IterableMap<K,V>	transformedMap(map, kTransformer, vTransformer)     追加转换
 * static <K,V> SortedMap<K,V>	    transformedSortedMap(map, kTf, vTf)                 追加转换排序
 * static <K,V> Map<K,V>	        unmodifiableMap(Map<? extends K,? extends V> map)   不可修改
 * static <K,V> SortedMap<K,V>	    unmodifiableSortedMap(SortedMap<K,? extends V> map) 不可修改排序
 * <p>
 * static <K,V> Map<K,V>    	    emptyIfNull(Map<K,V> map)                           如果为 null，返回空 Map
 * static boolean	                isEmpty(Map<?,?> map)                               判断为空
 * static boolean	                isNotEmpty(Map<?,?> map)                            判断非空
 * static <K,V> Properties	        toProperties(Map<K,V> map)                          转换成 Properties
 *
 * @author ljh
 * created on 2019/8/8 19:39
 */
public class MapUtilsDemo extends Demo {

    Map<Integer, Object> map = new HashMap<Integer, Object>(3) {
        {
            put(1, "A");
            put(2, "B");
            put(3, "C");
        }
    };

    /**
     * static <K> XXX	getXXX(Map<? super K,?> map, K key[, Boolean defaultValue])
     */
    @Test
    public void getXXX() {
        p(MapUtils.getString(map, 4, "D")); // 4
        p(MapUtils.getIntValue(map, 1));    // 1
    }

    /**
     * static <K,V> Map<V,K>	invertMap(Map<K,V> map)
     * 键值倒置
     */
    @Test
    public void invertMap() {
        p(MapUtils.invertMap(map)); // {A=1, B=2, C=3}
    }

    /**
     * static <K,V> Map<K,V>	putAll(Map<K,V> map, Object[] array)
     * Puts all the keys and values from the specified array into the map.
     */
    @Test
    public void putAll() {
        p(MapUtils.putAll(map, new Object[]{4, "D", 5, "E", 6, "F"}));
        // {1=A, 2=B, 3=C, 4=D, 5=E, 6=F}
    }

    /**
     * static <K> void	safeAddToMap(Map<? super K,Object> map, K key, Object value)
     * 如果 value 是 null，则用 "" 代替
     */
    @Test
    public void safeAddToMap() {
        MapUtils.safeAddToMap(map, 4, "D");
        p(Demo.map); // {1=A, 2=B, 3=C}
    }

}