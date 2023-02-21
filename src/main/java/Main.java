import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String PATH = "src/main/resources/";
    private static final String exitCmd = "exit";

    public static void main(String[] args) {
        BookParser bookParser = new BookParser();
        BookStatSerializer bookStatSerializer = new BookStatSerializer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the book name");
        while (!scanner.hasNext(exitCmd)) {
            File book = new File(PATH + scanner.next());
            List<String> words = bookParser.getText(book);
            List<String> topWords = bookParser.topWords(words, 3);
            int uniqWords = bookParser.uniqWords(words);
            BookStat bookStat = new BookStat(topWords, uniqWords);
            System.out.println(bookStat);
            try {
                bookStatSerializer.serializeToFile(bookStat, new File(PATH + book.getName() + "_statistic.txt"));
            } catch (IOException e) {
                System.out.println("Statistics could not be written to a file on the server!");
            }
            System.out.println("\nEnter the next book name to continue or type '" + exitCmd + "' for exit");

        }
    }
}