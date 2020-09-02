package knowledge.网络编程;

import org.junit.Test;
import utils.LUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress类
 * 表示互联网协议 (IP) 地址
 * IP 地址是 IP 使用的 32 位或 128 位无符号数字，它是一种低级协议，UDP 和 TCP 协议都是在它的基础上构建的。
 */
public class InetAddressDemo {

    @Test
    public void test() throws UnknownHostException {
        // static InetAddress	getLocalHost()
        // 返回本地主机
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);                   // IT-LJH234607/192.168.131.36

        // static InetAddress	getByName(String host)
        // 在给定主机名的情况下确定主机的 IP 地址
        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);                   // www.baidu.com/14.215.177.39

        // String	getHostName()
        // 获取此 IP 地址的主机名
        System.out.println(address.getHostName());     // www.baidu.com
        // String	getHostAddress()
        // 返回 IP 地址字符串（以文本表现形式）
        System.out.println(address.getHostAddress());  // 14.215.177.39
        // byte[]	getAddress()
        // 返回此 InetAddress 对象的原始 IP 地址
        System.out.println(Arrays.toString(address.getAddress())); // [14, -41, -79, 38]

    }

}
