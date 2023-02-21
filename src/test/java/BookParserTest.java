import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class BookParserTest {
    @Test
    public void getTextTest() throws IOException {
        BookParser bookParser = new BookParser();
        File file = new File("src/main/resources/" + "tests.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("Hello, , ! !  ! ! : Hello Hello world world world bmw top shop");
        writer.close();
        List<String> words = bookParser.getText(file);
        Assert.assertEquals(9, words.size());
        file.delete();
    }

    @Test
    public void topWords() {
        BookParser bookParser = new BookParser();
        List<String> words = List.of("Hello", "iPhone", "Notebook", "cup", "cup", "Hello", "cup", "cup", "Notebook");
        int amount = 3;
        List<String> expected = List.of("cup", "Hello", "Notebook");
        List<String> result = bookParser.topWords(words, amount);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void uniqWordsTest() {
        BookParser bookParser = new BookParser();
        List<String> words = List.of("Hello", "iPhone", "Notebook", "cup", "cup", "Hello", "cup", "cup", "Notebook");
        int uniqWords = bookParser.uniqWords(words);
        Assert.assertEquals(4, uniqWords);
    }

    @Test
    public void serializeToFileTest() throws IOException {
        BookParser bookParser = new BookParser();
        List<String> words = List.of("Hello", "iPhone", "Notebook", "cup", "cup", "Hello", "cup", "cup", "Notebook");
        File file = new File("src/main/resources/" + "tests.txt" + "_statistic.txt");
        int amount = 3;
        List<String> expected = List.of("cup", "Hello", "Notebook");
        BookStatSerializer bookStatSerializer = new BookStatSerializer();
        BookStat bookStat = new BookStat(expected, amount);
        bookStatSerializer.serializeToFile(bookStat, file);
        int uniqWords = bookParser.uniqWords(words);
        Assert.assertEquals(4, uniqWords);
        List<String> result = bookParser.topWords(words, amount);
        Assert.assertEquals(expected, result);
        file.delete();
    }
}
