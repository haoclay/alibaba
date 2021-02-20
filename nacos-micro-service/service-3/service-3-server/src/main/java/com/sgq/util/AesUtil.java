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
     * ���ܽ�����Կ������Ϊ16��24��32λ���ȣ�
     */
    private static final String KEY = "123456789012345612345678";

    /**
     * �����㷨
     */
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * ����
     *
     * @param content �������ַ���
     * @return ���ܺ���ַ���
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
     * ����
     *
     * @param encrypt �����ַ���
     * @return ���ܺ���ַ���
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
     * base64����
     *
     * @param bytes ��������ֽ�����byte[]
     * @return base64�������ַ���
     */
    static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * base64����
     *
     * @param base64Code �������base64�����ַ���
     * @return �������ֽ�����byte[]
     */
    static byte[] base64Decode(String base64Code) throws Exception {
        return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }

    /**
     * AES����Ϊbase64�����ַ���
     *
     * @param content �����ܵ�����
     * @param encryptKey ������Կ
     * @return base64�����ַ���
     */
    private static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES����Ϊ�ֽ�����
     *
     * @param content �����ܵ�����
     * @param encryptKey ������Կ
     * @return ���ܺ��byte[]
     */
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }

    /**
     * AES����
     *
     * @param encryptStr �����ܵ�����
     * @param decryptKey ������Կ
     * @return ���ܺ��string
     */
    private static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    /**
     * AES����Ϊ�ַ���
     *
     * @param encryptBytes �����ܵ��ֽ�����byte[]
     * @param decryptKey ������Կ
     * @return ���ܺ��String
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
     * AES�ӽ��ܲ���
     */
    public static void main(String[] args) throws Exception {
        String content = "��ע΢�Ź��ںţ�IT�ؿ���";
        String encrypt = aesEncrypt(content, KEY);
        String decrypt = aesDecrypt(encrypt, KEY);
        log.info("AES����ǰ��{}", content);
        log.info("AES���ܺ�{}", encrypt);
        log.info("AES���ܺ�{}", decrypt);
    }
}