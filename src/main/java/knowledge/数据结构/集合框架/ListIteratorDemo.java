package knowledge.数据结构.集合框架;

import l.demo.Demo;
import org.junit.Test;

import java.util.ListIterator;

/**
 * ListIterator
 * 列表迭代器，允许程序员按任一方向遍历列表、迭代期间修改列表，并获得迭代器在列表中的当前位置。
 * <p>
 * void	    add(E e)            将指定的元素插入列表（可选操作）
 * void	    set(E e)            用指定元素替换 next 或 previous 返回的最后一个元素（可选操作）
 * void	    remove()            从列表中移除由 next 或 previous 返回的最后一个元素（可选操作）
 * <p>
 * https://jdk6.net/util/ListIterator.html
 *
 * @author ljh
 * created on 2020/10/16 15:22
 */
public class ListIteratorDemo extends Demo {

    @Test
    public void testListIterator() {
        p(list);
        ListIterator<Integer> listIterator = list.listIterator(0);

        while (listIterator.hasNext()) {
            p(listIterator.next() + ", " + listIterator.previousIndex() + ", " + listIterator.nextIndex());
            // 1, 0, 1
            // 2, 1, 2
            // 3, 2, 3
            // 4, 3, 4
            // 5, 4, 5
            // 6, 5, 6
            // 7, 6, 7
            // 8, 7, 8
            // 9, 8, 9
        }

        while (listIterator.hasPrevious()) {
            p(listIterator.previousIndex() + ", " + listIterator.nextIndex() + ", " + listIterator.previous());
            // 8, 9, 9
            // 7, 8, 8
            // 6, 7, 7
            // 5, 6, 6
            // 4, 5, 5
            // 3, 4, 4
            // 2, 3, 3
            // 1, 2, 2
            // 0, 1, 1
        }

    }
}
