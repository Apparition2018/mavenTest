import cn.hutool.crypto.SecureUtil;

import java.io.IOException;
import java.text.ParseException;

// 史上最强整理: https://mp.weixin.qq.com/s/kJpRgfI3zT77XqMeRfmmQQ
// SpringBoot 之整合 Swagger2: https://www.cnblogs.com/zhangyinhua/p/9286391.html
// Gradle / Groovy
// SMB
// Desktop
// ACL
// JAVA与模式
// SpringBoot + Spring Batch
// Guava (140)
// 多种 Collections (143)
// SSL：https://www.cnblogs.com/crazyacking/p/5648520.html

// CSDN 阿_毅
// 林祥纤 SpringBoot
public class Test {

    public static void main(String[] args) throws ParseException, IOException {

        System.out.println(SecureUtil.md5().digestHex16("123"));

    }

}