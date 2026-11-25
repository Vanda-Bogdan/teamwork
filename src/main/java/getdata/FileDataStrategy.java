package getdata;

import java.util.List;

public class FileDataStrategy<T> implements GetDataStrategy<T> {


    @Override
    public List<T> getData() {
        return List.of();
    }
}
