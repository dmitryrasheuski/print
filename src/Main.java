import printer.PhotoPrinter;
import printer.Printer;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        Printer photoPrinter = new PhotoPrinter();
        File photoFile = new File("./resources/PolaroidVert.jpg");

       photoPrinter.print(photoFile);

    }
}
