import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BookStatSerializer {
    public void serializeToFile(BookStat book, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(book.toString());
        writer.close();
    }
}
