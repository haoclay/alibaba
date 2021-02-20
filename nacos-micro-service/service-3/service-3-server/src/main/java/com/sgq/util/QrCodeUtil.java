package com.sgq.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
//import com.hechuan.alltest.all.encodeAndDecode.base64.Base64Util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class QrCodeUtil {

    /**
     * Ĭ�϶�ά���С
     */
    private static final Integer DEFAULT_SIZE = 200;

    /**
     * Ĭ�϶�ά��ͼƬ���ͣ�png/jpg/jepg...�ȣ�
     */
    private static final String DEFAULT_TYPE = "png";

    /**
     * ����base64�����Ķ�ά����Ϣ��Ĭ�ϴ�С��Ĭ��ͼƬ���ͣ�
     *
     * @param content ��ά������
     */
    public static String genQrCodeBase64(String content) {
        return AesUtil.base64Encode(genQrCode(content));
    }

    /**
     * ����base64�����Ķ�ά����Ϣ��ָ����ά���С��ͼƬ���ͣ�
     *
     * @param content ��ά������
     */
    public static String genQrCodeBase64(int size, String format, String content) {
        return AesUtil.base64Encode(genQrCode(size, format, content));
    }

    /**
     * ���ɶ�ά�루Ĭ�ϴ�С��Ĭ��ͼƬ���ͣ�
     *
     * @param content ��ά������
     */
    private static byte[] genQrCode(String content) {
        return genQrCode(DEFAULT_SIZE, DEFAULT_TYPE, content);
    }

    /**
     * ���ɶ�ά���ֽ�����
     *
     * @param size ��ά���С
     * @param picType ��ά��ͼƬ����
     * @param content ��ά������
     */
    private static byte[] genQrCode(int size, String picType, String content) {
        byte[] qrCodeBytes = null;
        ByteArrayOutputStream bout = genOrCodeToStream(size, picType, content);
        if (Objects.nonNull(bout)) {
            qrCodeBytes = bout.toByteArray();
        }
        return qrCodeBytes;
    }

    /**
     * ���ɶ�ά�벢ת��Ϊ�ֽ����������
     */
    private static ByteArrayOutputStream genOrCodeToStream(int size, String picType, String content) {
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //���ɾ���
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hints);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, picType, bout);
            return bout;
        } catch (Exception e) {
            log.error("genQrCode exception, e:", e);
        }
        return null;
    }

    /**
     * ����main����
     */
    public static void main(String[] args) throws Exception {
        //1.����base64�����Ķ�ά����Ϣ����Ҫ��ϱ�ǩ<img src="data:image/jpg;base64,base64QrCode"/>����ʾ�ö�ά��ͼƬ
        String base64QrCode = QrCodeUtil.genQrCodeBase64("�ܼ�����������?");
        log.info(base64QrCode);
        //2.���ɶ�ά��ͼƬ�������浽����ָ��Ŀ¼
        byte[] qrCodeBytes = AesUtil.base64Decode(base64QrCode);
        if (Objects.nonNull(qrCodeBytes)) {
            try {
                OutputStream out = new FileOutputStream(new File("D:/qrCode.png"));
                out.write(qrCodeBytes);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
