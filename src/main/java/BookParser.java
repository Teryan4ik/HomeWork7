import java.io.*;
import java.util.*;


public class BookParser {

    private static final List<String> replace = List.of(",", "!", "?", ":");

    public List<String> getText(File file) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't open this file!");
            System.out.println("Enter the book name");
            Scanner scanner = new Scanner(System.in);
            return Collections.singletonList(scanner.next());
        }
        List<String> words = reader.lines().map(word -> word.replaceAll(String.valueOf(replace), " ")).flatMap(line -> Arrays.stream(line.split(" "))).filter(word -> word.length() > 2).toList();
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Problem reading the file");
        }
        return words;
    }

    public List<String> topWords(List<String> words, int amount) {
        return words.stream()
                .distinct().
                sorted(Comparator.comparingInt(word -> Collections.frequency(words, word)).reversed())
                .limit(amount)
                .toList();
    }
    public int uniqWords(List<String> words) {
        return new HashSet<>(words).size();
    }
}
