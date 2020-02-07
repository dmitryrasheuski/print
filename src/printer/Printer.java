package printer;

import javax.print.PrintException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Printer {
    void print(File file) throws Exception;
}
