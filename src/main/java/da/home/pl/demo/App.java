package da.home.pl.demo;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String path = "C:\\Users\\images\\"; //path to images
        List<String> songs = ocrImages(path);
        songs.forEach(System.out::println);
    }

    private static List<String> ocrImages(String directoryPath) {
        File[] files = new File(directoryPath).listFiles();
        List<String> songs = new ArrayList<>();

        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("D:\\Tesseract\\src\\main\\resources\\tessdata\\"); //path to tess libraries
        tesseract.setLanguage("eng+rus");


        for (int i = 0; i < files.length; i++) {
            try {
                String result = tesseract.doOCR(files[i]);
                songs.add(result);
            } catch (TesseractException e) {
                e.printStackTrace();
            }
        }

        return songs;
    }
}
