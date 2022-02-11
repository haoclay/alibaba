package com.sgq.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
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
     * 默认二维码大小
     */
    private static final Integer DEFAULT_SIZE = 200;

    /**
     * 默认二维码图片类型（png/jpg/jepg...等）
     */
    private static final String DEFAULT_TYPE = "png";

    /**
     * 生成base64编码后的二维码信息（默认大小、默认图片类型）
     *
     * @param content 二维码内容
     */
    public static String genQrCodeBase64(String content) {
        return AesUtil.base64Encode(genQrCode(content));
    }

    /**
     * 生成base64编码后的二维码信息（指定二维码大小和图片类型）
     *
     * @param content 二维码内容
     */
    public static String genQrCodeBase64(int size, String format, String content) {
        return AesUtil.base64Encode(genQrCode(size, format, content));
    }

    /**
     * 生成二维码（默认大小、默认图片类型）
     *
     * @param content 二维码内容
     */
    private static byte[] genQrCode(String content) {
        return genQrCode(DEFAULT_SIZE, DEFAULT_TYPE, content);
    }

    /**
     * 生成二维码字节数组
     *
     * @param size 二维码大小
     * @param picType 二维码图片类型
     * @param content 二维码内容
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
     * 生成二维码并转换为字节数组输出流
     */
    private static ByteArrayOutputStream genOrCodeToStream(int size, String picType, String content) {
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //生成矩阵
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hints);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, picType, bout);
            return bout;
        } catch (Exception e) {
//            log.error("genQrCode exception, e:", e);
        }
        return null;
    }

    /**
     * 测试main方法
     */
    public static void main(String[] args) throws Exception {
        //1.生成base64编码后的二维码信息，需要配合标签<img src="data:image/jpg;base64,base64QrCode"/>来显示该二维码图片
        String base64QrCode = QrCodeUtil.genQrCodeBase64("谈伟华我爱你(๑′ᴗ‵๑)Ｉ Lᵒᵛᵉᵧₒᵤ❤");
//        log.info(base64QrCode);
        //2.生成二维码图片，并保存到本地指定目录
        byte[] qrCodeBytes = AesUtil.base64Decode(base64QrCode);
        if (Objects.nonNull(qrCodeBytes)) {
            try {
                OutputStream out = new FileOutputStream(new File("D:/qrCode1.png"));
                out.write(qrCodeBytes);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
