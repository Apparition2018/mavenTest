package jar.hutool.crypto;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import l.demo.Demo;

import java.nio.charset.StandardCharsets;

/**
 * SymmetricCrypto  对称加密
 * https://hutool.cn/docs/#/crypto/%E5%AF%B9%E7%A7%B0%E5%8A%A0%E5%AF%86-SymmetricCrypto
 * https://apidoc.gitee.com/loolly/hutool/cn/hutool/crypto/symmetric/SymmetricCrypto.html
 *
 * @author ljh
 * created on 2020/11/9 9:30
 */
public class SymmetricCryptoDemo extends Demo {

    /**
     * SymmetricAlgorithm:
     * AES (默认AES/ECB/PKCS5Padding)
     * ARCFOUR
     * Blowfish
     * DES (默认DES/ECB/PKCS5Padding)
     * DESede
     * RC2
     * PBEWithMD5AndDES
     * PBEWithSHA1AndDESede
     * PBEWithSHA1AndRC2_40
     */
    public static void testSymmetricCrypto(SymmetricAlgorithm symmetricAlgorithm) {
        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(symmetricAlgorithm.getValue()).getEncoded();

        // 构建 SymmetricCrypto
        SymmetricCrypto aes = new SymmetricCrypto(symmetricAlgorithm, key);

        // 加密
        String encryptHex = aes.encryptHex(HELLO_WORLD);

        // 解密
        String decryptStr = aes.decryptStr(encryptHex, StandardCharsets.UTF_8);
    }
}
