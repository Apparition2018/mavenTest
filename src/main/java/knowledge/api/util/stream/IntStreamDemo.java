package knowledge.api.util.stream;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static l.demo.Demo.p;

/**
 * IntStream
 * IntStream 支持顺序和并行聚合操作的 int 序列，类似的还有 LongStream, DoubleStream
 * <p>
 * IntStream 用法全解：https://blog.csdn.net/qq_31865983/article/details/106443244
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
 *
 * @author ljh
 * created on 2020/11/6 14:43
 */
public class IntStreamDemo {

    /**
     * 大部分 API 跟 Stream 一样，可查看 StreamDemo
     * <p>
     * DoubleStream                 asDoubleStream()
     * LongStream                   asLongStream()
     * Stream<Integer>              boxed()
     * PrimitiveIterator.OfInt      iterator()
     * Spliterator.OfInt            spliterator()
     */
    @Test
    public void testIntStream() {
        IntStream intStream;

        // ints()                               通过 Random 的 ints() 生成 IntStream                     
        intStream = new Random().ints(0, 10).limit(9);
        // IntStream.range(start, end)          范围内元素，不包括 end
        intStream = IntStream.range(1, 10);
        // IntStream.rangeClosed(start, end)    范围内元素，包括 end
        intStream = IntStream.rangeClosed(1, 9);

        // average()                            平均数              
        p(intStream.average());
        // sum()                                总和
        p(intStream.sum());
    }
}
