import java.io.*;
import java.util.*;


public class BookParser {
    public List<String> getText(File file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> words = reader.lines()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(word -> word.length() > 2)
                .toList();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        return new HashSet<String>(words).size();
    }
}
