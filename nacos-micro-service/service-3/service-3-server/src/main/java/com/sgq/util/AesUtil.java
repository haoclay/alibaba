package com.sgq.util;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

@Slf4j
public class AesUtil {

    /**
     * 加密解密密钥（必须为16、24或32位长度）
     */
    private static final String KEY = "123456789012345612345678";

    /**
     * 加密算法
     */
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     *
     * @param content 待加密字符串
     * @return 加密后的字符串
     */
    public static String aesEncrypt(String content) {
        try {
            return aesEncrypt(content, KEY);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }

    /**
     * 解密
     *
     * @param encrypt 加密字符串
     * @return 解密后的字符串
     */
    public static String aesDecrypt(String encrypt) {
        try {
            return aesDecrypt(encrypt, KEY);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }

    /**
     * base64编码
     *
     * @param bytes 待编码的字节数组byte[]
     * @return base64编码后的字符串
     */
    static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * base64解码
     *
     * @param base64Code 待解码的base64编码字符串
     * @return 解码后的字节数组byte[]
     */
    static byte[] base64Decode(String base64Code) throws Exception {
        return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }

    /**
     * AES加密为base64编码字符串
     *
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return base64编码字符串
     */
    private static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES加密为字节数组
     *
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     */
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }

    /**
     * AES解密
     *
     * @param encryptStr 待解密的内容
     * @param decryptKey 解密密钥
     * @return 解密后的string
     */
    private static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    /**
     * AES解密为字符串
     *
     * @param encryptBytes 待解密的字节数组byte[]
     * @param decryptKey 解密密钥
     * @return 解密后的String
     */
    private static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);

        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    /**
     * AES加解密测试
     */
    public static void main(String[] args) throws Exception {
        String content = "关注微信公众号：IT特靠谱";
        String encrypt = aesEncrypt(content, KEY);
        String decrypt = aesDecrypt(encrypt, KEY);
        log.info("AES加密前：{}", content);
        log.info("AES加密后：{}", encrypt);
        log.info("AES解密后：{}", decrypt);
    }
}