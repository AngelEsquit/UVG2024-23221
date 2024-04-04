import java.util.Comparator;

public class StringComparator<K> implements Comparator<K>{

    @Override
    public int compare(K o1, K o2) {
        return ((String) o1).compareTo((String) o2);
    }
}
