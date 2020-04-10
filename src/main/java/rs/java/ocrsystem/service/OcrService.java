package rs.java.ocrsystem.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.LoadLibs;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;

@Service
public class OcrService {

    public String getText(String url) throws IOException {
        //pobieram obrazek z internetu
        URL imageFile = new URL(url);

        //buforuje obrazek na postać bitową
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        //instancja klasy odpowiadająca za translacje obrazka na tekst
        ITesseract instance = new Tesseract();

        //gdzie są dane do odczytywania
        instance.setDatapath("N:\\Bykowski\\ocr-system");

        //ustawiam język na polski
        instance.setLanguage("pol");
        String result = null;
        // przekazuję postać bajtową i zamieniam ją na treść
        try {
            result = instance.doOCR(bufferedImage);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return result;
    }
}
