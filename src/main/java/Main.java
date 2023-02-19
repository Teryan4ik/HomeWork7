import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String PATH = "src/main/resources/";
    private static String exitCmd = "Exit";

    public static void main(String[] args) throws FileNotFoundException {
        BookParser bookParser = new BookParser();
        System.out.println("Enter the book name");
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());

        while (!scanner.next().equals(exitCmd)) {

            System.out.println("Enter the book name");
            File book = new File(PATH + scanner.next());
            List<String> words = bookParser.getText(book);
            bookParser.topWords(words,3);

            System.out.println("Enter " + exitCmd + " to exit");
        }
    }
}