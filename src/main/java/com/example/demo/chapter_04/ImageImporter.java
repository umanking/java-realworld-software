package com.example.demo.chapter_04;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class ImageImporter implements Importer {

    public static final String PATH = "path";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String TYPE = "type";

    @Override
    public Document importFile(File file) throws IOException {
        Map<String, String> attributes = new HashMap<>();

        attributes.put(PATH, file.getPath());
        BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE, "IMAGE");

        return new Document(attributes);
    }
}
