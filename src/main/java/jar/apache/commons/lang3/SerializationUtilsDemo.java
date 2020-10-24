package jar.apache.commons.lang3;

import l.demo.Demo;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.*;
import java.util.Date;
import java.util.Objects;

/**
 * SerializationUtils
 */
public class SerializationUtilsDemo extends Demo {

    private static Date date = new Date();

    @Test
    public void test1() {
        // static <T extends Serializable> T	clone(T object)
        // 深克隆
        Date cDate = SerializationUtils.clone(date);
        p(Objects.equals(date, cDate));     // true

        // static byte[]	serialize(Serializable obj)
        // 序列化，Object → byte[]
        byte[] bytes = SerializationUtils.serialize(cDate);

        // static <T> T     deserialize(byte[] objectData)
        // 反序列化，byte[] → T
        Date deDate = SerializationUtils.deserialize(bytes);
        p(Objects.equals(cDate, deDate));   // true
    }

    @Test
    public void test2() {
        OutputStream os = null;
        InputStream is = null;

        try {
            String filePath = DEMO_PATH + "Serialization.obj";
            os = new FileOutputStream(filePath);
            is = new FileInputStream(filePath);

            // static void	serialize(Serializable obj, OutputStream outputStream)
            // 序列持久化，Object → bytes[] → File
            SerializationUtils.serialize(date, os);

            // static <T> T	deserialize(InputStream inputStream)
            // 反序列持久化，File → bytes[] → T
            Date deDate = SerializationUtils.deserialize(is);

            p(date.equals(deDate)); // true
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(is);
        }
    }

}
