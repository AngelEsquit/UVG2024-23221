import java.util.Comparator;

public class StringComparator<K> implements Comparator<K>{

    @Override
    public int compare(K o1, K o2) {
        return o1.toString().compareTo(o2.toString());
    }
    
}
