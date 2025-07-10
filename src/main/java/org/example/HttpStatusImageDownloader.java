package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException, URISyntaxException {
        HttpStatusChecker checker = new HttpStatusChecker();
        URI uri = new URI(checker.getStatusImage(code));
        URL imageUrl = uri.toURL();

        try {
            BufferedImage image = ImageIO.read(imageUrl);

            if (!image.hasTileWriters()) {
                throw new IOException();
            }
            ImageIO.write(image, "jpg", new File("cats/" + code + ".jpg"));
            System.out.println("Image " + code + " downloaded");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
