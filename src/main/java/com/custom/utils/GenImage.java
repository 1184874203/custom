package com.custom.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: 邵禹寒
 * @date: 2021-09-29 15:17
 */
public class GenImage {

    private static final Integer WHITE = 0xFF000000;
    private static final Integer BLACK = 0xFFFFFFFF;
    private static final String UTF_8 = "UTF-8";
    private static final Integer WIDTH = 300;
    private static final Integer HEIGHT = 300;
    private static final String FILE_LOCATION = "C:/Users/11848/Desktop/";
    private static final String PNG = "png";
    private static final String JPG = "jpg";

    public static String genImage(String text) throws WriterException, IOException {
        Map map = new HashMap<>(4);
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.CHARACTER_SET, UTF_8);
        map.put(EncodeHintType.MARGIN, 1);

        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, map);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? WHITE : BLACK);
            }
        }
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + PNG;
        File file = new File(FILE_LOCATION + fileName);
        ImageIO.write(image, PNG, file);
        return fileName;
    }

    public static void main(String[] args) throws IOException, WriterException {
        // genImage("https://www.baidu.com");
        System.out.println(genImage("http://210.14.72.9:8088/news/04c716b89c8e56d48c6d68f3528c01e8c69c9ac300d467d20d1767921297e1f3.html"));
    }
}
