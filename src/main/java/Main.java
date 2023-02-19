import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String PATH = "src/main/resources/";
    private static String exitCmd = "Exit";

    public static void main(String[] args) throws IOException {
        BookParser bookParser = new BookParser();
//        System.out.println("Enter the book name");
        BookStatSerializer bookStatSerializer = new BookStatSerializer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("press any or exit");

        while (!scanner.next().equals(exitCmd)) {
            System.out.println("Enter the book name");
            File book = new File(PATH + scanner.next());
            List<String> words = bookParser.getText(book);
            List<String> topWords = bookParser.topWords(words, 3);
            int uniqWords = bookParser.uniqWords(words);
            BookStat bookStat = new BookStat(topWords, uniqWords);
            System.out.println(bookStat);
            bookStatSerializer.serializeToFile(bookStat, new File(PATH + book.getName() + "_statistic.txt"));
            System.out.println("Enter " + exitCmd + " to exit");
        }
    }
}