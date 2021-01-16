package knowledge.api.util.stream;

import l.demo.Demo;
import l.demo.Person;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Collectors
 * Collectors 类实现了很多归约操作
 * Collectors 操作：https://www.cnblogs.com/felordcn/p/collectors.html
 * Collectors reducing()：https://blog.csdn.net/zebe1989/article/details/82855511
 *
 * @author ljh
 * created on 2021/1/14 14:51
 */
public class CollectorsDemo extends Demo {

    @Test
    public void testCollectors() {
        List<String> names = Arrays.asList("Luna", "Olivia", "Cora", "Leo", "Henry");

        // toCollection(), toList(), toSet(), toMap(), toConcurrentMap()
        p(names.stream().collect(Collectors.toList()));

        // joining()                                连接字符串
        p(names.stream().collect(Collectors.joining(", ")));            // Luna, Olivia, Cora, Leo, Henry
        p(names.stream().collect(Collectors.joining(", ", "[", "]")));  // [Luna, Olivia, Cora, Leo, Henry]

        // collectingAndThen()                      进行收集操作再执行额外执行 Function
        p(names.stream().collect(Collectors.collectingAndThen(Collectors.joining(", "), String::toUpperCase)));
        // LUNA, OLIVIA, CORA, LEO, HENRY

        // mapping()                                先通过 Function 操作，再进行收集操作
        p(names.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList())));
        // [LUNA, OLIVIA, CORA, LEO, HENRY]

        // groupingBy() / groupingByConcurrent()    分组，Function
        p(names.stream().collect(Collectors.groupingBy(String::length)));
        // {3=[Leo], 4=[Luna, Cora], 5=[Henry], 6=[Olivia]}

        // partitioningBy()                         分区，Predicate
        p(names.stream().collect(Collectors.partitioningBy(name -> name.length() > 4)));
        // {false=[Luna, Cora, Leo], true=[Olivia, Henry]}

        // maxBy() / minBy()                        最大/最小
        p(names.stream().collect(Collectors.maxBy(Comparator.comparingInt(String::length)))); // Optional[Olivia]
        p(names.stream().collect(Collectors.minBy(Comparator.comparingInt(String::length)))); // Optional[Leo]

        // summingXXX()                             和
        p(names.stream().collect(Collectors.summingInt(String::length)));   // 22

        // averagingXXX()                           平均值
        p(names.stream().collect(Collectors.averagingInt(String::length))); // 4.4

        // summarizingXXX()                         统计
        IntSummaryStatistics stats = names.stream().collect(Collectors.summarizingInt(String::length));
    }

    /**
     * Java 官方例子：统计每个城市个子最高的人
     */
    @Test
    public void testReducing() {
        List<Person> personList = new ArrayList<Person>(3) {
            {
                add(new Person("张三", 20, "男", null));
                add(new Person("李四", 21, "女", null));
                add(new Person("王五", 22, "男", null));
                add(new Person("赵六", 23, "女", null));
            }
        };

        Person identity = new Person();
        identity.setName("identity");
        identity.setAge(22);

        Function<Person, Person> round = person -> {
            Integer age = person.getAge();
            BigDecimal decimal = new BigDecimal(age);
            age = decimal.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
            person.setAge(age);
            return person;
        };

        Comparator<Person> compareAge = Comparator.comparing(Person::getAge);

        Map<String, Person> collect = personList.stream().collect(Collectors.groupingBy(Person::getGender,
                Collectors.reducing(identity, round, BinaryOperator.maxBy(compareAge))));
        p(collect); // {女=Person{name='赵六', age=23, gender='女'}, 男=Person{name='identity', age=22}}
    }
}