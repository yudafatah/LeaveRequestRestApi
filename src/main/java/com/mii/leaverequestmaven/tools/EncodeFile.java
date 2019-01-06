/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author yudafatah
 */
public class EncodeFile {
    public static String upload(String file) throws IOException {
        String encodedfile = "";
        File filee = new File(file);
        FileInputStream fileInputStreamReader = new FileInputStream(filee);

        byte imageData[] = new byte[(int) filee.length()];
        fileInputStreamReader.read(imageData);
        encodedfile = Base64.getEncoder().encodeToString(imageData);

        return encodedfile;

    }
}
