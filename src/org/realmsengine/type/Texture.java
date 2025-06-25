package org.realmsengine.type;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Texture {
    private int width, height;
    private BufferedImage bufferedImage;

    public Texture(BufferedImage image) {
        this.bufferedImage = image;
        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();
    }

    public Texture(InputStream stream) throws IOException {
        this.bufferedImage = ImageIO.read(stream);
        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();
    }

    public Texture(String path) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
        if (stream == null) {
            throw new FileNotFoundException(path);
        }
        this.bufferedImage = ImageIO.read(stream);
        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();
    }
}
