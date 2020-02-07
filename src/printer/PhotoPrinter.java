package printer;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import java.io.*;

public class PhotoPrinter implements Printer {
    private PrintService printService;
    private DocPrintJob job;
    private DocFlavor flavor;
    private Doc doc;
    {
        flavor = DocFlavor.INPUT_STREAM.JPEG;
        printService = PrintServiceLookup.lookupDefaultPrintService();
        job = printService.createPrintJob();
    }

    @Override
    public void print(File file) throws IOException, PrintException {
        BufferedInputStream stream = new BufferedInputStream( new FileInputStream(file) );

        doc = new SimpleDoc( stream, flavor, getDocAttributeSet() );
        job = printService.createPrintJob();

        job.print( doc, getPrintRequestAttributeSet() ) ;

        stream.close();
    }


    private DocAttributeSet getDocAttributeSet(){
        DocAttributeSet set = new HashDocAttributeSet();

        set.add( OrientationRequested.LANDSCAPE );
        set.add( new MediaPrintableArea(0.16f, 0.16f, 2.84f, 3.84f, MediaPrintableArea.INCH));
        set.add( MediaSize.findMedia(3, 4, MediaSize.INCH) );

        return  set;
    }

    private PrintRequestAttributeSet getPrintRequestAttributeSet() {
        PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();

        return null;
    }
}
