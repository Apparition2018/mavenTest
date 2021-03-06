package knowledge.io.file;

import l.demo.Demo;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;

/**
 * FilenameFilter
 * 实现此接口的类实例可用于过滤器文件名。
 * https://www.runoob.com/manual/jdk1.6/java/io/FilenameFilter.html
 *
 * @author ljh
 * created on 2020/9/14 10:51
 */
public class FilenameFilterDemo extends Demo {

    @Test
    public void testFilenameFilter() {
        File file = new File(USER_DIR);

        // boolean	    accept(File dir, String name)
        // 测试指定文件是否应该包含在某一文件列表中
        FilenameFilter filter = (dir, name) -> name.startsWith("p");

        File[] subFiles = file.listFiles(filter);
        for (File subFile : Objects.requireNonNull(subFiles, "目录不存在或它不是一个目录")) {
            p(subFile.getName());
        }
    }
}
