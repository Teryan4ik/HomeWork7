import java.util.List;

public class BookStat {
    private final List<String> topWords;
    private final int uniqWords;

    public BookStat(List<String> topWords, int uniqWords) {
        this.topWords = topWords;
        this.uniqWords = uniqWords;
    }

    @Override
    public String toString() {
        return "BookStat{" +
                "topWords=" + topWords +
                ", uniqWords=" + uniqWords +
                '}';
    }
}
