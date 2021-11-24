package com.wivety.utils;

import com.itextpdf.text.pdf.codec.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;

public class Utils {
    public static String ConvertImageIconToBase64String(ImageIcon ii) {
        // Create a buffered image of the size of the original image icon
        BufferedImage image = new BufferedImage(ii.getIconWidth(),
                ii.getIconHeight(), BufferedImage.TYPE_INT_RGB);

        // Create a graphics object to draw the image
        Graphics g = image.createGraphics();

        // Paint the icon on to the buffered image
        ii.paintIcon(null, g, 0, 0);
        g.dispose();

        // Convert the buffered image into a byte array
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", b);
        } catch (Exception ex) {
            // Handle the exception
        }
        byte[] imageInByte = b.toByteArray();

        // Return the Base64 encoded String
        return Base64.encodeBytes(imageInByte);
    }
}
