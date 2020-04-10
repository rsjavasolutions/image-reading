package rs.java.ocrsystem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.LoadLibs;

import javax.imageio.ImageIO;

public class TesseractExample {

    public static void main(String[] args) throws IOException {
        //pobieram obrazek z internetu
        URL imageFile = new URL(
                "https://i.pinimg.com/originals/3d/30/91/3d3091cc0c7a275fe223401b707cbd75.jpg");

        //buforuje obrazek na postać bitową
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        //instancja klasy odpowiadająca za translacje obrazka na tekst
        ITesseract instance = new Tesseract();

        //gdzie są dane do odczytywania
        instance.setDatapath("N:\\Bykowski\\ocr-system");

        //ustawiam język na polski
        instance.setLanguage("pol");

        // przekazuję postać bajtową i zamieniam ją na treść
        try {
            String result = instance.doOCR(bufferedImage);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
