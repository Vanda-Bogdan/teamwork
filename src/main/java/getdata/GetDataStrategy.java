package getdata;

import java.util.List;

public interface GetDataStrategy<T> {
    List<T> getData();
}