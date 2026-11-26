package sorter;


import java.util.Comparator;
import java.util.List;

public class Sorter {
    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.sort(comparator);
    }
}
